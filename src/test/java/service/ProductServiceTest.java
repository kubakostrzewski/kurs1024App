package service;

import model.Product;
import org.junit.Assert;
import org.junit.Test;
import service.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetAllProductsPositive(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l, "shoe", 11f, 1, "red", 1));
        products.add(new Product(2l, "cloth", 8f, 2, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsFromClass = productService.getAllProducts();

        Assert.assertEquals(products, productsFromClass);
    }

    @Test
    public void testGetAllProductsNegative(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l, "shoe", 11f, 1, "red", 1));
        products.add(new Product(2l, "cloth", 8f, 2, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
        products.add(new Product(3l, "shoe", 2f, 4, "yellow", 4));
        List<Product> productsFromClass = productService.getAllProducts();

        Assert.assertNotEquals(products, productsFromClass);
    }

    @Test
    public void testGetProductCountPositive(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l, "shoe", 11f, 1, "red", 1));
        products.add(new Product(2l, "cloth", 8f, 2, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        int productCount = productService.getProductCount();

        Assert.assertEquals(3, productCount);
    }

    @Test
    public void testGetProductCountNegative(){
        ProductServiceImpl productService = new ProductServiceImpl();

        int productCount = productService.getProductCount();

        Assert.assertEquals(0, productCount);
    }

    @Test
    public void testGetProductPositive(){
        List<Product> products = new ArrayList<Product>();
        Product shoe = new Product(1l, "shoe", 11f, 1, "red", 1);
        Product cloth = new Product(2l, "cloth", 8f, 2, "blue", 2);
        products.add(shoe);
        products.add(cloth);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product productFromClass = productService.getProduct("shoe");

        Assert.assertEquals(shoe, productFromClass);
    }

    @Test
    public void testGetProductNegative(){
        List<Product> products = new ArrayList<Product>();
        Product shoe = new Product(1l, "shoe", 11f, 1, "red", 1);
        Product cloth = new Product(2l, "cloth", 8f, 2, "blue", 2);
        products.add(shoe);
        products.add(cloth);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product productFromClass = productService.getProduct("boot");

        Assert.assertNull(productFromClass);
    }

    @Test
    public void testIsProductAvailablePositive(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l, "shoe", 11f, 1, "red", 1));
        products.add(new Product(2l, "cloth", 8f, 2, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isAvailableFromClass = productService.isProductAvaliable("shoe");

        Assert.assertTrue(isAvailableFromClass);
    }

    @Test
    public void testIsProductAvailableNegative(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l, "shoe", 11f, 1, "red", 0));
        products.add(new Product(2l, "cloth", 8f, 2, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isAvailableFromClass = productService.isProductAvaliable("shoe");

        Assert.assertFalse(isAvailableFromClass);
    }

    @Test
    public void testIsProductAvailableNonExistingProduct(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l, "shoe", 11f, 1, "red", 0));
        products.add(new Product(2l, "cloth", 8f, 2, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isAvailableFromClass = productService.isProductAvaliable("boot");

        Assert.assertFalse(isAvailableFromClass);
    }

    @Test
    public void testIsProductExistingByNamePositive(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l, "shoe", 11f, 1, "red", 0));
        products.add(new Product(2l, "cloth", 8f, 2, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProdctExistingFromClass = productService.isProductExisting("cloth");

        Assert.assertTrue(isProdctExistingFromClass);
    }

    @Test
    public void testIsProductExistingByNameNegative(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l, "shoe", 11f, 1, "red", 0));
        products.add(new Product(2l, "cloth", 8f, 2, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProdctExistingFromClass = productService.isProductExisting("boot");

        Assert.assertFalse(isProdctExistingFromClass);
    }

    @Test
    public void testIsProductExistingByIdPositive(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l, "shoe", 11f, 1, "red", 0));
        products.add(new Product(2l, "cloth", 8f, 2, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProdctExistingFromClass = productService.isProductExisting(1l);

        Assert.assertTrue(isProdctExistingFromClass);
    }
    @Test
    public void testIsProductExistingByIdNegative(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l, "shoe", 11f, 1, "red", 0));
        products.add(new Product(2l, "cloth", 8f, 2, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProdctExistingFromClass = productService.isProductExisting(3l);

        Assert.assertFalse(isProdctExistingFromClass);
    }

}
