package Login;

import MagMuschel.MagMuschelController;
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
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void Login (){
        this.txt_Error.setVisible(false);
        if (!txt_Username.getText().equals("") && !txt_Password.getText().equals("")){
            for (int i=0; i<register.size()/2;i=i+2) {
                if (txt_Username.getText().equals(this.register.get(i))){
                    i++;
                    if (txt_Password.getText().equals(register.get(i))){
                        loadScene("MagischeMuschel.fxml","Magische Muschel");
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            Register.RegisterController Controller = loader.getController();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root, 500, 500));
            Controller.setStage(nextStage);
            nextStage.setTitle("Register");
            nextStage.show();

            this.stage.close();
        }
        catch (Exception ex){
            this.txt_Error.setText("Stage konnte nicht Geladen werden");
            this.txt_Error.setVisible(true);
        }
    }
    public ArrayList getRegister() {
        return register;
    }

    public void addRegister(String Username, String Password) {
        register.add(Username);
        register.add(Password);
    }
    public void loadScene(String s,String t){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MagMuschelController.class.getResource(s));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            MagMuschelController ctrl = fxmlLoader.getController();
            ctrl.setStage(stage);

            stage.setTitle(t);
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
            this.stage.close();
        }
        catch (IOException ex){
            this.txt_Error.setText("Stage konnte nicht Geladen werden");
            this.txt_Error.setVisible(true);
        }
    }
}

