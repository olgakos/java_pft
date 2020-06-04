package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    //строка ниже это искусственно вставленная команда закрытия всплывающего окна при удалении контакта
    app.getContactHelper().closeAlertfromDelete();
  }


}
