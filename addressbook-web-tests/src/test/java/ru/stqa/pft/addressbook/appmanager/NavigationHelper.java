package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{
    //private FirefoxDriver wd;

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }

    // public void goToGroupPage() {
    ////wd.findElement(By.linkText("groups")).click();
    ////стало
    // click(By.linkText("groups"));
    //}

//    public void goToContactPage() {
//        if (isElementPresent(By.id("maintable"))) {
//            return;
//        }
//        click(By.linkText("home"));
//
//    }

    public void goToContactPage() {
        wd.findElement(By.linkText("add new")).click();
    }
    
}
