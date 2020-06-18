package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    //Тест до 4.6
//    @Test (enabled = false)
 //   public void testGroupModification() {
//        app.getNavigationHelper().goToGroupPage();
//        //три строки ниже: добавленая в 3.10 ПРОВЕРКА наличия хотя тут хотя бы 1 группы для выполнения модификаций)
//        if (! app.getGroupHelper().isThereAGroup()) {
//            app.getGroupHelper().createGroup(new GroupData("test1", "null", "null"));
 //       }
//        int before = app.getGroupHelper().getGroupCount();
//        app.getGroupHelper().selectGroup(before - 1);
//        app.getGroupHelper().initGroupModification();
//        app.getGroupHelper().fillGroupForm(new GroupData("Test1", "Test2", "Test3"));
//        app.getGroupHelper().submitGroupModification();
 //       app.getGroupHelper().returnToGroupPage();
//        int after = app.getGroupHelper().getGroupCount();
//        Assert.assertEquals(after, before);
//    }

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "null", "null"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData("Test1", "Test2", "Test3");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }
}
