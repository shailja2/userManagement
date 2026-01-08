package com.user.userManagement.controller;

import com.user.userManagement.dto.UserDTO;
import com.user.userManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm() {

        return "login";
    }
    @GetMapping("/admin")
    public String adminForm() {

        return "admin";
    }
    @GetMapping("/")
    public String defaultHome() {
        return "index";
    }

    @PostMapping("/register/save")
    public String saveUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result, Model model){
        UserDTO existing = userService.findByEmail(userDTO.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()){
            model.addAttribute("user", userDTO);
            return "register";
        }
        String password = userDTO.getPwd();
        boolean hasMoreSplChars = password.matches(".*[^a-zA-Z0-9].*[^a-zA-Z0-9].*");
        if(hasMoreSplChars){
            result.rejectValue("pwd", "","Single special character allowed");
            return "register";
        }
        userService.saveUser(userDTO);
        //return "User saved successfully!";
        return "redirect:/register?success";
    }

    @GetMapping("/register")
    public String showRegistration(Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "register";
    }


    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<UserDTO> userDTOList = userService.findAllUsers();
        model.addAttribute("users", userDTOList);
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "users";
    }

    @GetMapping("/delete/{Id}")
    public String deleteUser(@PathVariable Long Id){
        userService.deleteUser(Id);
        return"redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDTO userDTO){
        userService.updateUser(userDTO);
        return "redirect:/users";
    }
}
