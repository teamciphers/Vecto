package com.example.vecto;

public class UserHelperClass {
    String Name1,email1, pass1 ,Uid,Enrollment , Phone;

    public UserHelperClass() {
    }

    public UserHelperClass(String name1,String email1,String pass1 , String uid ,String enrollment , String phone) {
        this.Name1 = name1;
        this.email1 = email1;
        this.pass1 = pass1;
        this.Enrollment = enrollment;
        this.Phone = phone;
        this.Uid = uid;

    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }


    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        this.Uid = uid;
    }

    public String getEnrollment() {
        return Enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.Enrollment = enrollment;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) { this.Phone = phone;}

}
