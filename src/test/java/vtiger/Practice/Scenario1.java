package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {

        //Step 1: Launch the Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8889");
		
		//Step 2: Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
	    driver.findElement(By.id("submitButton")).click();
	    
//	    Step 3: Navigate to Contacts Link
	    driver.findElement(By.linkText("Contacts")).click();
	    
//	    Step 4: Click on Create contact look Up Image
	    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	    
//	    Step 5: Create Contacts with mandatory information
	    WebElement drop = driver.findElement(By.name("salutationtype"));
	    Select sel = new Select(drop);
	    sel.selectByValue("Mr.");
	    
	    WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
	    firstName.sendKeys("Aanada Kumar");
	    
	    WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
	    lastName.sendKeys("N");
	    
//    	Step 7: Save
    	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
//	    Step 8: Validate
	    String contactText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(contactText.contains("N Aanada Kumar")){
	    	System.out.println("PASS");
	    	System.out.println(contactText);
	    }
	    else {
	    	System.out.println("FAIL");
	    } 
	    
//	    Step 9: Logout the App
	    WebElement onmouseOver = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions act = new Actions(driver);
	    act.moveToElement(onmouseOver).perform();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Sign Out")).click();
	    
//	    Step 10: Close the Browser
	    Thread.sleep(2000);    
	    driver.quit();	
	    
	    
	    
	    
	}
	


}
