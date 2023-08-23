package com.Test;

import Utils.MethodHibernate;
import org.example.Product;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Test {
    private static byte[] convertImageToByteArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, "jpg", baos);

            // Chuyển đổi ByteArrayOutputStream thành mảng byte[]
            byte[] imageBytes = baos.toByteArray();
            return imageBytes;
        } catch (IOException io) {
            io.printStackTrace();
        }
        // Ghi ảnh vào ByteArrayOutputStream

        // Đóng ByteArrayOutputStream
        baos.close();

        return null;
    }

    public static void main(String[] args) {
        Product pd = new Product();
        pd.setId("sp02");
        pd.setName("sản phẩm 01");
        pd.setDescribe("san pham sieu dep");
        String pathImage = "/image1.jpg";
        try {
            InputStream ips = Test.class.getResourceAsStream(pathImage);

            // Đọc ảnh từ luồng đầu vào
            BufferedImage bi = ImageIO.read(ips);

            pd.setImage(convertImageToByteArray(bi));
            new MethodHibernate().Insert(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new MethodHibernate().ShowAll();
    }
}
