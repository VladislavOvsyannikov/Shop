package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Cart;
import system.model.Driver;
import system.model.Type;
import system.model.User;

import java.util.List;

@Repository
public class TypeDao extends GenericDao<Type> {

    public List<Type> getAllTypes(){
        return getAll("Type");
    }

    public Type getType(String name){
        return getElement("from Type where name=:n", name);
    }

    public void saveType(Type type){
        save(type);
    }

    public List<Type> getTypes(String name){
        return getList("from Type where name=:n", name);
    }

    public void deleteType(Type type){
        delete(type);
    }
}
