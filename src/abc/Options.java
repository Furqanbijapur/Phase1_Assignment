package abc;

import java.util.List;
import java.util.Scanner;

public class Options {
	public static void handleWelcomeScreenInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				String menu = "\n\n****** Select any option number from below and press Enter ******\n\n"
						+ "1) Retrieve all files inside \"main\" folder\n" + "2) Display menu for File operations\n"
						+ "3) Exit program\n";
				System.out.println(menu);
				int input = sc.nextInt();

				switch (input) {
				case 1:
					FileOperations.displayAllFiles("Folder");
					break;
				case 2:
					Options.handleFileMenuOptions();
					break;
				case 3:
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
		} while (running == true);
	}
	
	public static void handleFileMenuOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				MenuOptions.op2menu();
				FileOperations.createFolderIfNotPresent("Folder");
				
				int input = sc.nextInt();
				switch (input) {
				case 1:
					// File Add
					System.out.println("Enter the file-name to be added to the Folder");
					String NewFile = sc.next();
					
					FileOperations.createFile(NewFile, sc);
					
					break;
				case 2:
					// File/Folder delete
					System.out.println("Enter the file-name to be deleted from the Folder");
					String DeleteFile = sc.next();
					
					FileOperations.createFolderIfNotPresent("Folder");
					List<String> filesToDelete = FileOperations.displayFileLocations(DeleteFile, "Folder");
					
					System.out.println("\nSelect index of which file to delete?");
				
					int idx = sc.nextInt();
					FileOperations.deleteFileRecursively(filesToDelete.get(idx - 1));
					
					break;
				case 3:
					// File/Folder Search
					System.out.println("Enter the file-name to be searched from folder");
					String fileName = sc.next();
					
					FileOperations.createFolderIfNotPresent("Folder");
					FileOperations.displayFileLocations(fileName, "Folder");

					break;
				case 4:
					// Go to Previous menu
					return;
				case 5:
					// Exit
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
	}
}
