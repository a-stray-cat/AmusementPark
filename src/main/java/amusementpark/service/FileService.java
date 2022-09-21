package amusementpark.service;

import amusementpark.model.Fileinfo;
import amusementpark.model.Files;
import amusementpark.model.Result;
import amusementpark.model.UploadResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.05 17:45
 */
@Service
public interface FileService {
    /**
     * 文件上传接口
     * @param files
     * @return
     */
    UploadResult upLoadFiles(Files files);

    /**
     * 根据id获取文件
     * @param id
     * @return
     */
    Files getFileByFileName(String id);

    /**
     * 根据id获取数据流
     * @param files
     * @return
     */
    InputStream getFileInputStream(Files files);
}
