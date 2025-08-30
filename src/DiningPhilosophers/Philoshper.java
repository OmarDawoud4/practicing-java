package DiningPhilosphers;

public class Philoshper implements Runnable  {

    private final String name ;
    private final Fork leftFork , rightFork ;
    public Philoshper(String name, Fork left, Fork right) {
        this.name = name;
        this.leftFork = left;
        this.rightFork = right;

    }
    @Override
    public void run() {
        // TODO

        while (true) {

            try {
                think();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                eat();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void think() throws InterruptedException {

        System.out.println( name + " is thinking.");
        Thread.sleep((int)(Math.random() * 1000)); // simulate time
    }
    private void eat () throws InterruptedException {
        synchronized (leftFork){
            System.out.println(name + " picked left fork " + leftFork.getId());
            synchronized (rightFork){
                System.out.println(name + " picked right fork " + rightFork.getId());
                System.out.println(name + " is eating ...");
                Thread.sleep((int)(Math.random() * 1000));
            }
            System.out.println(name + " put down right fork "+ rightFork.getId());

        }
        System.out.println(name + " put down left fork "+ leftFork.getId());

    }
}
