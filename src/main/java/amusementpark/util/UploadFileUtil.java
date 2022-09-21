package amusementpark.util;

import amusementpark.model.Files;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.05 22:33
 */

public class UploadFileUtil {

  private static final String SAVE_PATH = "D:/uploadTest/";

  public static Files uploadFile(MultipartFile file) {

    Files state = new Files();
    // 设置支持最大上传的文件，这里是1024*1024*2=2M
    long MAX_SIZE = 20971520L;
    // 获取要上传文件的名称
    String fileName = file.getOriginalFilename();
    // 如果名称为空，返回一个文件名为空的错误
    if (StringUtils.isEmpty(fileName)) {
      state.setFileName("为空");
      return state;
    }
    // 如果文件超过最大值，返回超出可上传最大值的错误
    if (file.getSize() > MAX_SIZE) {
      state.setFilePath("大于");
      return state;
    }
    // 获取到后缀名
    String suffixName =
        fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : null;
    // 文件的保存重新按照时间戳命名
    String newFileName = String.valueOf(System.currentTimeMillis());
    String newName = newFileName + suffixName;
    File newFile = new File(SAVE_PATH, newName);
    if (!newFile.getParentFile().exists()) {
      newFile.getParentFile().mkdirs();
    }
    try {
      // 文件写入
      file.transferTo(newFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
    // 将这些文件的信息写入到数据库中
    return new Files(newFile.getPath(), fileName, suffixName, newFileName);
  }
}
