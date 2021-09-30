package abc;

 class MenuOptions {

	public static void Welcome() {
		
		System.out.println("\n***********************************************************\n"
				+ "** Welcome to LockedMe.com\n" + "** This application was developed by Forqan Ahmed Bijapur\n"
				+ "***********************************************************\n");
	}

	public static void op2menu() {
		
		System.out.println("\n\n****** Select your option number from below******\n\n"
				+ "1) Add a file to Folder\n" 
				+ "2) Delete a file from Folder\n"
				+ "3) Search for a file from folder\n" 
				+ "4) Show Previous Menu\n" 
				+ "5) Exit program\n");
	}

}

public class LockedMeMain {

	public static void main(String[] args) {
		
		// create a folder if not present 
		FileOperations.createFolderIfNotPresent("Folder");
		
		MenuOptions.Welcome();
		
		Options.handleWelcomeScreenInput();
	}

	
}
