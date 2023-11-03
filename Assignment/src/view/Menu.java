package view;
import controller.StaffManagement;
public class Menu {
    public void displayMenu() {
        System.out.println("=== Vaccine Management System ===");
        System.out.println("1. Load vaccines from file");
        System.out.println("2. Display all vaccines");
        System.out.println("3. Add a new vaccine");
        System.out.println("4. Delete a vaccine");
        System.out.println("5. Sort vaccines by name");
        System.out.println("6. Save vaccines to file");
        System.out.println("0. Exit");
        System.out.println("=================================");
    }
    public Menu() {

    }
}
