package dao;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private String fileName;

    public ProductDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    public void saveProduct(Product product) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        PrintWriter writer = new PrintWriter(fileOutputStream);
        writer.print(product.toString());
        writer.close();
    }

    public void saveProducts(List<Product> products) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        PrintWriter writer = new PrintWriter(fileOutputStream);
        for (Product p : products){
            writer.print(p.toString());
        }
        writer.close();
    }
    public void saveProducts(List<Product> products, boolean append) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, append);
        PrintWriter writer = new PrintWriter(fileOutputStream);
        for (Product p : products){
            writer.print(p.toString());
        }
        writer.close();
    }

    public void removeProductById(long productId) throws IOException {
        ProductDaoImpl productDao = new ProductDaoImpl(fileName);
        List<Product> products = productDao.getAllProducts();
        for (Product p : products){
            if (p.getId() == productId){
                products.remove(products.indexOf(p));
                saveProducts(products, false);
                break;
            }
        }
    }

    public void removeProductByName(String productName) throws IOException {
        ProductDaoImpl productDao = new ProductDaoImpl(fileName);
        List<Product> products = productDao.getAllProducts();
        for (Product p : products){
            if (p.getProductName().equals(productName)){
                products.remove(products.indexOf(p));
                saveProducts(products, false);
                break;
            }
        }
    }

    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<Product>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        while (line!=null){
            products.add(parseProduct(line));
            line = reader.readLine();
        }
        reader.close();
        return products;
    }

    public Product getProductById(long productId) throws IOException {
        ProductDaoImpl productDao = new ProductDaoImpl(fileName);
        List<Product> products = productDao.getAllProducts();
        for (Product p : products){
            if (p.getId() == productId){
                return p;
            }
        }
        return null;
    }

    public Product getProductByName(String productName) throws IOException {
        ProductDaoImpl productDao = new ProductDaoImpl(fileName);
        List<Product> products = productDao.getAllProducts();
        for (Product p : products){
            if (p.getProductName().equals(productName)){
                return p;
            }
        }
        return null;
    }

    private Product parseProduct(String line){
        String values[] = line.split("#");
        long id = Long.parseLong(values[0]);
        String name = values[1];
        float price = Float.parseFloat(values[2]);
        float weight = Float.parseFloat(values[3]);
        String color = values[4];
        int count = Integer.parseInt(values[5]);
        return new Product(id,name,price,weight,color,count);
    }
}
