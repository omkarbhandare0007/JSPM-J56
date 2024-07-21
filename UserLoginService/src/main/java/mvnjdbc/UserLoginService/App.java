package mvnjdbc.UserLoginService;

import java.util.Scanner;

import LoginMVN.user.User;

public class App 
{
	 public static void main (String  args[]) {
	       
			while(true){
         System.out.println();
         Scanner scanner = new Scanner(System.in);
         System.out.println("User Login System");
         System.out.println("1. Create Account");
         System.out.println("2. Login");
         System.out.println("3. Reset Password");
         System.out.println("4. Delete Account");

         System.out.println("0. Exit");
         System.out.print("Choose an option: ");
         int option = scanner.nextInt();
         switch (option) {
         	case 0:
         		System.exit(0);
         		break;
             case 1:
                 new User().createAccount();
                 break;
             case 2:
                 new User().login();
                 break;
             case 3:
                 new User().passwordRst();
                 break;
             case 4:
             	new User().deleteAccount();
                 break;
             default:
                 System.out.println("Invalid choice. Try again.");
         }
     }

 }
}
