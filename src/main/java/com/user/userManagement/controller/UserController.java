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
//@RequestMapping ("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm() {

        return "login";
    }
    @GetMapping("/")
    public String defaultHome() {
        return "index";
    }

    @PostMapping("/register/save")
    //public String saveUser(@RequestBody UserDTO userDTO){
    public String saveUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result, Model model){
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
        return "redirect:/user/register?success";
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
        return "users";
    }

    @GetMapping("/delete/{Id}")
    public String deleteUser(@PathVariable Long Id){
        userService.deleteUser(Id);
        return"redirect:/user/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam Long userId, @RequestParam String name, @RequestParam String pwd, @RequestParam String phoneNo, @RequestParam String usrAddress, @RequestParam String email){
        userService.updateUser(userId, name, email, pwd, phoneNo, usrAddress);
        return "redirect:/user/users";
    }
}
