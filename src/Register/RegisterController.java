package Register;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RegisterController {
    private Stage stage;
    @FXML private TextField txt_Username;
    @FXML private TextField txt_Password;
    @FXML private Text txt_Error;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void register() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login/Login.fxml"));
        Parent root = loader.load();
        Login.LoginController loginC = loader.getController();
        ArrayList loginCRegister = loginC.getRegister();

        if (!txt_Username.getText().equals("") && !txt_Password.getText().equals("")){
            if (loginCRegister.size()!=0) {
                for (int i = 0; i < loginCRegister.size(); i++) {
                    if (!txt_Username.getText().equals(loginCRegister.get(i))) {
                        i++;
                        loginC.addRegister(txt_Username.getText(), txt_Password.getText());
                        break;
                    } else {
                        Error("Username bereits verwendet");
                    }
                }
            }
            else {
                loginC.addRegister(txt_Username.getText(), txt_Password.getText());
            }
        }
        else {
            Error("Error: Sie haben ein Feld Ausgelassen");

        }

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Log in");
        primaryStage.setScene(new Scene(root));
        loginC.setStage(primaryStage);
        primaryStage.show();
        this.stage.close();

        //System.out.print(loginCRegister.toString());
    }
    public void Error(String s){
        txt_Error.setText(s);
        txt_Error.setVisible(true);
        txt_Password.clear();
    }
}
