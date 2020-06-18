package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.nio.file.FileStore;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }
    //protected WebDriver wd;

    public void returnToGroupPage() {
        click(By.linkText("group page"));
        //!!! закаменть строку ниже про логаут если падают тесты с группами
        //click(By.linkText("Logout"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData classData) {
        type(By.name("group_name"), classData.getName());
        type(By.name("group_header"), classData.getHeader());
        type(By.name("group_footer"), classData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.xpath("(//input[@name='delete'])[2]"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    //5.05 обрати унимение что findElement а не findElementS
    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    // ниже: созданный в 3.10 вспомогательынй метод "создание группы"
    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    //5.2 modifyGroup
    public void modify(int index, GroupData group) {
        selectGroup(index);
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupPage();
    }

    //5.03
    public void delete(int index) {
        selectGroup(index);
        deleteSelectedGroups();
        returnToGroupPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        returnToGroupPage();
    }

// ниже: соданный  в 3.10 Метод для проверки НАЛИЧИЯ к-либо элеемнта, у нас чекбокса (на стр.Групп)
    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
       return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            //String id = findElement(By.tagName("input")).getAttribute("value");
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }

        //5.05
        public Set<GroupData> all() {
            Set<GroupData> groups = new HashSet<GroupData>();
            List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
            for (WebElement element : elements){
                String name = element.getText();
                //String id = findElement(By.tagName("input")).getAttribute("value");
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                groups.add(new GroupData().withId(id).withName(name));
            }
            return groups;

    }


}
