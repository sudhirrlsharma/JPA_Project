package cybage.entitymanager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import cybage.annotation.util.EntityManagerUtil;
import cybage.entity.BillingDetail;

public class BillingDetailDao {
	
	public void saveBillingDetail(BillingDetail bd) {
		
		EntityManager manager = null;
		EntityTransaction tx = null;
		try {
			manager = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(bd);
			tx.commit();
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public BillingDetail retriveBillingDetailById(Long id) {
		
		EntityManager manager = null;
		EntityTransaction tx = null;
		BillingDetail bd = null;
		try {
			manager = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			bd = manager.getReference(BillingDetail.class, id);
			manager.persist(bd);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return bd;
	}
	
	
public List<BillingDetail> retriveAllBillingDetailBy() {
		
		EntityManager manager = null;
		EntityTransaction tx = null;
		List<BillingDetail> bds = null;
		try {
			manager = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			  Query q = manager.createQuery("SELECT u FROM BillingDetail u " );
			  bds =q.getResultList();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return bds;
	}
}
