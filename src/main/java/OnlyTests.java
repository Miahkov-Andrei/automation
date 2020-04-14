import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlyTests extends MethodsBasic {



    @Test
    public void test_account_createAccount() throws InterruptedException {

        Assert.assertEquals(getText("com.coherohealth.breathesmart:id/tv_title"),"Home");
        Assert.assertEquals(getText("com.coherohealth.breathesmart:id/st_title"), "Welcome");
        Assert.assertEquals(getText("com.coherohealth.breathesmart:id/st_title"), "Welcome");

    }

    @Test
    public void test_account_changeUserName() throws InterruptedException {

        clickById("com.coherohealth.breathesmart:id/iv_home_button");
        clickByxPath("Account", true);
        clickById("com.coherohealth.breathesmart:id/ugi_name");
        clickById("com.coherohealth.breathesmart:id/ugi_first_name");
        clickById("com.coherohealth.breathesmart:id/ugi_first_name_clear");
        typeTextById("com.coherohealth.breathesmart:id/ugi_first_name", "FirstFirstName");
        clickById("com.coherohealth.breathesmart:id/ugi_last_name");
        clickById("com.coherohealth.breathesmart:id/ugi_last_name_clear");
        typeTextById("com.coherohealth.breathesmart:id/ugi_last_name", "LastLastName");
        clickById("com.coherohealth.breathesmart:id/save");


        Assert.assertEquals(getText("com.coherohealth.breathesmart:id/ugi_name"), "FirstFirstName LastLastName");

    }

    @Test
    public void test_account_changeUserEmail() throws InterruptedException {

        clickById("com.coherohealth.breathesmart:id/iv_home_button");
        clickByxPath("Account", true);
        clickById("com.coherohealth.breathesmart:id/ugi_email");
        clickById("com.coherohealth.breathesmart:id/fce_new_email");
        typeTextById("com.coherohealth.breathesmart:id/fce_new_email", "testemail@cohero.com");
        clickById("com.coherohealth.breathesmart:id/fce_new_email_confirm");
        typeTextById("com.coherohealth.breathesmart:id/fce_new_email_confirm", "testemail@cohero.com");
        clickById("com.coherohealth.breathesmart:id/btnChangeEmail");

        Assert.assertEquals(getText("com.coherohealth.breathesmart:id/ugi_email"), "testemail@cohero.com");

    }

    @Test
    public void test_account_storeRedirection() throws InterruptedException {

        clickById("com.coherohealth.breathesmart:id/iv_home_button");
        clickByxPath("Account", true);
        clickById("com.coherohealth.breathesmart:id/ugi_manage_account_section");
        clickById("com.coherohealth.breathesmart:id/ll_manage_subscrobtion_container");

        String x = getText("com.sec.android.app.sbrowser:id/location_bar_edit_text");

        driver.navigate().back();
        driver.navigate().back();

        Assert.assertEquals(x, "\u200Estore.coherohealth.com");

    }

}