import java.util.HashMap;

public class Inventory {

    HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {

        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(int id,
                              int quantity,
                              double price) {

        Product p = inventory.get(id);

        if(p != null){

            p.setQuantity(quantity);
            p.setPrice(price);
        }
    }

    public void deleteProduct(int id){

        inventory.remove(id);
    }

    public void display(){

        System.out.println(inventory.values());
    }
}
