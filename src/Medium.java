import java.util.List;

public interface Medium {
    void write(String user, String data) throws MediumException;
    String read(String user) throws MediumException;
    List<String> read() throws MediumException;
}
