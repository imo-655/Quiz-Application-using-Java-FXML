/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 * This class is used to define the Fill in the blanks Questions, it extends
 * Question class; it has 2 fields "ans" and "userInput" which are private and
 * hence has getters and setters; it has validateAnswer() method which validates
 * the answers given by the user during the quiz; it has toString() method which
 * prints the entire Object as a string
 *
 * @author Group
 */
public class FillInTheBlanks extends Question {

    private String ans;
    private String userInput;

    /**
     * //default constructor
     */
    public FillInTheBlanks() {
    }

    /**
     *
     * @param QuestionType type of question
     * @param LevelOfDifficulty difficulty level of the question
     * @param Questiondesc description of the question
     * @param ans answer for the question
     */
    public FillInTheBlanks(String QuestionType, String LevelOfDifficulty, String Questiondesc, String ans) {
        super(QuestionType, LevelOfDifficulty, Questiondesc);
        this.ans = ans;
    }

    /**
     *
     * @return answer for the question
     */
    public String getAns() {
        return ans;
    }

    /**
     *
     * @param ans answer for the question
     */
    public void setAns(String ans) {
        this.ans = ans;
    }

    /**
     *
     * @return user input for the question
     */
    public String getUserInput() {
        return userInput;
    }

    /**
     *
     * @param userInput user input for the question
     */
    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public boolean validateAnswer() {
        // we need to avoid any trailing and leading empty spaces and also should not be case sensitive
        if ((this.getAns().trim()).equals(this.getUserInput().trim())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Question{" + "QuestionType=" + QuestionType + ", LevelOfDifficulty=" + LevelOfDifficulty + ", Questiondesc=" + Questiondesc + ", skipQuestion=" + skipQuestion + '}' + "FillInTheBlanks{" + "ans=" + ans + ", userInput=" + userInput + '}';
    }
}
