import java.util.ArrayList;

public interface ProductsSaver {
    ArrayList<Product> getProducts();
    void saveProducts(ArrayList<Product> store);
}
