package api.controller;

import api.dto.Item;
import api.service.ItemService;
import api.service.MessageService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/sandelis")
public class ItemController {
    private final ItemService itemService;
    private final MessageService messageService;

    public ItemController(ItemService itemService, MessageService messageService) {
        this.itemService = itemService;
        this.messageService=messageService;
    }

    @GetMapping
    public String openFrontPage(Model model, @PageableDefault(sort = {"quantity"}) Pageable pageable) {
        model.addAttribute("itemsByPage", itemService.getAllItemsPage(pageable));
        return "frontpage";
    }

    @GetMapping("/addItem")
    public String openItemForm(Model model/*, String message*/) {
        model.addAttribute("item", new Item());
        /*model.addAttribute("message", messageService.getMessage(message));*/
        return "forms/itemForm";
    }

    @PostMapping("/addItem")
    public String createItem(Item item/*, BindingResult bindingResult, RedirectAttributes redirectAttributes*/) {

     /*   if(bindingResult.hasErrors()) {
            return "form/product";
        }*/
        itemService.addItem(item);
        String message = "item.created";
        /*log.debug("Product {}", product);
        redirectAttributes.addFlashAttribute("message", "lt.codeacademy.eshop.product.create.message.success");
*/
        /* return "redirect:/products/save";*/
        return " redirect:/addItem";
    }

    @GetMapping("/{id}")
    public String openItem(@PathVariable UUID id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        model.addAttribute("pictureUrl", "https://fi.makitamedia.com/images/3_Makita/301_machines/3011_a_GS1/30120_JPG_zoom/PT001GZ_C2L0.jpg");
        return "item";
    }



}
