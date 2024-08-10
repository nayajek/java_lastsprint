public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;

    // Constructors, Getters, and Setters

    public User(int id, String username, String password, String email, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    
    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    
}
