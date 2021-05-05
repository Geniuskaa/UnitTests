import java.io.Serializable;

public class Product implements ProductsListener {
    protected String nameOfProduct;
    protected Integer countOfProducts;

    public Product(String nameOfProduct, Integer countOfProducts) {
        this.nameOfProduct = nameOfProduct.toLowerCase();
        this.countOfProducts = countOfProducts;
    }

    @Override
    public Product productsUpdated() {
        return this;
    }
}
