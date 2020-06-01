package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }


    // далее отдельно выносим во вспомогальеный гласс ГоТу ГруппПейдж
    //public void goToGroupPage() {

    //}

    //public void GoToContactPage() {

   // }

    public void goToContactPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void goToGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }
}
