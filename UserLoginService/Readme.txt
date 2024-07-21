Auther:1:Linge Shubham 
	   2:Nitin Munde
	   3:Shivam Barve 
	   4:Jayesh Pawar
	   5:Gayatri Joshi



Description:This program  is of basic user login services, you have option  
			1:register
			2:login
			3:delete password
			4:reset password
			5:exit
			
			It is done using JDBC and MVC format
			
			
Files in the forler:1:Main.java
	  				 
	  				 this contains the basic logic of choosing and executing  the action.
	  				 
	  				2:User.java
	  				
	  				  this is the class that is used as a entity
	  				  follwing fileds :1:user_name
	  				  				   2:user_password
	  				  				   
	  				3:UserDAO.java
	  				
	  				  this file is used as the DAO layer and has function to uxecute the actions
	  				  
	  				4:create_sql_db.txt
	  				
	  					this file is used to create the database in mysql
	  					
	  					
Steps before Running the code:

								1:run the sql commands given in the sql.txt in your mysql workbench
								2:open UserDAO.java and change the value of 'user' and 'password' present on line 16 and 17
								3:run the Main.java.    