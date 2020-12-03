package MagMuschel;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class MuschelController {
    private Stage stage;
    @FXML Text txt_Answer;
    @FXML TextField txt_Question;
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void Question(){
        String s = txt_Question.getText();
        if (s.contains("Hallo")){
           print("Es ist schön zu wissen, das es noch anständige Leute gibt.\nHallo Mensch!");
        }
        else if (s.contains(".")){
            print("Sind Sie sicher das das eine Frage ist?");
        }
        else if (s.contains("!")){
            print("Mir gefällt Ihr Ton nicht...");
        }
        else if (s.contains("?")){
             if (s.contains("SEW")|| s.contains("MEDT")|| s.contains("Softwareentwiklung") || s.contains("Technik")){
                print(getRespond(5));
             }
             else if (s.contains("Undertale")){
                 print(getRespond(7));
             }
             else if (s.contains("Montag")){
                print(getRespond(-4));
             }
             else {
                 print(getRespond(0));
             }
         }
        else {
            print("Tut mir Leid aber Ich habe keine Frage gefunden.\nBitte benutze ein '?'.");
        }
    }
    public String getRespond(int bonus){
        Random random = new Random();
        int r = random.nextInt(19)+bonus;
        String respons = "Hello";
        //no
        if (r<=0){
            respons = "Very doubtful.";
        }
        else if (r==1){
            respons= "Outlook not so good.";
        }
        else if (r==2){
            respons= "My sources say no.";
        }
        else if (r==3){
            respons= "My reply is no.";
        }
        else if (r==4){
            respons= "Don't count on it.";
        }
        //mabye
        else if (r==5){
            respons= "Concentrate and ask again.";
        }
        else if (r==6){
            respons= "Cannot predict now.";
        }
        else if (r==7){
            respons= "Better not tell you now.";
        }
        else if (r==8){
            respons= "Ask again later.";
        }
        else if (r==9){
            respons="Reply hazy, try again.";
        }
        //Yes
        else if (r==10){
            respons= "Signs point to yes.";
        }
        else if (r==11){
            respons= "Yes.";
        }
        else if (r==12){
            respons= "Outlook good.";
        }
        else if (r==13){
            respons= "Most likely.";
        }
        else if (r==14){
            respons= "As I see it, yes.";
        }
        else if (r==15){
            respons= "You may rely on it.";
        }
        else if (r==16){
            respons= "Yes – definitely.";
        }
        else if (r==17){
            respons= "Without a doubt.";
        }
        else if (r==18){
            respons= "It is decidedly so.";
        }
        else if (r >= 19){
            respons= "It is certain.";
        }
        if (r<5){
            txt_Answer.setFill(Color.RED);
        }
        else if (r<10){
            txt_Answer.setFill(Color.ORANGE);
        }
        else {
            txt_Answer.setFill(Color.GREEN);
        }


        return respons;
    }
    public void print(String s){
        txt_Answer.setVisible(true);
        txt_Answer.setText(s);
    }
}
