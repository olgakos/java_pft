package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws Exception {
        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new ClassData("test1", "test2", "test3"));
        submitGroupCreation();
        returnToGroupPage();
    }


}
