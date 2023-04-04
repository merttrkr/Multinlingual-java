import java.util.*;
public class Multilingualism {
    public static void main(String[] args) {
    	String csvFile = "users.csv";
    	FileIO csvReader = new FileIO();
        List<User> userList = new ArrayList<>();
        userList = csvReader.readUsersCSV(csvFile);
        for (int i = 0; i < 100; i++) {
        	  System.out.println(userList.get(i));
        	}
        
    }	
}
