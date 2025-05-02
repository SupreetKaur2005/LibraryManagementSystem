package util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeUtil {

    private static final Logger logger = Logger.getLogger(QRCodeUtil.class.getName());

    public static void generateQRCode(String data, String filePath) {
        if (data == null || filePath == null) {
            logger.warning("generateQRCode called with null parameters");
            return;
        }
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 250, 250);

            Path path = Paths.get(filePath);
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);
        } catch (WriterException | IOException e) {
            logger.log(Level.SEVERE, "Failed to generate QR Code", e);
        }
    }
}
