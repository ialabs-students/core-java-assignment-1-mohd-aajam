
import java.util.ArrayList;
import java.util.Objects;

public class ProductService {
    public static ArrayList<Product> prods = Product.getProductsList();
    String prodName;
    double temp = 0.00;
    Product product_object, temp_obj;
    ArrayList<Product> newList = new ArrayList<>();

    public String findNameByCode(int productCode) {
        prods.forEach(a -> {
            if (productCode == a.getProductCode()) prodName = a.getName();
            else prodName = null;

        });
        return ("Product Name: " + prodName);
    }

    public Product findMaxPriceProduct(String category) {

        prods.forEach(a -> {
            if (Objects.equals(category, a.getCategory())) {
                product_object = a;
                if (temp < a.getPrice()) {
                    temp = a.getPrice();
                    temp_obj = a;
                }
            } else {
                product_object = null;
            }
        });
        return (temp_obj);
    }

    public ArrayList<Product> getProductsByCategory(String category) {
        prods.forEach(a -> {
            if (Objects.equals(category, a.getCategory())) {
                newList.add(a);
            } else {
                product_object = null;
            }
        });
        return newList;
    }
