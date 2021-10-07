package echovalley.farm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import echovalley.farm.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{
	public List<Category> findAll();
}
