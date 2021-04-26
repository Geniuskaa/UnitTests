import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class StoreToFileTests {
    private Store store;
    private ArrayList<Product> storage;

    @Before
    public void prepareProducts() {
        storage = new ArrayList<>();

        storage.add(new Product("Iphone", 20));
        storage.add(new Product("Playstation 5", 60));
        storage.add(new Product("Samsung", 12));

        ProductsFileSaver saver = new ProductsFileSaver("products.txt");
        saver.saveProducts(storage);

        store = new Store(saver);
    }

    @Test
    public void readToStoreTest() {
        assertEquals(storage.size(), store.storage.size());

        for (int i = 0; i < storage.size(); i++) {
            assertEquals(storage.get(i).nameOfProduct, store.storage.get(i).nameOfProduct);
            assertEquals(storage.get(i).countOfProducts, store.storage.get(i).countOfProducts);
        }
    }

    @Test
    public void createProductTest() {
        storage.add(new Product("HTC", 15));
        store.addNewProduct("HTC", 15);

        ArrayList<Product> temp = store.saver.getProducts();

        assertEquals(storage.size(), temp.size());

        for (int i = 0; i < storage.size(); i++) {
            assertEquals(storage.get(i).nameOfProduct, temp.get(i).nameOfProduct);
            assertEquals(storage.get(i).countOfProducts, temp.get(i).countOfProducts);
        }
    }
}