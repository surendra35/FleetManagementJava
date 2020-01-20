package fleetProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public class RegisteruserDaoImpl implements RegisteruserDao
{
	
	@Autowired
	HibernateTemplate template;
	
	@Override
	public void addCustomer(Registeruser c) {
		
		template.save(c);
	}

	@Override
	public List<Registeruser> getCustomers() {
		
		
		@SuppressWarnings("unchecked")
		List<Registeruser> mylist=(List<Registeruser>) template.find("from Registeruser r");
		return mylist;
	}

	@Override
	public void delete(int id) {
		
		template.delete(template.get(Registeruser.class, id));
	}

	@Override
	public void update(Registeruser r, int id) {
	
		template.bulkUpdate("update Registeruser r1 set r1.userPassword=?,r1. userFirstname=?,r1.userLastname=?,r1.userAddress=?,r1.userEmailId=?,r1.userDrivingLicenseNo=?,r1.userPassportNo=?,r1.userPhoneNo=?,r1.userAadharNo=?,r1.userDob=? where r1.userId=?",
				            r.getUserPassword(),r.getUserFirstname(),r.getUserLastname(),r.getUserAddress(),r.getUserEmailId(),r.getUserDrivingLicenseNo(),r.getUserPassportNo(),r.getUserPhoneNo(),r.getUserAadharNo(),r.getUserDob(),id);
		
	}

	@Override
	public Registeruser getCustomer(int id) {
		Registeruser temp =(Registeruser) template.find("from Registeruser r where r. userId=?",id ).get(0);
		
		return temp;
	}

}
