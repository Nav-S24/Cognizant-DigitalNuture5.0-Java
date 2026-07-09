public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        inventory.addProduct(new Product(101,"Laptop",5,60000));
        inventory.addProduct(new Product(102,"Mouse",20,500));

        inventory.display();

        inventory.updateProduct(101,10,58000);

        inventory.display();

        inventory.deleteProduct(102);

        inventory.display();
    }
}