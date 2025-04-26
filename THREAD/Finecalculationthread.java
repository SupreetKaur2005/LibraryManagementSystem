package thread;

import service.FineService;

public class FineCalculationThread extends Thread {

    @Override
    public void run() {
        try {
            FineService fineService = new FineService();
            fineService.calculateFinesForOverdueBooks();
        } catch (Exception e) {
            e.printStackTrace();  // Log calculation errors
        }
    }
}
