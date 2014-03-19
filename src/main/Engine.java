package main;

import java.util.Scanner;

public class Engine {

	private int user_id;

	Scanner scanIn = new Scanner(System.in);
	
	public void start() {
		homepage();
	}

	private void homepage() {
		System.out.println("Welcome to to best cooking website in the world!");
		System.out.println("================================================");
		int choice = printOptions(new String[] { "Signin", "Sign up", "Quit" });
		if (choice == 1) { // Signin
		 	signin();
			return;
		} else if (choice == 2) { // Sign up
			System.out.println("Signup!");
			return;
		} else if (choice == 3) { // Quit
			System.out.println("Why do you leave us!");
			scanIn.close();
			System.exit(0);
		}

	}

	private void signin() {
		
		System.out.println();
		System.out.println("================================================");
		System.out.println("\t LOGIN");
		System.out.println("================================================");
		String email, password;
		while (true) {
			System.out.print("Email: ");
			email = scanIn.next();
			System.out.println(email);
			System.out.print("Password: ");
			password = scanIn.next();
			System.out.println(password);
			System.out.println(DBProcess.loginUser(email, password));
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
		
		int result = 0;
		while (!(result > 0 && result <= options.length)) {
			System.out.print("Choice: ");
			result = scanIn.nextInt();
		}
		return result;
	}
}
