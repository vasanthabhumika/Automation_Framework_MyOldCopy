package vtiger.Practice;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganisationWithIndustry {

	public static void main(String[] args) throws Throwable{
		// TODO Auto-generated method stub
		
        //Step 1: Launch the Browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8889");

		//Step 2: Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
	    driver.findElement(By.id("submitButton")).click();
	    
//	    Step 3: Navigate to Organisation Link
	    driver.findElement(By.linkText("Organizations")).click();
	    
//	    Step 4: Click on create organisation Lookup image
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//	    Step 5: Create organisation with mandatory information
	    driver.findElement(By.name("accountname")).sendKeys("pizzaHut");
	    
//	    Step 6: Select 'chemicals' from industry dropdown
	    WebElement dropdown = driver.findElement(By.name("industry"));
	    Select sel = new Select(dropdown);
	    sel.selectByValue("Chemicals");
	    
//	    Step 7: Save
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
//	    Step 8: Validate
	    String orgText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(orgText.contains("pizzaHut")){
	    	System.out.println("PASS");
	    	System.out.println(orgText);
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
