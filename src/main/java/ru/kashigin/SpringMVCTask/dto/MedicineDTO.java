package ru.kashigin.SpringMVCTask.dto;

public class MedicineDTO {
    private Long id;
    private String name;
    private double price;
    private int stock;

    //конструктор по умолчанию
    public MedicineDTO(){}
    //конструктор с параметрами
    public MedicineDTO(Long id, String name, double price, int stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
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
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public int getStock(){
        return stock;
    }
}
