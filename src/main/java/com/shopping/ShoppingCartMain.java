package com.shopping;

import java.util.*;

public class ShoppingCartMain {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

		while (true)

		{
			System.out.println("----Please choose your log in type----");
			System.out.println("1)User\n\n2)Admin\n\n3)Vendor\n\n4)Exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("---You have selected : USER LOGIN ----");
				shoppingCartService.userLog();
				break;
			case 2:
				System.out.println("---You have selected : ADMIN LOGIN ----");
				shoppingCartService.adminLog();
				break;
			case 3:
				System.out.println("---You have selected : VENDOR LOGIN ----");
				shoppingCartService.vendorLog();
				break;
			case 4:
				System.out.println("Exiting....");
				System.exit(0);

			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}

		}

	}
}
