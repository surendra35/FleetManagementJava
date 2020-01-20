package fleetProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteruserManagerImpl implements RegisteruserManager 
{
	@Autowired
	RegisteruserDao dao;

	@Override
	public void addCustomer(Registeruser c) {
		
		dao.addCustomer(c);
	}

	

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(Registeruser customer, int id) {
		// TODO Auto-generated method stub
		dao.update(customer, id);
	}

	@Override
	public Registeruser getCustomer(int id) {
		// TODO Auto-generated method stub
		return dao.getCustomer(id);
	}

	@Override
	public List<Registeruser> getCustomers() {
		// TODO Auto-generated method stub
		return dao.getCustomers();
	}
	
	
	

}
