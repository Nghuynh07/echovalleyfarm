package echovalley.farm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import echovalley.farm.models.Gallery;
import echovalley.farm.models.User;
import echovalley.farm.repositories.GalleryRepository;

@Service
public class GalleryService {
	@Autowired
	private GalleryRepository galleryRepo;
	
	//create image object save to database
	
	public void uploadPIc(User user, String url) {
		Gallery newImg = new Gallery(url, user);
		this.galleryRepo.save(newImg);
	}
	
	public List<Gallery> uploadedImgages(User user){
		return this.galleryRepo.findAllByUser(user);
	}
	
}
