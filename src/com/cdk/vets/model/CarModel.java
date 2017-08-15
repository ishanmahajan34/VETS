package com.cdk.vets.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "car_models")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vin;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String trim;

    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date dateOfPurchase;

    @Column(nullable = false)
    private double price;

    //    private Image carImage;

    @Enumerated(value = EnumType.ORDINAL)
    private Fuel fuelType;

    @Enumerated(value = EnumType.ORDINAL)
    private Transmission transmissionType;
    
    private int km;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "vin")
    private Customer customer;

    public CarModel() {
    }

    public CarModel(int vin, String brand, String model, String trim, Date dateOfPurchase, double price, Fuel fuelType, Transmission transmissionType, int km, Customer customer) {
        this.vin = vin;
        this.brand = brand;
        this.model = model;
        this.trim = trim;
        this.dateOfPurchase = dateOfPurchase;
        this.price = price;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.km = km;
        this.customer = customer;
    }


    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Fuel getFuelType() {
        return fuelType;
    }

    public void setFuelType(Fuel fuelType) {
        this.fuelType = fuelType;
    }

    public Transmission getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(Transmission transmissionType) {
        this.transmissionType = transmissionType;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "vin=" + vin +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", trim='" + trim + '\'' +
                ", dateOfPurchase=" + dateOfPurchase +
                ", price=" + price +
                ", fuelType=" + fuelType +
                ", transmissionType=" + transmissionType +
                ", km=" + km +
                ", customer=" + customer +
                '}';
    }
}
