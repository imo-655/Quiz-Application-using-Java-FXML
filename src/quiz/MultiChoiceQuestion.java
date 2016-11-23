/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author Group
 */
public class MultiChoiceQuestion extends Question {

    //Fields choice1, ans1, choice2, ans2, choice3, ans3, choice4, answer4, userInput1, userInput2, userInput3, userInput4
    //method validateAnswer
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private boolean ans1;
    private boolean ans2;
    private boolean ans3;
    private boolean ans4;
    private boolean userInput1;
    private boolean userInput2;
    private boolean userInput3;
    private boolean userInput4;

    public MultiChoiceQuestion() {
    }

    public MultiChoiceQuestion(String QuestionType, String LevelOfDifficulty, String Questiondesc, String choice1, String choice2, String choice3, String choice4, boolean ans1, boolean ans2, boolean ans3, boolean ans4) {
        super(QuestionType, LevelOfDifficulty, Questiondesc);
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public boolean isAns1() {
        return ans1;
    }

    public void setAns1(boolean ans1) {
        this.ans1 = ans1;
    }

    public boolean isAns2() {
        return ans2;
    }

    public void setAns2(boolean ans2) {
        this.ans2 = ans2;
    }

    public boolean isAns3() {
        return ans3;
    }

    public void setAns3(boolean ans3) {
        this.ans3 = ans3;
    }

    public boolean isAns4() {
        return ans4;
    }

    public void setAns4(boolean ans4) {
        this.ans4 = ans4;
    }

    public boolean isUserInput1() {
        return userInput1;
    }

    public void setUserInput1(boolean userInput1) {
        this.userInput1 = userInput1;
    }

    public boolean isUserInput2() {
        return userInput2;
    }

    public void setUserInput2(boolean userInput2) {
        this.userInput2 = userInput2;
    }

    public boolean isUserInput3() {
        return userInput3;
    }

    public void setUserInput3(boolean userInput3) {
        this.userInput3 = userInput3;
    }

    public boolean isUserInput4() {
        return userInput4;
    }

    public void setUserInput4(boolean userInput4) {
        this.userInput4 = userInput4;
    }

    public boolean validateAnswer() {
        if (this.isAns1() == this.isUserInput1() && this.isAns2() == this.isUserInput2() && this.isAns3() == this.isUserInput3() && this.isAns4() == this.isUserInput4()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Question{" + "QuestionType=" + QuestionType + ", LevelOfDifficulty=" + LevelOfDifficulty + ", Questiondesc=" + Questiondesc + ", skipQuestion=" + skipQuestion + '}' + "MultiChoiceQuestion{" + "choice1=" + choice1 + ", choice2=" + choice2 + ", choice3=" + choice3 + ", choice4=" + choice4 + ", ans1=" + ans1 + ", ans2=" + ans2 + ", ans3=" + ans3 + ", ans4=" + ans4 + ", userInput1=" + userInput1 + ", userInput2=" + userInput2 + ", userInput3=" + userInput3 + ", userInput4=" + userInput4 + '}';
    }
}
