package sr.unasat.ecom.bp.command;

import sr.unasat.ecom.bp.command.user.*;
import sr.unasat.ecom.bp.services.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserCommandInvoker {
    private final Map<Integer, Command> commands = new HashMap<>();

    public UserCommandInvoker(UserService userService, Scanner scanner) {
        commands.put(1, new CreateUserCommand(userService, scanner));
        commands.put(2, new ViewUserByIdCommand(userService, scanner));
        commands.put(3, new UpdateUserCommand(userService, scanner));
        commands.put(4, new DeleteUserCommand(userService, scanner));
        commands.put(5, new ViewAllUsersCommand(userService));
        commands.put(6, new ViewAllOrdersWithProductsCommand(userService));
        commands.put(7, new ViewOrdersForUserCommand(userService, scanner));
        commands.put(8, new ViewTotalPriceForOrderCommand(userService, scanner));
        commands.put(9, new ViewTotalPriceForAllOrdersCommand(userService, scanner));
    }

    public void executeCommand(int choice) {
        Command command = commands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid choice. Please choose a number between 1 and 8.");
        }
    }
}
