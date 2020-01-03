package com.deloitte.estore.applications;
import java.util.List;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.deloitte.estore.model.Product;
import org.hibernate.query.Query;
public class DeloitteEStoreApp {

	public static void main(String[] args)  {
		SessionFactory sf= new Configuration()
				                  .configure()
				                  .addAnnotatedClass(Product.class)
				                  .buildSessionFactory();
		
	//	Product product = new Product(1265,"LAPTOP",505);
		
		Session ssn= sf.openSession();
		Transaction tx= ssn.beginTransaction();
		
		@SuppressWarnings("rawtypes")
		Query q= ssn.createQuery("from Product");
		@SuppressWarnings("unchecked")
		List<Product> products= q.getResultList();
		products.forEach(System.out::println);
		
		//ssn.save(product);
		tx.commit();
		ssn.close();
	}
}
