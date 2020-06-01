package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHepler extends HelperBase {
    //private FirefoxDriver wd; (2.8 потому что она наследуется из базового класса )

    public SessionHepler(FirefoxDriver wd) {
        super(wd);

       // this.wd = wd; (2.8)
    }

    public void login(String username, String password) {
        wd.get("http://localhost/addressbook/");
        type(By.name("user"), username);
        type(By.name("pass"), password);
        click(By.xpath("//input[@value='Login']"));
    }


}
