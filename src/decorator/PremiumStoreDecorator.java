package decorator;

public class PremiumStoreDecorator implements Store{
    private Store baseStore;

    public PremiumStoreDecorator(Store baseStore) {
        this.baseStore = baseStore;
    }

    @Override
    public void sell() {
        baseStore.sell();
        System.out.println("Providing premium customer service.");
    }
}
