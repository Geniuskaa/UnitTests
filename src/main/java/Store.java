import java.util.ArrayList;


public class Store {
    protected ProductsSaver saver;
    protected ArrayList<Product> storage;
    private ArrayList<ProductsListener> listeners;

    public Store(ProductsSaver saver){
        this.saver = saver;
        storage = saver.getProducts();
        listeners = new ArrayList<>();
        for (Product p : storage){
            addListener(p);
        }

        //updater();
    }

    private void addListener(ProductsListener pl){
        if(!listeners.contains(pl))
            listeners.add(pl);
    }

    private void removeListener(ProductsListener pl){
        if(listeners.contains(pl))
            listeners.remove(pl);
    }

    public void updater(){
        System.out.println("Сейчас на складе есть:");
        int totalSpaceOfProducts = 0;
        Product biggestAmountOfCertainProduct = new Product("",0);

        for (ProductsListener pl : listeners){
            Product p = pl.productsUpdated();
            if(p.countOfProducts > biggestAmountOfCertainProduct.countOfProducts){
                biggestAmountOfCertainProduct = p;
            }
            System.out.println(p.nameOfProduct);
            totalSpaceOfProducts += p.countOfProducts;
        }
        System.out.println("Товар на складе занимает " + totalSpaceOfProducts + " единиц");
        System.out.println("Сейчас на складе больше всего " + biggestAmountOfCertainProduct.nameOfProduct);
    }

    public void addNewProduct(String name, int count) {
        Product product = new Product(name, count);

        if(storage != null) {
            for (Product p : storage) {
                if (p.nameOfProduct.equals(product.nameOfProduct)) {
                    System.out.println("Такой товар уже есть на складе, поэтому мы увеличили его кол-во.");
                    p.countOfProducts += product.countOfProducts;
                    saver.saveProducts(storage);
                    updater();
                    return;
                }
            }
        }

        storage.add(product);
        addListener(product);
        saver.saveProducts(storage);
        updater();
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
            removeListener(p);
            updater();
        }

        saver.saveProducts(storage);
    }

    void changeCountOfProducts(String name, int count) { // Метод не заменит значение, а увеличит
        String answer = name.toLowerCase();
        for(int i = 0; i < storage.size(); i++) {
            if (storage.get(i).nameOfProduct.equals(answer)) {
                storage.get(i).countOfProducts += count;

                updater();
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
