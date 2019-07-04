package hello.entities;

import hello.utilities.enums.GENDER;
import hello.utilities.enums.ROLE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Arrays;

@Entity
public class User implements Serializable {
    public User() {
    }

    public User(int id) {
        this.userID=id;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GENDER getSex() {
        return sex;
    }

    public void setSex(GENDER sex) {
        this.sex = sex;
    }

    public User(String name, String surname, String login, String nickname, char[] password, String email, GENDER sex, ROLE role) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.role = role;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userID;
    private String name;
    private String surname;
    private String login;
    private String nickname;
    private char[] password;
    private String email;
    private GENDER sex;

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    private ROLE role;

    public char[] getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password=" + Arrays.toString(password) +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", role=" + role +
                '}';
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}

