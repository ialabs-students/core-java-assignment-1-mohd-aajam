import java.util.*;

class ProductService {
    String prodName = "Unavailable";
    public String findNameByCode(int pCode) {
        allProductObject.forEach(i -> {
                if(pCode == i.getProductCode()) prodName = i.getName();
        });
        return ("Product : " + prodName);
    }

    double price = 0.00;
    String maximumPrice = null;
    Product pObject;
    public String findMaxPriceProduct(String category){
        filteredObject.forEach(i -> {
            if (Objects.equals(category, i.getCategory())) {
                if (price < i.getPrice()) {
                    price = i.getPrice();
                    maximumPrice = i.getName();
                }
            } else pObject = null;
        });
        return ("Max price product : "+maximumPrice);
    }


    ArrayList<Product> filteredObject = new ArrayList<>();
    static ArrayList<Product> allProductObject = Product.getAllProduct(); //class name.method name

    public ArrayList<Product> getProductsByCategory(String category) {
        allProductObject.forEach(i -> {                            //here i is like (11, "Fan", 3999.00, "cloth"));
            if (Objects.equals(category, i.getCategory())) filteredObject.add(i);
            else pObject = null;
        });
        return filteredObject;
    }
}

public class Product {

    private int pCode;
    private String pName, category;
    private double pPrice;

    public Product(int pCode, String pName, double pPrice, String category){
        this.pCode = pCode;
        this.pName = pName;
        this.pPrice = pPrice;
        this.category = category;
    }

    public int getProductCode(){return pCode;}
    public void setProductCode(int pCode) {this.pCode = pCode;}
    public String getName() {return pName;}
    public void setName(String pName) {this.pName = pName;}
    public double getPrice() {return pPrice;}
    public void setPrice(double pPrice) {this.pPrice = pPrice;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}

    public static ArrayList<Product> getAllProduct(){
        ArrayList<Product> entireProducts = new ArrayList<>();
        entireProducts.add(new Product(11, "Fan", 3999.00, "electronic"));
        entireProducts.add(new Product(12, "Cooler", 8999.00, "electronic"));
        entireProducts.add(new Product(13, "Air conditioner", 29999.00, "electronic"));
        entireProducts.add(new Product(21, "Mac", 89999.00, "laptop"));
        entireProducts.add(new Product(22, "Lenovo", 59999.00, "laptop"));
        entireProducts.add(new Product(23, "HP", 52000.00, "laptop"));
        entireProducts.add(new Product(24, "Dell", 59000.00, "laptop"));
        entireProducts.add(new Product(31, "Shirt", 999.00, "cloth"));
        entireProducts.add(new Product(32, "Pant", 12999.00, "cloth"));
        entireProducts.add(new Product(33, "Trouser", 2999.00, "cloth"));
        return entireProducts;
    }

    public static void main(String[] args){
        ProductService p = new ProductService();
        String categoryName = "electronic"; //cloth, laptop, electronic
        ArrayList<Product> filteredCategory = p.getProductsByCategory(categoryName);

        if (filteredCategory != null)
            for (Product i : filteredCategory)
                System.out.println("[pCode: " + i.getProductCode() + ", pName:" + i.getName() + ", pPrice: Rs." + i.getPrice() + ", pCategory: " + i.getCategory() + "]");


        System.out.println("\n"+p.findNameByCode(23));

        System.out.println("\n"+p.findMaxPriceProduct(categoryName));
    }
}
