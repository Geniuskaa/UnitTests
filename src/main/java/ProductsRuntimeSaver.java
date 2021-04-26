import java.util.ArrayList;

public class ProductsRuntimeSaver implements ProductsSaver {
    ArrayList<Product> products = new ArrayList<>();

    @Override
    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public void saveProducts(ArrayList<Product> products) {
        this.products = products;
    }
}