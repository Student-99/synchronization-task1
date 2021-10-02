import java.util.ArrayList;
import java.util.List;

import intarface.Car;
import intarface.Seller;
import intarface.Shop;

public class AutoLider implements Shop {

    List<Seller> sellers = new ArrayList<>();
    List<Car> cars = new ArrayList<>();

    public AutoLider(int countSellers) {
        for (int i = 0; i < countSellers; i++) {
            sellers.add(new Zavod(this));
        }
    }

    @Override
    public void acceptCar() {
        Seller seller = findASeller(true);
        seller.receiveCar();
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public Car sellCar() {
        Seller seller = findASeller(false);
        return seller.sellCar();
    }

    private Seller findASeller(boolean isBusy){
        while (true) {
            for (Seller sell : sellers) {
                if (sell.isBusy()==isBusy) {
                    return sell;
                }
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
