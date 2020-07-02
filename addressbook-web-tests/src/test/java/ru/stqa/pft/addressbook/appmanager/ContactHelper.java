package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

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

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        //wd.findElement(By.name("firstname")).click();
        //wd.findElement(By.name("firstname")).clear();
        //wd.findElement(By.name("firstname")).sendKeys(classDataContact.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("company"), contactData.getCompany());
        type(By.name("home"), contactData.getTelHome());
        type(By.name("mobile"), contactData.getTelMobile());
        type(By.name("work"), contactData.getTelWork());
        type(By.name("email"), contactData.getEmail1());

        //блок ниже: Проверяет наличе или отсутствие выпадающего списка в ContactCreation (true) vs CoctactModif.. (false)
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
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

    public void createContact(ContactData contact, boolean creation) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    private void fillContactForm(ContactData contact) {
    }

    // ниже: соданный  в 3.10 Метод для проверки НАЛИЧИЯ к-либо элеемнта, у нас чекбокса (на стр.КОНТАКТЫ)
    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        int size = wd.findElements(By.name("selected[]")).size();

        return size;
    }

}
