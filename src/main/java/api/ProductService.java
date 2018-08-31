package api;

import model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    int getProductCount();
    Product getProduct(String productName);
    boolean isProductAvaliable(String productName);
    boolean isProductExisting(String productName);
    boolean isProductExisting(long id);

}
