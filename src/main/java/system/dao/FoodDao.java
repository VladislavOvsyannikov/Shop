package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Cart;
import system.model.Driver;
import system.model.Food;
import system.model.User;

import java.util.List;

@Repository
public class FoodDao extends GenericDao<Food> {

    public List<Food> getAllFood() {
        return getAll("Food");
    }

    public Food getFood(String name) {
        return getElement("from Food where name=:n", name);
    }

    public void saveFood(Food food) {
        save(food);
    }

    public List<Food> getAllFood(String name) {
        return getList("from Food where name=:n", name);
    }

    public void deleteFood(Food food) {delete(food);}
}
