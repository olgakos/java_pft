package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {
    //1 строка ниже это из 4.3, int BEFORE
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Daniel", "Jacob", "Radcliffe", "Harry", "WB", "London", "111-11-11", "222-22-22", "333-33-33", "daniel@wb.uk", "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    //строка ниже это искусственно вставленная команда закрытия всплывающего окна при удалении контакта
    app.getContactHelper().closeAlertfromDelete();
//2строкb ниже это из 4.3, int AFTER
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before - 1);
  }


}
