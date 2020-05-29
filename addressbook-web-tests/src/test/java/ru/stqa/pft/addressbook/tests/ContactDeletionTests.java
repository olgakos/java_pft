package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {
    app.selectContact();
    app.deleteSelectedContact();
    //строка ниже это искусственно вставленная команда закрытия всплывающего окна при удалении контакта
    app.closeAlertfromDelete();
  }


}
