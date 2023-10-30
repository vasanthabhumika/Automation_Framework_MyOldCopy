package vtiger.Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario5 {

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
	    firstName.sendKeys("sathish Kumar");
	    
	    WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
	    lastName.sendKeys("K");
	    
//	    Step 6: Select the 'Organization' from organization look up image
	    driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
	    
	    
//	    Step 7: switch the control to child window
	    String mainWinID = driver.getWindowHandle();
	    
	    Set<String> allWinIds = driver.getWindowHandles();
	    
	    for(String ID: allWinIds) {
	    	if(!ID.equals(mainWinID)) {
	    		driver.switchTo().window(ID);
	    	}
	    }
//	    WebElement search = driver.findElement(By.xpath("//input[@id='search_txt']"));

	   

	}

}
