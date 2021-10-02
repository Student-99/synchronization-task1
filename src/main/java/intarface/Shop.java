package intarface;

import java.util.List;

public interface Shop {
    void acceptCar();
    List<Car> getCars();
    Car sellCar();
}
