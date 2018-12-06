package cn.edu.bnuz.file.service;

import cn.edu.bnuz.file.util.FileDownloadView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import java.io.*;

import static cn.edu.bnuz.file.util.InputStreamToString.stream2String;
import static cn.edu.bnuz.file.util.InputStreamToString.string2File;

/**
 * 文件 FileUtil 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
@Service
public class FileUtil {
    @Value("${muduo.upload.file-path}")
    private String filePath;

    private String localFilePath(String name) {
        return filePath + File.separator + name;
    }

    public boolean fileExist(String fileName) {
        return new File(localFilePath(fileName)).exists();
    }

    public void storeFile(InputStream inputStream, String fileName) throws IOException {
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(localFilePath(fileName)));

        int hasRead;
        byte[] bytes = new byte[1024];

        while ((hasRead = inputStream.read(bytes)) != -1)
            outputStream.write(bytes, 0, hasRead);

        outputStream.close();
    }

    public String getFile(String filePath) {
        try {
            return stream2String(new FileInputStream(localFilePath(filePath)));
        } catch (IOException e) {
            return null;
        }
    }

    public void stringToFile(String context, String fileName) throws IOException {
        string2File(context, localFilePath(fileName));
    }

    public String streamToString(InputStream stream) throws IOException {
        return stream2String(stream);
    }

    public View fileDownload(String fileName, String contentType) {
        return new FileDownloadView(filePath, contentType, fileName);
    }
}
