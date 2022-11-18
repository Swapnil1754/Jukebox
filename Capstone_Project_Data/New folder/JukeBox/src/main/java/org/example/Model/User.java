package org.example.Model;

public class User {
    private String uname;
    private int Uid;
    private long mob;
    private String email;
    private int age;
    private String city;

    public User(String uname, int uid, long mob, String email, int age, String city) {
        this.uname = uname;
        Uid = uid;
        this.mob = mob;
        this.email = email;
        this.age = age;
        this.city = city;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public long getMob() {
        return mob;
    }

    public void setMob(long mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", Uid=" + Uid +
                ", mob=" + mob +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
