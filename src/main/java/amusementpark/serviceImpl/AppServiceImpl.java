package amusementpark.serviceImpl;

import amusementpark.mapper.AppMapper;
import amusementpark.model.Apkinfo;
import amusementpark.model.ResponseCode;
import amusementpark.model.Result;
import amusementpark.service.AppService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.17 11:21
 */
@Service
public class AppServiceImpl implements AppService {

  private final AppMapper appMapper;

  public AppServiceImpl(AppMapper appMapper) {
    this.appMapper = appMapper;
  }

  // 新增软件资源
  @Override
  public Result addAppFileInfo(Apkinfo apkinfo) {
    appMapper.insertFileInfo(apkinfo);
    return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), "APP资源新增成功");
  }

  /**
   * 查询所有软件资源
   *
   * @return
   */
  @Override
  public List<Apkinfo> selectAllInfo() {
    return appMapper.selectAllInfo();
  }

  /**
   * 条件查询
   *
   * @param apkinfo
   * @return
   */
  @Override
  public List<Apkinfo> selectInfo(Apkinfo apkinfo) {

    if (StringUtils.isNotBlank(apkinfo.getApktag())) {
      String tag = apkinfo.getApktag();
      apkinfo.setApklink("%" + tag + "%");
    }
    if (StringUtils.isNotBlank(apkinfo.getApktag())) {
      String name = apkinfo.getApkname();
      apkinfo.setApkname("%" + name + "%");
    }
    if (StringUtils.isNotBlank(apkinfo.getApktag())) {
      String mes = apkinfo.getApkmessage();
      apkinfo.setApkmessage("%" + mes + "%");
    }
    return appMapper.selectInfo(apkinfo);
  }

  /**
   * 修改APP资源信息
   *
   * @param apkinfo
   * @return
   */
  @Override
  public Result updateAppFileInfo(Apkinfo apkinfo) {
    appMapper.updateAppInfo(apkinfo);
    return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), "APP资源更新成功");
  }

  /**
   * 删除APP资源信息
   *
   * @param apkinfo
   * @return
   */
  @Override
  public Result deleteAppFileInfo(Apkinfo apkinfo) {
    appMapper.deleteAppInfo(apkinfo);
    return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), "APP资源删除成功");
  }

}
