package ru.kashigin.SpringMVCTask.dto;

public class PharmacyDTO {
    //объявление полей
    private Long id;
    private String name;
    private String address;

    //конструктор по умолчанию
    public PharmacyDTO(){}
    //конструктор с параметрами
    public PharmacyDTO(Long id, String name, String address){
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
