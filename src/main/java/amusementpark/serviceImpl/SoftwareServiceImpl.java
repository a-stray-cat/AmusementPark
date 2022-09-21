package amusementpark.serviceImpl;

import amusementpark.mapper.SoftwareMapper;
import amusementpark.model.Fileinfo;
import amusementpark.model.ResponseCode;
import amusementpark.model.Result;
import amusementpark.service.SoftwareService;
import org.apache.commons.lang.StringUtils;
import org.jsoup.internal.StringUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.07 0:06
 */
@Service
public class SoftwareServiceImpl implements SoftwareService {

  private final SoftwareMapper softwareMapper;

  public SoftwareServiceImpl(SoftwareMapper softwareMapper) {
    this.softwareMapper = softwareMapper;
  }

  // 新增软件资源
  @Override
  public Result uploadFilesInfo(Fileinfo fileinfo) {
    softwareMapper.insertFileInfo(fileinfo);
    return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), "软件资源新增成功");
  }

  /**
   * 查询所有软件资源
   * @return
   */
  @Override
  public List<Fileinfo> selectAllInfo() {
    return softwareMapper.selectAllInfo();
  }

  /**
   * 条件查询
   * @param fileinfo
   * @return
   */
  @Override
  public List<Fileinfo> selectInfo(Fileinfo fileinfo) {

    if (StringUtils.isNotBlank(fileinfo.getSoftwaretag())) {
      String tag = fileinfo.getSoftwaretag();
      fileinfo.setSoftwaretag("%" + tag + "%");
    }
    if (StringUtils.isNotBlank(fileinfo.getFilename())) {
      String name = fileinfo.getFilename();
      fileinfo.setFilename("%" + name + "%");
    }
    if (StringUtils.isNotBlank(fileinfo.getSoftwaremessage())) {
      String mes = fileinfo.getSoftwaremessage();
      fileinfo.setSoftwaremessage("%" + mes + "%");
    }
    return softwareMapper.selectInfo(fileinfo);
  }


  /**
   * 更新软件资源信息
   * @return
   */
  @Override
  public Result updateFilesInfo(Fileinfo fileinfo) {
    if (fileinfo.getArticleid() != null && (!Objects.equals(fileinfo.getArticleid(), ""))) {
      softwareMapper.updateFileInfo(fileinfo);
      return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), "软件资源更新成功");
    } else {
      return new Result(ResponseCode.ID_EMPTY.getCode(), ResponseCode.ID_EMPTY.getMsg(), null);
    }
  }

  /**
   * 删除软件资源信息
   * @return
   */
  @Override
  public Result deleteFilesInfo(Fileinfo fileinfo) {
    if (fileinfo.getArticleid() != null && (!Objects.equals(fileinfo.getArticleid(), ""))) {
      softwareMapper.deleteFileInfo(fileinfo);
      return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), "软件资源删除成功");
    } else {
      return new Result(ResponseCode.ID_EMPTY.getCode(), ResponseCode.ID_EMPTY.getMsg(), null);
    }
  }
}
