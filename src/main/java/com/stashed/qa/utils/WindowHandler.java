package com.stashed.qa.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandler {
	
	private WebDriver driver;

    public WindowHandler(WebDriver driver) {
        this.driver = driver;
    }
    
    
    public void switchWindows(String operation) throws InterruptedException {

        // Get all window handles and store them in a list
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());

        if ("child".equalsIgnoreCase(operation)) {
            // This corresponds to switchToChildWindow

            Thread.sleep(6000);
            System.out.println("switchToChildWindow");

            // Get all window handles again after the child window has opened
            Set<String> newWindowHandles = driver.getWindowHandles();

            // Add any new window handles to our list
            for (String handle : newWindowHandles) {
                if (!windowHandles.contains(handle)) {
                    windowHandles.add(handle);
                    driver.switchTo().window(handle);
                    System.out.println("Switched to child window: " + handle);
                }
            }

        } else if ("parent".equalsIgnoreCase(operation)) {
            // This corresponds to switchToParentWindow

            System.out.println("switchToParentWindow");

            // The first handle in our list should be the parent window handle
            String parentWindowHandle = windowHandles.get(0);

            if (driver.getWindowHandles().contains(parentWindowHandle)) {
                driver.switchTo().window(parentWindowHandle);
                System.out.println("Switched back to parent window: " + parentWindowHandle);
            } else {
                System.out.println("Parent window is already closed");
                // Handle the error as needed
            }
        } else {
            System.out.println("Invalid operation: " + operation);
        }
    }

    
    
    
    
    
    
    
    
    /*
    public void switchToParentWindow() throws InterruptedException {
    	
    	System.out.println("switchToParentWindow");

        String mainWindowHandle = driver.getWindowHandle();

        // Check if the main window is still open
        if (driver.getWindowHandles().contains(mainWindowHandle)) {
            driver.switchTo().window(mainWindowHandle);
        } else {
            System.out.println("Main window is already closed");
            // Switch to a different window, or handle the error as needed
        }
    }


	public void switchToChildWindow() throws InterruptedException {
        
    	Thread.sleep(6000);
    	System.out.println("switchToChildWindow");
		//Get handles of the windows
		String mainWindowHandle = driver.getWindowHandle();
		
		// getWindowHandle method to get ID of new window (child window)
        Set<String> Child_id = driver.getWindowHandles();
 
		System.out.println(Child_id);

        // for each loop
        for (String a : Child_id) {
            // it will print IDs of both window
            System.out.println(a);
   
            driver.switchTo().window(a);

        }
    }
    */

}
