package com.amr.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {
	public static void main(String[] args) {
		int count = 5;
		UserDetails[] users = new UserDetails[count];
		for (int i = 0; i < count; i++) {
			users[i] = new UserDetails();
			users[i].setUserId(i + 1);
			users[i].setUserName("Updated Amr Alaa " + new Date() + (i + 1));
		}

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

//		for (int i = 0; i < count; i++)
//			session.update(users[i]);
		session.delete(users[2]);

		session.getTransaction().commit();
	}
}
