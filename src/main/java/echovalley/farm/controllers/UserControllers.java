package echovalley.farm.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import echovalley.farm.models.User;
import echovalley.farm.services.CartItemService;
import echovalley.farm.services.UserService;
import echovalley.farm.validations.UserValidations;

@Controller
public class UserControllers {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidations userValidations;
	
	@Autowired
	private CartItemService cartItemService;
	
	
	@GetMapping("/register")
	public String registerPage(@ModelAttribute("user") User user) {
		return "pages/register.jsp";
	}
	
	@GetMapping("/login")
	public String loginPage(Model model, @ModelAttribute("user") User user) {
		model.addAttribute("items", cartItemService.getCartItems());
		return "pages/login.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, HttpSession session, BindingResult result) {
		userValidations.validate(user, result);
		if(result.hasErrors()) {
			return "pages/register.jsp";
		}
		else {
			User newUser = this.userService.registerAUser(user);
			session.setAttribute("user__id", newUser.getId());
			return "redirect:/home";
		}
	}
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirect, HttpSession session) {
		if(!this.userService.authenticateUser(email, password)) {
			redirect.addFlashAttribute("error", "Invalid Credentials");
			return "redirect:/login";
		}
		else {
			User user = this.userService.findUserByEmail(email);
			session.setAttribute("user__id", user.getId());
			System.out.println("User Logged in as " + session);
			return "redirect:/";
		}
	}
	@GetMapping("/logout")
	public String personLogout(HttpSession session) {
		session.removeAttribute("user__id");
		System.out.println("User Logged out as " + session);
		return "redirect:/";
	}

}
