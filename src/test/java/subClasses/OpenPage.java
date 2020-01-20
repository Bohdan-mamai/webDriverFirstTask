package subClasses;

import org.openqa.selenium.WebDriver;

public class OpenPage {

    private WebDriver driver;

    private final String pasteBinLink = "https://paste.ubuntu.com/";

    public OpenPage(WebDriver driver) {
        this.driver = driver;
    }

    public OpenPage openAppPage(){
        driver.get(pasteBinLink);
        return this;
    }
}
