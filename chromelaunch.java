package mvnproject;

import java.io.File;
import java.io.*;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.FileOutputStream;
import java.io.IOException;


public class chromelaunch {
	private static final String FileUtils = null;

	public static <TakeScreenshot> void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lavanya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.google.com/");
//		System.out.println(driver.getTitle());
		
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://www.amazon.in/");
	    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("dresses women");
//	    List<WebElement> list= driver.findElements(By.xpath(""));
//	    System.out.println(list.size());
	    
//	    nav-search-submit-button
	    driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
    driver.findElement(By.xpath("//div[@data-component-type= 's-search-result'][1]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)"); 
		
		Select dropdown = new Select(driver.findElement(By.id("native_dropdown_selected_size_name")));
		dropdown.selectByVisibleText("L");
		
		String price = driver.findElement(By.xpath("//span[@class = 'a-price-whole']")).getText();
		System.out.println("The price is " + price);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		
		String size = driver.findElement(By.xpath("//span[@class = 'a-list-item']/span[2]")).getText();
		System.out.println("The size is " + size);
		
		String totalprice = driver.findElement(By.xpath("//span[@class = 'a-price-whole']")).getText();
		System.out.println("The price is " + totalprice);
		
		driver.findElement(By.id("nav-cart")).click();
		driver.findElement(By.id("desktop-ptc-button-celWidget")).click();
		
		byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        // Save the screenshot to a file
        String destinationPath = "./src/Screenshots/Image1.png";
        try (FileOutputStream outputStream = new FileOutputStream(destinationPath)) {
            ((FileOutputStream) outputStream).write(screenshotBytes);
            System.out.println("Screenshot saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save the screenshot. Error: " + e.getMessage());
        }

	}
		
}
