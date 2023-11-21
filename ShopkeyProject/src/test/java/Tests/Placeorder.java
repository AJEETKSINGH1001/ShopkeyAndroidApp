package Tests;
import java.awt.HeadlessException;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
//package <set your test package>;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


/*This is test case for Placing order 
Written by Ajeet k Singh on 18 December 2022*/

public class Placeorder {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Placing the Order";
    protected AndroidDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability(MobileCapabilityType.UDID, "084113125P054404");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Infinix");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.bitnudge.ime.shopkey.shopkey");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.bitnudge.ime.parent.view.activities.SplashActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

	/* Logging into Shopkey app */
    @SuppressWarnings("deprecation")
	@Test
    public void DemoPlacingOrders() throws HeadlessException, UnsupportedFlavorException, IOException {
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/getStartedBtnLogin")).click();
       // driver.findElement(By.className("android.widget.LinearLayout")).click();
       // driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/countryCodeTV")).click();
        ///handling drop-downs
       // List items = (List) driver.findElements(By.id("com.bitnudge.ime.shopkey.shopkey:id/countryCodeDropDownIV"));
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
        driver.findElement(By.className("android.widget.TextView")).click();
        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/phoneNumberTfEditText")).sendKeys("8636478855");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/btnNext")).click();
        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/etPasswordEditText")).sendKeys("Test@12345");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/btnNext")).click();
        driver.findElement(By.className("android.view.ViewGroup")).click();
        WebElement result= (WebElement) driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/gc_gctextview"));
        Assert.assertEquals(result.getText(), "English");
        System.out.println("Welcome to Shopkey");
        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/gc_gctextview")).click();
        driver.findElement(By.className("android.widget.Button")).click();
        //Dashboard screen
        System.out.println("This is Shopkey Dashboard");
    	//Going to product page
        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/btnProduct")).click();
        System.out.println("Welcome to Products Page");
        //Srolling the screen
       // driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
        //Adding Product to cart
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/btnContinue")).click();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/tvLeadName")).click();
    	//Sharing Payment Link
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/btnShare")).click();
    	//Copying the store url for clicking over url
       // driver.findElement(By.id("android:id/chooser_copy_button")).click(); //text copied to clipboard
        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='11']")).click();
        //Sending payment url to a contact
        driver.findElement(By.id("com.whatsapp:id/contactpicker_row_phone_type")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
        //Sending url
        driver.findElement(By.id("com.whatsapp:id/send")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.id("com.whatsapp:id/send")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.view.View[@index='0']")).click();
        System.out.println("This Payment Page");
        //Scrolling the screen
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
        //Clicking checkout button
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Pergi ke Checkout\"]/android.widget.Button")).click();
        //validating the next page
        WebElement resultElement = driver.findElement(MobileBy.xpath("//android.view.View[@content-desc=\"Toko\"]/android.widget.TextView"));
       // driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
        Assert.assertTrue(resultElement.isDisplayed(), "At the checkout page");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.Button[5]")).click();
        //placing order
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[6]/android.widget.Button")).click();
        
		/*
		 * //At checkout page adding address
		 * driver.findElement(By.id("com.android.chrome:text/JakartaIndonesia")).click()
		 * ; // adding flat number driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.EditText"
		 * )).sendKeys("flt 243"); // Adding postal code driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.widget.EditText"
		 * )).sendKeys("454334"); //kota of address driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.widget.EditText"
		 * )).sendKeys("454334"); // Selecting province driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[5]"
		 * )).click(); //next page driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View"
		 * )).click();
		 */
         }
    
    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }
}