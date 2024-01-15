package sr.unasat.ecom.bp.command.user;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.entities.User;
import sr.unasat.ecom.bp.services.UserService;

import java.util.List;

public class ViewAllUsersCommand implements Command {
    private final UserService userService;

    public ViewAllUsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        List<User> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            System.out.println("All Users:");
            for (User user : users) {
                System.out.println("ID: " + user.getId() + ", Username: " + user.getUsername());
            }
        } else {
            System.out.println("No users found.");
        }
    }
}
