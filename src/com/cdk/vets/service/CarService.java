package com.cdk.vets.service;

import com.cdk.vets.model.Car;
import com.cdk.vets.dao.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarDAO carDAO;

    @Transactional
    public int add(Car car){
        //20 loc
        return carDAO.save(car);
    }

    @Transactional
    public int modify(Car car){
        return carDAO.update(car);
    }


    @Transactional
    public Car readByVin(Integer vin){
        return carDAO.selectByVin(vin);
    }

    @Transactional
    public List<Car> readAll(){
        return carDAO.selectAll();

    }

    @Transactional
    public void remove(int vin) {
        carDAO.delete(vin);
    }

}
