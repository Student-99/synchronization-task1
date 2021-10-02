import intarface.Shop;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int countSellers = 5;
        final int countBuyer = 10;
        final Shop shop = new AutoLider(countSellers);
        final int frequencyOfAppearanceOfBuyers = 1000;
        final int carReleaseFrequency = 3000;

        for (int i = 0; i < countBuyer; i++) {
            new Thread(null, shop::sellCar, "Покупатель " + (i + 1)).start();
            Thread.sleep(frequencyOfAppearanceOfBuyers);
        }
        for (int i = 0; i < countBuyer; i++) {
            new Thread(null, shop::acceptCar, "Завод").start();
            Thread.sleep(carReleaseFrequency);
        }
    }
}
