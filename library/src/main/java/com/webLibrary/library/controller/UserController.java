package com.webLibrary.library.controller;

import com.webLibrary.library.models.Book;
import com.webLibrary.library.models.Role;
import com.webLibrary.library.models.User;
import com.webLibrary.library.repositori.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("Users",userRepository.findAll());
        return "userList";
    }
    @GetMapping("/{id}/edit")
    public String updateUser(@PathVariable(value = "id") long id, Model model){
        if(!userRepository.existsById(id))
            return "redirect:/";
        Optional<User> user=userRepository.findById(id);
        ArrayList<User> list=new ArrayList<User>();
        user.ifPresent(list::add);
        model.addAttribute("user",list);
        return "user-edit";
    }
    @PostMapping("/{id}/edit")
    public String postUpdateUser(@PathVariable(value = "id") long id,
                                 @RequestParam String username,
                                 @RequestParam String role,
                                 Model model){
        User user=userRepository.findById(id).orElseThrow();
        user.setUsername(username);
        Set<Role> set=new HashSet<Role>();
        set.add(Role.valueOf(role));
        user.setRoles(set);
        userRepository.save(user);
        return "redirect:/";
    }
    @PostMapping("/{id}/remove")
    public String postDeleteUser(@PathVariable(value = "id") long id,
                                 Model model){
        User user=userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        return "redirect:/";
    }
}
