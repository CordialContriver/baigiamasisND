package api.controller;

import api.dto.IssuedItem;
import api.dto.Item;
import api.exceptions.ExceptionResponse;
import api.service.ItemService;
import api.service.MessageService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static api.Paths.*;

import java.util.List;
import java.util.UUID;

@OpenAPIDefinition(tags = {
        @Tag(name = "Item Controller", description = "sandelio item controller")})
@RestController
@RequestMapping(ITEMS)
public class ItemController {
    private final ItemService itemService;
    private final MessageService messageService;

    public ItemController(ItemService itemService, MessageService messageService) {
        this.itemService = itemService;
        this.messageService = messageService;
    }

    @Operation(tags = "Item Controller", summary = "Get all items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All items returned successfully", content = {@Content(schema = @Schema(implementation = Item.class))}),
            @ApiResponse(responseCode = "401", description = "User not authorized", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Request not found", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItemList() {
        return itemService.getItemList();
    }

    @GetMapping(value = ITEM, produces = MediaType.APPLICATION_JSON_VALUE)
    public Item getItemById(@PathVariable(itemId) UUID id) {
        return itemService.getItemById(id);
    }

    @PostMapping(value=ADD_ITEM,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestBody Item item) {
        itemService.createItem(item);
    }

    @DeleteMapping(value = ITEM)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable(itemId) UUID id) {
        itemService.deleteItem(id);
    }

    @GetMapping(ISSUED)
    public List<IssuedItem> getIssuedItem(@PathVariable UUID id) {
        return itemService.getIssuedItemsById(id);
    }

    @PostMapping(value = ISSUE_ITEM, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveIssuedItem(@RequestBody IssuedItem issuedItem) {
        itemService.saveIssuedItem(issuedItem);
    }

    @GetMapping(value = SEARCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> searchByText(@RequestParam String query) {
        return itemService.searchByText(query);
    }




/*
    @GetMapping(value = "Items", produces = MediaType.APPLICATION_JSON_VALUE)
    public String openFrontPage(Model model, @PageableDefault(sort = {"quantity"}) Pageable pageable) {
        model.addAttribute("itemsByPage", itemService.getAllItemsPage(pageable));
        return "frontpage";
    }
    @GetMapping(value = "/addItem", produces = MediaType.APPLICATION_JSON_VALUE)
    public String openItemForm(Model model, String message) {
        model.addAttribute("item", new Item());
        model.addAttribute("categorySet", itemService.getItemCategorySet());
         model.addAttribute("message", messageService.getMessage(message));
        return "forms/itemForm";
    }
  @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/addItem", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createItem(Item item, BindingResult bindingResult , RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "forms/itemForm";
        }
        itemService.addItem(item);

        String message = "item.created";

        redirectAttributes.addFlashAttribute("message", "lt.codeacademy.eshop.product.create.message.success");
        return " redirect:/addItem";
    }
 @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String openItem(@PathVariable UUID id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        model.addAttribute("pictureUrl", "https://fi.makitamedia.com/images/3_Makita/301_machines/3011_a_GS1/30120_JPG_zoom/PT001GZ_C2L0.jpg");
        return "item";
    }
  @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}/delete")
    public String deleteItem(@PathVariable UUID id) {
        itemService.deleteItem(id);
        return "redirect:/sandelis";
    }
  @GetMapping("/{id}/issued")
    public String getIssuedItem(@PathVariable UUID id) {
        itemService.getIssuedItemsById(id);
        return "/itemIssued";
    }
*/

}
