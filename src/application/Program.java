package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int number;
		String holder;
		Account account;
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			sc.nextLine();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			sc.nextLine();
			account = new Account(number, holder, initialBalance, withdrawLimit);
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.println("New balance: " + account.getInicialBalance());
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Input error: Invalid Type");
		}
	}

}
