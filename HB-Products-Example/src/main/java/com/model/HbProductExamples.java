package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HbProductExamples {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=HbUtil.getSessionFactory();
    	Session session=sessionFactory.getCurrentSession();
    	Transaction tx=session.beginTransaction();
    	
    	Criteria criteria=session.createCriteria(Product.class);
    	List<Product> proList=criteria.list();
    	for(Product pro:proList)
    	{
    		System.out.println("ID="+" "+pro.getSlno()+" "+pro.getPname()+" "+pro.getQty()+" "+pro.getPrice());
    	}
    	System.out.println("====================================================================");
    	proList=session.createCriteria(Product.class) .add(Restrictions.gt("price",20000)).list();
    	for(Product pro1:proList) 
    	{
    		System.out.println("Product whose price is greater than 20000 = "+pro1.getPname());
    	}
    	System.out.println("====================================================================");
    	proList=session.createCriteria(Product.class).add(Restrictions.gt("qty", 30)).list();
    	for(Product pro2:proList)
    	{
    		System.out.println("Product whose quantity is greater than 10 = "+pro2.getPname());
    	}
    	System.out.println("====================================================================");
    	Criteria d=session.createCriteria(Product.class);
    	proList=d.setProjection(Projections.max("price")).list();
    	System.out.println("Maximum of Price = "+proList.getFirst());
    	System.out.println("====================================================================");
    	Criteria c=session.createCriteria(Product.class);
    	proList=c.setProjection(Projections.min("price")).list();
    	System.out.println("Minimum of Price = "+proList.getFirst());
    	System.out.println("====================================================================");
    	Criteria f=session.createCriteria(Product.class);
    	proList=f.setProjection(Projections.sum("price")).list();
    	System.out.println("Sum of Price = "+proList.getFirst());
    	System.out.println("====================================================================");
    	Criteria g=session.createCriteria(Product.class);
    	proList=g.setProjection(Projections.count("pname")).list();
    	System.out.println("Count of the product = "+proList.getFirst());
    	System.out.println("====================================================================");
    	tx.commit();
    	sessionFactory.close();    	

	}

}