package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClassDataContact;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        //app.GoToContactPage();
        //ниже пробная строка
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ClassDataContact("Daniel", "Jacob", "Radcliffe", "Harry", "WB", "London", "111-11-11", "222-22-22", "333-33-33", "daniel@wb.uk", "test1"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
        //!!!с строка ниже закоментена, т.к. из-за нее падалли тесты в 3.10
        //app.getContactHelper().ClickToLogout();
    }


}
