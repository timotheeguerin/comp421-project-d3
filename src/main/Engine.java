package main;

public class Engine {

	public void start() {
		homepage();
	}

	private void homepage() {
		System.out.println("Welcome to to best cooking website in the world!");
		System.out.println("================================================");
		int choice = printOptions(new String[] { "Signin", "Sign up", "Quit" });
		if (choice == 0) {
			
		}
			
	}

	private int printOptions(String[] options) {
		System.out.println("What do you want to do?");
		for (int i = 0; i < options.length; i++) {
			System.out.println((i+1) + ".\t" + options[i]);
		}
		return 0;
	}
}
