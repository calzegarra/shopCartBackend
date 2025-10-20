package com.shopcart.usecase.util;
import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GeneralUseCase {
    public static byte[] compress(byte[] data) throws IOException {
        if (data == null || data.length == 0) return data;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOS = new GZIPOutputStream(bos)) {
            gzipOS.write(data);
        }
        return bos.toByteArray();
    }

    public static byte[] decompress(byte[] compressedData) throws IOException {
        if (compressedData == null || compressedData.length == 0) return compressedData;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (GZIPInputStream gzipIS = new GZIPInputStream(new ByteArrayInputStream(compressedData))) {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = gzipIS.read(buffer)) > 0) {
                bos.write(buffer, 0, len);
            }
        }
        return bos.toByteArray();
    }

    public static byte[] createThumbnail(byte[] originalBytes, int width, int height) throws IOException {
        // 1️⃣ Convertir el byte[] en una imagen
        ByteArrayInputStream in = new ByteArrayInputStream(originalBytes);
        BufferedImage originalImage = ImageIO.read(in);
        if (originalImage == null) {
            throw new IOException("No se pudo leer la imagen desde los bytes proporcionados");
        }
        // 2️⃣ Calcular escala proporcional
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();

        double scale = Math.min((double) width / originalWidth, (double) height / originalHeight);

        int newWidth = (int) (originalWidth * scale);
        int newHeight = (int) (originalHeight * scale);
        // 3️⃣ Crear la nueva imagen reescalada
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resizedImage.createGraphics();
        // Suavizado para mantener calidad
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();
        // 4️⃣ Convertir de nuevo a bytes
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(resizedImage, "jpg", out);

        return out.toByteArray();
    }
}
