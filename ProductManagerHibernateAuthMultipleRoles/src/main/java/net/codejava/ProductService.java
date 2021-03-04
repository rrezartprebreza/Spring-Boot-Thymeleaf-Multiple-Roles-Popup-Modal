package net.codejava;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll() {		
		return repo.findAll();
	}
	
	public void save(Product product) {
		this.repo.save(product);
	}
	
	public Product getId(Long id) {
		Optional<Product> product = repo.findById(id);
        Product product1 = null;
        if (product.isPresent()) {
        	product1 = product.get();
        } else {
            throw new RuntimeException("Student not found for id ::" + id);
        }
        return product1;
	}
	
	public void update(Product product){
		repo.save(product);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
