package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Driver;

import java.util.List;

@Repository
public class DriverDao extends GenericDao<Driver> {

    public List<Driver> getAllDrivers(){
        return getAll("Driver");
    }

    public Driver getDriver(int id){
        return getElement("from Driver where id=:n", id);
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
