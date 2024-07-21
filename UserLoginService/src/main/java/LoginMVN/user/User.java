package LoginMVN.user;

import java.util.Scanner;

import LoginMVN.db.DBmanager;

public class User {
	public  void createAccount() {
	       
    	Scanner scanner=new Scanner(System.in);
    	System.out.print("Enter first name: ");
        String firstName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String LastName = scanner.next();
        System.out.print("Enter User Name: ");
        String user = scanner.next();
        System.out.print("Enter Password: ");
        String pass = scanner.next();
        DBmanager dBmanager=new DBmanager();
        dBmanager.connect();
        dBmanager.dml_acc_cr(firstName, LastName, user, pass);
        dBmanager.disconnect();
       
}




public  void login()  {
 Scanner scanner=new Scanner(System.in);
 System.out.print("Enter User Name: ");
 String user = scanner.next();
 System.out.print("Enter Password: ");
 String pass = scanner.next();  
 DBmanager dBmanager=new DBmanager();
 dBmanager.connect();
 dBmanager.dql_show_user(user,pass);
 dBmanager.disconnect();
    
}




public  void passwordRst() {
 Scanner scanner=new Scanner(System.in);
 System.out.print("Enter User Name: ");
 String user = scanner.next();
 System.out.print("Enter Password: ");
 String pass = scanner.next();
 System.out.print("Enter New Password: ");
 String newpass = scanner.next();
 DBmanager dBmanager=new DBmanager();
 dBmanager.connect();
 dBmanager.dml_rst_pass(user, pass, newpass);
 dBmanager.disconnect();
 
 
 	


}



public void deleteAccount() {
 Scanner scanner=new Scanner(System.in);
 System.out.print("Enter User Name: ");
 String user = scanner.next();
 System.out.print("Enter Password: ");
 String pass = scanner.next();
 DBmanager dBmanager=new DBmanager();
 dBmanager.connect();
 dBmanager.dml_del_acc(user, pass);
 dBmanager.disconnect();
 
   
}


}
