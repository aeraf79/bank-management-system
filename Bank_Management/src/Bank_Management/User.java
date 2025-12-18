package Bank_Management;

public class User {
    private String username;
    private String password;
    private String email;
    private Bankaccount account;
    
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public Bankaccount getAccount() {
        return account;
    }
    
    public void setAccount(Bankaccount account) {
        this.account = account;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}