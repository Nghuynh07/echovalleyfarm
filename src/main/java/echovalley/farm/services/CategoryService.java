package echovalley.farm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import echovalley.farm.models.Category;
import echovalley.farm.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Category> getCategories(){
		return this.categoryRepo.findAll();
	}
	
	public Category makeCategory(String cat) {
		Category newCategory = new Category(cat);
		return this.categoryRepo.save(newCategory);
	}
	
	
	public String deleteCategory(Long id) {
		this.categoryRepo.deleteById(id);
		return id + "was deleted";
	}
}
