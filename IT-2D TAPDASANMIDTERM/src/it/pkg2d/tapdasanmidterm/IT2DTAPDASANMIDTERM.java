package it.pkg2d.tapdasanmidterm;

import jars.config;
import java.util.Scanner;

public class IT2DTAPDASANMIDTERM {

   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        String response;
        do{
        
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.println("Enter Action: ");
        int action = sc.nextInt();
        IT2DTAPDASANMIDTERM doctors = new IT2DTAPDASANMIDTERM ();

        switch(action){
            case 1:
                doctors.addDoctors();           
                break;
            case 2:       
                doctors.viewDoctors();
                break;
            case 3:
                doctors.viewDoctors();
                doctors.updateDoctors();
                doctors.viewDoctors();
                break;
            case 4:
                doctors.viewDoctors();
                doctors.deleteDoctors();
                doctors.viewDoctors();    
                break;
        }
        System.out.println("Do you want to continue? (yes/no)");
        response = sc.next();
    }while(response.equalsIgnoreCase("yes"));
    System.out.println("Thank You, See you soonest!");
    
    }
    
    
    public void addDoctors(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("First Name: ");
        String fname = sc.next();
        System.out.print("Last Name: ");
        String lname = sc.next();
        System.out.print("Specialization: ");
        String spec = sc.next();
        System.out.print("Contact Number: ");
        String cn = sc.next();
        System.out.print("Years of Experience: ");
        String years = sc.next();

        String sql = "INSERT INTO tbl_doctor (d_fname, d_lname, d_specialization, d_contactnumber, d_yearsofexperience) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, fname, lname, spec, cn, years);


    }

    private void viewDoctors() {
        config conf = new config();
        String Query = "SELECT * FROM tbl_doctors";
        String[] Headers = {"Doctors_ID","FirstName", "LastName", "Specialization", "ContactNumber", "YearsofExperience"};
        String[] Columns = {"d_id", "d_lname", "d_specialization", "d_contactnumber", "d_yearsofexperience"};
        
        
        conf.viewRecords(Query, Headers, Columns);
    }
    private void updateDoctors() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the ID to update: ");
        int id = sc.nextInt();
        
        System.out.println("New First Name: ");
        String nfname = sc.next();
        
        System.out.println("New Last Name: ");
        String nlname = sc.next();
        
        System.out.println("New Specialization: ");
        String nspec = sc.next();
        
        System.out.print("New Contact Number: ");
        String ncn = sc.next();
        
        System.out.print("New Years of Experience: ");
        String nyears = sc.next();
        
        String qry = "UPDATE tbl_doctor SET d_fname = ?, d_lname = ?, d_specialization = ?, d_contactnumber = ?, d_yearsofexperience = ? WHERE d_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, nfname, nlname, nspec, ncn, nyears, id);         
        
        
    }
    
    private void deleteDoctors() {
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Enter the ID  to delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_doctor WHERE d_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}