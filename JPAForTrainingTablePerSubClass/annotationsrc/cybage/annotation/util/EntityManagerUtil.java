/**
 * 
 */
package cybage.annotation.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author SudhirSharma
 * 
 */
public class EntityManagerUtil {
	
	private static EntityManagerFactory emf;
	
	static {
		try {
			// Create the SessionFactory
			emf = Persistence.createEntityManagerFactory("JPAService");
			
		} catch (Throwable ex) {
			
			System.out.println("Initial SessionFactory creation failed.");
			throw new ExceptionInInitializerError(ex);
			
		} // end of the try - catch block
		
	} // end of static block
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}
