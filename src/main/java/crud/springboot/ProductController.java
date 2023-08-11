package crud.springboot;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public List<Product> list() {
		return service.listAll();
		}
	
	@GetMapping("/products/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        try {
            Product product = service.get(id)
;
            
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = "No row found against id_no:"+id;
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
	
	@PostMapping("/products")
    public ResponseEntity<?> add(@RequestBody Product product) {
        try {
            Integer id = product.getId();
            if (service.existsById(id)) {
                String errorMessage = "Row with id_no:"+id+" already exists";
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
            }
            else {
            	service.save(product);
                String successMessage = "Data Inserted Successfully";
                return ResponseEntity.ok(successMessage);            	
            }

        } catch (Exception e) {
            String errorMessage = "Data Not Inserted";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
	        


		
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
        try {
        	Product existingProduct = service.get(id);

            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            service.save(existingProduct);

            String successMessage = "Data Updated Successfully";
            return ResponseEntity.ok(successMessage);
        } catch (Exception e) {
            String a = "No row found against provided id number";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(a);
        }
    }
     
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
    try {
    	service.delete(id);
        String successMessage = "Row Deleted Successfully";
        
        return ResponseEntity.ok(successMessage);
    } catch (Exception e) {
        String errorMessage = "No row found against provided id number";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    }
}
	
	