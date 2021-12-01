public class CarSeller {
    private final CarShop carShop;
    private final int sellTime = 1000;
    private final int timeOfMakingCar = 4000;
    private static int limiter = 10;



    public CarSeller(CarShop carShop) {
        this.carShop = carShop;
    }
    public void receiveCar() {
        try {
            while(limiter != 0) {
                System.out.println("Производим автомобиль!");
                Thread.sleep(timeOfMakingCar);
                System.out.println("Производитель Toyota выпустил 1 авто");
                synchronized (this) {
                    carShop.getCars().add(new Car());
                    notifyAll();
                }
                limiter--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (carShop.getCars().size() == 0) {
                System.out.println("Машин нет!");
                wait();
            }
            if (limiter != 0) {
                Thread.sleep(sellTime);
                System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
                limiter--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carShop.getCars().remove(0);
    }

}

