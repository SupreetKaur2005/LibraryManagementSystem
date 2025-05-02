package Service;

import dao.FineDAO;
import dao.TransactionDAO;
import exception.DatabaseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import model.Fine;
import model.Transaction;

public class FineService {

    private static final double FINE_PER_DAY = 2.0;

    private FineDAO fineDAO = new FineDAO();
    private TransactionDAO transactionDAO = new TransactionDAO();

    public double calculateFine(int lateDays) {
        return lateDays * FINE_PER_DAY;
    }

    public void payFine(String username, double amount) {
        System.out.println(username + " paid fine: $" + amount);
    }

    public void calculateFinesForOverdueBooks() {
        try {
            List<Transaction> transactions = transactionDAO.getAllActiveTransactions();
            LocalDate today = LocalDate.now();

            for (Transaction transaction : transactions) {
                LocalDate dueDate = transaction.getDueDate();
                if (dueDate != null && today.isAfter(dueDate)) {
                    long lateDays = ChronoUnit.DAYS.between(dueDate, today);
                    double fineAmount = calculateFine((int) lateDays);

                    Fine fine = new Fine(transaction.getId(), fineAmount);
                    fineDAO.addFine(fine);
                }
            }
        } catch (DatabaseException e) {
            System.err.println("Error calculating fines: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
