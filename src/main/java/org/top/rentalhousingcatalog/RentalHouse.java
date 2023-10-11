package org.top.rentalhousingcatalog;

import jakarta.persistence.*;

// Класс RentalHouse - описывает объект единицы арендного жилья
// соответсвует таблице rental_house из БД
// хранить информацию об объекте "Арендное жильё", не реализует бизнес-логику
// является dataclass-ом
@Entity
@Table(name = "rental_house")

public class RentalHouse {
    // поля - соответствуют столбцам (атрибутам) таблице в БД
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                             //ID

    @Column(name = "address_f", nullable = false)   //Адрес (улица, дом, квартира)
    private String address;

    @Column(name="city_f", nullable = false)        //Город
    private String city;

    @Column(name = "district_f", nullable = false)  //Район
    private String district;

    @Column(name = "total_area", nullable = false)  //Общая площадь
    private Integer totalArea;

    @Column(name = "num_rooms", nullable = false)   //Количество комнат
    private Integer numOfRooms;

    @Column(name = "price_day", nullable = false)   //Стоимость аренды за сутки
    private Double pricePerDay;

    @Column(name = "price_month", nullable = false) //Стоимость аренды за месяц
    private Double pricePerMonth;

    @Column (name = "description_f")                //Описание
    private String description;

    //Конструкторы
    //1. Конструктор по умолчанию
    public RentalHouse() {
        id = 0;
        address = "";
        city = "";
        district = "";
        totalArea = 0;
        numOfRooms = 0;
        pricePerDay = 0.0;
        pricePerMonth = 0.0;
        description = null;
    }

    // getters & setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Integer totalArea) {
        this.totalArea = totalArea;
    }

    public Integer getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(Integer numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Double getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(Double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return id + " - " + address + " - " + city + " - " + district + " - " + totalArea + " - " +
                numOfRooms + " - " + pricePerDay + " - " + pricePerMonth + " - " + description;
    }
}
