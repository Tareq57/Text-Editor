package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {
    @FXML
    public TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    public void new_on_action(ActionEvent actionEvent) {
        textArea.clear();
    }
    @FXML
    public void open_on_action(ActionEvent actionEvent) throws FileNotFoundException {
        FileChooser fileChooser=new FileChooser();
        File file=fileChooser.showOpenDialog(null);
        if(file==null)return ;
        Scanner sc=new Scanner(file);
        String str="";
        while(sc.hasNext()) {
            str += sc.nextLine() + "\n";
        }
        textArea.setText(str);

    }

    public void save_on_action(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser=new FileChooser();
        File file=fileChooser.showSaveDialog(null);
        if(file== null)return ;
        String str=textArea.getText();
        FileWriter fileWriter=new FileWriter(file);
        fileWriter.write(str);
        fileWriter.close();
    }
}
