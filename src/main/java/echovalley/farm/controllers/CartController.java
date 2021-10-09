package echovalley.farm.controllers;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import echovalley.farm.services.CartItemService;
import echovalley.farm.services.CartService;


@Controller
public class CartController {
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private CartService cartService;

	
	@GetMapping("/shoppingCart")
	public String shoppingCart(HttpServletRequest request, Model model) {
		String token = (String)request.getSession().getAttribute("token");
		request.setAttribute("cart", token);
		model.addAttribute("cart", cartService.getCarts());
		model.addAttribute("items", cartItemService.getCartItems());
		System.out.println("Current Shopping Cart Session is:" + request.getSession(false).getAttribute("token"));
		return "pages/cart.jsp";
	}
	
	
	@PostMapping("/addToCart")
	public String addToCart(
			HttpSession session,
			HttpServletRequest request,
			Model model,
			@RequestParam("id") Long id,
			@RequestParam("quantity") int quantity) {
		
		//tokenSession
		String token = (String) request.getSession(true).getAttribute("token");
		if(token == null) {
			token = UUID.randomUUID().toString();
			request.getSession().setAttribute("token", token);
			request.getSession().setMaxInactiveInterval(604800);
			this.cartService.newShoppingCart(id, token, quantity);
			System.out.println("Shopping Cart Session timedout is: " + request.getSession().getMaxInactiveInterval());
		}
		else {
			this.cartService.existingShoppingCart(id,token,quantity);
			System.out.println("Success");
		}
		return "redirect:/produces";
	}
	
	@GetMapping("/removeCartItem/{id}")
	public String removeItem(@PathVariable("id") Long id, HttpServletRequest request) {
		String token = (String) request.getSession(false).getAttribute("token");
		cartService.removeItemFromCart(id,token);
		System.out.println("success");
		return "redirect:/shoppingCart";
	}

	@GetMapping("/clearCart")
	public String clearCart(HttpServletRequest request, RedirectAttributes redirect) {
		String token = (String) request.getSession(false).getAttribute("token");
		request.getSession(false).removeAttribute(token);
		cartService.clearCart(token);
		return "redirect:/shoppingCart";
	}


	@PostMapping("/updateQuantity/{id}")
	public String updateQuantity(@PathVariable("id") Long id, @RequestParam("quantity") int quantity) {
		this.cartService.updateShoppingCartItem(id, quantity);
		return "redirect:/shoppingCart";
	}
	
	@GetMapping("/checkout")
	public String checkout(HttpServletRequest request, Model model, RedirectAttributes redirect) {
		model.addAttribute("items", cartItemService.getCartItems());
		String token = (String)request.getSession(false).getAttribute("token");
		Long id = (Long)request.getSession().getAttribute("user__id");
		if(id == null) {
			redirect.addFlashAttribute("login_error", "Please login to check out");
			return "redirect:/login";
		}
		model.addAttribute("cart", token);
		return "pages/checkOutPage.jsp";
	}
	
}
