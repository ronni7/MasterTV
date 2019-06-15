package hello.entities.dataObjects;

import hello.utilities.enums.GENDER;
import hello.utilities.enums.ROLE;

public class UserLoggedDTO {
    private String name;
    private String email;
    private GENDER sex;
    private ROLE role;

    @Override
    public String toString() {
        return "UserLoggedDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", role=" + role +
                '}';
    }

    public UserLoggedDTO(String name, String email, GENDER sex, ROLE role) {
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }
}
