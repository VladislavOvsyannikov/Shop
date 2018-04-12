package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Cart;
import system.model.User;

import java.util.List;

@Repository
public class CartDao extends GenericDao<Cart> {

    public List<Cart> getAllCarts() {
        return getAll("Cart");
    }

    public Cart getCart(String name) {
        return getElement("from Cart where name=:n", name);
    }

    public void saveCart(Cart cart) {
        save(cart);
    }

    public void updateCart(Cart cart) {
        update(cart);
    }

    public List<Cart> getCarts(String name) {
        return getList("from Cart where name=:n", name);
    }

    public void deleteCart(Cart cart) {
        delete(cart);
    }
}
