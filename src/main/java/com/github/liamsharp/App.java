package com.github.liamsharp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application
{
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    private static boolean mEventFired = false;
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    public static boolean wasEventFired()
    {
        return mEventFired;
    }
    
    private static void eventFired()
    {
        LOGGER.info("event fired!");
        mEventFired = true;
    }

    @Override
    public void start(
        final Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        
        final MenuItem openMenuItem = new MenuItem("Open");
        openMenuItem.setOnAction(event -> Platform.runLater(App::eventFired));
        openMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN));
        
        final Menu fileMenu = new Menu("File");
        fileMenu.getItems().add(openMenuItem);

        final MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);
        
        final BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(new Label("Use the menu"));
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    

}
