
import java.util.ArrayList;

public class Product {
    private int productCode;
    private String name;
    private double price;
    private String category;

    public Product(int productCode, String name, double price, String category) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static ArrayList<Product> getProductsList() {
        ArrayList<Product> prods = new ArrayList<>();
        Product f1 = new Product(11, "Fan", 3999.00, "electronics");
        prods.add(f1);
        Product f2 = new Product(12, "Cooler", 8999.00, "electronics");
        prods.add(f2);
        Product f3 = new Product(13, "Air conditioner", 29999.00, "electronics");
        prods.add(f3);
        Product m1 = new Product(21, "Mac", 89999.00, "laptop");
        prods.add(m1);
        Product m2 = new Product(22, "Lenovo", 59999.00, "laptop");
        prods.add(m2);
        Product m3 = new Product(23, "HP", 52000.00, "laptop");
        prods.add(m3);
        Product e1 = new Product(31, "Shirt", 999.00, "Clothes");
        prods.add(e1);
        Product e2 = new Product(32, "Pant", 12999.00, "Clothes");
        prods.add(e2);
        Product e3 = new Product(33, "Trouser", 2999.00, "Clothes");
        prods.add(e3);
        return prods;
    }

    public static void main(String[] args) {

        ProductService productService = new ProductService();
        String prodName = productService.findNameByCode(513);
        System.out.println(prodName);

        Product product_obj = productService.findMaxPriceProduct("laptop");
        System.out.println(product_obj);

        ArrayList<Product> products = productService.getProductsByCategory("electronics");
        if (products != null) {
            for (Product product : products) {
                System.out.println("[ product code: " + product.getProductCode() + ", product name: " + product.getName() + ", product price: Rs." + product.getPrice() + ", product category: " + product.getCategory() + " ]");
            }
        }
    }
}
