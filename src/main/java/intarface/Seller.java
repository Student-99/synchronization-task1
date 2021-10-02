package intarface;

public interface Seller {

    Car sellCar();

    void receiveCar();

    boolean isBusy();

    void setBusy(boolean isBusy);
}
