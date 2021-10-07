package echovalley.farm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import echovalley.farm.models.Gallery;
import echovalley.farm.models.User;

@Repository
public interface GalleryRepository extends CrudRepository<Gallery,Long>{
	List<Gallery> findAllByUser(User user);
}
