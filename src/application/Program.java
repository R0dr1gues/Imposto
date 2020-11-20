package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.PhysicalPerson;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or campany (i/c)? ");
			char type = sc.next().charAt(0);
			if (type == 'i') {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Anual income: ");
				Double anualIncome = sc.nextDouble();
				System.out.print("Health expenditures: ");
				Double health = sc.nextDouble();
				list.add(new PhysicalPerson(name, anualIncome, health));
			} else {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Anual income: ");
				Double anualIncome = sc.nextDouble();
				System.out.print("Number of employees: ");
				Integer employees = sc.nextInt();
				list.add(new LegalPerson(name, anualIncome, employees));
			}
		}
			double sum = 0.0;
			System.out.println();
			System.out.println("TAXES PAID:");
			for (TaxPayer tp : list) {
				double tax = tp.tax();
				System.out.println(tp.getName() + ": $" + String.format("%.2f", tax));
				sum += tax;
			}
			System.out.println();
			System.out.println("TOTAL PAID: $ " + String.format("%.2f", sum));

		sc.close();
	}

}
