/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package example.ratelimitapplication;

/**
 *
 * @author mac
 */
public class RateLimitApplication {

    public static void main(String[] args) {
        RateLimit rateLimiter = new RateLimit(5); // 5 requests per second

        for (int i = 0; i < 10; i++) {
            try {
                rateLimiter.limit();
                System.out.println("Request #" + (i + 1) + " processed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
