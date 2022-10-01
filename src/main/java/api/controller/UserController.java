package api.controller;

import api.dto.User;
import api.service.MessageService;
import api.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;
    private final MessageService messageService;


    public UserController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService=messageService;

    }

    @GetMapping("/register")
    public String registerUserForm (Model model, String message) {
        model.addAttribute("user", new User());
        model.addAttribute("message", messageService.getMessage(message));
        return "forms/userForm";
    }

    @PostMapping("/register")
    public String createUser(User user/*, BindingResult bindingResult, RedirectAttributes redirectAttributes*/) {
         /*   if(bindingResult.hasErrors()) {
            return "form/product";
        }*/
        userService.addUser(user);
        String message ="user.created";
        /*log.debug("Product {}", product);
        redirectAttributes.addFlashAttribute("message", "lt.codeacademy.eshop.product.create.message.success");
*/
        /* return "redirect:/products/save";*/
        return "redirect:/front";
    }
}
