package sample;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


import java.io.*;


public class Controller {
    public TextArea userInput;
    public TextArea foundedWords;
    public Button btnDelete;

    public Button btnEnter;
    public Label scoreLabel;
    public Label counter;

    StringBuilder word = new StringBuilder();
    int counterVal = 0;

    int score = 0;
    int reverseScore = 0;
    int normalScore = 0;
    boolean isExist = true;


    //butonlara karakter atama işlemi.
    @FXML
    protected void clickS() {

        userInput.setText(word + "S");
        word.append("S");

    }

    @FXML
    protected void clickA() {

        userInput.setText(word + "A");
        word.append("A");

    }

    @FXML
    protected void clickE() {
        userInput.setText(word + "E");
        word.append("E");

    }

    @FXML
    protected void clickI() {
        userInput.setText(word + "I");
        word.append("I");

    }

    @FXML
    protected void clickB() {
        userInput.setText(word + "B");
        word.append("B");

    }

    @FXML
    protected void clickR() {
        userInput.setText(word + "R");
        word.append("R");

    }

    @FXML
    protected void clickK() {
        userInput.setText(word + "K");
        word.append("K");

    }


    @FXML
    protected void clrInput() {


        word.setLength(word.length() - 1);//Silme işlemi karakter sayısı bir azaltılarak yapıldı.
        userInput.setText(String.valueOf(word));


    }


    @FXML
    protected void validation() throws IOException {//Girilen kelimenin uygunluk kontrolü.


        if (word.toString().equals("")) {//hiç bir şey girilmezse.
            Alert nullAlert = new Alert(Alert.AlertType.ERROR);
            nullAlert.setContentText("Bir kelime girin!!");
            nullAlert.show();


        } else {
            if (word.indexOf("K") == -1  ) {//merkez harfi içermez yada 4 karakterden kısaysa
                Alert centerALert = new Alert(Alert.AlertType.ERROR);
                centerALert.setContentText("Yazdığınız kelime K karakterini içermeli !!!");
                centerALert.show();

            }
            else if(word.length() < 4){
                Alert lengthALert = new Alert(Alert.AlertType.ERROR);
                lengthALert.setContentText("Yazdığınız kelime 3 karakterden uzun olmalı!!!");
                lengthALert.show();

            }
            else {
                BufferedReader reader = new BufferedReader(new FileReader("C://Users/kubra/Documents/sozluk.txt"));
                String line = reader.readLine();
                String sWord = word.toString();
                String lowerWord = sWord.toLowerCase();
                boolean areEqual = true;
                boolean isContain=true;
                int lineNum = 1;


                while (line != null) {
                    if (line.equals(null)) {
                        areEqual = false;

                        break;
                    } else if (line.equalsIgnoreCase(lowerWord)) {
                        areEqual = true;
                        if (foundedWords.getText().toString().indexOf((" "+word.toString() + " ")) == -1) {
                            foundedWords.appendText(" "+(word) + " ");
                            isContain=true;
                            counterVal++;
                            counter.setText(counterVal + " Kelime Buldunuz...");

                        } else {
                            Alert repeatALert = new Alert(Alert.AlertType.ERROR);
                            repeatALert.setContentText("Bu kelimeyi daha önce kullandınız!!!");
                            repeatALert.show();
                            isContain=false;
                        }




                        break;


                    } else {
                        areEqual = false;


                    }
                    line = reader.readLine();
                    lineNum++;
                }


                if (areEqual&&isContain) {


                    if (word.reverse().toString().equals(userInput.getText())) {

                        reverseScore = word.length() + 4;
                        score = score + reverseScore;
                        scoreLabel.setText(String.valueOf(score));


                    } else {

                        normalScore = word.length() - 3;
                        score = score + normalScore;
                        scoreLabel.setText(String.valueOf(score));


                    }
                }
                else if (areEqual==false){
                    Alert invalidALert = new Alert(Alert.AlertType.ERROR);
                    invalidALert.setContentText("Yazdığınız kelime sözlükte mevcut değil!!!");
                    invalidALert.show();
                }

                {

                }

            }
        }


    }

}




