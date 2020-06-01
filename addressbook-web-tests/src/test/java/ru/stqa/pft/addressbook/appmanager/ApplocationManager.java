package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class ApplocationManager {
    FirefoxDriver wd;

    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private SessionHepler sessionHepler;
    private NavigationHelper navigationHelper;
    //строка выше сильно порезана вручную в 2.8!

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
 // строчка ниже была вручную перенесена сюда из блока private void login (2.6)
        //wd.get("http://localhost/addressbook/");
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
