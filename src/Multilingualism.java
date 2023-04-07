
public class Multilingualism {
    public static void main(String[] args) {
    	/*String csvFile = "users.csv";
    	FileIO csvReader = new FileIO();
        List<User> userList = new ArrayList<>();
        userList = csvReader.readUsersCSV(csvFile);
        for (int i = 0; i < 100; i++) {
        	  System.out.println(userList.get(i));
        	}*/
    	
    	Spanish spanish = new Spanish("spanish");
    	Unit[] units =  spanish.getUnitsArray();
        //System.out.println("units " + units[59]);
        //System.out.println("units " + units);
        for (int i = 0; i <spanish.getUnitNumber(); i++) {
      	  System.out.println(i + ": " +  units[i].getQuizArray()[0].getQuestionsArray()[3].getLanguageName());
      	}
        System.out.println("point " + units[5].getQuizArray()[0].getQuestionsArray()[3].getPoint());
    }	
}
