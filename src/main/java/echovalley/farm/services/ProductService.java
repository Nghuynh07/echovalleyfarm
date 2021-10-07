package echovalley.farm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import echovalley.farm.models.Category;
import echovalley.farm.models.Product;
import echovalley.farm.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	
	public List<Product> findAllProducts(){
		return this.productRepo.findAll();
	}
	
	public Product findOneProduct(Long id) {
		return this.productRepo.findById(id).orElse(null);
	}
	

	public Product updateOneProduct(Product product) {
		return this.productRepo.save(product);
	}
	
	public void deleteOneProduct(Long id) {
		this.productRepo.deleteById(id);
	}
	
	public void add_product(String name, Double price, String img_url,String unit,String description,Category category) {
		Product newProduct = new Product(name,price,img_url,unit,description,category);
		this.productRepo.save(newProduct);
	}
	

	
}
