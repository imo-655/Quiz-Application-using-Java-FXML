
package quiz;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Group
 */
public interface QuizDBDAO {
    
    public void addQuestions(String fileName);
    public void addUser(User user);
    public void addStudentResults(StudentResults result);  
    public int questionCount(String difficultyLevel);
    public ArrayList<Question> selectQuestions(int numOfQuestions,String difficultyLevel);
    public ArrayList<User> selectUser(String userName,String password);   
    public ArrayList<StudentResults> getStudentResults(Date date);
}
