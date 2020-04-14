import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class TestClass {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "7.0.0");
        desiredCapabilities.setCapability("deviceName", "Samsung J7");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("app", "C:/automation/autotests/app-stageServer-autotests.apk");
        desiredCapabilities.setCapability("noReset", "true");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void Test_01() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 55);

//        wait.until(presenceOfElementLocated(By.id(idAndroid)));
//        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id(idAndroid)), expected));

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/sign_up_btn")));
        MobileElement el1 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/sign_up_btn");
        el1.click();

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/fn_text")));
        MobileElement el2 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/fn_text");
        el2.sendKeys("MyFirstName");

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/fn_next")));
        MobileElement el3 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/fn_next");
        el3.click();

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/fn_text")));
        MobileElement el4 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/fn_text");
        el4.sendKeys("MyLastName");

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/fn_next")));
        MobileElement el5 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/fn_next");
        el5.click();

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/fn_text")));
        MobileElement el6 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/fn_text");
        el6.sendKeys("newtestuser@mail.com");

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/fn_next")));
        MobileElement el7 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/fn_next");
        el7.click();

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/fn_text")));
        MobileElement el8 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/fn_text");
        el8.sendKeys("@Cohero1");

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/fn_next")));
        MobileElement el9 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/fn_next");
        el9.click();

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/fn_text")));
        MobileElement el10 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/fn_text");
        el10.sendKeys("Inst2spconf");

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/fn_next")));
        MobileElement el11 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/fn_next");
        el11.click();

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/atc_check")));
        MobileElement el12 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/atc_check");
        el12.click();

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/atc_action_continue")));
        MobileElement el13 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/atc_action_continue");
        el13.click();

//        Only for new build verification
//        wait.until(elementToBeClickable(By.id("com.android.packageinstaller:id/permission_allow_button")));
//        MobileElement el14 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
//        el14.click();

    }

    @Test
    public void Test_02() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 55);

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/iv_home_button")));
        MobileElement el1 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/iv_home_button");
        el1.click();

        String xPath = String.format("//*[%s='%s']", "translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')", "Account".toLowerCase());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));

        String xPath_01 = String.format("//*[%s='%s']", "translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')", "Account".toLowerCase());
        WebElement button = driver.findElement(By.xpath(xPath));
        button.click();

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/ugi_manage_account_section")));
        MobileElement el2 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/ugi_manage_account_section");
        el2.click();

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/ll_delete_account_container")));
        MobileElement el3 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/ll_delete_account_container");
        el3.click();

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/fn_text")));
        MobileElement el4 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/fn_text");
        el4.sendKeys("@Cohero1");

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/btn_delete_account")));
        MobileElement el5 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/btn_delete_account");
        el5.click();

        wait.until(elementToBeClickable(By.id("com.coherohealth.breathesmart:id/btn_left_button")));
        MobileElement el6 = (MobileElement) driver.findElementById("com.coherohealth.breathesmart:id/btn_left_button");
        el6.click();

    }


    public void clickIfExistsById(String androidId, Boolean clickable) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 55);
            wait.until(elementToBeClickable(By.id(androidId)));
            MobileElement element = (MobileElement) driver.findElementById(androidId);
            element.click();

        } catch (Exception ex) {

        }

    }



//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }


}