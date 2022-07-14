package Interface.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

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

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    //abre o explorador de arquivos para fazer a seleção de um arquivo csv (database)
    public void openExplorer(ActionEvent actionEvent){
        // create a File chooser
        FileChooser file_chooser = new FileChooser();
        file_chooser.setTitle("Select the database");
        file_chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        file_chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All", "*.*"));


        // get the file selected
        File file = file_chooser.showOpenDialog(Main.getMainScene().getWindow());
        if (file != null) {
            sourceFileName.setText(file.getAbsolutePath());
        }
    }

    //salva o caminho src da database em um atributo do main
    public void transform(ActionEvent actionEvent) {
        progressBar.setDisable(false);
        progressLabel.setDisable(false);
        progressLabel.setText("Progress");
        Main.setFacade(sourceFileName.getText(), (int) sliderS.getValue(), (int) sliderI.getValue(), (int) sliderT.getValue(), (int) sliderA.getValue());
    }

    //atualiza o status (disable = true/false) dos sliders
    public void updateSliders(Object uData){
        boolean[] hasSITA = (boolean[]) uData;
        sliderS.setDisable(!hasSITA[0]); // hasSITA[0] = facade.hasS()
        sliderI.setDisable(!hasSITA[1]); // hasSITA[1] = facade.hasI()
        sliderT.setDisable(!hasSITA[2]); // hasSITA[2] = facade.hasT()
        sliderA.setDisable(!hasSITA[3]); // hasSITA[3] = facade.hasA()
    }

    public void updateProgressBar(Object uData){
        BigDecimal value = (BigDecimal) uData;
        Double doubleValue = value.doubleValue();
        progressBar.setProgress(doubleValue);
        if (doubleValue == 1){
            progressLabel.setText("   Done!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Main.addOnChangeScreenListener(new Main.onChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                uData = userData;
                if (uData instanceof boolean[]){
                    updateSliders(uData);
                }

                if (uData instanceof BigDecimal){
                    updateProgressBar(uData);
                    if (((BigDecimal) uData).compareTo(new BigDecimal("1")) != 0){
                        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(20), event -> {
                            Main.updateProgress();
                        }));
                        timeline.setCycleCount(1); // Executa apenas uma vez. Toda vez que o método updateProgress() é chamado, verifica novamente.
                        timeline.play();
                    }
                }
            }
        });
    }
}