package echovalley.farm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import echovalley.farm.models.CartItem;
import echovalley.farm.repositories.CartItemRepository;

@Service
public class CartItemService {
	@Autowired
	private CartItemRepository cartItemRepo;
	
	
	public List<CartItem> getCartItems(){
		return this.cartItemRepo.findAll();
	}

	
}
