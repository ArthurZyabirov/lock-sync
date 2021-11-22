import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CarSeller {
    private CarShop carShop;
    private int sellTime = 1000;
    private int timeOfMakingCar = 4000;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();



    public CarSeller(CarShop carShop) {
        this.carShop = carShop;
    }
    public synchronized void recieveCar() {
        try {
            lock.lock();
            System.out.println("Производим автомобиль!");
            Thread.sleep(timeOfMakingCar);
            carShop.getCars().add(new Car());
            System.out.println("Производитель Toyota выпустил 1 авто");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public synchronized Car sellCar(Thread thread) {
        lock.lock();
        try {
            System.out.println(thread.getName() + " зашел в автосалон");
            while (carShop.getCars().size() == 0) {
                System.out.println("Машин нет!");
                condition.await();
            }
            Thread.sleep(sellTime);
            System.out.println(thread.getName() + " уехал на новеньком авто");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return carShop.getCars().remove(0);
    }

}

