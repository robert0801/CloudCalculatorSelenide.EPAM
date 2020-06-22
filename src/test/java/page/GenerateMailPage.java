package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class GenerateMailPage{


    public static Double priceOnGenerateMailPage;

    private final Logger logger = LogManager.getRootLogger();

    public GenerateMailPage getToMailPage(){
        Selenide.open("https://10minutemail.com/");
        return this;
    }

    public GenerateMailPage copyMail() {
        $(By.xpath("//*[@id='copy_address']")).waitUntil(Condition.visible, 10000).click();
        Selenide.switchTo().window(PageWithSettings.tab.get(0));
        logger.info("Generate email");
        return this;

    }

    public GenerateMailPage clickToOpenMail() {

        switchTo().window(PageWithSettings.tab.get(1));
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", $(By.xpath("//*[@id='mail_messages_content']")));


        $(By.xpath("//*[@id='mail_messages_content']")).waitUntil(Condition.appear, 20000).click();
        logger.info("The email was success open");
        return this;
    }

    public void getPriceOnGenerateMailPage() {
        String s = $(By.xpath("//h3[contains(text(), 'USD')]")).waitUntil(Condition.visible, 20000)
                .getText()
                .replace("USD ", "")
                .replaceAll("[^0-9.]","");
        priceOnGenerateMailPage = Double.parseDouble(s);
        System.out.println(priceOnGenerateMailPage);
    }
}
