package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final int POOL_SIZE = 5;
    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        List<MyThread> threads = new ArrayList<>();
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads.add(new MyThread());
        }

        List<Future<String>> futures = executorService.invokeAll(threads);
        for (Future<String> future : futures) {
            logger.info(future.get());
        }
        executorService.shutdown();
    }
}
