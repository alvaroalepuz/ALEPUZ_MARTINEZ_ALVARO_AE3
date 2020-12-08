package es.florida;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 999; i++) {
            executorService.execute(new MemberCreator());
            Thread.sleep(1000);
            executorService.execute(new MailSender());
            Thread.sleep(1000);
        }
        executorService.shutdown();
        if (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
            executorService.shutdownNow();

        }

    }
}