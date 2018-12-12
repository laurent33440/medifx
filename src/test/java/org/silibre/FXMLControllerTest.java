/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.silibre;

import java.util.concurrent.TimeoutException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

/**
 *
 * @author lauthier
 */
public class FXMLControllerTest extends ApplicationTest {
    
    Button button;
    Label label;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(MainApp.class.getResource("scene.fxml"));
        Scene scene = new Scene(mainNode);
        scene.getStylesheets().add(MainApp.class.getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        /* Do not forget to put the GUI in front of windows. Otherwise, the robots may interact with another
        window, the one in front of all the windows... */
        stage.toFront();
    }
    
    /* Just a shortcut to retrieve widgets in the GUI. */
    public <T extends Node> T find(final String query) {
        /** TestFX provides many operations to retrieve elements from the loaded GUI. */
        return lookup(query).query();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         button = find("#button");
         label = find("#label");
    }
    
    /* IMO, it is quite recommended to clear the ongoing events, in case of. */
    @After
    public void tearDown() throws TimeoutException {
        /* Close the window. It will be re-opened at the next test. */
        FxToolkit.hideStage();
        release(new KeyCode[] {});
        release(new MouseButton[] {});
    }
    
    @Test
    public void checkLabelBeforeButtonClicked() {
        Assert.assertEquals(FXMLController.LABEL_UNCLICKED,label.getText());
    }
    
    @Test
    public void checkButtonLabelUnclicked() {
        Assert.assertEquals(FXMLController.BUTTON_UNCLICKED, button.getText());
    }
    
    @Test
    public void checkButtonLabelOnClick() {
        clickOn(button);
        WaitForAsyncUtils.waitForFxEvents();
        
        Assert.assertEquals(FXMLController.BUTTON_CLICKED, button.getText());
    }
    
    @Test
    public void checkLabelWithButtonClicked() {
        clickOn(button);
        WaitForAsyncUtils.waitForFxEvents();
        
        Assert.assertEquals(FXMLController.LABEL_CLICKED, label.getText());
    }
    
   
    /**
     * Test of initialize method, of class FXMLController.
     */
//    @Test
//    public void testInitialize() {
//        System.out.println("initialize");
//        FXMLController instance = new FXMLController();
//        instance.initialize();
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
    
}
