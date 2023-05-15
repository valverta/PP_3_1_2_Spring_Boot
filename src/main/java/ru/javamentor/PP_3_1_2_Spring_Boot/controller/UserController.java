package ru.javamentor.PP_3_1_2_Spring_Boot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.PP_3_1_2_Spring_Boot.model.User;
import ru.javamentor.PP_3_1_2_Spring_Boot.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		model.addAttribute("allUser", userService.getAllUsers());
		return "index";
	}

	@GetMapping(value = "/post-page")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "post-page";
	}

	@PostMapping(value = "/add-user")
	public String addNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "post-page";
		userService.saveUser(user);
		return "redirect:/";
	}

	@GetMapping(value = "/update-page/{id}")
	public String updateUser(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		return "update-page";
	}

	@PatchMapping(value = "/save-user")
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "update-page";
		userService.updateUser(user);
		return "redirect:/";
	}

	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable("id") int id){
		userService.removeUser(id);
		return "redirect:/";
	}
}