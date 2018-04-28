package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Cart;

import java.util.List;

@Repository
public class CartDao extends GenericDao<Cart> {

    public List<Cart> getAllCarts() {
        return getAll("Cart");
    }

    public Cart getCart(int id) {
        return getElement("from Cart where id=:n", id);
    }

    public void saveCart(Cart cart) {
        save(cart);
    }

    public void updateCart(Cart cart) {
        update(cart);
    }

    public List<Cart> getCarts(String name) {
        return getList("from Cart where status=:n", name);
    }

    public void deleteCart(Cart cart) {
        delete(cart);
    }
}
