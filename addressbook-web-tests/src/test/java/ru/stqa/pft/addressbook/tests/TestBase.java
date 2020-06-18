package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplocationManager;
//import sun.plugin2.util.BrowserType;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {

    // ниже в 5.1 добавлен сюда staic чтобы заускалосьв се в одном браузере
    protected static final ApplocationManager app = new ApplocationManager(BrowserType.CHROME);

    //@BeforeMethod(alwaysRun = true) убран в 5.1
    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }


   // @AfterMethod(alwaysRun = true) убран в 5.1
    @AfterSuite
    public void tearDown() throws Exception {
        app.stop();
    }


}
