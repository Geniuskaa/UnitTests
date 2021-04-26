import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FileSaverTests {
    private ProductsFileSaver saver;
    private ArrayList<Product> storage;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void openFile() throws IOException {
        File f = folder.newFile();
        saver = new ProductsFileSaver(f);

        storage = new ArrayList<>();
        storage.add(new Product("Iphone", 20));
        storage.add(new Product("Playstation 5", 60));
        storage.add(new Product("Samsung", 12));
    }

    @Test
    public void readWriteProductsTest() {
        saver.saveProducts(storage);
        ArrayList<Product> temp = saver.getProducts();

        assertEquals(storage.size(), temp.size());

        for (int i = 0; i < storage.size(); i++) {
            assertEquals(storage.get(i).nameOfProduct, temp.get(i).nameOfProduct);
            assertEquals(storage.get(i).countOfProducts, temp.get(i).countOfProducts);
        }
    }
}