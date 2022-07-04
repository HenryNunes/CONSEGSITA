package Interface.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    private static Object uData;

    @FXML
    private TextField sourceFileName;

    @FXML
    private Slider sliderS;

    @FXML
    private Slider sliderI;

    @FXML
    private Slider sliderT;

    @FXML
    private Slider sliderA;

    //abre o explorador de arquivos para fazer a seleção de um arquivo csv (database)
    public void openExplorer(ActionEvent actionEvent){
        // create a File chooser
        FileChooser file_chooser = new FileChooser();

        file_chooser.setTitle("Select the database (just CSV files):");
        file_chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));


        // get the file selected
        File file = file_chooser.showOpenDialog(Main.getMainScene().getWindow());
        if (file != null) {
            sourceFileName.setText(file.getAbsolutePath());
        }
    }

    //salva o caminho src da database em um atributo do main
    public void transform(ActionEvent actionEvent) {
        Main.setFileName(sourceFileName.getText());
        Main.setS(sliderS.getValue());
        Main.setI(sliderI.getValue());
        Main.setT(sliderT.getValue());
        Main.setA(sliderA.getValue());
        System.out.println(Main.getFileName());
        System.out.println(Main.getS());
        System.out.println(Main.getI());
        System.out.println(Main.getT());
        System.out.println(Main.getA());

    }

    //atualiza o status (disable = true/false) dos sliders
    public void updateSliders(Object uData){
        boolean[] hasSITA = (boolean[]) uData;
        sliderS.setDisable(!hasSITA[0]); // hasSITA[0] = facade.hasS()
        sliderI.setDisable(!hasSITA[1]); // hasSITA[1] = facade.hasI()
        sliderT.setDisable(!hasSITA[2]); // hasSITA[2] = facade.hasT()
        sliderA.setDisable(!hasSITA[3]); // hasSITA[3] = facade.hasSA()
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Main.addOnChangeScreenListener(new Main.onChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                uData = userData;
                updateSliders(uData);
            }
        });
    }
}