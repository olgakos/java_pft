package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        login("admin", "secret");
    }

    private void login(String username, String password) {
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    protected void returnToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
        wd.findElement(By.linkText("Logout")).click();
    }

    protected void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(ClassData classData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(classData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(classData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(classData.getFooter());
    }

    protected void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    protected void goToGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }



    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
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

    protected void ClickToLogout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    protected void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    protected void submitContactCreation() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    protected void fillContactForm(ClassDataContact classDataContact) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(classDataContact.getFirstName());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(classDataContact.getMiddleName());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(classDataContact.getLastName());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(classDataContact.getNickname());
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(classDataContact.getCompany());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(classDataContact.getAddress());
        wd.findElement(By.name("theform")).click();
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(classDataContact.getTelHome());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(classDataContact.getTelMobile());
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(classDataContact.getTelWork());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(classDataContact.getEmail1());
    }

    protected void GoToContactPage() {
        wd.findElement(By.linkText("add new")).click();
    }

 //   @BeforeMethod(alwaysRun = true)
 //   public void setUp() throws Exception {
//      wd = new FirefoxDriver();
//      wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }

    protected void deleteSelectedGroups() {
      wd.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
    }

    protected void selectGroup() {
      wd.findElement(By.name("selected[]")).click();
    }

    protected void closeAlertfromDelete() {
      wd.switchTo().alert().accept();
    }

    protected void deleteSelectedContact() {
      wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    protected void selectContact() {
      wd.findElement(By.name("selected[]")).click();
    }
}
