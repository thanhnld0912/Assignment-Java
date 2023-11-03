package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffList {
    private List<Staff> staffList;
    public StaffList() {
        staffList = new ArrayList<>();
    }
    public void loadStaffsFromFile(File fileName) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String ID= getValue(parts[0].trim());

            String name = getValue(parts[1].trim());

            String department = getValue(parts[2].trim());
            String password = getValue(parts[3].trim());

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            String DobStr = getValue(parts[4].trim());

            Date Dob;
            Dob = dateFormat.parse(DobStr);

            Staff staff = new Staff(ID, name, department, password ,Dob);
            staffList.add(staff);
        }
        reader.close();
    }
    private String getValue(String part) {
        int index = part.indexOf(":");
        return part.substring(index + 1);
    }
    private boolean isDuplicateCode(String ID) {
        for (Staff staff : staffList) {
            if (staff.getStaffID().contains(ID)) {
                return true;
            }
        }
        return false;
    }
    public void displayStaffList() {
        if (staffList.isEmpty()) {
            System.out.println("No vaccines available.");
            return;
        }

        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }
    public void addNewStaff(String ID, String name, String department, String password,
                            String dobstr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Validate input
        if (ID.isEmpty() || name.isEmpty() || department.isEmpty() || password.isEmpty() || dobstr.isEmpty()) {
            System.out.println("Invalid input. Please provide all the required information.");
            return;
        }

        try {
            // Check for duplicate code
            if (isDuplicateCode(ID)) {
                System.out.println("Staff with the same ID already exists. Please provide a different code.");
                return;
            }

            Date dob = dateFormat.parse(dobstr);

            Staff staff = new Staff(ID, name, department, password, dob);
            staffList.add(staff);
            System.out.println("Staff added successfully.");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Vaccine not added.");
        }
    }
    public void deleteStaffByID(String ID) {
        for (Staff staff : staffList) {
            if (staff.getStaffID().contains(ID)) {
                staffList.remove(staff);
                System.out.println("Staff deleted successfully.");
                return;
            }
        }
        System.out.println("Staff not found.");
    }
    public void deleteStaffByName(String name) {
        for (Staff staff : staffList) {
            if (staff.getFullName().equalsIgnoreCase(name) ) {
                staffList.remove(staff);
                System.out.println("Staff deleted successfully.");
                return;
            }
        }
        System.out.println("Staff not found.");
    }
    public void deleteStaffByDepartment(String department) {
        for (Staff staff : staffList) {
            if (staff.getFullName().equalsIgnoreCase(department) ) {
                staffList.remove(staff);
                System.out.println("Staff deleted successfully.");
                return;
            }
        }
        System.out.println("Staff not found.");
    }
    public void searchStaffByName(String name) {
        for (Staff staff : staffList) {
            if (staff.getFullName().equalsIgnoreCase(name) ) {
                System.out.println(staff);
                return;
            }
        }
        System.out.println("Staff not found.");
    }
    public void searchStaffByID(String ID) {
        for (Staff staff : staffList) {
            if (staff.getStaffID().equalsIgnoreCase(ID) ) {
                System.out.println(staff);
                return;
            }
        }
        System.out.println("Staff not found.");
    }
    public void searchStaffByDepartment(String department) {
        for (Staff staff : staffList) {
            if (staff.getFullName().equalsIgnoreCase(department) ) {
                System.out.println(staff);
                return;
            }
        }
        System.out.println("Staff not found.");
    }
    public void searchStaffByPassword(String password) {
        for (Staff staff : staffList) {
            if (staff.getPassword().equalsIgnoreCase(password)) {
                System.out.println(staff);
                return;
            }
        }
        System.out.println("Staff not found.");
    }
//    public void searchStaffByDate(String dobstr) {
//        for (Staff staff : staffList) {
//            if (staff.getDoB().equalsIgnoreCase(name) ) {
//                System.out.println(staff);
//                return;
//            }
//        }
//        System.out.println("Staff not found.");
//    }
}
