package amusementpark.controller;

import amusementpark.model.Fileinfo;
import amusementpark.model.ResponseCode;
import amusementpark.model.Result;
import amusementpark.model.UploadResult;
import amusementpark.service.FileService;
import amusementpark.util.DownloadUtil;
import amusementpark.util.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.05 16:24
 */
@RestController
@RequestMapping("/file")
public class FileController {

  private final FileService fileService;

  public FileController(FileService fileService) {
    this.fileService = fileService;
  }

  /**
   * 文件上传
   * @param multipartFiles
   * @return
   */
  @PostMapping("/upload")
  public List<UploadResult> upLoadFiles(MultipartFile[] multipartFiles) {
    ArrayList<UploadResult> list = new ArrayList<UploadResult>();
    if (multipartFiles[0].isEmpty()) {
      list.add(
              new UploadResult(ResponseCode.FILE_EMPTY.getCode(), ResponseCode.FILE_EMPTY.getMsg(), null,null,null,null));
      return list;
    } else {
      for (MultipartFile multipartFile : multipartFiles) {
        list.add(fileService.upLoadFiles(UploadFileUtil.uploadFile(multipartFile)));
      }
      return list;
    }
  }

  /**
   * 文件下载
   * @param filename
   * @param request
   * @param response
   */
  @RequestMapping(value = "/download/{filename}")
  public void downloadFiles(
      @PathVariable("filename") String filename, HttpServletRequest request, HttpServletResponse response) {
    DownloadUtil.downloadFile(filename,response,fileService);
  }
}
