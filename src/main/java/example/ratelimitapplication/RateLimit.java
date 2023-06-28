
package example.ratelimitapplication;


/**
 *
 * @author mac
 */
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class RateLimit {

    private int requestsPerSecond;
    private long interval;
    private Instant lastRequestTime;

    public RateLimit(int requestsPerSecond) {
        this.requestsPerSecond = requestsPerSecond;
        this.interval = (long) Math.floorDiv(1_000, requestsPerSecond); // Milliseconds
        this.lastRequestTime = Instant.now();
    }

    public void limit() throws InterruptedException {
        Instant now = Instant.now();
        long elapsedTime = Duration.between(lastRequestTime, now).toMillis();
        long sleepTime = interval - elapsedTime;

        if (sleepTime > 0) {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        }

        lastRequestTime = Instant.now();
    }
}
