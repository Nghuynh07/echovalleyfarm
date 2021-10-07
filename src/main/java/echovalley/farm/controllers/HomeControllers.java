package echovalley.farm.controllers;





import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import echovalley.farm.models.User;
import echovalley.farm.services.CartItemService;
import echovalley.farm.services.ProductService;
import echovalley.farm.services.UserService;
@Controller
public class HomeControllers {
	@Autowired
	private ProductService prodService;
	
	@Autowired
	private UserService userService;


	
	@Autowired
	private CartItemService cartItemService;
	
	private String[] years = {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
	private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct","Nov", "Dec"};
	
	@GetMapping(value={"/", "/home"})
	public String home(HttpSession session,Model model) {
		String cartSession = (String) session.getAttribute("tokenSession");
		model.addAttribute("cart", cartSession);
		model.addAttribute("items", cartItemService.getCartItems());
		model.addAttribute("products", this.prodService.findAllProducts());

		return "pages/homePage.jsp";
	}
	
	@GetMapping("/profile")
	public String profilePage(
			HttpSession session,
			Model model) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		Long userId = (Long )session.getAttribute("user__id");
		User loggedInUser = this.userService.oneUser(userId);
		model.addAttribute("user", loggedInUser);
		model.addAttribute("years", this.years);
		model.addAttribute("months", this.months);

		return "pages/profile.jsp";
	}
	
	@GetMapping("/about")
	public String about() {
		return "pages/about.jsp";
	}

	@GetMapping(value={"/products", "/produces"})
	public String products(Model model, HttpSession session) {
		String tokenSession = (String)session.getAttribute("tokenSession");
		model.addAttribute("cart", tokenSession);
		model.addAttribute("products", prodService.findAllProducts());
		model.addAttribute("items", cartItemService.getCartItems());
		return "pages/products.jsp";
	}

}
