import java.io.Serializable;

public class Product {
    protected String nameOfProduct;
    protected Integer countOfProducts;

    public Product(String nameOfProduct, Integer countOfProducts) {
        this.nameOfProduct = nameOfProduct.toLowerCase();
        this.countOfProducts = countOfProducts;
    }
}
