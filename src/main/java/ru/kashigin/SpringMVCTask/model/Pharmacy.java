package ru.kashigin.SpringMVCTask.model;


import javax.persistence.*;

@Entity
@Table(name = "pharmacy")
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //объявление полей
    private Long id;
    private String name;
    private String address;

    //конструктор по умолчанию
    public Pharmacy(){}
    //конструктор с параметрами
    public Pharmacy(Long id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
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
    public void setAddress(String address){
        this.address= address;
    }
    public String getAddress(){
        return address;
    }
}
