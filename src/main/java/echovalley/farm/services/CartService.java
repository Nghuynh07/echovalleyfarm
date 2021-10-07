package echovalley.farm.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import echovalley.farm.models.Cart;
import echovalley.farm.models.CartItem;
import echovalley.farm.models.Product;
import echovalley.farm.repositories.CartItemRepository;
import echovalley.farm.repositories.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductService prodService;
	@Autowired
	private CartItemRepository cartItemRepository;


	public CartItem updateShoppingCartItem(Long id, int quantity) {
		CartItem cartItem = cartItemRepository.findById(id).orElse(null);
		cartItem.setQuantity(quantity);
		cartItem.setTotalProductPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
		return cartItemRepository.save(cartItem);
	}
	
	public Cart newShoppingCart(Long id, String tokenSession, int quantity) {
		Cart cart = new Cart();
		CartItem cartItem = new CartItem();
		cartItem.setProduct(prodService.findOneProduct(id));
		cartItem.setQuantity(quantity);
		cartItem.setDate(new Date());
		cartItem.setTotalProductPrice(prodService.findOneProduct(id).getPrice() * cartItem.getQuantity());
		Math.floor(cartItem.getTotalProductPrice());
		cart.setTokenSession(tokenSession);
		cart.setDate(new Date());
		return cartRepository.save(cart);
	}
	
	public Cart existingShoppingCart(Long id, String token, int quantity) {
		Cart shoppingCart = cartRepository.findBytokenSession(token);
		Product product = prodService.findOneProduct(id);
		Boolean productDoesExistInTheCart = false;
		if(shoppingCart != null) {
			List<CartItem> items = shoppingCart.getItems();
				for(CartItem item : items) {
					if(item.getProduct().equals(product)) {
						item.setQuantity(quantity + item.getQuantity());
						item.setTotalProductPrice(product.getPrice() * item.getQuantity());
						Math.floor(item.getTotalProductPrice());
						shoppingCart.setItems(items);
						return cartRepository.save(shoppingCart);
					}
			}
		}
		if(!productDoesExistInTheCart && (shoppingCart != null))
		{
			CartItem cartItem1 = new CartItem();
			cartItem1.setProduct(product);
			cartItem1.setQuantity(quantity);
			cartItem1.setTotalProductPrice(product.getPrice() * cartItem1.getQuantity());
			Math.floor(cartItem1.getTotalProductPrice());
			cartItem1.setDate(new Date());
			shoppingCart.getItems().add(cartItem1);
			return cartRepository.save(shoppingCart);
		}

		return this.newShoppingCart(id, token, quantity);

	}
	public void clearCart(String tokenSession) {
		Cart shoppingCart = cartRepository.findBytokenSession(tokenSession);
		cartRepository.delete(shoppingCart);
	}

	public Cart removeCartIemFromShoppingCart(Long id, String sessionToken) {
		Cart shoppingCart = cartRepository.findBytokenSession(sessionToken);
		List<CartItem> items = shoppingCart.getItems();
		CartItem cartItem = null;
		for(CartItem item : items) {
			if(item.getId()==id) {
				cartItem = item;
			}
		}
		items.remove(cartItem);
		cartItemRepository.delete(cartItem);
	    shoppingCart.setItems(items);
	    return cartRepository.save(shoppingCart);
	}

	
}
	
