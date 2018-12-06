package cn.edu.bnuz.file.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 文件 InputStreamToString 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
public class InputStreamToString {
    /**
     * 输入流转换为字符串
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static String stream2String(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, length);
        }
        return outputStream.toString(StandardCharsets.UTF_8.name());
    }

    public static void string2File(String context, String path) throws IOException {
        byte[] bytes = context.getBytes();
        try (FileOutputStream outputStream = new FileOutputStream(path);
             ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes)
        ) {
            int hasRead = -1;
            byte[] readByte = new byte[1024];

            while ((hasRead = inputStream.read(readByte)) != -1) {
                outputStream.write(readByte, 0, hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
