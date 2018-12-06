package cn.edu.bnuz.file.web;

import cn.edu.bnuz.file.service.FileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.UUID;

/**
 * 文件 FileController 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
@RestController
public class FileController {
    private FileUtil fileUtil;

    public FileController(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }

    @PostMapping("upload")
    public String fileUpload(MultipartFile file) throws IOException {
        if (file == null)
            throw new IllegalArgumentException("文件为空");

        int index = file.getOriginalFilename().lastIndexOf(".");
        StringBuilder name = new StringBuilder(UUID.randomUUID().toString());
        if (index != -1)
            name.append(file.getOriginalFilename().substring(index));

        fileUtil.storeFile(file.getInputStream(), name.toString());

        return name.toString();
    }

    @GetMapping("/{fileName}")
    public ModelAndView fileDownload(@PathVariable String fileName) {
        return new ModelAndView(fileUtil.fileDownload(fileName, "application/octet-stream"));
    }
}
