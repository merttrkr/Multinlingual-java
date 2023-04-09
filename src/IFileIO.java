import java.util.ArrayList;
import java.util.Map;

public interface IFileIO {
	public ArrayList<User> readUsersCSV(String fileName);
	public void createLanguagesCSV(Language[] languages);
	public Map<String, Integer> getQuizNumbers();
    public Map<String, Integer> getUnitNumbers();
    public void getQuizzesArrayAndSolve(User user);
}
