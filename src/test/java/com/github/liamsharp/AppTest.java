package com.github.liamsharp;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class AppTest extends FxRobot
{
    
    @Test
    public void testStuff() throws TimeoutException, InterruptedException
    {
        FxToolkit.registerPrimaryStage();
        final Application app = FxToolkit.setupApplication(App.class);
     
        robotContext().getTypeRobot().push(new KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN));
        
        assertEquals(true, App.wasEventFired());
        
        FxToolkit.cleanupApplication(app);
    }

}
