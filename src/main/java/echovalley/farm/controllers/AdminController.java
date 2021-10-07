package echovalley.farm.controllers;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import echovalley.farm.models.Category;
import echovalley.farm.models.User;

import echovalley.farm.services.CategoryService;
import echovalley.farm.services.GalleryService;
import echovalley.farm.services.ProductService;

import echovalley.farm.services.UserService;

@Controller
public class AdminController {
	@Autowired
	private ProductService prodService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GalleryService galleryService;
	

	@Autowired
	private CategoryService categoryService;
	


	
	private static String UPLOADED_FOLDER = "src/main/resources/static/uploaded_images/";
	private static String SITE_IMAGES = "src/main/resources/static/img/";
	
	@GetMapping("/admin")
	public String admin(HttpSession session,
			Model model)
			 {
		if(session.getAttribute("user__id") != null) {
			Long id = (Long)session.getAttribute("user__id");
			model.addAttribute("products", this.prodService.findAllProducts());
			model.addAttribute("categories", this.categoryService.getCategories());
			model.addAttribute("product", this.prodService.findOneProduct(id));
			return "admin/admin.jsp";
		}else {
			return "redirect:/";
		}
	}


	
	//Delete Category 
	
	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id") Long id) {
		this.categoryService.deleteCategory(id);
		return "redirect:/admin";
	}

	//Add Category
	@PostMapping("/addCategory")
	public String addCategory(@RequestParam("category") String cat) {
		this.categoryService.makeCategory(cat);
		return "redirect:/admin";
	}
	
	//Delete Product
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
			this.prodService.deleteOneProduct(id);
			return "redirect:/admin";
	}
	
	//User Profile
	@PostMapping("/uploadImage")
	public String upload(
			HttpSession session,
			@RequestParam("image_url") MultipartFile file,
			RedirectAttributes redirect) {
		User user = this.userService.oneUser((Long)session.getAttribute("user__id"));
		if(file.isEmpty()) {
			redirect.addFlashAttribute("message", "Field cannot be empty");
			return "pages/profile.jsp";
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			String url = "/uploaded_images/" + file.getOriginalFilename();
			this.galleryService.uploadPIc(user, url);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "redirect:/profile";
	}
	
	//Add Product
	@PostMapping("/admin/makeProduct")
	public String add_product(
			@RequestParam("description") String description,
			@RequestParam("unit")String unit,
			@RequestParam("category") Category category,
			HttpSession session,@RequestParam("name") String name,
			@RequestParam("price") Double price, @RequestParam("img_url") MultipartFile file,
			RedirectAttributes redirect) {
		if(file.isEmpty()) {
			redirect.addFlashAttribute("message", "Field cannot be empty");
			return "pages/admin.jsp";
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(SITE_IMAGES + file.getOriginalFilename());
			Files.write(path, bytes);
			String url = "/img/" + file.getOriginalFilename();
			this.prodService.add_product(name, price, url, unit, description,category);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "redirect:/admin";
	}
	
	@GetMapping("/editPageForProduct/{id}")
	public String editPage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", this.prodService.findOneProduct(id));
		return "admin/editProduct.jsp";
	}
	

	

}
