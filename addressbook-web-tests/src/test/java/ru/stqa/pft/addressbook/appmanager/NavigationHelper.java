package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{
    //private FirefoxDriver wd;

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }


    public void goToContactPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void goToGroupPage() {
        //wd.findElement(By.linkText("groups")).click();
        //стало
        click(By.linkText("groups"));
    }
}
