package echovalley.farm.controllers;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import echovalley.farm.services.CartItemService;
import echovalley.farm.services.CartService;


@Controller
public class CartController {
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private CartService cartService;

	
	@GetMapping("/shoppingCart")
	public String shoppingCart(HttpSession session, Model model) {
		model.addAttribute("items", cartItemService.getCartItems());
		String tokenSession = (String)session.getAttribute("tokenSession");

		if(tokenSession == null) {
			tokenSession = UUID.randomUUID().toString();
			session.setAttribute("tokenSession", tokenSession);
		}

		model.addAttribute("cart", tokenSession);
		System.out.println("Shopping Cart Session is:" + tokenSession);
		return "pages/cart.jsp";
	}
	
	
	@PostMapping("/addToCart")
	public String addToCart(
			HttpSession session,
			Model model,
			@RequestParam("id") Long id,
			@RequestParam("quantity") int quantity) {
		
		//tokenSession
		String token = (String) session.getAttribute("tokenSession");
		if(token == null) {
			token = UUID.randomUUID().toString();
			session.setAttribute("tokenSession", token);
			cartService.newShoppingCart(id, token, quantity);
		}
		else {
			this.cartService.existingShoppingCart(id,token,quantity);
			System.out.println("success");
		}
		return "redirect:/produces";
	}
	
	@GetMapping("/removeCartItem/{id}")
	public String removeItem(@PathVariable("id") Long id, HttpSession session) {
		String sessionToken = (String) session.getAttribute("tokenSession");
		cartService.removeCartIemFromShoppingCart(id,sessionToken);
		System.out.println("success");
		return "redirect:/shoppingCart";
	}

	@GetMapping("/clearCart")
	public String clearCart(HttpSession session) {
		String sessionToken = (String) session.getAttribute("tokenSession");
		session.removeAttribute(sessionToken);
		return "redirect:/shoppingCart";
	}


	@PostMapping("/updateQuantity/{id}")
	public String updateQuantity(@PathVariable("id") Long id, @RequestParam("quantity") int quantity) {
		this.cartService.updateShoppingCartItem(id, quantity);
		return "redirect:/shoppingCart";
	}
	
	@GetMapping("/checkout")
	public String checkout(HttpSession session, Model model) {
		model.addAttribute("items", cartItemService.getCartItems());
		String tokenSession = (String)session.getAttribute("tokenSession");
		Long id = (Long)session.getAttribute("user__id");
		if(id == null) {
			return "redirect:/";
		}
		if(tokenSession == null) {
			tokenSession = UUID.randomUUID().toString();
			session.setAttribute("tokenSession", tokenSession);
		}

		model.addAttribute("cart", tokenSession);
		return "pages/checkOutPage.jsp";
	}
	
}
