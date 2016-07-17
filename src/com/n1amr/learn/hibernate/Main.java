package com.n1amr.learn.hibernate;

import com.n1amr.learn.hibernate.entities.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;


@SuppressWarnings("WeakerAccess")
public class Main {
	public static void main(String[] args) {
		Address address = new Address("street", "city", "state", "pin code");
		Vehicle vehicle = new Vehicle("vehicle2");
		User user = new User("Amr Alaa", new Date());
		user.getAddresses().add(address);
		user.setVehicle(vehicle);
		Item item;
		Collection<Item> items = user.getItems();
		for (int i = 1; i <= 5; i++) {
			item = new Item("Item #" + i);
			item.setOwner(user);
			items.add(item);

			User user1 = new User("User #" + i, new Date());
			address = new Address("street" + i, "city" + i, "state" + i, "pin code" + i);
			user.getAddresses().add(address);
			user.getFollowing().add(user1);

			Vehicle vehicle1 = new Vehicle("Vehicle #" + i);
			user.getRentedVehicles().add(vehicle1);
			vehicle1.getRentingUsers().add(user);
			user1.getRentedVehicles().add(vehicle1);
			vehicle1.getRentingUsers().add(user1);

			Vehicle vehicle2;
			if (i % 2 == 0)
				vehicle2 = new TwoWheeler("Bike #" + i, i * 10);
			else
				vehicle2 = new FourWheeler("Car #" + i, i * 50);

			user.getRentedVehicles().add(vehicle2);
			vehicle2.getRentingUsers().add(user);

		}

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session;

		System.out.println("Before first get");
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.get(User.class, 3);

		session.getTransaction().commit();
		session.close();


		session = sessionFactory.openSession();
		session.setCacheMode(CacheMode.GET);
		session.beginTransaction();

		session.get(User.class, 3);

		session.getTransaction().commit();
		session.close();
		System.out.println("After second get");

		System.out.println("Before first query");
		session = sessionFactory.openSession();
		session.beginTransaction();

		printUsersList(session.createQuery("from amr_users user where user.id = 4").setCacheable(true).list());

		session.getTransaction().commit();
		session.close();


		session = sessionFactory.openSession();
		session.setCacheMode(CacheMode.GET);
		session.beginTransaction();

		printUsersList(session.createQuery("from amr_users user where user.id = 4").setCacheable(true).list());

		session.getTransaction().commit();
		session.close();
		System.out.println("After second query");


		session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();

//	  Retrieve session
		session = sessionFactory.openSession();

		user = (User) session.get(User.class, 1);
		System.out.println("Retrieved user 1 (" + user.getName() + ")");
		Set<Address> addresses = user.getAddresses();

		System.out.println("\nUser has " + addresses.size() + " addresses:");
		for (Address address1 : user.getAddresses())
			System.out.println(address1.getStreet());

		vehicle = user.getVehicle();
		System.out.println("\nUser has vehicle: " + vehicle.getName());

		System.out.println("\nUser has " + user.getItems().size() + " items:");
		for (Item item1 : user.getItems())
			System.out.println(item1.getName());

		item = (Item) session.get(Item.class, 2);
		System.out.print("\nItem 2 (" + item.getName() + ")");
		System.out.println("'s owner is " + item.getOwner().getName());

		Collection<User> following = user.getFollowing();
		System.out.println("\nUser is following " + following.size() + " users");
		for (User user1 : following)
			System.out.println(user1.getName());

		Collection<Vehicle> rentedVehicles = user.getRentedVehicles();
		System.out.println("\nUser rented " + rentedVehicles.size() + " vehicles");
		for (Vehicle vehicle1 : rentedVehicles)
			System.out.println(vehicle1.getName());

		vehicle = (Vehicle) session.get(Vehicle.class, 4);
		Collection<User> rentingUsers = vehicle.getRentingUsers();
		System.out.println("\nVehicle 4 (" + vehicle.getName() + ") is rented by " + rentingUsers.size() + " users");
		for (User user1 : rentingUsers)
			System.out.println(user1.getName());


		session.close();

		session = sessionFactory.openSession();
		Query query = session.createQuery("from amr_users where name like ?");
		query.setString(0, "User%");

		printUsersList(query.list());

		query = session.getNamedQuery("User.byId");
		query.setInteger(0, 1);

		printUsersList(query.list());

		query = session.getNamedQuery("User.byName");
		//noinspection JpaQueryApiInspection
		query.setString(0, "Amr Alaa");

		printUsersList(query.list());

		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("name", "User #3"));

		printUsersList(criteria.list());

		User exampleUser = new User("User %", new Date(1000L));
		Example example = Example.create(exampleUser)
			.enableLike()
			.excludeProperty("joinedDate");

		criteria = session.createCriteria(User.class)
			.add(example)
			.add(Restrictions.ge("id", 3));

		printUsersList(criteria.list());


		session.close();
	}

	private static void printUsersList(List users) {
		for (Object o : users) {
			User user = (User) o;
			System.out.println("id " + user.getId() + ": " + user.getName());
		}
	}
}
