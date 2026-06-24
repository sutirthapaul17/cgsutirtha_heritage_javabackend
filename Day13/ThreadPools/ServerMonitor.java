package ThreadPools;

import java.util.concurrent.*;

public class ServerMonitor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Run once after a 10-second delay
        scheduler.schedule(
                () -> System.out.println("[Report] Generating daily summary..."),
                10, TimeUnit.SECONDS
        );

        // Run every 5 seconds (initial delay: 0s)
        scheduler.scheduleAtFixedRate(
                () -> System.out.println("[Monitor] Server health: OK at " + System.currentTimeMillis()),
                0, 5, TimeUnit.SECONDS
        );

        // scheduleWithFixedDelay: waits 5s AFTER previous task COMPLETES
        scheduler.scheduleWithFixedDelay(
                () -> System.out.println("[Cleanup] Purging old logs..."),
                2, 5, TimeUnit.SECONDS
        );
    }
}

