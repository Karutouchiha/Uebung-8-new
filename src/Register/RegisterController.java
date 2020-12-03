package Register;

import Login.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterController {
    private Stage stage;
    @FXML
    private TextField txt_Username;
    @FXML private TextField txt_Password;
    @FXML private Text txt_Error;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void register(){
        LoginController loginC = new FXMLLoader(getClass().getResource("Login.fxml")).getController();
        loginC.addRegister(txt_Username.getText(),txt_Password.getText());
        System.out.print(loginC.getRegister().toString());
    }
}
