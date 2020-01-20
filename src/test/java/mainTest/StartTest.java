package mainTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import subClasses.CreateNewPaste;
import subClasses.OpenPage;

public class StartTest {

    private final String termFillPoster = "hello";
    private final String termFillContent = "git config --global user.name  \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        DesiredCapabilities chrome_cap = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        chrome_cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(chrome_cap);
    }

    @Test(description = "Just first rest, JIRA binding can be here")
    public void commonSearchTermResults() throws InterruptedException {

        OpenPage OpenPage = new OpenPage(driver);
        OpenPage.openAppPage();

        CreateNewPaste createNewPaste = new CreateNewPaste(driver);

        createNewPaste.fillPoster(termFillPoster);
        createNewPaste.selectExpiration();

        createNewPaste.fillContent(termFillContent);

        createNewPaste.pressPasteButton();

        String realPoster = driver.findElement(By.xpath("//*[@id=\"contentColumn\"]/div/h1[2]")).getText();
        String sendKey = driver.findElement(By.xpath("//*[@id=\"contentColumn\"]/../..//td[2]/div/pre")).getText();


        Assert.assertTrue(realPoster.contains(termFillPoster), "Poster does not match");
        Assert.assertTrue(sendKey.equals(termFillContent), "Content does not match");

    }

    @AfterMethod(alwaysRun = true)
    public void browseTearDown() {
        driver.quit();
    }


}
