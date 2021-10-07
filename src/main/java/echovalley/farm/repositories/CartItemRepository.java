package echovalley.farm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import echovalley.farm.models.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
	List<CartItem> findAll();
	
	
}
