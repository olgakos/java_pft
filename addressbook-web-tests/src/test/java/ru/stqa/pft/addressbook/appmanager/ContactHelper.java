package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ClassDataContact;

public class ContactHelper extends HelperBase {
    //protected GroupHelper groupHelper;
    //private FirefoxDriver wd; (2.8)

    public ContactHelper(WebDriver wd) {
        //this.wd = wd; (2.8)
        super(wd);
    }

    public void ClickToLogout() {
        //wd.findElement(By.linkText("Logout")).click();
        click(By.linkText("Logout"));
    }

    public void returnToHomePage() {
        //wd.findElement(By.linkText("home page")).click();
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        //wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ClassDataContact classDataContact) {
        type(By.name("firstname"),classDataContact.getFirstName());
        //wd.findElement(By.name("firstname")).click();
        //wd.findElement(By.name("firstname")).clear();
        //wd.findElement(By.name("firstname")).sendKeys(classDataContact.getFirstName());
        type(By.name("middlename"),classDataContact.getMiddleName());
        //wd.findElement(By.name("middlename")).click();
        //wd.findElement(By.name("middlename")).clear();
        //wd.findElement(By.name("middlename")).sendKeys(classDataContact.getMiddleName());
        type(By.name("lastname"),classDataContact.getLastName());
        //wd.findElement(By.name("lastname")).click();
        //wd.findElement(By.name("lastname")).clear();
       // wd.findElement(By.name("lastname")).sendKeys(classDataContact.getLastName());
        type(By.name("nickname"),classDataContact.getNickname());
        //wd.findElement(By.name("nickname")).click();
        //wd.findElement(By.name("nickname")).clear();
        //wd.findElement(By.name("nickname")).sendKeys(classDataContact.getNickname());
        type(By.name("company"),classDataContact.getCompany());
        //wd.findElement(By.name("company")).click();
        //wd.findElement(By.name("company")).clear();
        //wd.findElement(By.name("company")).sendKeys(classDataContact.getCompany());
        //wd.findElement(By.name("address")).click();
        type(By.name("company"),classDataContact.getCompany());
        //wd.findElement(By.name("address")).clear();
        //wd.findElement(By.name("address")).sendKeys(classDataContact.getAddress());
        //wd.findElement(By.name("theform")).click();
        type(By.name("home"),classDataContact.getTelHome());
        //wd.findElement(By.name("home")).click();
        //wd.findElement(By.name("home")).clear();
        //wd.findElement(By.name("home")).sendKeys(classDataContact.getTelHome());
        type(By.name("mobile"),classDataContact.getTelMobile());
        //wd.findElement(By.name("mobile")).click();
        //wd.findElement(By.name("mobile")).clear();
        //wd.findElement(By.name("mobile")).sendKeys(classDataContact.getTelMobile());
        type(By.name("work"),classDataContact.getTelWork());
        //wd.findElement(By.name("work")).click();
        //wd.findElement(By.name("work")).clear();
        //wd.findElement(By.name("work")).sendKeys(classDataContact.getTelWork());
        type(By.name("email"),classDataContact.getEmail1());
        //wd.findElement(By.name("email")).click();
        //wd.findElement(By.name("email")).clear();
        //wd.findElement(By.name("email")).sendKeys(classDataContact.getEmail1());
    }

    public void closeAlertfromDelete() {
      wd.switchTo().alert().accept();
    }

    public void deleteSelectedContact() {
      //wd.findElement(By.xpath("//input[@value='Delete']")).click()
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact() {
      //wd.findElement(By.name("selected[]")).click();
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        //click(By.name("update"));
        click(By.xpath("xpath=//input[@name='update'])[2]"));

    }
}
