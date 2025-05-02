package thread;

import Service.BackupService;

public class BackupThread extends Thread {

    @Override
    public void run() {
        try {
            BackupService backupService = new BackupService();
            backupService.createBackup();
        } catch (Exception e) {
            e.printStackTrace();  // Log backup failure
        }
    }
}