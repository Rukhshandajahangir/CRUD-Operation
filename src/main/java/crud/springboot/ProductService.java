package crud.springboot;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service          //to mark the class as a service provider
@Transactional         //Transactions are a way to manage database operations 
public class ProductService {
	
	@Autowired     
	private ProductRepository repo;
	
	public boolean existsById(Integer id) {
		return repo.existsById(id);
	}
	
	public List<Product> listAll() {
		return repo.findAll();
		}
	
	public void save(Product product) {
		 repo.save(product);
	}
	
	public Product get(Integer id) {
		return repo.findById(id).get();
		}
	
	public void delete(Integer id) {
		repo.deleteById(id);
		}
}