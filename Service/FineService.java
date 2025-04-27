package service;
public class FineService {

    private static final double FINE_PER_DAY = 2.0;

    public double calculateFine(int lateDays) {
        return lateDays * FINE_PER_DAY;
    }

    public void payFine(String username, double amount) {
        System.out.println(username + " paid fine: $" + amount);
    }
}
