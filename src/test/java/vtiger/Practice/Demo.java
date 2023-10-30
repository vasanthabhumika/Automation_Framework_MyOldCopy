package vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8889");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.linkText("Organizations")).click();
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        driver.findElement(By.name("accountname")).sendKeys("Ospiders 1.0");
        driver.findElement(By.xpath("//input[@value='T']")).click();
        driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
        
        
        
        
//        case 2: contacts
//        driver.findElement(By.linkText("Contacts")).click();
//        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
        
	}

}
