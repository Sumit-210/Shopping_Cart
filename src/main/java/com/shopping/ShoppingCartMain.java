package com.shopping;

import java.util.*;

public class ShoppingCartMain {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ShoppingCartService ShoppingCartService = new ShoppingCartServiceImpl();

		while (true)

		{
			System.out.println("----Menu----");
			System.out.println(
					"1.Add_User\n\n2.Display_User\n\n3.Update_User\n\n4.Delete_User\n\n5.Add_Product\n\n6.Display_Product"
					+ "\n\n7.Update_Product\n\n8.Delete_Product\n\n9.Exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				ShoppingCartService.addUser();
				break;
			case 2:
				ShoppingCartService.displayUser();
				break;
			case 3:
				ShoppingCartService.updateUser();
				break;
			case 4:
				ShoppingCartService.deleteUser();
				break;
			case 5:
				ShoppingCartService.addProduct();
				break;
			case 6:
				ShoppingCartService.displayProduct();
				break;
			case 7:
				ShoppingCartService.updateProduct();
				break;
			case 8:
				ShoppingCartService.deleteProduct();       
				break;
			case 9:
				System.out.println("Exiting....");
				return;

			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}

		}

	}
}
