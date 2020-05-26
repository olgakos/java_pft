package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GroupCreationTests {
  private WebDriver wd;
  //строкой выше: было: "driver" (rafactor--rename to "wd")
  //private String baseUrl;
 // private boolean acceptNextAlert = true;
 // private StringBuffer verificationErrors = new StringBuffer();
  // удали эти строки, т.к. это следы от SeleniumIDE-2 [u2.2]

  @BeforeMethod(alwaysRun = true)
  // БЫЛО РАНЕЕ @BeforeClass  [u2.2]
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
//    baseUrl = "https://www.google.com/";
    // удали эти строки, т.к. это следы от SeleniumIDE-2 [u2.2]
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //строки ниже: это переложенне сюда шаги залогина, танее в @Test
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testGroupCreation() throws Exception {
    //БЫЛО testGroupCreationTests -- стало  testGroupCreation [u2.2]
    wd.findElement(By.linkText("groups")).click();
    wd.findElement(By.name("new")).click();
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys("test1");
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys("test2");
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys("test3");
    wd.findElement(By.name("submit")).click();
    wd.findElement(By.linkText("group page")).click();
    wd.findElement(By.linkText("Logout")).click();
  }

  @AfterMethod(alwaysRun = true)
  // БЫЛО РАНЕЕ @AfterClass  [u2.2]
  public void tearDown() throws Exception {
    wd.quit();
    // String verificationErrorString = verificationErrors.toString();
  //  if (!"".equals(verificationErrorString)) {
  //    fail(verificationErrorString);
  //  }
    // удали эти строки, т.к. это следы от SeleniumIDE-2 [u2.2]
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

 // private String closeAlertAndGetItsText() {
  //  try {
  //    Alert alert = driver.switchTo().alert();
  //    String alertText = alert.getText();
 //     if (acceptNextAlert) {
 //       alert.accept();
 //     } else {
 //       alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
  // удали эти строки, т.к. это следы от SeleniumIDE-2 [u2.2]
}
