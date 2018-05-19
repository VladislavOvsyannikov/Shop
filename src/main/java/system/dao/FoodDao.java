package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Food;

import java.util.List;

@Repository
public class FoodDao extends GenericDao<Food> {

    public List<Food> getAllFoods() {
        return getAll("Food");
    }

    public Food getFood(int id) {
        return getElement("from Food where id=:n", id);
    }

    public void saveFood(Food food) {
        save(food);
    }

    public List<Food> getAllFood(String name) {
        return getList("from Food where name=:n", name);
    }

    public void deleteFood(Food food) {delete(food);}
}
