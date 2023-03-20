package project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class p3maven
{
	public static String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	    WebDriver driver;
	    @BeforeTest
	    public void bt() {
	        WebDriverManager.chromedriver().setup();
	        driver= new ChromeDriver();
	        driver.get(url);
	        
	    }
	    @Test
	    public void login() throws InterruptedException {
	        String beforelogin=driver.getTitle();
	        System.out.println(beforelogin);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        //driver.findElement(By.name("username")).sendKeys("Admin");;
	        WebElement d = driver.findElement(By.name("username"));
	        if(d.isEnabled()) {
	        d.sendKeys("Admin");
	        }
	        Thread.sleep(5000);
	        WebElement a = driver.findElement(By.name("password"));
	        if(a.isEnabled()) {
	            a.sendKeys("admin123");
	        }
	        Thread.sleep(5000);
	        WebElement b = driver.findElement(By.xpath("//*[@type='submit']"));
	        if(b.isEnabled())
	        {
	            b.click();
	        }
	        Thread.sleep(5000);
	        System.out.println("login successfull");
	        String afterlogin=driver.getTitle();
	        System.out.println(afterlogin);
	        Assert.assertEquals(beforelogin, afterlogin);
	        System.out.println("same");
	        driver.findElement(By.linkText("Admin")).click();
	        //WebElement i = driver.findElement(By.xpath("//*[@class='oxd-select-wrapper']//div"));
	       // i.click();
	        Actions act = new Actions(driver);
	        WebElement j = driver.findElement(By.xpath("//*[@class='oxd-select-wrapper']"));
	        //act.contextClick(j).build().perform();
	        act.click(j).build().perform();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        act.sendKeys(j,Keys.ARROW_DOWN);
	        act.sendKeys(j,Keys.ARROW_DOWN);
	        
	    }
	    
	    @Test
	    public void logout() throws InterruptedException {
	        Thread.sleep(5000);
	        WebElement c=driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"));
	        if(c.isEnabled())
	        {
	            c.click();
	        }
	        Thread.sleep(5000);
	        WebElement e= driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']//li[4]//a"));
	        if(e.isEnabled()) {
	            e.click();
	        }
	    }
	    @AfterTest
	    public void at() {
	        driver.close();
	    }
	}

