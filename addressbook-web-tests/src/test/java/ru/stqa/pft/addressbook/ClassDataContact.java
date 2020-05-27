package ru.stqa.pft.addressbook;

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

    //ниже это конструктор который позволяет проинициализировать объект какими-то значениями
    //и список методов возаращает список атрибутов
    public ClassDataContact(String FirstName, String MiddleName, String LastName, String Nickname, String Company, String Address, String TelHome, String TelMobile, String TelWork, String Email1) {
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
}
