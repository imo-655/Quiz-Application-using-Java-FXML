/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.question.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javax.swing.JOptionPane;
import quiz.FillInTheBlanks;
import quiz.MultiChoiceQuestion;
import quiz.QuizMain;
import quiz.TrueOrFalseQuestion;
import static quiz.student.view.StartTestController.*;

/**
 * This class is the controller class for the MultipleWithOneAnswer fxml page;
 * it has initialize(), setApp() as base methods; onNextButtonClick() to go to
 * next question, onBackButtonClick() to go to previous question and
 * onSkipButtonClick() to skip the question event related methods.
 *
 * @author VinayaSaiD
 */
public class MultipleWithOneAnswerController implements Initializable {

    private QuizMain application;
    /**
     * Initializes the controller class.
     */

    @FXML
    private ToggleGroup Choices;
    @FXML
    private TextArea questionDescription;
    @FXML
    private RadioButton choice1;
    @FXML
    private RadioButton choice2;
    @FXML
    private RadioButton choice3;
    @FXML
    private RadioButton choice4;
    @FXML
    private Button backButton;
    @FXML
    private Label questionNumber;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // setting the question number label
        questionNumber.setText("Question " + (questionCounter + 1) + " of " + (selectednumOfQuestions));
        // these are used when user presses back button,used to remember the previous user answers
        choice1.setSelected(((MultiChoiceQuestion) questionsForTest.get(questionCounter)).isUserInput1());
        choice2.setSelected(((MultiChoiceQuestion) questionsForTest.get(questionCounter)).isUserInput2());
        choice3.setSelected(((MultiChoiceQuestion) questionsForTest.get(questionCounter)).isUserInput3());
        choice4.setSelected(((MultiChoiceQuestion) questionsForTest.get(questionCounter)).isUserInput4());
        // back button should not be visible for the first question
        if (questionCounter == 0) {
            backButton.setVisible(false);
        }
        //set the Question description in the text field
        questionDescription.setText(((MultiChoiceQuestion) questionsForTest.get(questionCounter)).getQuestiondesc());
        //setup tool tip
        questionDescription.setTooltip(new Tooltip("Question Description"));
        choice1.setText(((MultiChoiceQuestion) questionsForTest.get(questionCounter)).getChoice1());
        //setup tool tip
        choice1.setTooltip(new Tooltip("Choice 1"));
        choice2.setText(((MultiChoiceQuestion) questionsForTest.get(questionCounter)).getChoice2());
        //setup tool tip
        choice2.setTooltip(new Tooltip("Choice 2"));
        choice3.setText(((MultiChoiceQuestion) questionsForTest.get(questionCounter)).getChoice3());
        //setup tool tip
        choice3.setTooltip(new Tooltip("Choice 3"));
        choice4.setText(((MultiChoiceQuestion) questionsForTest.get(questionCounter)).getChoice4());
        //setup tool tip
        choice4.setTooltip(new Tooltip("Choice 4"));
    }

    public void setApp(QuizMain application, MultiChoiceQuestion qust) {
        this.application = application;
    }

    @FXML
    private void onNextButtonClick(ActionEvent event) {
        // if the answer is no given need to throw a warning, skip can be used to not answer the question
        if (!(choice1.isSelected()) && !(choice2.isSelected()) && !(choice3.isSelected()) && !(choice4.isSelected())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("You need to select an answer to proceed.Or use 'Skip' to Skip the question");
            alert.showAndWait();
        } // else need to save the user input into the Question object
        else {
            ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setUserInput1(choice1.isSelected());
            ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setUserInput2(choice2.isSelected());
            ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setUserInput3(choice3.isSelected());
            ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setUserInput4(choice4.isSelected());
            ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setSkipQuestion(false);
            // go to the next question using gotoNextQuestion() method
            application.gotoNextQuestion();
        }
    }

    @FXML
    private void onBackButtonClick(ActionEvent event) {
        // reduce the counter by one and send it to the screen based on type of question
        questionCounter = questionCounter - 1;
        if (questionsForTest.get(questionCounter).getQuestionType().equals("MC")) {
            application.showMCScreen((MultiChoiceQuestion) questionsForTest.get(questionCounter));
        } else if (questionsForTest.get(questionCounter).getQuestionType().equals("MA")) {
            application.showMAScreen((MultiChoiceQuestion) questionsForTest.get(questionCounter));
        } else if (questionsForTest.get(questionCounter).getQuestionType().equals("TF")) {
            application.showTFScreen((TrueOrFalseQuestion) questionsForTest.get(questionCounter));
        } else if (questionsForTest.get(questionCounter).getQuestionType().equals("FIB")) {
            application.showFIBScreen((FillInTheBlanks) questionsForTest.get(questionCounter));
        }
    }

    @FXML
    private void onSkipButtonClick(ActionEvent event) {
        // if the user gives an answer then need to throw a confirmation asking if he want to remove the answer and proceed or do not remove
        if ((choice1.isSelected()) || (choice2.isSelected()) || (choice3.isSelected()) || (choice4.isSelected())) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You selected an answer. Do you wish to remove the selection and proceed.", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setSkipQuestion(true);
                ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setUserInput1(false);
                ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setUserInput2(false);
                ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setUserInput3(false);
                ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setUserInput4(false);
                // go to the next question using gotoNextQuestion() method
                application.gotoNextQuestion();
            }
        } // else make the tag SkipQuestion to true and proceed
        else {
            ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setSkipQuestion(true);
            ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setUserInput1(false);
            ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setUserInput2(false);
            ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setUserInput3(false);
            ((MultiChoiceQuestion) questionsForTest.get(questionCounter)).setUserInput4(false);
            // go to the next question using gotoNextQuestion() method
            application.gotoNextQuestion();
        }
    }
}
