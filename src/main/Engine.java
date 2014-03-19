package main;

import java.util.Scanner;

public class Engine {

	private int user_id;

	public void start() {
		homepage();
	}

	private void homepage() {
		System.out.println("Welcome to to best cooking website in the world!");
		System.out.println("================================================");
		int choice = printOptions(new String[] { "Signin", "Sign up", "Quit" });
		if (choice == 1) { // Signin
			System.out.println("Sign in!");
			return;
		} else if (choice == 2) { // Sign up
			System.out.println("Signup!");
			return;
		} else if (choice == 3) { // Quit
			System.out.println("Why do you leave us!");
			return;
		}

	}

	private void signin() {
		System.out.println();
		System.out.println("================================================");
		System.out.println("\t LOGIN");
		System.out.println("================================================");
		Scanner scanIn = new Scanner(System.in);
		while (true) {
			System.out.print("Username: ");
			System.out.print("Password: ");
		}
	}

	private void signup() {
		System.out.println();
		System.out.println("================================================");
	}

	private int printOptions(String[] options) {
		System.out.println("\nWhat do you want to do?");
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ".\t" + options[i]);
		}
		Scanner scanIn = new Scanner(System.in);

		int result = 0;
		while (!(result > 0 && result <= options.length)) {
			System.out.print("Choice: ");
			result = scanIn.nextInt();
		}
		scanIn.close();
		return result;
	}
}
