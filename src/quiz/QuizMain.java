package quiz;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import quiz.student.view.StartTestController;
import quiz.student.view.StudentDashboardController;
import quiz.login.view.LoginController;
import quiz.login.view.AdminDashboardController;
import quiz.login.view.SignUpController;
import quiz.question.view.FillInTheBlanksController;
import quiz.question.view.MultipleWithMoreAnswersController;
import quiz.question.view.MultipleWithOneAnswerController;
import quiz.question.view.TrueOrFalseController;
import quiz.security.Authenticator;

/**
 *
 * @author Group
 */
public class QuizMain extends Application {

    public  Stage stage;
    private User loggedUser;
    private final double MINIMUM_WINDOW_WIDTH = 700.0;
    private final double MINIMUM_WINDOW_HEIGHT = 700.0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            stage.setTitle("Java Quiz");
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
             //uploadQuestions();
             //gotoLogin();
            gotoStudentDashboard();
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(QuizMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoLogin() {
         try {
            System.out.println("test");
            LoginController profile = (LoginController) replaceSceneContent("login/view/Login.fxml");
            profile.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(QuizMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean userLogging(String userId, String password) {
        if (Authenticator.validate(userId, password)) {
            gotoAdminDashboard();
            return true;
        } else {
            return false;
        }
    }

    public void gotoAdminDashboard() {
        try {
            System.out.println("in adminDashboard");
            AdminDashboardController profile = (AdminDashboardController) replaceSceneContent("login/view/AdminDashboard.fxml");
            profile.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(QuizMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoSignUpScreen() {
        try {
            System.out.println("in SignUpScreen");
            SignUpController profile = (SignUpController) replaceSceneContent("login/view/SignUp.fxml");
            profile.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(QuizMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoStudentDashboard() {
        try {
            StudentDashboardController profile = (StudentDashboardController) replaceSceneContent("student/view/StudentDashboard.fxml");
            profile.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(QuizMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoStartTest() {
        try {
            StartTestController profile = (StartTestController) replaceSceneContent("student/view/StartTest.fxml");
            profile.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(QuizMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void gotoTestPage() {
//        try {
//            StartTestController profile = (StartTestController) replaceSceneContent("student/view/StartTest.fxml");
//            profile.setApp(this);
//        } catch (Exception ex) {
//            Logger.getLogger(QuizMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

        public ArrayList<Question> getQuestions(int numOfQuestions, String difficultyLevel) {
                QuizDBImplementation qzImpl = new QuizDBImplementation();
            return qzImpl.selectQuestions(numOfQuestions,difficultyLevel);
            
        }
    public void uploadQuestions() {
        System.out.println("Inside upload q to db");
                    QuizDBImplementation qzImpl = new QuizDBImplementation();

        qzImpl.addQuestions("test-sample.csv");
    }
    
        public  void showMCScreen(MultiChoiceQuestion qust) {
        try {
            MultipleWithOneAnswerController profile = (MultipleWithOneAnswerController) replaceSceneContent("question/view/MultipleWithOneAnswer.fxml");
            profile.setApp(this,qust);
        } catch (Exception ex) {
            Logger.getLogger(QuizMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showMAScreen(MultiChoiceQuestion qust) {
        try {
            MultipleWithMoreAnswersController profile = (MultipleWithMoreAnswersController) replaceSceneContent("question/view/MultipleWithMoreAnswers.fxml");
            profile.setApp(this,qust);
        } catch (Exception ex) {
            Logger.getLogger(QuizMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showTFScreen(TrueOrFalseQuestion qust) {
        try {
            TrueOrFalseController profile = (TrueOrFalseController) replaceSceneContent("question/view/TrueOrFalse.fxml");
            profile.setApp(this, qust);
        } catch (Exception ex) {
            Logger.getLogger(QuizMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showFIBScreen(FillInTheBlanks qust) {
        try {
            FillInTheBlanksController profile = (FillInTheBlanksController) replaceSceneContent("question/view/FillInTheBlanks.fxml");
            profile.setApp(this,qust);
        } catch (Exception ex) {
            Logger.getLogger(QuizMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public  Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = QuizMain.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(QuizMain.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 800, 600);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
    
    
    public void addUser(String loginName, String userName, String password, String uniRole) {
        System.out.println("in addUser");
        User usr = new User(loginName, userName, password, uniRole);
        System.out.println("AddUser");
        QuizDBImplementation qzImpl = new QuizDBImplementation();
        qzImpl.addUser(usr);
    }

}
