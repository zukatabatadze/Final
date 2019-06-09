import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleMedium implements Medium {
    Map<String, String> usersTransactions = new HashMap<String, String>();
    Map<String, Long> userDataIds = new HashMap<String, Long>();
    @Override
    public void write(String user, long dataId, String data) throws GeneralException {
        usersTransactions.put(user, data);
    }

    @Override
    public String read(String user, long dataId) throws GeneralException {
        return usersTransactions.get(user);
    }

    @Override
    public List<String> read(String user) throws GeneralException {
        return null;
    }
}