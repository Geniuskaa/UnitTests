import java.util.ArrayList;


public class Store {
    protected ProductsSaver saver;
    protected ArrayList<Product> storage;

    public Store(ProductsSaver saver){
        this.saver = saver;
        storage = saver.getProducts();
    }

    public void addNewProduct(String name, int count) {
        Product product = new Product(name, count);

        if(storage != null) {
            for (Product p : storage) {
                if (p.nameOfProduct.equals(product.nameOfProduct)) {
                    System.out.println("Такой товар уже есть на складе, поэтому мы увеличили его кол-во.");
                    p.countOfProducts += product.countOfProducts;
                    saver.saveProducts(storage);
                    return;
                }
            }
        }

        storage.add(product);
        saver.saveProducts(storage);
    }

    void printAllProducts(){
        for (Product p : storage) {
            System.out.println("- " + p.nameOfProduct + ": " + p.countOfProducts);
        }
    }

    public Product getProduct(String name){
        String temp = name.toLowerCase();
        for (Product p : storage) {
            if (p.nameOfProduct.equals(temp))
                return p;
        }

        return null;
    }

    public void deleteProduct(String name){
        Product p = getProduct(name);

        if (p != null) {
            storage.remove(p);
        }

        saver.saveProducts(storage);
    }

    void changeCountOfProducts(String name, int count) { // Метод не заменит значение, а увеличит
        String answer = name.toLowerCase();
        for(int i = 0; i < storage.size(); i++) {
            if (storage.get(i).nameOfProduct.equals(answer)) {
                storage.get(i).countOfProducts += count;

                saver.saveProducts(storage);
                return;
            }
        }
        System.out.println("Такого товара нет на складе!");
    }

    int sizeOfStore(){
        return storage.size();
    }


}
