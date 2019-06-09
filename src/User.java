import java.util.List;

public class User {
    public String Username;
    public List<Transactions> Transactions;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public List<Transactions> getTransactions() {
        return Transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        Transactions = transactions;
    }
}