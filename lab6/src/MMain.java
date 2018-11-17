import server.Main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MMain {
    public static void main(String[] args){
        server.Main A = new Main();
        klient.Main B = new klient.Main();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(A);
        executorService.submit(B);

    }
}