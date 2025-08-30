package com.springlearning.AK_Final_SpringLearningProject.model;

public class UserModel {

    Integer  id;
    String name;
    String email;
    String city;

    public UserModel(Integer id, String name, String email, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
      //below can be commented. only for understanding. if @RequestBody is used in Any JSON controller then this constructor will be auto called as RequestBody in JSON is implicitly called and converted into POJO
        System.out.println("Inputs received in UserModel POJO - UserModel Created :"+id+"-"+name+"-"+getEmail()+"-"+getCity());  //name or getName() both works. this is logs to check what value is passed to constructor.
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "UserModel [id=" + id + ", name=" + name + ", email=" + email +  ",city="+ city+"]";
    }

}
