package ru.kashigin.SpringMVCTask.dto;

public class CustomerDTO {
    private Long id;
    private String name;
    private String email;

    //конструктор по умолчанию
    public CustomerDTO(){}
    //конструктор с параметрами
    public CustomerDTO(Long id, String name, String email){
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
