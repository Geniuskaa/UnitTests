import org.junit.*;

import static org.junit.Assert.*;

public class StoreTests {
    private Store store;
    private ProductsRuntimeSaver saver;

    @Before
    public void prepareProductsTest() {
        this.saver = new ProductsRuntimeSaver();

        saver.products.add(new Product("Iphone", 10));
        saver.products.add(new Product("Playstation 5", 60));
        saver.products.add(new Product("Samsung", 12));
        this.store = new Store(saver);

    }

    @Test
    public void addNewProductTest(){
        store.addNewProduct("LG", 27);

        assertEquals(4, store.sizeOfStore());
        assertEquals("lg", store.getProduct("lg").nameOfProduct);
        assertEquals(27, (int)store.getProduct("lg").countOfProducts);
    }

    @Test
    public void addExistingProductTest(){
        store.addNewProduct("Iphone", 10);

        assertEquals(20, (int)store.getProduct("iphone").countOfProducts);
    }

    @Test
    public void getProductTestSuccess(){
        Product p = store.getProduct("Playstation 5");

        assertNotNull(p);
        assertEquals("playstation 5", p.nameOfProduct);
        assertEquals(60, (int) p.countOfProducts);
    }

    @Test
    public void getProductTestFailed(){
        Product p = store.getProduct("Playstation 4");
        assertNull(p);
    }

    @Test
    public void deleteExistingProductTest(){
        store.deleteProduct("iphone");
        Product p = store.getProduct("iphone");
        assertNull(p);
    }

    @Test
    public void deleteProductTestFailed(){
        store.deleteProduct("HTC");

        Product p = store.getProduct("htc");
        assertNull(p);
    }

    @Test
    public void changeCountOfExistingProductsTest(){
        store.changeCountOfProducts("Playstation 5", -10);
        assertEquals(50, (int) store.getProduct("playstation 5").countOfProducts);
    }

    @Test
    public void changeCountOfProductsTestFailed(){
        store.changeCountOfProducts("HTC", 5);
        Product p = store.getProduct("HTC");
        assertNull(p);
    }
}
