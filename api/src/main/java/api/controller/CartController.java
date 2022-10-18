package api.controller;

import api.dto.IssuedItem;
import api.dto.Item;
import api.dto.User;
import api.service.ItemService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.time.LocalDate;
import java.util.*;

import static api.Paths.CART;

@RestController
@RequestMapping(CART)
@SessionAttributes("cart")
public class CartController {
    final private ItemService itemService;

    public CartController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ModelAttribute("cart")
    public Hashtable<Item, Integer> initializeCart() {
        return new Hashtable<>();
    }

    @GetMapping
    public String openShoppingCart(@ModelAttribute("cart") Hashtable<Item, Integer> cart) {
        return "cart";
    }

    @GetMapping("/add")
    public void addToCart(@RequestParam UUID id, @RequestParam Integer quantity, @ModelAttribute("cart") Hashtable<Item, Integer> cart) {

        Item item = itemService.getItemById(id);
        if (!cart.containsKey(item)) {
            cart.put(item, quantity);
        } else {
            quantity += cart.get(item);
            cart.put(item, quantity);
        }
    }

    @GetMapping("/remove")
    public void removeFromCart(@RequestParam UUID id, @ModelAttribute("cart") Hashtable<Item, Integer> cart) {

        Item item = itemService.getItemById(id);
            cart.remove(item);
    }


    @GetMapping("/checkout")
    public String checkout(SessionStatus sessionStatus,
                           @ModelAttribute("cart") Hashtable<Item, Integer> cart,
                           @ModelAttribute("user") User user) {
        for (Item item : cart.keySet()) {
            itemService.saveIssuedItem(new IssuedItem(user, item, cart.get(item), LocalDate.now()));
        }

        sessionStatus.setComplete();
        return "redirect:/cart";
    }

}
