package cybage.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cybage.entitymanager.dao.BillingDetailDao;
import cybage.entitymanager.dao.UserDao;
import cybage.model.Address;


public class EntityManagerTest {
	
	public static void main(String argsa[]) {
		EntityManagerTest test = new EntityManagerTest();

//		BillingDetailDao billingDetail = new BillingDetailDao();
//		test.testBillingDetail(billingDetail);
//		test.testRetriveBillingDetails(billingDetail);
		
		UserDao userDao = new UserDao();
		test.testSaveUser(userDao, "sudhirsharma");
		test.testRetriveUser(userDao);
		
	}
	
	
	public void testBillingDetail(BillingDetailDao billingDetailDao) {
		BankAccount ba = new BankAccount();
		ba.setAccountNo(1923568555);
		ba.setBillSmount(1000);
		ba.setNominiName("sudhir sharma");
		
		billingDetailDao.saveBillingDetail(ba);
		
		CreaditCard cc = new CreaditCard();
		cc.setCreaditCardNo("abc182369");
		cc.setBillSmount(1000);
		billingDetailDao.saveBillingDetail(cc);
		System.out.println("user save successfully");
	}

	public void testRetriveBillingDetails(BillingDetailDao billingDetailDao) {
		 List<BillingDetail> details = billingDetailDao.retriveAllBillingDetailBy();
		 for(BillingDetail bd:details){
			 System.out.println(bd.toString());
		 }
		System.out.println("user save successfully");
	}

	
	
	public void testSaveUser(UserDao userDao, String userName) {
		
		Address address = new Address();
		address.setAddress1("C1 ");
		address.setAddress2("Kumar Cerebrum ");
		address.setCity("pune");
		address.setState("Maharastra");
		address.setCountry("India");
		
		User user = new User();
		user.setName(userName);
		user.setCompanyName("Cybage");
		user.setSalary(new Double(1000));
		user.setAddress(address);
		
		Set<BillingDetail> set = new HashSet<BillingDetail>();
		BankAccount ba = new BankAccount();
		ba.setAccountNo(1923568555);
		ba.setBillSmount(1000);
		ba.setNominiName("sudhir sharma");
		ba.setUser(user);
		
		set.add(ba);
		
		CreaditCard cc = new CreaditCard();
		cc.setCreaditCardNo("abc182369");
		cc.setBillSmount(1000);
		cc.setUser(user);
		set.add(cc);
		user.setBillingDetail(set);
		userDao.saveUser(user);
		System.out.println("user save successfully");
		
	}
	
	public void testRetriveUser(UserDao userDao) {
		User user = userDao.retriveUserByName("sudhirsharma");
		System.out.println("User  " + user);
		
		if(user.getBillingDetail()!=null && !user.getBillingDetail().isEmpty()){
			System.out.println("Billing Detail Size   " + user.getBillingDetail().size());
			 for(BillingDetail bd:user.getBillingDetail()){
				 System.out.println(bd.toString());
			 }
		}
		
	}
	
}
