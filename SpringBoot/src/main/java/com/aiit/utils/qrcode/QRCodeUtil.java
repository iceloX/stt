package com.aiit.utils.qrcode;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;

import java.awt.*;
import java.io.ByteArrayOutputStream;

/**
 * @author litong
 * @date 2019/10/14 18:14
 */
public class QRCodeUtil {
    /**
     *
     * @param text
     * @return
     */
    public static String getQRCodeBase64(String text) {
        int width = 100;
        int height = 100;
        QrConfig config = new QrConfig(width, height);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(1);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.BLACK.getRGB());
        // 设置背景色（灰色）
        config.setBackColor(Color.WHITE.getRGB());
        // 生成二维码到文件，也可以到流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        QrCodeUtil.generate(text, config, ImgUtil.IMAGE_TYPE_PNG, outputStream);
        byte[] pngData = outputStream.toByteArray();
        // 这个前缀，可前端加，可后端加，不加的话，不能识别为图片
        return "data:image/png;base64," + Base64.encode(pngData);
    }

    /**
     * 生成二维码
     *
     * @param text   储存内容
     * @param config 自定义配置
     * @return
     */
    public static String getQRCodeBase64(String text, QrConfig config) {
        // 生成二维码到文件，也可以到流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        QrCodeUtil.generate(text, config, ImgUtil.IMAGE_TYPE_PNG, outputStream);
        byte[] pngData = outputStream.toByteArray();
        return "data:image/png;base64," + Base64.encode(pngData);
    }


    public static void main(String[] args) {
        QrConfig config = new QrConfig(100, 100);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.CYAN.getRGB());
        // 设置背景色（灰色）
        config.setBackColor(Color.GRAY.getRGB());
        // 生成二维码到文件，也可以到流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        QrCodeUtil.generate("wawaw", config, ImgUtil.IMAGE_TYPE_PNG, outputStream);
        byte[] pngData = outputStream.toByteArray();
        System.out.println(Base64.encode(pngData));
    }
}

