package finalProject.finalProject;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;


public class AppTest   
{

	private static final Boolean True = null;
	WebDriver driver=new ChromeDriver();
	String WebSite="http://www.almosafer.com/en";
	
	@BeforeTest
   public void MySetup() {
		driver.get(WebSite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement SettingPopup=driver.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));
		SettingPopup.click();
	}
   
   
   
   @Test (priority=1, enabled=true)
   public void CheckTheSiteLanguage() {
	   
	   String ActualLanguge=driver.findElement(By.tagName("html")).getDomAttribute("Lang");
	   System.out.println(ActualLanguge);
	   String ExpectedLanauge = "en";
	   
	   Assert.assertEquals(ActualLanguge, ExpectedLanauge);
	   
   }
	   
	  
   @Test(priority=2, enabled=true)
   public void CheckCurrency() {
	   String ActualCurrency=driver.findElement(By.cssSelector(".sc-hUfwpO.kAhsZG")).getText();
	   String ExpectedCurrency="SAR";
	   Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	
   }
   
   
   @Test(priority=3, enabled=true)
   public void MobileNumber() {
	   String AcutalNumber=driver.findElement(By.partialLinkText("9665")).getText();
	   String ExpectedNumber="+966554400000";
	   Assert.assertEquals(AcutalNumber, ExpectedNumber);
	   }
   
   @Test(priority=4, enabled=true)
   public void TakafulLogo() {
	   WebElement Footer=driver.findElement(By.tagName("Footer"));
	   Boolean AcutalLogo=Footer.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();
	   Boolean ExpectedLogo=true;
	   Assert.assertEquals(AcutalLogo, ExpectedLogo);
	   }
   
   
   @AfterTest
   public void quit() {}
}
