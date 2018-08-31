package service;

import api.ProductService;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;

    public ProductServiceImpl() {
        products = new ArrayList<Product>();
    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public int getProductCount() {
        int productCount = 0;
        for (Product product:products){
            productCount = productCount + product.getProductCount();
        }
        return productCount;
    }

    public Product getProduct(String productName) {
        for (Product product:products){
            if (product.getProductName() == productName){
                return product;
            }
        }
        return null;
    }

    public boolean isProductAvaliable(String productName) {
        for (Product product:products){
            if (product.getProductName() == productName){
                int productCount = product.getProductCount();
                if (productCount == 0){
                    return false;
                }else {

                    return true;
                }
            }
        }
        return false;
    }

    public boolean isProductExisting(String productName) {
        for (Product product:products){
            if (product.getProductName() == productName){
                return true;
            }
        }
        return false;
    }

    public boolean isProductExisting(long id) {
        for (Product product: products){
            if (product.getId() == id){
                return true;
            }
        }
        return false;
    }
}
