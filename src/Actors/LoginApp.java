package Actors;
import java.io.IOException;
import java.util.Scanner;

import SubSystems.Database;
import Tools.Key;

public class LoginApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	User myUser = null;
        Scanner scanner = new Scanner(System.in);
        User a = new Admin(new Key("a_sazanova", "123456"), "Aruzhan", "Sazanova","22B030429");
        Database.DATABASE.users.add(a);
        Database.writeData();
        Database.readData();
       while(myUser == null) {
    	   System.out.println("Welcome to the Login Page!");

           System.out.print("Enter username: ");
           String username = scanner.nextLine();

           System.out.print("Enter password: ");
           String password = scanner.nextLine();

           Key k = new Key(username,password);
           // Check if entered credentials match the predefined ones
           for(User u : Database.DATABASE.users) {
        	   if(u.getKey().equals(k)) myUser = u;
           }
       }
       myUser.logIn();
       
    }
}
