package com.cdk.vets.dao;

import com.cdk.vets.model.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CarDAO {

    @PersistenceContext
    EntityManager entityManager;


    public int update(Car car){
        entityManager.merge(car);
       return car.getVin();
    }

    public int save(Car car){
        entityManager.persist(car);
        return car.getVin();
    }


    public Car selectByVin(Integer vin){
       return entityManager.find(Car.class,vin);
    }


    public List<Car> selectAll(){
        return entityManager.createQuery("from Car").getResultList();

    }


    public void delete(int vin) {
        Car car = entityManager.find(Car.class,vin);
        entityManager.remove(car);
    }
}
