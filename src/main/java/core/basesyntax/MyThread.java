package core.basesyntax;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        LocalTime start = LocalTime.now();
        Thread.sleep(new Random().nextInt(1000));
        LocalTime end = LocalTime.now();
        long duration = ChronoUnit.MILLIS.between(start, end);
        return "Task duration was %d ms, execution finished at %s"
                .formatted(duration, end);
    }
}
