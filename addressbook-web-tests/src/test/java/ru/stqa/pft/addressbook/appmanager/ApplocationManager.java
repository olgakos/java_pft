package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
//строкой выше: это вернй BrowserType: import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class ApplocationManager {
    WebDriver wd;

    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private SessionHepler sessionHepler;
    private NavigationHelper navigationHelper;
    private String browser;

    public ApplocationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        //String browser = BrowserType.FIREFOX;
        if  (browser.equals(FIREFOX)) {
             wd = new FirefoxDriver();
        }    else if (browser.equals(BrowserType.CHROME)) {
             wd = new ChromeDriver();
        }    else if (browser.equals(BrowserType.IE)) {
             wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // где должна быть эта строка ниже? Тут (да тут) или в SessionHelper (без /group.php)??
        //wd.get("http://localhost/addressbook/group.php");
        wd.get("http://localhost/addressbook");
        contactHelper = new ContactHelper(wd);
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHepler = new SessionHepler(wd);
        sessionHepler.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }




    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
