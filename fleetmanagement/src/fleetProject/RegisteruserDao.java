package fleetProject;

import java.util.List;

public interface RegisteruserDao 
{
	
	void addCustomer(Registeruser c);
	List<Registeruser> getCustomers();
	void delete(int id);
	void update(Registeruser customer,int id);
	Registeruser getCustomer(int id);

}
