package Login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable{
    private Stage stage;
    private ArrayList<String> register = new ArrayList();
    @FXML private TextField txt_Username;
    @FXML private TextField txt_Password;
    @FXML private Text txt_Error;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addRegister("Karuto","Cisco");
        addRegister("Lukas","Cisco");
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void Login (){
        this.txt_Error.setVisible(false);
        if (!txt_Username.getText().equals("") && !txt_Password.getText().equals("")){
            for (int i=0; i<register.size();i++) {
                if (txt_Username.getText().equals(this.register.get(i))){
                    i++;
                    if (txt_Password.getText().equals(register.get(i))){
                        loadScene("/MagMuschel/Muschel.fxml","Magische Muschel");
                    }
                }
            }
        }
        else {
            txt_Error.setText("Error: Sie haben ein Feld Ausgelassen");
            txt_Error.setVisible(true);
            txt_Password.clear();
            txt_Username.clear();

        }
    }
    @FXML
    public void Register(){
        this.txt_Error.setVisible(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Register/Register.fxml"));
            Parent root = loader.load();

            Register.RegisterController Controller = loader.getController();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root));
            Controller.setStage(nextStage);
            nextStage.setTitle("Register");
            nextStage.show();

            this.stage.close();
        }
        catch (IOException ex){
            this.txt_Error.setText("Stage konnte nicht Geladen werden");
            this.txt_Error.setVisible(true);
        }
    }
    public ArrayList getRegister() {
        return this.register;
    }

    public void addRegister(String Username, String Password) {
        register.add(Username);
        register.add(Password);
    }
    public void loadScene(String s, String t){
        this.txt_Error.setVisible(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(s));
            Parent root = loader.load();

            MagMuschel.MuschelController Controller = loader.getController();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root));
            Controller.setStage(nextStage);
            nextStage.setTitle(t);
            nextStage.show();

            this.stage.close();
        }
        catch(IOException ex){
            this.txt_Error.setText("Stage konnte nicht Geladen werden");
            this.txt_Error.setVisible(true);
        }
    }
}

