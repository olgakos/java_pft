package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ClassData;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new ClassData("test1", "test2", "test3"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }


}
