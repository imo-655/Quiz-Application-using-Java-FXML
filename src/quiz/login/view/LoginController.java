/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.login.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import quiz.QuizDBImplementation;
import quiz.QuizMain;
import quiz.User;

/**
 * FXML Controller class
 *
 * @author Hari
 */
public class LoginController implements Initializable {

    private QuizMain application;
    @FXML
    private TextField loginName;
    @FXML
    private TextField password;
    @FXML
    private Button signin;
    @FXML
    private Label errorMessage;
    @FXML
    private Button signIn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Loading Login page...");
    }

    public void setApp(QuizMain application) {
        this.application = application;
    }

    @FXML
    public void onClickSignIn() {
        QuizDBImplementation impl=new QuizDBImplementation();
        System.out.println("in on click");
        System.out.println("userName.getText()"+loginName.getText());
         System.out.println("password.getText()"+password.getText());
        try{ 
        User user=impl.selectUser(loginName.getText(), password.getText());
        
        if(user.getUniRole().equals("Admin")){
            System.out.println("in1");
        application.gotoAdminDashboard();
        }else {
            System.out.println("in2");
        application.gotoStudentDashboard();
        }
        }
        catch(Exception exp){
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Incorrect username/password");
            alert.showAndWait();
        }
        
    }

    public void onClickSignUp() {
        application.gotoSignUpScreen();

    }

}
