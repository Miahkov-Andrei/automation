import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MethodsBasicClass {

    public AndroidDriver driver;
    SoftAssert softAssert = new SoftAssert();

    private static final String CONVERT_LOWER = "translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')";
    private static final String XPATH_PATTERN = "//*[%s='%s']";
    private static final String IV_HOME_BUTTON = "iv_home_button";


    @BeforeMethod
    public void beforeTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "7.0.0");
        desiredCapabilities.setCapability("deviceName", "Samsung J7");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("app", "C:/automation/autotests/app-stageServer-autotests.apk");
        desiredCapabilities.setCapability("noReset", "false");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.resetApp();
        System.out.println("Начало теста");
        createUser();

    }

    @AfterMethod
    public void afterTest() throws InterruptedException {
        deleteUser();
        System.out.println("Конец теста");
        driver.quit();
    }


    public void clickById(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 55);

        wait.until(elementToBeClickable(By.id(id)));

        MobileElement element = (MobileElement) driver.findElementById(id);

        element.click();
    }

    public void typeTextById(String id, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 55);

        wait.until(elementToBeClickable(By.id(id)));

        MobileElement element = (MobileElement) driver.findElementById(id);

        element.sendKeys(text);

    }
    public void clickByxPath(String xPath, Boolean clickable) {

        String finalXpath = String.format("//*[%s='%s']", "translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')", xPath.toLowerCase());

        if (clickable) {
            WebDriverWait wait = new WebDriverWait(driver, 55);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(finalXpath)));
        } else {
            WebDriverWait wait = new WebDriverWait(driver, 55);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(finalXpath)));
        }


        WebElement button = driver.findElement(By.xpath(finalXpath));
        button.click();
    }

    public void clickIfExistsById(String androidId, Boolean clickable) throws InterruptedException {

        Thread.sleep(1000);

        if (driver.findElements(By.id(androidId)).size() != 0) {
            WebDriverWait wait = new WebDriverWait(driver, 55);
            wait.until(elementToBeClickable(By.id(androidId)));
            WebElement element = driver.findElementById(androidId);
            element.click();
        } else {
        }

    }

//    public void clickIfExistsById(String androidId, Boolean clickable) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, 55);
//            wait.until(elementToBeClickable(By.id(androidId)));
//            MobileElement element = (MobileElement) driver.findElementById(androidId);
//            element.click();
//
//        } catch (Exception ex) {
//
//        }
//
//    }

    public String getText(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 55);
        wait.until(elementToBeClickable(By.id(id)));
        MobileElement element = (MobileElement) driver.findElementById(id);
        return element.getAttribute("text");
    }

    public void createUser() throws InterruptedException {
        clickById("com.coherohealth.breathesmart:id/sign_up_btn");
        typeTextById("com.coherohealth.breathesmart:id/fn_text", "MyFirstName");
        clickById("com.coherohealth.breathesmart:id/fn_next");
        typeTextById("com.coherohealth.breathesmart:id/fn_text", "MyLastName");
        clickById("com.coherohealth.breathesmart:id/fn_next");
        typeTextById("com.coherohealth.breathesmart:id/fn_text", "newtestuser" + System.currentTimeMillis() + "@mail.com");
        clickById("com.coherohealth.breathesmart:id/fn_next");
        typeTextById("com.coherohealth.breathesmart:id/fn_text", "@Cohero1");
        clickById("com.coherohealth.breathesmart:id/fn_next");
        typeTextById("com.coherohealth.breathesmart:id/fn_text", "Inst2spconf");
        clickById("com.coherohealth.breathesmart:id/fn_next");
        clickById("com.coherohealth.breathesmart:id/atc_check");
        clickById("com.coherohealth.breathesmart:id/atc_action_continue");
        clickIfExistsById("com.android.packageinstaller:id/permission_allow_button", false);

    }

    public void deleteUser() throws InterruptedException {
        clickById("com.coherohealth.breathesmart:id/iv_home_button");
        clickByxPath("Account", true);
        clickById("com.coherohealth.breathesmart:id/ugi_manage_account_section");
        clickById("com.coherohealth.breathesmart:id/ll_delete_account_container");
        typeTextById("com.coherohealth.breathesmart:id/fn_text", "@Cohero1");
        clickById("com.coherohealth.breathesmart:id/btn_delete_account");
        clickById("com.coherohealth.breathesmart:id/btn_left_button");
    }

    public Boolean softAssertComparison(String actualResult, String expectedResult) {
        if (actualResult.contains(expectedResult)) {
            softAssert.assertTrue(true);
            return true;
        } else {
            System.out.println(expectedResult + " was not found");
            softAssert.assertTrue(false);
            return false;
        }
    }
    
//    public Page assertTextByXpath(String text, String expectedResult, int index) {
//        String xPath = String.format(XPATH_PATTERN, CONVERT_LOWER, text.toLowerCase());
//        waitElementByXpath(text);
//        List<MobileElement> element = driver.findElements(By.xpath(xPath));
//        String actualResult = element.get(index).getAttribute("text");
//        Assert.assertEquals(expectedResult, actualResult);
//        return this;
//
//    }

}
