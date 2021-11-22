import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CarShop {
    final CarSeller c = new CarSeller(this);
    List<Car> cars = new ArrayList<>(20);
    public Car sellCar() {
        return c.sellCar(Thread.currentThread());
    }
    public void recieveCar() {
        c.recieveCar();
    }
    List<Car> getCars() {
        return cars;
    }



}
