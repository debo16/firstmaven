package Hibiscus;

import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Guru99 {
	public static String url = "https://demo.guru99.com/test/newtours/index.php";
	WebDriver driver;
	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		}
	@Test(enabled = true,alwaysRun = true, priority = -1)
	public void login() {
		String beforelogin = driver.getTitle();
		System.out.println(beforelogin);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.xpath("//*[@type='text']"));
		
		username.sendKeys("user");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
		password.sendKeys("user");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		String afterlogin = driver.getTitle();
		System.out.println(afterlogin);
		//Assert.assertEquals(afterlogin, beforelogin);
//		SoftAssert softassert = new SoftAssert();
//		softassert.assertEquals(afterlogin, beforelogin);
		
		if(beforelogin.equals(afterlogin)){
			
			System.out.println("same");
		}
		else {
			System.out.println("not same");
	}
	}
	@Test(enabled = true,alwaysRun = true, priority = 0)
	public void register() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.linkText("REGISTER")).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.name("firstName")).sendKeys("debolina");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		driver.findElement(By.name("lastName")).sendKeys("ghosh");
		Thread.sleep(3000);
		driver.findElement(By.name("phone")).sendKeys("9500000100");
		Thread.sleep(3000);
		driver.findElement(By.name("userName")).sendKeys("debo123");
		Thread.sleep(6000);
		driver.findElement(By.name("address1")).sendKeys("Kolkata");
		driver.findElement(By.name("city")).sendKeys("Siliguri");
		Thread.sleep(2000);
		driver.findElement(By.name("state")).sendKeys("WB");
		Thread.sleep(2000);
		driver.findElement(By.name("postalCode")).sendKeys("000001");
		WebElement country = driver.findElement(By.xpath("//*[@name='country']"));
		Thread.sleep(3000);
		Select s = new Select(country);    // Select method
		s.selectByIndex(5);// country Angola
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys("debolina");
		driver.findElement(By.name("password")).sendKeys("debo123");
		driver.findElement(By.name("confirmPassword")).sendKeys("debo123");
		Thread.sleep(3000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
	}
	/*@Test
	public void linkpresent() {   // how to check how many links are present
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		System.out.println(ele.size());
		for(int i = 0; i< ele.size(); i++) {
			//System.out.println(ele.get(i).getText());
			System.out.println(ele.get(i).getAttribute("href"));
		}
	}*/
	
	@AfterTest
	private void close() {
		driver.close();		
	}
		
	}


