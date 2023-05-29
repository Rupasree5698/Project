 package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.io.InputStreamReader;
import model.Login;
import model.Product;
import dao.LoginDAO;
import dao.ProductDAO;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException,ClassNotFoundException,SQLException{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 int choice,option;
    	 
    	 Login login = new Login();
    	 LoginDAO logindao = new LoginDAO();
    	 Product product = new Product();
    	 ProductDAO productdao = new ProductDAO(); 
    	 
    	 do
    	 {
    		 System.out.println("1.Admin");
    		 System.out.println("2.Agent");
    		 System.out.println("3.Exit");
    		 System.out.println("__________________________________________________________________________________________");
    		 choice = Integer.parseInt(br.readLine());
    		 
    		 switch(choice)
    		 {
    		 case 1: System.out.println("_______________________________________________________________________________________________");
    		 System.out.println("Enter the username: ");
    		 String username = br.readLine();
    		 System.out.println("Enter the password: ");
    		 String password = br.readLine();
    		 login.setUsername(username);
    		 login.setPassword(password);
    		 if(logindao.validate(login)) {
    			 System.out.println("_______________________________________________________________________________________________________________");
    			 System.out.println("Login Successful");
    			 
    			 do
    			 {
    				 System.out.println("________________________________________________________________________________________________________________");
    				 System.out.println("1.Add Product");
    				 System.out.println("Display Inventory Details");
    				 System.out.println("3.Logout");
    				 System.out.println("___________________________________________________________________________________________________________________________");
    				 option = Integer.parseInt(br.readLine());
    				 switch(option)
    				 {
    				 case 1:System.out.println("Enter the product id: ");
    				 int productId = Integer.parseInt(br.readLine());
    				 System.out.println("Enter the product name: ");
    				 String productname = br.readLine();
    				 System.out.println("Enter the min selling quantity: ");
    				 int minsell = Integer.parseInt(br.readLine());
    				 System.out.println("Enter the product price: ");
    				 int price = Integer.parseInt(br.readLine());
    				 System.out.println("Enter the product quantity: ");
    				 int quantity = Integer.parseInt(br.readLine());
    				 product.setProductName(productname);
    				 product.setProductId(productId);
    				 product.setMinSellQuantity(minsell);
    				 product.setPrice(price);
    				 product.setQuantity(quantity);
    				 
    				 productdao.addProduct(product);
    				 break;
    				 
    				 case 2: productdao.display();
    				 break;
    				 
    				 case 3: break;
    				 }
    			 }while(option!=3);
    		 }
    		 else
    		 {
    			 System.out.println("_______________________________________________________________________________________________________");
    			 System.out.println("Check your Username & Password");
    		 }
    		 break;
    		 
    		 case 2: System.out.println("_____________________________________________________________________________________________________________________________");
    		    System.out.println("Enter the username: ");
    		    String name = br.readLine();
    		    System.out.println("Enter the password");
    		    String pass = br.readLine();
    		    login.setUsername(name);
    		    login.setPassword(pass);
    		    if(logindao.validate(login)) {
    		    	System.out.println("__________________________________________________________________________________________________________________");
    		    	System.out.println("Login Successful");
    		    	
    		    	do
    		    	{
    		    		System.out.println("__________________________________________________________________________________________________________________________");
    		    		System.out.println("1.Buy/Sell");
    		    		System.out.println("2.Show History");
    		    		System.out.println("3.Logout");
    		    		System.out.println("_____________________________________________________________________________________________________________________________________");
    		    		option = Integer.parseInt(br.readLine());
    		    		switch(option)
    		    		{
    		    		case 1: System.out.println("Buy/Sell");
    		    		String agent = br.readLine();
    		    		if(agent.equalsIgnoreCase("buy"))
    		    		{
    		    			System.out.println("Enter the product id: ");
    		    			int productId = Integer.parseInt(br.readLine());
    		    			System.out.println("Enter the product name: ");
    		    			String productname = br.readLine();
    		    			System.out.println("Enter the min selling quantity: ");
    		    			int minsell = Integer.parseInt(br.readLine());
    		    			System.out.println("Enter the product price: ");
    		    			int price = Integer.parseInt(br.readLine());
    		    			System.out.println("Enter the product quantity: ");
    		    			int quantity = Integer.parseInt(br.readLine());
    		    			
    		    			product.setProductName(productname);
    	    				 product.setProductId(productId);
    	    				 product.setMinSellQuantity(minsell);
    	    				 product.setPrice(price);
    	    				 product.setQuantity(quantity);
    	    				 
    	    				 productdao.addProduct(product);
    	    				 System.out.println("_______________________________________________________________________________________________________________________________________");
    		    		}
    		    		else if(agent.equalsIgnoreCase("sell"))
    		    		{
    		    			System.out.println("_______________________________________________________________________________________________________________________________________________");
    		    			System.out.println("Enter the product id: ");
    		    			int productId = Integer.parseInt(br.readLine());
    		    			System.out.println("Enter the product quantity");
    		    			int quantity = Integer.parseInt(br.readLine());
    		    			if(productdao.quantityAvailable(productId,quantity))
    		    			{
    		    				int total = productdao.totalCost(productId,quantity);
    		    				System.out.println("___________________________________________________________________________________________________________________________________________");
    		    				System.out.println("Total cost is "+total);
    		    				System.out.println("____________________________________________________________________________________________________________________________________________");
    		    				System.out.println("Confirm Booking(Yes/No)");
    		    				String booking = br.readLine();
    		    				System.out.println("______________________________________________________________________________________________________________________________________________");
    		    			}
    		    		}
    		    		}
    		    	}while(option!=3);
    		    }
    		 }
    	 }while(choice!=3);
     }
}
