package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ClassDataContact;

public class ContactDeletionTests extends TestBase {


  @Test (enabled = false)
  public void testContactDeletion() throws Exception {
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ClassDataContact("Daniel", "Jacob", "Radcliffe", "Harry", "WB", "London", "111-11-11", "222-22-22", "333-33-33", "daniel@wb.uk", "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    //строка ниже это искусственно вставленная команда закрытия всплывающего окна при удалении контакта
    app.getContactHelper().closeAlertfromDelete();
  }


}
