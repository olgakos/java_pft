package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    //@Test (enabled = false)
    public void testContactModification() {
        //1 строка ниже это из 4.3, int BEFORE
        int before = app.getContactHelper().getContactCount();
        app.goTo().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Daniel", "Jacob", "Radcliffe", "Harry", "WB", "London", "111-11-11", "222-22-22", "333-33-33", "daniel@wb.uk", "test1"), true);
        }
        //app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Daniel1", "Jacob1", "Radcliffe1", "Harry", "WB", "London", "111-11-11", "222-22-22", "333-33-33", "daniel@wb.uk", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        //2строки ниже это из 4.3, int AFTER
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
         //Важно!! строка ниже (логаут) убрана в ходе выпослнения задания №9. Не знаю, куда приткнуть.
        //app.getContactHelper().ClickToLogout();
    }
}
