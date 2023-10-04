package org.fin.practice.modal;

import javax.persistence.*;

@Entity
@Table(name="studentDetails")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name="standard")
    private String standard;
    @Column(name = "roll")
    private String roll;
    @Column(name="contact")
    private String contactNumber;
    @Column(name="email")
    private String email;
    @Column(name = "state")
    private String state;

    public Student(String name, String standard, String roll, String contactNumber, String email, String state) {
        this.name = name;
        this.standard = standard;
        this.roll = roll;
        this.contactNumber = contactNumber;
        this.email = email;
        this.state=state;
    }


    public Student() {
        super();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
