import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProductsFileSaver implements ProductsSaver {
    Type listOfProducts = new TypeToken<ArrayList<Product>>() {}.getType();
    private File file;

    public ProductsFileSaver(File file) {
        this.file = file;
    }

    public ProductsFileSaver(String fileName) {
        file = new File(fileName);
    }

    @Override
    public ArrayList<Product> getProducts() {
        ArrayList<Product> result = new ArrayList<>();

        Gson gson = new GsonBuilder().create();
        try {
            result = gson.fromJson(new JsonReader(new FileReader(file.getName())), listOfProducts);
            if(result == null){
                result = new ArrayList<Product>();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return result;
    }

    @Override
    public void saveProducts(ArrayList<Product> store) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(file.getName(), false)) {
            writer.write(gson.toJson(store));
            writer.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}