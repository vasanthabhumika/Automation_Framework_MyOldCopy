package CalendarPopUp_09_09_23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopUpEx {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		

		
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.goibibo.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		
		String month = "September 2022";
		String exp_date = "25";
		
		while(true) {
			String text = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
			System.out.println(text);
			
			if(text.equalsIgnoreCase(month)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
		
		
		List<WebElement> dateList = driver.findElements(By.className("fsw__date"));
		
		for(WebElement ele: dateList) {
			String textdate = ele.getText();
			System.out.println(textdate);
			String dateArray[] = textdate.split("\n");
			
			if(dateArray[0].equals(exp_date)) {
				ele.click();
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']"
//				+ "/descendant::p[text()='"+date+"']")).click();
//		driver.findElement(By.xpath("//span[text()='Done']")).click();
//	
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//span[text()='Return']")).click();
//		String month1 = "October 2023";
//		String date1 = "27";
//		driver.findElement(By.xpath("//div[text()='"+month1+"']"
//				+ "/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date1+"']")).click();
//		
//		driver.findElement(By.xpath("//span[text()='Done']")).click();
		
		
		
		


//		
//		List<WebElement> dateList = driver.findElements(By.className("fsw__date"));
//		
//		int count = dateList.size();
//		
//		for(int i=0; i<count; i++) {
//			String text = driver.findElements(By.className("fsw__date")).get(i).getText();
//			System.out.println("text is " +text);
//			if(text.equalsIgnoreCase("25")) {
//				driver.findElements(By.className("fsw__date")).get(i).click();
//				break;
//			}
//		}
//	
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//p[@class='sc-12foipm-23 iFkclr']/ancestor::div[@class='sc-12foipm-16 wRKJm fswFld ']")).click();
//		
//		
//		
//	List<WebElement> dateList2 = driver.findElements(By.className("fsw__date"));
//		
//		int count2 = dateList2.size();
//		
//		for(int i=0; i<count2; i++) {
//			String text = driver.findElements(By.className("fsw__date")).get(i).getText();
//			System.out.println("text is " +text);
//			if(text.equalsIgnoreCase("27")) {
//				driver.findElements(By.className("fsw__date")).get(i).click();
//				break;
//			}
//		}
//		
//		driver.findElement(By.xpath("//span[text()='Done']")).click();
		
		
//		while(!driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/ancestor::div[@class='DayPicker']")).getText().contains("December")) {
//			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']/ancestor::div[@class='DayPicker-NavBar']"));
//		}
		
	}

}
