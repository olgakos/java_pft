package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {


    @Test
   // @Test (enabled = false)
    public void testContactCreation() throws Exception {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().gotoHomePage();
        app.getContactHelper().createContact(new ContactData("Daniel", "Jacob", "Radcliffe", "Harry", "WB", "London", "111-11-11", "222-22-22", "333-33-33", "daniel@wb.uk", "test1"), true);
        //int after = app.getContactHelper().getContactCount();
        //Assert.assertEquals(after, before + 1);
        //app.GoToContactPage();
        //ниже пробная строка
        //app.getContactHelper().initContactCreation();
        //app.getContactHelper().fillContactForm(new ClassDataContact("Daniel", "Jacob", "Radcliffe", "Harry", "WB", "London", "111-11-11", "222-22-22", "333-33-33", "daniel@wb.uk", "test1"), true);
        //app.getContactHelper().submitContactCreation();
        //app.getContactHelper().returnToHomePage();
        //!!!с строка ниже закоментена, т.к. из-за нее падалли тесты в 3.10
        //app.getContactHelper().ClickToLogout();
//4-11
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() + 1);
    }


}
