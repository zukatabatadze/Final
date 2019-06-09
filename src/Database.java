import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    public void insertData(String client, int amount, long dataId) {
        try {
            String  myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/myBank";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO clients (client, amount,dataId) " + "VALUES ('aleksandridis', 12,123)");
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }
    public static void Backupdbtosql() {
        try {
            CodeSource codeSource = Database.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();


            /*NOTE: Creating Database Constraints*/
            String name = "myBank";
            String user = "root";
            String pass = "";

            /*NOTE: Creating Path Constraints for folder saving*/
            /*NOTE: Here the backup folder is created for saving inside it*/
            String pash = jarDir + "\\backup";

            /*NOTE: Creating Folder if it does not exist*/
            File f1 = new File(pash);
            f1.mkdir();

            /*NOTE: Creating Path Constraints for backup saving*/
            /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
            String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";

            /*NOTE: Used to create a cmd command*/
            String executeCmd = "mysqldump -u" + user + " -p" + pass + " --database " + name + " -r " + pash;

            /*NOTE: Executing the command here*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                System.out.println("Backup Complete");
            } else {
                System.out.println("Backup Failure");
            }

        } catch (URISyntaxException | IOException | InterruptedException ex) {

        }
    }
}