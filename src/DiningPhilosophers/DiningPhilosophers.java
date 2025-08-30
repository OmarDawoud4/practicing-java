package DiningPhilosphers;

public class DiningPhilosophers {


    public static void main(String[] args) {
        int philosophersCnt = 5 ;
        Fork[] forks = new Fork[philosophersCnt];
        Philoshper [] philoshpers = new Philoshper[philosophersCnt];

        for (int i = 0; i < philosophersCnt; i++) {
            forks[i]= new Fork(i);

        }

        String names [] ={"nietsche " , "camus" , "kant" , "descartes" ,"marx"};
        for (int i = 0; i < philosophersCnt; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i+1)% philosophersCnt];
            if (i== philosophersCnt-1) {
                philoshpers[i]= new Philoshper(names[i] , rightFork,leftFork);
            }
            else {
                philoshpers[i] = new Philoshper(names[i], leftFork,rightFork);
            }
            new Thread (philoshpers[i]).start();

        }

    }
}
