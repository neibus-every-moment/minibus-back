package com.minibus.moment.domain.image;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class ImageUploader {

    private static final String DIRECTORY = "src/main/resources/image/";

    public static String upload(String base64, String fileName ,String format){
        byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64);
        String path = DIRECTORY + fileName + "." +format;
        try {
            BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imageBytes));
            ImageIO.write(bufImg, format, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
