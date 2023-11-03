package model;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Staff {
    private String StaffID;
    private String FullName;
    private String Department;
    private String Password;
    private Date DoB;
    public Staff(String staffID, String fullName, String department, String Password, Date doB) {
        this.StaffID = staffID;
        this.FullName = fullName;
        this.Department = department;
        this.Password = Password;
        this.DoB = doB;
    }
    public Staff () {

    }
    public String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String staffID) {
        StaffID = staffID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date doB) {
        DoB = doB;
    }
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Staff ID: ").append(this.StaffID);
        sb.append(" ,Full name: ").append(this.FullName);
        sb.append(" ,Department: ").append(this.Department);
        sb.append(" ,Password: ").append(this.Password);
        sb.append(" ,DoB: ").append(dateFormat.format(this.DoB));
        return sb.toString();
    }

    public void changePassword(String password) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====CHANGE PASSWORD=====");
        System.out.println("Enter correct old password:");
        String oldPassword = sc.nextLine();
        if (oldPassword.equals(password)) {
            System.out.println("====ENABLE CHANGING=====");
            System.out.println("====Enter new password=====");
            String newPassword = sc.nextLine();
            this.setPassword(newPassword);
            System.out.println("=====CHANGE COMPLETE=====");
        } else {
            System.out.println("=====WRONG PASSWORD=====");
        }
    }
}
