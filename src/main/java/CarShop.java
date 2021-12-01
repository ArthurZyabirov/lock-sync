import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CarShop {
    final CarSeller c = new CarSeller(this);
    List<Car> cars = new ArrayList<>(20);
    public void sellCar() {
        c.sellCar();
    }
    public void receiveCar() {
        c.receiveCar();
    }
    List<Car> getCars() {
        return cars;
    }



}
