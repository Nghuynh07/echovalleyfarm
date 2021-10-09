package echovalley.farm.repositories;




import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import echovalley.farm.models.Cart;



@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

	Cart findBycartSession(String tokenSession);

	List<Cart> findAll();
	
}
