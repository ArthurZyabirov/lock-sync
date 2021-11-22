public class Main {
    public static void main(String[] args) {
        final CarShop c = new CarShop();
        ThreadGroup mainGroup = new ThreadGroup("main group");
        new Thread(mainGroup, c::sellCar, "Покупатель 1").start();
        new Thread(mainGroup, c::sellCar, "Покупатель 2").start();
        new Thread(mainGroup, c::sellCar, "Покупатель 3").start();
        new Thread(mainGroup, c::recieveCar,"Производитель авто").start();
    }

}
