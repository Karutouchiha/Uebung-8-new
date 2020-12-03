package Register;

import Login.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RegisterController {
    private Stage stage;
    @FXML private TextField txt_Username;
    @FXML private TextField txt_Password;
    @FXML private Text txt_Error;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void register(){
        LoginController loginC = new FXMLLoader(getClass().getResource("Login.fxml")).getController();
        ArrayList loginCRegister = new ArrayList();
        try{loginCRegister.addAll(loginC.getRegister());}
        catch (NullPointerException x){

        }
        if (txt_Username.getText().equals("") && txt_Password.getText().equals("")){
            for (int i=0; i<loginCRegister.size()/2;i=i+2) {
                if (!txt_Username.getText().equals(loginCRegister.get(i))){
                    i++;
                    if (!txt_Password.getText().equals(loginCRegister.get(i))){
                        loginC.addRegister(txt_Username.getText(),txt_Password.getText());
                    }
                }
            }
        }
        else {
            txt_Error.setText("Error: Sie haben ein Feld Ausgelassen");
            txt_Error.setVisible(true);
            txt_Password.clear();
        }
        System.out.print(loginCRegister.toString());
    }
}
