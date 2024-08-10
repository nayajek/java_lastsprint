import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAO(DatabaseConnection.getConnection());
        ProductDAO productDAO = new ProductDAO(DatabaseConnection.getConnection());
        UserService userService = new UserService(userDAO);
        ProductService productService = new ProductService(productDAO);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> register(scanner, userService);
                case 2 -> login(scanner, userService, productService);
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private static void register(Scanner scanner, UserService userService) {
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Role (buyer/seller/admin): ");
        String role = scanner.next();
        userService.register(username, password, email, role);
    }

    private static void login(Scanner scanner, UserService userService, ProductService productService) {
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        User user = userService.login(username, password);
        if (user != null) {
            System.out.println("Login successful");
            showMenu(scanner, user, productService);
        } else {
            System.out.println("Invalid credentials");
        }
    }

    private static void showMenu(Scanner scanner, User user, ProductService productService) {
        switch (user.getRole()) {
            case "buyer" -> {
            }
            case "seller" -> {
                // Show seller menu
                System.out.println("1. Add Product");
                System.out.println("2. View Products");
                System.out.println("3. Logout");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Product Name: ");
                        String name = scanner.next();
                        System.out.print("Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Quantity: ");
                        int quantity = scanner.nextInt();
                        productService.addProduct(name, price, quantity, user.getId());
                }
                    case 2 -> productService.viewProductsBySeller(user.getId());
                    case 3 -> {
                        return;
                }
                }
            }
            case "admin" -> {
            }
        }
        // Show buyer menu
        // Show admin menu
            }
}
