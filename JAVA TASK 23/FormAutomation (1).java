package org.Dropdown;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.util.Set;

public class FormAutomation {
    public static void main(String[] args) {
        // Set the path to geckodriver.exe
    	System.setProperty("Webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\geckodriver-v0.34.0-win64.exe");
    	
        // Initialize FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Navigate to the form page
        driver.get("https://phptravels.com/demo/");

        // Initialize WebDriverWait with a timeout of 60 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        try {
            // Fill in form details FirstName
            WebElement FirstnameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("first_name")));
            FirstnameInput.sendKeys("John");
            
            // Fill in form details LastName
            WebElement LastnameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("last_name")));
            LastnameInput.sendKeys("Doe");
            
            // Fill in form details BusinessName
            WebElement BusinessnameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("business_name")));
            BusinessnameInput.sendKeys("Doe@John ");
            
            // Fill Email InPut
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            emailInput.sendKeys("john.doe@example.com");

            //WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
           // phoneInput.sendKeys("1234567890");

            // Wait for the sum elements to be visible and extract their values
            WebElement sum1Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numb1")));
            WebElement sum2Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numb2")));
            int sum1 = Integer.parseInt(sum1Input.getText());
            int sum2 = Integer.parseInt(sum2Input.getText());

            // Calculate the sum
            int sumResult = sum1 + sum2;

            // Fill in the sum result
            WebElement sumResultInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("number")));
            sumResultInput.sendKeys(String.valueOf(sumResult));

            // Submit the form
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("demo")));
            submitButton.click();

            // Verify form submission message
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'completed')]")));
            System.out.println("Form submitted successfully: " + successMessage.getText());

            // Take a screenshot of the page after form submission
            File screenshot = ((FirefoxDriver) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
            // Save screenshot to a specific location
            FileUtils.copyFile(screenshot, new File("C:Users_Dell_OneDrive_Pictures_Screenshots"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.close();
        }
    }
}
