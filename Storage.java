import java.io.*;
import java.util.Map;

public class Storage {

    static public void registeruser(String username, String password){
       try {
           FileWriter writer = new FileWriter("users.txt",true);

           for (Map.Entry<String, String> entry : Main.users.entrySet()) {
               String line = username + ":" + password + System.lineSeparator();
               writer.write(line);
           }

           writer.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
    static public boolean checker(String username, String password){
        try {
            File file = new File("users.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(":");
                if (username.equals(parts[0]) && password.equals(parts[1])) {
                    return true;
                }
            }

            bufferedReader.close();
            reader.close();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
