package fleetProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
//@CrossOrigin("http://localhost:4200")

public class Registerusercontroller
{
	@Autowired
	RegisteruserManager manager;
	
	@GetMapping(value = "fleet/search",headers = "Accept=application/json")  
	 public String showusers()
	 {
		  return new Gson().toJson(manager.getCustomers());
	 }
	
	@GetMapping(value = "fleet/search/{id}", headers = "Accept=application/json")  
	 public Registeruser getPro(@PathVariable int id)
	 {
		Registeruser c=manager.getCustomer(id);
		return c;
	 }
	
	@DeleteMapping(value = "fleet/delete/{id}", headers = "Accept=application/json")  
	 public void removepro(@PathVariable int id)
	 {
		manager.delete(id);
	 }
	
	@PutMapping(value = "fleet/update/{id}",headers = "Accept=application/json")  
	 public void updatepro(@RequestBody Registeruser customer,@PathVariable int id)
	 {
		manager.update(customer,id);
	 }

	@PostMapping(value = "fleet/add", headers = "Accept=application/json")  
	 public void addpro(@RequestBody Registeruser customer)
	 {
		System.out.println("customer called");
		manager.addCustomer(customer);
	 }
}
