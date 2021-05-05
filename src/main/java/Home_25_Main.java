import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Home_25_Main {
    public static void main(String[] args) throws FileNotFoundException {
        ProductsFileSaver fileSaver = new ProductsFileSaver("file.txt");
        Store store = new Store(fileSaver);

        //store.addNewProduct("Iphone", 10);
        //store.addNewProduct("Samsung", 15);
        //store.addNewProduct("Playstation 5", 142);
        //store.addNewProduct("Xbox One X", 3);
        //store.addNewProduct("LG", 1);

        store.deleteProduct("Xbox one x");
        //store.printAllProducts();






    }
}
