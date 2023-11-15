package factory;

import products.Phone;
import products.TV;

public class PhoneFactory {
    public Product createProduct(){
        return new Phone();
    }
}
