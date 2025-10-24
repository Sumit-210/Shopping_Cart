package com.shopping;

import java.util.*;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static Scanner sc = new Scanner(System.in);

	public void userLog() {
		while (true) {
			System.out.println("Enter the choice");
			System.out.println("1)Add User\n\n 2)Update User\n\n3)View Products\n\n4)Exit");

			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				addUser();
				break;
			case 2:
				updateUser();
				break;
			case 3:
				displayAllProducts();
				break;
			case 4:
				return;
			default:
			    System.out.println("Invalid choice. Please try again.");
			    break;

			}
		}

	}

	public void adminLog() {
		while (true) {
			System.out.println("Enter the choice");
			System.out.println("1)Delete Customer\n\n2)Delete Product\n\n3)View All Users\n\n4)View All Products\n\n"
					+ "5)View a uesr\n\n6)View a Product\n\n7)Exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				deleteUser();
				break;
			case 2:
				deleteProduct();
				break;
			case 3:
				displayAllUser();
				break;
			case 4:
				displayAllProducts();
				break;
			case 5:
				displayUser();
				break;
			case 6:
				displayProduct();
				break;
			case 7:
				return;
			default:
			    System.out.println("Invalid choice. Please try again.");
			    break;

			}

		}
	}

	public void vendorLog() {
		while(true) {
			System.out.println("Enter the choice");
			System.out.println("1)Add Product\n\n2)Update Product\n\n3)Exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				addProduct();
			case 2:
				deleteProduct();
			case 3:
				return;
			default:
			    System.out.println("Invalid choice. Please try again.");
			    break;

			}
		}
	}

	public void addUser() {

		User user = new User();
		System.out.println("Enter the user Details");
		System.out.println("Enter the ID of the user");
		user.setId(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter the Name of the user");
		user.setName(sc.nextLine());
		System.out.println("Enter the Phone Number of the user");
		user.setPhone(sc.nextLong());
		sc.nextLine();
		System.out.println("Enter the Email ID of the user");
		user.setEmail(sc.nextLine());
		System.out.println("Enter the Password");
		user.setPassword(sc.nextLine());
		System.out.println("Enter the Role of the user");
		user.setRole(sc.nextLine());
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}

	public void deleteUser() {
		System.out.println("Enert the user ID to be deleted");
		int id = sc.nextInt();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		User user = entityManager.find(User.class, id);
		if (user == null) {
			System.out.println(" User not found!");
			entityManager.close();
			return;
		}
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
	}

	public void updateUser() {
		System.out.println("Enert the user ID that needs to be Updated");
		int id = sc.nextInt();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		User user = entityManager.find(User.class, id);
		if (user == null) {
			System.out.println(" User not found!");
			entityManager.close();
			return;
		}
		System.out.println("What needs to be Updaed ? \n");
		System.out.println("1.Name\n2.Email\n3.Phone Number\n4.Password\n5.Role\n6.Exit");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println("Enter the New Name  --");
			sc.nextLine();
			user.setName(sc.nextLine());
			break;
		case 2:
			System.out.println("Enter the New Email ID  --");
			sc.nextLine();
			user.setEmail(sc.nextLine());
			break;
		case 3:
			System.out.println("Enter the New Phone Number  --");
			sc.nextLine();
			user.setPhone(sc.nextLong());
			break;
		case 4:
			System.out.println("Enter the New Password  --");
			sc.nextLine();
			user.setPassword(sc.nextLine());
			break;
		case 5:
			System.out.println("Enter the New Role  --");
			sc.nextLine();
			user.setRole(sc.nextLine());
			break;
		case 6:
			return;

		default:
		    System.out.println("Invalid choice. Please try again.");
		    break;

		}
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();

	}

	public void displayUser() {
		System.out.println("Enert the ID of the User To Get the Details");
		int id = sc.nextInt();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		User user = entityManager.find(User.class, id);
		if (user == null) {
			System.out.println(" User not found!");
			entityManager.close();
			return;
		}
		System.out.println("Name          - " + user.getName());
		System.out.println("Email         - " + user.getEmail());
		System.out.println("Phone Number  - " + user.getPhone());
		System.out.println("Password      - " + user.getPassword());
		System.out.println("Role          - " + user.getRole());

	}

	public void displayAllUser() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<User> user = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
		for (User u : user) {
			System.out.println("Name          - " + u.getName());
			System.out.println("Email         - " + u.getEmail());
			System.out.println("Phone Number  - " + u.getPhone());
			System.out.println("Password      - " + u.getPassword());
			System.out.println("Role          - " + u.getRole());
		}
	}

	public void addProduct() {
		Product product = new Product();

		System.out.println("Enter the Product Details");
		System.out.println("Enter the Product ID");
		product.setId(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter the Product Name");
		product.setName(sc.nextLine());
		System.out.println("Enter the Product Price");
		product.setPrice(sc.nextDouble());
		sc.nextLine();
		System.out.println("Enter the Product Category");
		product.setCategory(sc.nextLine());
		System.out.println("Enter the Product Quantity");
		product.setQuantity(sc.nextInt());
		sc.nextLine();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();

	}

	public void deleteProduct() {
		System.out.println("Enter the  Product ID to be deleted ");
		int id = sc.nextInt();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Product product = entityManager.find(Product.class, id);
		if (product == null) {
			System.out.println(" Product not found!");
			entityManager.close();
			return;
		}
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(product);
		entityTransaction.commit();

	}

	public void updateProduct() {
		System.out.println("Enter the Product ID to Update");
		int id = sc.nextInt();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Product product = entityManager.find(Product.class, id);
		if (product == null) {
			System.out.println(" Product not found!");
			entityManager.close();
			return;
		}

		System.out.println("What needs to be Updated ? ");
		System.out.println("1.Name\n2.Price\n3.Category\n4.Quantity\n5.Exit");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println("Enter New Name of the Product ");
			sc.nextLine();
			product.setName(sc.nextLine());
			break;
		case 2: {
			System.out.println("Enter New Price of the Product ");
			product.setPrice(sc.nextDouble());
			break;
		}
		case 3: {
			System.out.println("Enter New Category of the Product ");
			sc.nextLine();
			product.setCategory(sc.nextLine());
			break;
		}
		case 4: {
			System.out.println("Enter New Quantity of the Product ");
			sc.nextLine();
			product.setQuantity(sc.nextInt());
			break;
		}
		case 5: {
			return;
		}
		default:
		    System.out.println("Invalid choice. Please try again.");
		    break;

		}
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(product);
		entityTransaction.commit();

	}

	public void displayProduct() {
		System.out.println("Enter the Product ID to Get Details");
		int id = sc.nextInt();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Product product = entityManager.find(Product.class, id);
		if (product == null) {
			System.out.println(" Product not found!");
			entityManager.close();
			return;
		}
		System.out.println("Name          - " + product.getName());
		System.out.println("Price         - " + product.getPrice());
		System.out.println("Category      - " + product.getCategory());
		System.out.println("Quantity      - " + product.getQuantity());

	}

	public void displayAllProducts() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Product> product = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
		for (Product p : product) {
			System.out.println("Name          - " + p.getName());
			System.out.println("Price         - " + p.getPrice());
			System.out.println("Category      - " + p.getCategory());
			System.out.println("Quantity      - " + p.getQuantity());
		}
	}
}
