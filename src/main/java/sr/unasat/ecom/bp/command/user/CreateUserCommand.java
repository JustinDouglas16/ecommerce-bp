package sr.unasat.ecom.bp.command.user;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.entities.User;
import sr.unasat.ecom.bp.services.UserService;

import java.util.Scanner;

public class CreateUserCommand implements Command {
    private final UserService userService;
    private final Scanner scanner;

    public CreateUserCommand(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter user details:");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User newUser = new User(firstName, lastName, username, email, password);
        userService.createUser(newUser);
        System.out.println("User created successfully.");
    }
}

// Similar classes for other operations (ViewUserByIdCommand, UpdateUserCommand, DeleteUserCommand, ViewAllUsersCommand)

