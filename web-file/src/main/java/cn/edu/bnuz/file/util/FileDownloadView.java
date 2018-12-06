package cn.edu.bnuz.file.util;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 文件 FileDownloadView 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
public class FileDownloadView implements View {
    private String fileDirectory;
    private String contentType;
    private String fileName;

    public FileDownloadView(String fileDirectory, String contentType, String fileName) {
        this.fileDirectory = fileDirectory;
        this.contentType = contentType;
        this.fileName = fileName;
    }

    @Override
    public String getContentType() {
        return this.contentType;
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        try {
            File file = new File(this.fileDirectory, fileName);
            String fileName = file.getName();

            httpServletResponse.setContentType(this.contentType);
            httpServletResponse.setHeader("Content-Disposition", "attachment" + ";filename=\"" + URLEncoder.encode(fileName, "UTF-8")
                    + "\";filename*=utf-8''" + URLEncoder.encode(fileName, "UTF-8"));

            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream outputStream = new BufferedOutputStream(httpServletResponse.getOutputStream());
            int hasRead;
            byte[] readBytes = new byte[512];

            while ((hasRead = inputStream.read(readBytes)) != -1) {
                outputStream.write(readBytes, 0, hasRead);
                outputStream.flush();
            }

            inputStream.close();
        } catch (FileNotFoundException ex) {
            httpServletResponse.reset();
            throw ex;
        }
    }
}
