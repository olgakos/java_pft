package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  //ниже это рабочий тест до измеенний в Un4.5
//  @Test (enabled = false)
//  public void testGroupDeletion() throws Exception {
//    app.getNavigationHelper().goToGroupPage();
//    if (! app.getGroupHelper().isThereAGroup()) {
//      app.getGroupHelper().createGroup(new GroupData("test1", "null", "null"));
//    }
//    int before = app.getGroupHelper().getGroupCount();
//    app.getGroupHelper().selectGroup(before - 1);
//    app.getGroupHelper().deleteSelectedGroups();
 //   app.getGroupHelper().returnToGroupPage();
//    int after = app.getGroupHelper().getGroupCount();
//    Assert.assertEquals(after, before - 1);
//  }

  //5.2
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    //это из модуля 4.6: спавнение списков groupdata
    before.remove(index);
    Assert.assertEquals(before, after);

  }


}
