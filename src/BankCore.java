import java.util.List;

public class BankCore implements BankCoreFunctions {
    private Medium medium;
    @Override
    public void addAmount(String client, int amount) throws CoreException {
        int balance = getBalance(client);
        if (balance + amount < 0) {
            throw new CoreException("Insufficient funds");
        }
        try {
            medium.write(client, 0, String.valueOf(amount));
        } catch (GeneralException e) {
            throw new CoreException(e.getErrorMessage());
        }
    }

    @Override
    public void withdrawAmount(String client, int amount) throws CoreException {
        addAmount(client, -amount);
    }

    @Override
    public void transferAmount(String fromClient, String toClient, int amount) throws CoreException {
        withdrawAmount(fromClient, amount);
        addAmount(toClient, amount);
    }

    @Override
    public int getBalance(String client) throws CoreException {
        int balance = -1;
        try {
            List<String> transactions = medium.read(client);
            for (String t: transactions) {
                balance += Integer.getInteger(t);
            }
        } catch (GeneralException e) {
            throw new CoreException(e.getMessage());
        }
        return balance;
    }
}