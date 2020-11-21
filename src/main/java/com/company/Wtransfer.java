package com.company;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Jack on 18.12.2018.
 */
public class Wtransfer {
    private String fxmlUrl;
    private String title;
    private Stage stage;
    private FXMLLoader loader;
    private AnchorPane anchorPane;
    public Wtransfer(){

    }

    /**
     * @param fxmlUrl
     * @param title
     * This constructor call like Main Window
     */
    public Wtransfer(String fxmlUrl, String title) {
        this.fxmlUrl = fxmlUrl;
        this.title = title;
        this.init();
    }

    /**
     * @param fxmlUrl
     * This constructor to  call window like PopUp
     */
    public Wtransfer(String fxmlUrl) {
        this.fxmlUrl = fxmlUrl;
        this.initPopUp();
    }

    private void initPopUp()
    {
        System.out.println(fxmlUrl);
        loader = new FXMLLoader();

        try {
            Parent root = loader.load(this.getClass().getClassLoader().getResource(fxmlUrl));
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.setFullScreen(false);
            stage.setMaximized(false);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Wtransfer(AnchorPane anchorPane, String fxmlUrl,Locale locale) {
        this.anchorPane = anchorPane;
        this.fxmlUrl = fxmlUrl;
        this.prepareInit();
    }

    private void prepareInit()
    {
        System.out.println(fxmlUrl);
        if(anchorPane.getChildren() != null && anchorPane.getChildren().size() > 0)
            this.anchorPane.getChildren().clear();
        loader = new FXMLLoader(getClass().getClassLoader().getResource(this.fxmlUrl));
        try {
            anchorPane.getChildren().add((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void init() {
        try {
            System.out.println(fxmlUrl);
            loader = new FXMLLoader();
            Parent root = loader.load(this.getClass().getClassLoader().getResource(fxmlUrl));
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.initStyle(StageStyle.DECORATED);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toGetController(String fxmlUrl, Locale locale)
    {
        try {
            System.out.println(fxmlUrl);
            loader = new FXMLLoader();
            Parent root = loader.load(this.getClass().getClassLoader().getResource(fxmlUrl).openStream());
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void  setHint(String hint){this.stage.setFullScreenExitHint(hint);}
    public void setFullScreen(boolean yes){
        this.stage.setFullScreen(yes);
    }
    public void setResizeble(boolean yes){this.stage.setResizable(yes);}
    public void setMaximized(boolean yes){this.stage.setMaximized(yes);}
    public void setStageStyle(StageStyle stageStyle){
        this.stage.initStyle(stageStyle);
    }
    public void show(){
        this.stage.show();
    }
    public void showAndWait(){this.stage.showAndWait();}
    public void setModality(Modality modality){
        this.stage.initModality(modality);
    }
    public <T> T getController(){
        return loader.getController();
    }


}

