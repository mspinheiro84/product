package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		List<Product> list = new ArrayList<>();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char c = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			switch (c) {
				case 'u': {
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					list.add(new UsedProduct(name, price, date));
					break;
				}
				case 'i': {
					System.out.print("Customs fee: ");
					double customsFee = sc.nextDouble();
					list.add(new ImportedProduct(name, price, customsFee));
					break;
				}
				default:
					list.add(new Product(name, price));
			}
		}
				
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product p : list) {
			System.out.println(p.priceTag());
		}
		sc.close();
	}

}
