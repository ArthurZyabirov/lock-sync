public class Main {
    public static void main(String[] args) throws InterruptedException {
        final CarShop c = new CarShop();

        for (int i = 1; i < 4; i++) {
            Thread.sleep(3000);
            new Thread(null, c::sellCar, "Покупатель " + i).start();
        }
        new Thread(null, c::receiveCar,"Производитель авто").start();
    }

}
