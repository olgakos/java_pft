package ru.stqa.pft.addressbook.model;

public class ClassDataContact {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nickname;
    private final String company;
    private final String address;
    private final String telHome;
    private final String telMobile;
    private final String telWork;
    private final String email1;
    private String group;

    //ниже это конструктор который позволяет проинициализировать объект какими-то значениями
    //список методов возаращает список атрибутов. Атрибуту здесь это FirstName...
    public ClassDataContact(String FirstName, String MiddleName, String LastName, String Nickname, String Company, String Address, String TelHome, String TelMobile, String TelWork, String Email1, String group) {
        firstName = FirstName;
        middleName = MiddleName;
        lastName = LastName;
        nickname = Nickname;
        company = Company;
        address = Address;
        telHome = TelHome;
        telMobile = TelMobile;
        telWork = TelWork;
        email1 = Email1;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getTelHome() {
        return telHome;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public String getTelWork() {
        return telWork;
    }

    public String getEmail1() {
        return email1;
    }

    public String getGroup() {
        return group;
    }

    //на опереденеи из модуля 4.7 строки ниже
    @Override
    public String toString() {
        return "ClassDataContact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassDataContact that = (ClassDataContact) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
