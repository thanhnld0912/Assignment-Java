package controller;
import model.Staff;
import model.StaffList;
import view.Menu;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;


public class StaffManagement {

    private StaffList staffManage;
    private Scanner scanner;
    public Menu menu;

    public StaffManagement() {

        staffManage = new StaffList();
        scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        System.out.println("=== Staff Management System ===");
        System.out.println("1. Load staff from file");
        System.out.println("2. Display all Staffs");
        System.out.println("3. Add new staff");
        System.out.println("4. Delete a staff");
        System.out.println("5. Search staff");
        System.out.println("0. Exit");
        System.out.println("=================================");
    }
    public void handleInput() {
        int choice = -1;

        while (choice != 0) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                    case 1:
                        loadStaffsFromFile();
                        break;
                    case 2:
                        staffManage.displayStaffList();
                        break;
                    case 3:
                        addNewStaff();
                        break;
                    case 4:
                        deleteStaff();
                        break;
                    case 5:
                        searchStaff();
                        break;
                    case 0:
                        System.out.println("Exiting, thank you for using");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }

                System.out.println();
            }
        }

        public void loadStaffsFromFile() {
            File fileName =  new File("src/staff.txt");
            try {
                staffManage.loadStaffsFromFile(fileName);
                System.out.println("Staffs list loaded successfully.");
            } catch (IOException e) {
                System.out.println("Error loading staffs list from file: " + e.getMessage());
            } catch (ParseException e) {
                System.out.println("Invalid data format in the file: " + e.getMessage());
            }
        }
        public void addNewStaff() {
            System.out.print("Enter the staff ID: ");
            String ID = scanner.nextLine();
            System.out.print("Enter the staff name: ");
            String name = scanner.nextLine();
            System.out.print("Enter the department: ");
            String department = scanner.nextLine();
            System.out.println("Enter the password: ");
            String password = scanner.nextLine();
            System.out.println("Enter the dob (dd/MM/yyyy):");
            String dob = scanner.nextLine();
            staffManage.addNewStaff(ID, name, department, password, dob);
    }
    public void changePassword() {
        System.out.println("Change password");
        String password = scanner.nextLine();

    }
    public void deleteStaff() {
        System.out.println("=== Delete by categories ===");
        System.out.println("1. Delete by ID");
        System.out.println("2. Delete by Name");
        System.out.println("3. Delete by Department");
        System.out.println("4. Delete by Password");
        System.out.println("0. Exit");
        System.out.println("=================================");
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    System.out.println("Enter the ID");
                    String ID = sc.nextLine();
                    staffManage.deleteStaffByID(ID);
                    break;
                case 2:
                    System.out.println("Enter the Name");
                    String Name = sc.nextLine();
                    staffManage.deleteStaffByName(Name);
                    break;
                case 3:
                    System.out.println("Enter the department");
                    String department = sc.nextLine();
                    staffManage.deleteStaffByDepartment(department);
                    break;
                case 4:
                    System.out.println("Enter the password");
                    String password = sc.nextLine();
                    staffManage.deleteStaffByName(password);
                    break;
                case 0:
                    System.out.println("Back to main menu");
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
    public void searchStaff() {
        System.out.println("=== Delete by categories ===");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Department");
        System.out.println("4. Search by Password");
        System.out.println("0. Exit");
        System.out.println("=================================");
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    System.out.println("Enter the ID");
                    String ID = sc.nextLine();
                    staffManage.searchStaffByID(ID);
                    break;
                case 2:
                    System.out.println("Enter the Name");
                    String Name = sc.nextLine();
                    staffManage.searchStaffByName(Name);
                    break;
                case 3:
                    System.out.println("Enter the department");
                    String department = sc.nextLine();
                    staffManage.searchStaffByDepartment(department);
                    break;
                case 4:
                    System.out.println("Enter the password");
                    String password = sc.nextLine();
                    staffManage.searchStaffByPassword(password);
                    break;
                case 0:
                    System.out.println("Back to main menu");
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        StaffManagement sm = new StaffManagement();
        sm.handleInput();
    }
}

