package project1;


//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.sun.tools.javac.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class p2maven
{
public static String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
WebDriver driver;
	@BeforeTest
	public void bt()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
	}
	@Test (priority = 0)
	public void login() throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		Thread.sleep(4000);
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
	}
	    
	@Test (priority = 3)
	public void logout() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']//li[4]//a")).click();
		Thread.sleep(1000);
		driver.close();
	}
	
	@Test (priority = 1)
	public void tc()
	{
		java.util.List<WebElement> ele=driver.findElements(By.tagName("a"));
		System.out.println(ele.size());
		for(int i=0;i<ele.size();i++)
		{
			System.out.println(ele.get(i).getText());
			System.out.println(ele.get(i).getAttribute("href"));
	}
	}
	
	@Test(priority = 2)
    public void admin()
    {
    	java.util.List <WebElement> el=driver.findElements(By.xpath("//*[@class='oxd-table-card']"));
    	System.out.println(el.size());
    	Actions act=new Actions(driver);
    	WebElement mm=driver.findElements(By.xpath("//*[@class='oxd-table-card']")).get(1);
    	act.click().build().perform();
    	

    }
}


