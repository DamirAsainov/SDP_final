package decorator;

public class BaseStore implements Store{
    @Override
    public void sell() {
        System.out.println("Selling products...");
    }
}
