package WebTables_30_09_23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Scenario1 {

	public static void main(String[] args) {
	WebDriver driver = new EdgeDriver();
	driver.get("http://localhost:8889");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
    driver.findElement(By.name("user_password")).sendKeys("admin");
    driver.findElement(By.id("submitButton")).click();
    
    driver.findElement(By.linkText("Organizations")).click();
    driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]")).click();

	}

}
