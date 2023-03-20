package Hibiscus;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	public static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	@Test(priority = -1)
	public void login() throws InterruptedException {
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		String beforelogin = driver.getTitle();
		System.out.println(beforelogin);
	    WebElement user = driver.findElement(By.xpath("//*[@name='username']"));
	    Thread.sleep(6000);
	    if(user.isEnabled()) {
		user.sendKeys("Admin");
	    }
	    Thread.sleep(4000);
		//driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");// can use either of the one
		// driver.findElement(By.name("username")).sendKeys("Admin");
		//driver.findElement(By.name("password")).sendKeys("admin123");
		WebElement pass = driver.findElement(By.name("password"));
		if(pass.isEnabled()) {
		pass.sendKeys("admin123");
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(2000);
		String afterlogin = driver.getTitle();
		Assert.assertEquals(afterlogin, beforelogin);
		System.out.println("same");
		
	}
	@Test(priority = 0, enabled = false)
	public void linkpresent() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		System.out.println(ele.size());
		for(int i=0; i<ele.size();i++) {
			Thread.sleep(2000);
			System.out.println(ele.get(i).getText());
			//Thread.sleep(5000);
			//System.out.println(ele.get(i).getAttribute("href"));
			Thread.sleep(5000);
		}
			//driver.close();
		
	}
	
	@Test(priority = 4)
	public void logout() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']//li[4]//a")).click();
		
		
		/*WebElement logout = driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']//li[4]//a"));
		Thread.sleep(3000);
		Select s = new Select(logout);
		s.selectByIndex(3);*/
		}
	
	
@Test(priority = 1, enabled = true)
	public void Admin() throws InterruptedException {
		
		//driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		WebElement user = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a"));
		user.click();
		Thread.sleep(6000);
		//driver.findElement(By.xpath("//*[@class='oxd-select-text oxd-select-text--active']//div")).click();
		WebElement username = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
		Thread.sleep(5000);
		username.sendKeys("debolina");
		Thread.sleep(6000);
		WebElement select = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]"));
		select.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		Actions act = new Actions(driver);
//		act.sendKeys(select,Keys.ARROW_DOWN);
//		
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		act.sendKeys(select,Keys.ARROW_DOWN);
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		List<WebElement> usern = driver.findElements(By.xpath("//*[@class='oxd-table-card']"));//size of usernames in Admin
		System.out.println(usern.size());
		
		Actions act1 = new Actions(driver);
		Thread.sleep(3000);
		WebElement goingdown = driver.findElements(By.xpath("//*[@class='oxd-table-card']")).get(3);
		Thread.sleep(4000);
		act1.click(goingdown).build().perform();  //keyboard action
		Thread.sleep(3000);
		// For DELETING
		List<WebElement> delete = driver.findElements(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[2]/div/div[6]/div/button[1]/i"));
		Thread.sleep(3000);
		WebElement delete1 = driver.findElements(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[2]/div/div[6]/div/button[1]/i")).get(0);
		Thread.sleep(3000);
		act1.click(delete1).build().perform();
		Thread.sleep(3000);
		WebElement cancel = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div/div[3]/button[1]"));
		Thread.sleep(3000);
		act1.click(cancel).build().perform();
//		act1.sendKeys(goingdown, Keys.ARROW_DOWN);
//		Thread.sleep(3000);
//		act1.sendKeys(goingdown, Keys.ARROW_DOWN);
		Thread.sleep(4000);
//		Select s = new Select(goingdown);   // getting fail
//		s.selectByIndex(5);
		Thread.sleep(2000);
		}
//@Test(priority = 2)
//	public void PIM() throws InterruptedException {
//	//driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).click();
//	driver.findElement(By.linkText("PIM")).click();
//	Thread.sleep(2000);
//	}
//@Test(priority = 3)
//	public void Leave() throws InterruptedException {
//	Thread.sleep(5000);
//	driver.findElement(By.xpath("//*[@class='oxd-main-menu-item active']")).click();
//	//driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")).click();
//	Thread.sleep(2000);
//}

/*@Test
	public void National() throws InterruptedException{
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span")).click();
	Thread.sleep(4000);
	List<WebElement> nat = driver.findElements(By.xpath("//*[@class='oxd-table-card']"));
	Thread.sleep(3000);
	Actions act2 = new Actions(driver);
	Thread.sleep(3000);
	WebElement nat1 = driver.findElements(By.xpath("//*[@class='oxd-table-card']")).get(3);
	Thread.sleep(3000);
	act2.click(nat1).build().perform();	
	
}*/

	

}
