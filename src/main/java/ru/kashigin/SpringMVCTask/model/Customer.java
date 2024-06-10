package ru.kashigin.SpringMVCTask.model;

public class Customer {
    private Long id;
    private String name;
    private String email;

    //конструктор по умолчанию
    public Customer(){}
    //конструктор с параметрами
    public Customer(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
    //сеттеры и геттеры
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
}
