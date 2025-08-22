package launch;

import java.util.List;
import java.util.Scanner;

import DaoImp.UserDaoImp;
import Pojo.User;

public class LaunchUser {



	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
//		System.out.println("Enter the name");
//		String name = sc.next();
//		System.out.println("Enter the username");
//		String username = sc.next();
//		System.out.println("Enter the email");
//		String email = sc.next();
//		System.out.println("Enter the phone number");
//		String phone = sc.next();
//		System.out.println("Enter the password");
//		String password = sc.next();
//		System.out.println("Enter the Address");
//		String address = sc.next();
//		System.out.println("Enter the role");
//		String role = sc.next(); 
//		User u = new User(name, username, password,email, phone, address, role);
	
//		System.out.println("Enter id");
//		int id=sc.nextInt();
		
		UserDaoImp uimpl = new UserDaoImp();
		
//		User u = uimpl.getUserId(id);
//		System.out.println(u);

//
//		u.setPassword("456");
//		uimpl.updateUser(u);
//		System.out.print(u);
		
		List<User> list = uimpl.getAllUsers();
		
		for(User user : list) {
			System.out.println(user);
		}
		

	}

}
