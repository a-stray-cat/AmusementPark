package amusementpark.serviceImpl;

import amusementpark.mapper.FileMapper;
import amusementpark.model.*;
import amusementpark.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.05 17:47
 */
@Service
public class FileServiceImpl implements FileService {

    private static final String EMPTY = "为空";
    private static final String MAX_FILE = "大于";

    private final FileMapper fileMapper;

    public FileServiceImpl(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    //文件上传
    @Override
    public UploadResult upLoadFiles(Files files) {
        if (EMPTY.equals(files.getFileName())) {
             return new UploadResult(ResponseCode.FILE_NAME_EMPTY.getCode(),ResponseCode.FILE_NAME_EMPTY.getMsg(),null,null,null,null);
        } else if (MAX_FILE.equals(files.getFilePath())){
             return new UploadResult(ResponseCode.FILE_MAX_SIZE.getCode(),ResponseCode.FILE_MAX_SIZE.getMsg(),null,null,null,null);
        } else {
            fileMapper.insertFile(files);
            return new UploadResult(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMsg(),"数据上传成功",files.getFileName(),files.getFilePath(),files.getFileSuffix());
        }
    }

    //根据文件名获取文件信息
    @Override
    public Files getFileByFileName(String filename) {
        Files files = fileMapper.selectFileByFileName(filename);
        return files;
    }

    //将文件转化为InputStream
    @Override
    public InputStream getFileInputStream(Files files) {
        File file=new File(files.getFilePath());
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
