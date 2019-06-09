public interface BankCoreFunctions {
    void addAmount(String client, int amount) throws CoreException;
    void withdrawAmount(String client, int amount) throws CoreException ;
    void transferAmount(String fromClient, String toClient, int amount) throws CoreException ;
    int getBalance(String client) throws CoreException;
}