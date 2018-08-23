package mypkg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Myclass {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		System.out.println("Back to JAVA, Great Feelings");
		
		WebDriver driver = null;
		
		// Invoking Firefox browser
		driver = new FirefoxDriver();
		driver.get("http://developer.pitneybowes.com");
		driver.manage().window().maximize();
		
		//driver.findElement(By.cssSelector("a[href='/en.html']")).click();
		driver.findElement(By.cssSelector(".icn-menu")).click();
		driver.findElement(By.linkText("API Home")).click();
	//	System.out.print("Total links are "+driver.findElements(By.tagName("a")).size());
		System.out.println(driver.findElement(By.tagName("h1")).getText());
		
		/*System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://developer.pitneybowes.com");*/

	}

}
