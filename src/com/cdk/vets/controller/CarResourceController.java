package com.cdk.vets.controller;

import com.cdk.vets.model.Car;
import com.cdk.vets.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.MediaType.*;

@RestController
public class CarResourceController {

    @Autowired
    CarService carService;

    @RequestMapping(value = "/cars",produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Collection<Car> readAllCarsAsJson(){
        return carService.readAll();
    }

    @RequestMapping(value = "/cars",produces = MediaType.APPLICATION_XML_VALUE ,method = RequestMethod.GET)
    public Collection<Car> readAllCarsAsXML(){
        return carService.readAll();
    }



    @RequestMapping(value = "/delete/{vin}",produces = TEXT_PLAIN_VALUE ,method = RequestMethod.DELETE)
    public String deleteCar(@PathVariable int vin){
        carService.remove(vin);
        return "Car with vin '"+vin+"'resource deleted successfully!";
    }

    @RequestMapping(value = "/update/{vin}",consumes = APPLICATION_JSON_VALUE ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.PUT)
    public String updateCar(@RequestBody Car car,@PathVariable int vin){
        car.setVin(vin);
        int value = carService.modify(car);
        return "Car with vin '"+value+" ' resource updated successfully!";
    }


    @RequestMapping(value = "/add",consumes = APPLICATION_JSON_VALUE ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.POST)
    public String addCar(@RequestBody Car car){
        System.out.println(car);
        int value = carService.add(car);
        return "Car with vin '"+value+" ' resource added successfully!";
    }

    @RequestMapping(value = "/car/{vin}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Car readCarByVinAsJson(@PathVariable Integer vin){
        System.out.println("VIN is : "+vin);
        Car car = carService.readByVin(vin);
        return car;
    }


    @RequestMapping(value = "/car",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Car readCarAsJson(){
        Car car = carService.readByVin(1);
        return car;
    }


    /*@RequestMapping(value = "/car",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public String readCarAsJson(){
        return "{\"vin\":100,\"model\":\"Q7\", \"make\":\"Audi\", \"price\":78000000.00, \"qty\":10}";
    }*/


    @RequestMapping(value = "/car",produces = APPLICATION_XML_VALUE ,method = RequestMethod.GET)
    public Car readCarAsXML(){
        Car car = carService.readByVin(1);
        return car;
    }

    /*@RequestMapping(value = "/car",produces = APPLICATION_XML_VALUE ,method = RequestMethod.GET)
    public String readCarAsXML(){
        return "<car><vin>100</vin><model>Q7</model><make>Audi</make><price>78000000.00</price><qty>10</qty></car>";
    }*/

    //@RequestMapping(value = "/car",produces = "text/plain", method = RequestMethod.GET)
    @RequestMapping(value = "/car",produces = TEXT_PLAIN_VALUE ,method = RequestMethod.GET)
    public String readCar(){
        return "vin-100, model-Q7, make-Audi, price-78000000.00, qty-10";
    }

}
