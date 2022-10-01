package api.controller;

import api.dto.Item;
import api.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {
    final private ItemService itemService;

    public CartController(ItemService itemService) {
        this.itemService = itemService;
    }


    @ModelAttribute("cart")
    public List<Item> initializeCart() {
        return new ArrayList<>();
    }

    @GetMapping
    public String openShoppingCart(@ModelAttribute("cart") List<Item> cart) {
        return "cart";
    }


    @GetMapping("/checkout")
    public String checkout(SessionStatus sessionStatus) {

        sessionStatus.setComplete();
        return "redirect:/cart";
    }


    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable UUID id, @ModelAttribute("cart") List<Item> cart) {

        Item item = itemService.getItemById(id);
        cart.add(item);

        return "redirect:/frontpage";
    }


}
