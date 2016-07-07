package cybage.entitymanager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import cybage.annotation.util.EntityManagerUtil;
import cybage.entity.User;

public class UserDao {

	public void saveUser(User user) {

		EntityManager manager = null;
		EntityTransaction tx = null;
		try {
			manager = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(user);
			tx.commit();
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public User retriveUserById(Long id) {

		EntityManager manager = null;
		EntityTransaction tx = null;
		User user = null;
		try {
			manager = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			user = manager.getReference(User.class, id);
			manager.persist(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return user;
	}

	public User retriveUserByName(String name) {

		EntityManager manager = null;
		EntityTransaction tx = null;
		User user = null;
		try {
			manager = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			user = (User) manager.createNamedQuery("User.findByName").setParameter("name", name).getSingleResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return user;
	}

	public User retriveUserByNameCritegra(String name) {

		EntityManager manager = null;
		EntityTransaction tx = null;
		User user = null;
		try {
			manager = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			user = (User) manager.createNamedQuery("User.findByName").setParameter("name", name).getSingleResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return user;
	}

	
	public List<User> retriveUsers() {

		EntityManager manager = null;
		EntityTransaction tx = null;
		List<User> users = null;
		try {
			manager = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
			tx = manager.getTransaction();
			tx.begin();

			Query q = manager.createQuery("SELECT u FROM User u ");
			users = q.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return users;
	}
}
