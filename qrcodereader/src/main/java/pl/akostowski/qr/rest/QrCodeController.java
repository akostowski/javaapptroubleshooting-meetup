package pl.akostowski.qr.rest;

import boofcv.abst.fiducial.QrCodeDetector;
import boofcv.alg.fiducial.qrcode.QrCode;
import boofcv.factory.fiducial.FactoryFiducial;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.struct.image.GrayU8;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@SessionScope
public class QrCodeController {

    BufferedImage image;

    @PostMapping
    @RequestMapping("find")
    public String detect(final @RequestParam("file") MultipartFile file) throws IOException {
        QrCodeDetector<GrayU8> detector = FactoryFiducial.qrcode(null, GrayU8.class);
        image = ImageIO.read(file.getInputStream());
        for (int i = 0; i < 50; i++) {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "tiff", os);
        }
        detector.process(ConvertBufferedImage.convertFrom(image, (GrayU8) null));
        List<QrCode> detections = detector.getDetections();

        return String.format("QRCode found: %s", detections.get(0).message);
    }
}
