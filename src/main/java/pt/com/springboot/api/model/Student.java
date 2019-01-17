package pt.com.springboot.api.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;


@Entity
public class Student extends AbstractEntity {
    @NotEmpty(message = "Not Empty")
    private String name;
    @NotEmpty
    @Email(message = "Not an Email")
    private String email;

    public Student() {
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
