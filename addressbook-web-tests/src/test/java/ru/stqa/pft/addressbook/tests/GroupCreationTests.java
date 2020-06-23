package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        Groups after = app.group().all();
        //assertEquals(after.size(), before.size() + 1); в 5.6 эта сточка стала как ниже:
        assertThat(after.size(), equalTo(before.size() + 1));

        //group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()); убрано в 5/6
        //before.add(group); ублали в 5.6
        //assertEquals(before, after);
        //5.06 ниже это проверялка из внешней бтблиотеки, кторая сравн. 2 объекта
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }


}
