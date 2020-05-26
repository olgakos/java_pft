package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests {
    private WebDriver wd;
    //private String baseUrl;
    // private boolean acceptNextAlert = true;
    //private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        //baseUrl = "https://www.google.com/";
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //ниже  - это перенесенный сюда залогин
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testContactCreation() throws Exception {
        //раньше тут были строки про залогин.... теперь они выше
        wd.findElement(By.linkText("add new")).click();
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("Daniel");
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys("Jacob");
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys("Radcliffe");
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys("Harry");
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys("WB");
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys("London");
        wd.findElement(By.name("theform")).click();
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys("111-11-11");
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys("222-22-22");
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys("333-33-33");
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys("daniel@wb.uk");
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
        wd.findElement(By.linkText("home page")).click();
        wd.findElement(By.linkText("Logout")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
        //String verificationErrorString = verificationErrors.toString();
        //if (!"".equals(verificationErrorString)) {
        // fail(verificationErrorString);
        //}
    }

//}

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;

        }
    }

        private boolean isAlertPresent () {
            try {
                wd.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }

        //private String closeAlertAndGetItsText() {
        // try {
        //  Alert alert = driver.switchTo().alert();
        //  String alertText = alert.getText();
        //  if (acceptNextAlert) {
        //    alert.accept();
        //  } else {
        //    alert.dismiss();
        //  }
        //  return alertText;
        // } finally {
        //   acceptNextAlert = true;
        //}
        //}
    }
