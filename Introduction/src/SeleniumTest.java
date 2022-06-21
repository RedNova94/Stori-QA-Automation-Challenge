import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;  


public class SeleniumTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		String key = "webdriver.chrome.driver";
		
		
		System.setProperty(key, "C:\\Users\\Nova\\eclipse-workspace\\Introduction\\Utils\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
	    driver.findElement(By.id("autocomplete")).sendKeys("me");
	    Thread.sleep(2000L);
	    driver.findElement(By.id("ui-id-7")).click();
	  
	    WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
	    Select dropdown = new Select(staticDropdown);
	    dropdown.selectByIndex(2);
	    Thread.sleep(1000L);
	    dropdown.selectByIndex(3);
	    Thread.sleep(1000L);
	    

	    String winHandleBefore = driver.getWindowHandle();
	    driver.findElement(By.id("openwindow")).click();
	    for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	    }
	    String xpath = "//*[@id=\"welcome\"]/div/div/div/div[5]/div/div[2]/div/div[2]/p";
	    String actualText =  driver.findElement(By.xpath(xpath)).getText();
	    String text = "We would never want you to be unhappy! If you are unsatisfied with your purchase, contact us in the first 30 days and we will give you a full refund.";
	    Assert.assertTrue(actualText.equals(text)); 
	    driver.close();
	    driver.switchTo().window(winHandleBefore);
	    
	    winHandleBefore = driver.getWindowHandle();
	    driver.findElement(By.id("opentab")).click();
	    for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	    }
	    xpath = "/html/body/div/div[2]/section[2]/div[2]";
	    WebElement element = driver.findElement(By.xpath(xpath));
	    Actions actions = new Actions(driver);
	    actions.moveToElement(element);
	    actions.perform(); 
	    Thread.sleep(3000L);
	    
	    driver.switchTo().window(winHandleBefore);
	    
	    driver.findElement(By.id("name")).sendKeys("Stori Card");
	    driver.findElement(By.id("alertbtn")).click();
	    System.out.println(driver.switchTo().alert().getText());
	    Thread.sleep(1000L);
	    driver.switchTo().alert().accept();
	    driver.findElement(By.id("name")).sendKeys("Stori Card");
	    driver.findElement(By.id("confirmbtn")).click();
	    Assert.assertEquals("Hello Stori Card, Are you sure you want to confirm?", driver.switchTo().alert().getText());
	    Thread.sleep(1000L);
	    driver.switchTo().alert().accept();

	    WebElement table =      driver.findElement(By.id("product"));
        List<WebElement> rowsList = table.findElements(By.tagName("tr"));
        List<WebElement> columnsList = null;
        List<String> currentRow = new ArrayList<String>();
        Thread.sleep(3000L);
       for (int i=1;i<rowsList.size();i++) {
    	   WebElement row = rowsList.get(i);
           columnsList = row.findElements(By.tagName("td"));
           for (WebElement column : columnsList) {
				currentRow.add(column.getText());
           }
            if(currentRow.get(2).equals("25")) {
            	System.out.println(currentRow.get(1));
            }
           currentRow.clear();
       }
       System.out.println();
       
       xpath = "/html/body/div[3]/div[2]/fieldset[2]/div[1]";
       table =      driver.findElement(By.xpath(xpath));
       rowsList = table.findElements(By.tagName("tr"));
       columnsList = null;
       currentRow.clear();
       Thread.sleep(3000L);
      for (int i=1;i<rowsList.size();i++) {
   	   WebElement row = rowsList.get(i);
          columnsList = row.findElements(By.tagName("td"));
          for (WebElement column : columnsList) {
				currentRow.add(column.getText());
          }
           if(currentRow.get(1).equals("Engineer")) {
           	System.out.println(currentRow.get(0));
           }
          currentRow.clear();
      }
      System.out.println();
      
      driver.switchTo().frame("courses-iframe");
      xpath = "/html/body/div/div[2]/section[4]/div/div/div/div[2]/ul/li[2]";
      System.out.println(driver.findElement(By.xpath(xpath)).getText());
      System.out.println();
      
      driver.quit();
      
	}
	
}
