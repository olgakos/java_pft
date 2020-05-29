package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.TestBase;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {
    selectContact();
    deleteSelectedContact();
    //строка ниже это искусственно вставленная команда закрытия всплывающего окна при удалении контакта
    closeAlertfromDelete();
  }


}
