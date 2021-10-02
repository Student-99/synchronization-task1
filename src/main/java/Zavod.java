import intarface.Car;
import intarface.Seller;
import intarface.Shop;

public class Zavod implements Seller {
    private Shop shop;
    private boolean isBusy;

    public Zavod(Shop shop) {
        this.shop = shop;
    }

    @Override
    public boolean isBusy() {
        return isBusy;
    }

    @Override
    public void setBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }

    public synchronized void receiveCar() {
        System.out.println("Производитель BMW выпустил 1 авто");
        shop.getCars().add(new BMW());
        System.out.println("В магазин прибыл новый авто");
        notify();

    }

    public synchronized Car sellCar() {
        Car car = null;
        setBusy(true);
        try {
            System.out.println("Покупатель " + Thread.currentThread().getName() + " зашел в автосалон");
            while (shop.getCars().size() == 0) {
                System.out.println("Машин нет, но ты держись!");
                wait();
            }
            car = shop.getCars().remove(0);
            setBusy(false);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return car;
    }
}
