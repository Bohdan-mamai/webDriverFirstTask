package subClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewPaste {

    public WebDriver driver;

    public CreateNewPaste(WebDriver driver) {
        this.driver = driver;
    }

    public CreateNewPaste fillPoster(String termFillPoster) throws InterruptedException {
        WebElement Poster = driver.findElement(By.xpath("/html/body/div/div/div/form/table/tbody/tr[3]/td/input"));
        Poster.sendKeys(termFillPoster);
        return this;
    }

    public CreateNewPaste selectExpiration() {
        WebElement Expiration = driver.findElement(By.xpath("//*[@id=\"id_expiration\"]/option[2]"));
        Expiration.click();
        return this;
    }

    public CreateNewPaste fillContent(String termFillContent) {
        WebElement Content = driver.findElement(By.xpath("/html/body/div/div/div/form/table/tbody/tr[6]/td/textarea"));
        Content.sendKeys(termFillContent);
        return this;
    }

    public CreateNewPaste pressPasteButton(){
        WebElement Button = driver.findElement(By.xpath("//*[@id=\"pasteform\"]/table/tbody/tr[7]/td/input"));
        Button.click();
        return this;
    }
}
