package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

    public void fillContactForm(ClassDataContact classDataContact, boolean creation) {
        type(By.name("firstname"),classDataContact.getFirstName());
        //wd.findElement(By.name("firstname")).click();
        //wd.findElement(By.name("firstname")).clear();
        //wd.findElement(By.name("firstname")).sendKeys(classDataContact.getFirstName());
        type(By.name("middlename"),classDataContact.getMiddleName());
        type(By.name("lastname"),classDataContact.getLastName());
        type(By.name("nickname"),classDataContact.getNickname());
        type(By.name("company"),classDataContact.getCompany());
        type(By.name("company"),classDataContact.getCompany());
        type(By.name("home"),classDataContact.getTelHome());
        type(By.name("mobile"),classDataContact.getTelMobile());
        type(By.name("work"),classDataContact.getTelWork());
        type(By.name("email"),classDataContact.getEmail1());

        //блок ниже: Проверяет наличе или отсутствие выпадающего списка в ContactCreation (true) vs CoctactModif.. (false)
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(classDataContact.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

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
        //click(By.name("update"));  (локатор СЛОМАЛСЯ)
        //click(By.xpath("xpath=//input[@name='update'])[2]")); (локатор СЛОМАЛСЯ)
        click(By.cssSelector("[value=Update]"));

    }
//ниже: это клик на кнопку создания нового контакта "add new" на стр. Home (добавлено в ур.3.9):

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void createContact(ClassDataContact contact, boolean creation) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    private void fillContactForm(ClassDataContact contact) {
    }

    // ниже: соданный  в 3.10 Метод для проверки НАЛИЧИЯ к-либо элеемнта, у нас чекбокса (на стр.КОНТАКТЫ)
    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }
}
