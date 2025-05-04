// package thread;

// import Service.BackupService;

// public class BackupThread extends Thread {

//     @Override
//     public void run() {
//         try {
//             BackupService backupService = new BackupService();
//             backupService.createBackup();
//         } catch (Exception e) {
//             e.printStackTrace();  // Log backup failure
//         }
//     }
// }

package thread;

import Service.BackupService;

public class BackupThread extends Thread {

    private BackupService backupService;

    // Default constructor
    public BackupThread() {
        // Initialize a new BackupService instance
        this.backupService = new BackupService();
    }

    // Constructor with BackupService instance
    public BackupThread(BackupService backupService) {
        this.backupService = backupService;
    }

    @Override
    public void run() {
        try {
            if (backupService != null) {
                backupService.createBackup();
            } else {
                System.out.println("BackupService is not initialized.");
            }
        } catch (Exception e) {
            e.printStackTrace();  // Log backup failure
        }
    }
}