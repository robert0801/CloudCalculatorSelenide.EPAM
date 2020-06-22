package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import util.TestListener;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;


@Listeners({TestListener.class})
public class CommonConditions {

    @BeforeTest()
    public static void setUp()
    {
        //Dimension dimension = new Dimension(1920, 1080);
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = false;
        baseUrl = "https://cloud.google.com";
    }

    @AfterClass
    public static void clearUp()
    {
        Selenide.closeWindow();
    }

}
