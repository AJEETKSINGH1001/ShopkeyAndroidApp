package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

public class login extends BaseClass {
	
	ExtentReports extent = new ExtentReports();
	
	@Test
    public void testlogin() {
		 driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/getStartedBtnLogin")).click();
	        driver.findElement(By.className("android.widget.LinearLayout")).click();
	       // driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/countryCodeTV")).click();
	        ///handling drop-downs
	       // List items = (List) driver.findElements(By.id("com.bitnudge.ime.shopkey.shopkey:id/countryCodeDropDownIV"));
	        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
	        driver.findElement(By.className("android.widget.TextView")).click();
	        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/phoneNumberTfEditText")).sendKeys("8636478855");
	        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/btnNext")).click();
	        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/etPasswordEditText")).sendKeys("Test@12345");
	        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/btnNext")).click();
	        driver.findElement(By.className("android.view.ViewGroup")).click();
	        WebElement result= (WebElement) driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/gc_gctextview"));
	        Assert.assertEquals(result.getText(), "English");
	        System.out.println("Welcome to Shopkey");
	        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/gc_gctextview")).click();
	        driver.findElement(By.className("android.widget.Button")).click();	
	}}
