package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Cart;
import system.model.Driver;
import system.model.User;

import java.util.List;

@Repository
public class DriverDao extends GenericDao<Driver> {

    public List<Driver> getAllDrivers(){
        return getAll("Driver");
    }

    public Driver getDriver(String name){
        return getElement("from Driver where name=:n", name);
    }

    public void saveDriver(Driver driver){
        save(driver);
    }

    public List<Driver> getDrivers(String name){
        return getList("from Driver where name=:n", name);
    }

    public void deleteDriver(Driver driver){
        delete(driver);
    }
}
