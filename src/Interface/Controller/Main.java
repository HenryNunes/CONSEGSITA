package Interface.Controller;

import Control.Facade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

// https://www.youtube.com/playlist?list=PLd4Jo6d-yhDJDu6z0luwaKpW2QD-jGVGc


public class Main extends Application {

    //criar atributo static para todos os scenes criados
    private static Stage stage;
    private static Scene mainScene;
    private static Facade facade;

    //listeners de quando a tela é alterada
    private static ArrayList<onChangeScreen> listeners = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        stage.setTitle("SITA Project"); //salva o titulo do primaryStage

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("../View/main.fxml")); //carrega o FXML
        mainScene = new Scene(fxmlMain, 600, 700); // Cria uma cena com o FXML carregado em root

        facade = new Facade();
        boolean[] hasSITA = {facade.hasS(), facade.hasI(), facade.hasT(), facade.hasA()};

        stage.setScene(mainScene); //salva a cena do primaryStage
        changeScreen("main", hasSITA);
        stage.show(); //mostra o primaryStage
    }

    public static void updateProgress(){
        BigDecimal valueProgress = facade.getProgress();
        changeScreen("main", valueProgress);
    }

    public static void setFacade(String sourceFileName, int s, int i, int t, int a) {
        facade.setS(s);
        facade.setI(i);
        facade.setT(t);
        facade.setA(a);
        String dest = sourceFileName.split("\\.")[0] + "_transformed." + sourceFileName.split("\\.")[1];
        facade.transform(sourceFileName, dest, ";");
        Main.updateProgress();

    }

    //métodos para trocar as telas do sistema
    //com parametros
    public static void changeScreen(String newScreen, Object userData){
        switch (newScreen){
            case "main":
                stage.setScene(mainScene);
                notifyAllListeners("main", userData);
                break;
            default:
                break;
        }
    }

    //sem parametros
    public static void changeScreen(String newScreen){
        changeScreen(newScreen, null);
    }

    public static Scene getMainScene() {
        return mainScene;
    }

    //alteração de telas com parametro
    public interface onChangeScreen{
        void onScreenChanged(String newScreen, Object userData);
    }

    public static void addOnChangeScreenListener(onChangeScreen newListener){
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, Object userData){
        for (onChangeScreen l : listeners){
            l.onScreenChanged(newScreen, userData);
        }
    }

}