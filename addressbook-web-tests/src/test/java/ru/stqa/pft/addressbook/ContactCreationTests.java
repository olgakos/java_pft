package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() throws Exception {
        GoToContactPage();
        fillContactForm(new ClassDataContact("Daniel", "Jacob", "Radcliffe", "Harry", "WB", "London", "111-11-11", "222-22-22", "333-33-33", "daniel@wb.uk"));
        submitContactCreation();
        returnToHomePage();
        ClickToLogout();
    }


}
