package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplocationManager;

public class TestBase {

    protected final ApplocationManager app = new ApplocationManager();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    //   @BeforeMethod(alwaysRun = true)
 //   public void setUp() throws Exception {
//      wd = new FirefoxDriver();
//      wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }

}
