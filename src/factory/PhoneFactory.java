package factory;

import products.Phone;

public class PhoneFactory {
    public Product createProduct(){
        return new Phone();
    }
}
