package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClassDataContact;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        //app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ClassDataContact("Daniel1", "Jacob1", "Radcliffe1", "Harry", "WB", "London", "111-11-11", "222-22-22", "333-33-33", "daniel@wb.uk", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        app.getContactHelper().ClickToLogout();



    }
}
