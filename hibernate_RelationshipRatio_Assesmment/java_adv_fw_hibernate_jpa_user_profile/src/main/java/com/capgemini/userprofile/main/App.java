package com.capgemini.userprofile.main;

import java.time.LocalDate;
import java.util.Scanner;

import com.capgemini.userprofile.dao.UserDAO;
import com.capgemini.userprofile.entity.Profile;
import com.capgemini.userprofile.entity.User;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		UserDAO dao = new UserDAO();

		while (true) {

			System.out.println("\n1. Add User");
			System.out.println("2. Search User");
			System.out.println("3. Update Email");
			System.out.println("4. Update Profile");
			System.out.println("5. Delete User");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:

				System.out.print("Enter username: ");
				String username = sc.nextLine();

				System.out.print("Enter email: ");
				String email = sc.nextLine();

				System.out.print("Enter phone: ");
				String phone = sc.nextLine();

				System.out.print("Enter gender: ");
				String gender = sc.nextLine();

				System.out.print("Enter dob: ");
				String dob = sc.nextLine();

				Profile profile = new Profile(phone, gender, LocalDate.parse(dob));

				User user = new User(username, email, profile);

				dao.addUser(user);

				break;

			case 2:

				System.out.print("Enter id: ");
				int id = sc.nextInt();

				dao.searchUser(id);

				break;

			case 3:

				System.out.print("Enter id: ");
				int uid = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter new email: ");
				String newEmail = sc.nextLine();

				dao.updateEmail(uid, newEmail);

				break;

			case 4:

				System.out.print("Enter user id: ");
				int pid = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter phone: ");
				String ph = sc.nextLine();

				System.out.print("Enter gender: ");
				String gen = sc.nextLine();

				System.out.print("Enter dob: ");
				String db = sc.nextLine();

				dao.updateProfile(pid, ph, gen, LocalDate.parse(db));

				break;

			case 5:

				System.out.print("Enter id: ");
				int did = sc.nextInt();

				dao.deleteUser(did);

				break;

			case 6:
				System.exit(0);
			}
		}
	}
}