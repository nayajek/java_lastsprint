import java.sql.*;
import java.util.List;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addProduct(String name, double price, int quantity, int sellerId) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setSellerId(sellerId);
        try {
            productDAO.addProduct(product);
            System.out.println("Product added successfully");
        } catch (SQLException e) {
            System.out.println("Failed to add product: " + e.getMessage());
        }
    }

    public void viewProductsBySeller(int sellerId) {
        try {
            List<Product> products = productDAO.getProductsBySeller(sellerId);
            for (Product product : products) {
                System.out.println(product);
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve products: " + e.getMessage());
        }
    }
}
