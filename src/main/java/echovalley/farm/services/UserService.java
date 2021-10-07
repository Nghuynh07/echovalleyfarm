package echovalley.farm.services;



import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import echovalley.farm.models.Product;
import echovalley.farm.models.User;
import echovalley.farm.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	
	public User findUserByEmail(String email) {
		return this.userRepo.findByEmail(email);
	}
    
	public User registerAUser(User user) {
		String hashedpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
		user.setPassword(hashedpw);
		return this.userRepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password ) {
		User user = this.userRepo.findByEmail(email);
		if(user==null) {
			return false;
		}else {
			return BCrypt.checkpw(password, user.getPassword());
		}
	}
	
    public User oneUser(Long id) {
    	return this.userRepo.findById(id).orElse(null);
    }

    
    public void userLikeProduct(User user, Product product) {
    	List<Product> listOfProducts = user.getProductLiked();
    	listOfProducts.add(product);
    	this.userRepo.save(user);
    }
    
    public void userunLikeProduct(User user, Product product) {
    	List<Product> listOfProducts = user.getProductLiked();
    	listOfProducts.remove(product);
    	this.userRepo.save(user);
    }
    
    

}
