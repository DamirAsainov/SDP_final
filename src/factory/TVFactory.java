package factory;

import products.TV;

public class TVFactory extends ProductFactory{
    public Product createProduct(){
        return new TV();
    }
}
