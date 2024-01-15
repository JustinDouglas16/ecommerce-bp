package sr.unasat.ecom.bp.app;

import sr.unasat.ecom.bp.services.ProductService;
import sr.unasat.ecom.bp.services.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        ProductService productService = new ProductService();

        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu(userService, productService, scanner);

        System.out.println("==== Welcome to the E-commerce System ====");
        mainMenu.start();
    }
}
