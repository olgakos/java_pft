package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelperBase {
    //строка выше про HelperBase -- базовый класс дял всех помощников...
    //строка ниже вставлена вручную в АМ убрать ее отсюда? не трогать? (2.7)
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text !=null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }

    }


   // public boolean isElementPresent(By by) {
   //     try {
   //         wd.findElement(by);
   //         return true;
   //     } catch (NoSuchElementException e) {
    //        return false;
    //    }
   // }

    //метод ниже: он позволяет проверить наличие диалоговоро окна. В Силениуме нет, только таким путем
    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public boolean isElementPresent(By locator){
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }

    }
}
