package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClassDataContact;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() throws Exception {
        app.getNavigationHelper().goToContactPage();
        //app.GoToContactPage();
        app.getContactHelper().fillContactForm(new ClassDataContact("Daniel", "Jacob", "Radcliffe", "Harry", "WB", "London", "111-11-11", "222-22-22", "333-33-33", "daniel@wb.uk"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
        app.getContactHelper().ClickToLogout();
    }


}
