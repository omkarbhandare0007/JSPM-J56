package LoginMVN.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBmanager {
	
	private static final String url = "jdbc:mysql://localhost:3306/user_info";
    private static final String username = "root";
    private static final String password = "mysql";
    Connection connection;
    PreparedStatement statement;
    
   static { 
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
    }catch (ClassNotFoundException e){
        System.out.println(e.getMessage());
    }
   }
   
   public DBmanager() {
	// TODO Auto-generated constructor stub

   }
   
   
   
   public void connect()  {
	   try {
	 connection = DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   
   
   public void disconnect() {
	   try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   
   
   public void dml_acc_cr(String firname,String lasname, String user,String pass) {
	   
	   String sql = "INSERT INTO reservations (guest_name, room_number, contact_number) VALUES ('?','?','?','?')";

       try {
    	   	statement = connection.prepareStatement(sql);
    	    statement.setString(1, firname);
   			statement.setString(2, lasname);
   			statement.setString(3, username);
   			statement.setString(4, pass);
           int affectedRows = statement.executeUpdate();

           if (affectedRows > 0) {
               System.out.println("Account Created ");
           } else {
               System.out.println("Account not created change user name ");
           }
       }
   catch (SQLException e) {
       e.printStackTrace();
   }
	  
}
   
   
   public void dql_show_user(String user,String pass) {
	   
	   String sql = "SELECT first_name, lsat_name, useer_name FROM users where username='?' and passwords='?' ";

       
    	   try {
    	    statement = connection.prepareStatement(sql);
    	    statement.setString(1, user);
    		statement.setString(2, pass);
            ResultSet resultSet = statement.executeQuery(); 

           resultSet.next();
           System.out.println("Login Successful!!  \nUser_id= "+"User_name = "+resultSet.getString(4));
             }
    	   catch (Exception e) {
			// TODO: handle exception
    		   e.printStackTrace();
		}
   
    }
   
   
   
   
   public void dml_rst_pass(String user,String pass,String newpass) {
       String sql =" UPDATE users SET passwords=? WHERE user_name=? AND passwords=?";

       try {
    	    statement = connection.prepareStatement(sql);
    	    statement.setString(1,newpass);
    		statement.setString(2,user);
    		statement.setString(3,pass);
           int affectedRows = statement.executeUpdate();

           if (affectedRows > 0) {
               System.out.println("Password updated ");
           } else {
               System.out.println("Password update failed.");
           }
       }
    catch (SQLException e) {
       e.printStackTrace();
   }
   }
   
   
   public void dml_del_acc(String user,String pass) {
	   String cmnd="DELETE FROM users WHERE user_name=? AND passwords=?";
	try {
		statement=connection.prepareStatement(cmnd);
		statement.setString(1,user);
		statement.setString(2,pass);
		int affectedRows = statement.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Account  deleted ");
        } else {
            System.out.println("Account deletion failed.");
        }
	}
	catch (SQLException e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	   
   }
   
}
