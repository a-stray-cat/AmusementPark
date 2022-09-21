package amusementpark.controller;

import amusementpark.model.Apkinfo;
import amusementpark.model.Result;
import amusementpark.service.AppService;
import amusementpark.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.17 11:20
 */
@RestController
@RequestMapping("/app")
public class AppController {

  private final String ad = "ad";
  private final AppService appService;
  private final UserService userService;

  public AppController(AppService appService, UserService userService) {
    this.appService = appService;
    this.userService = userService;
  }

  /**
   * 查询APP资源信息
   *
   * @param apkinfo
   * @return
   */
  @RequestMapping("/query")
  public List<Apkinfo> selectFileInfo(@RequestBody Apkinfo apkinfo) {
    if (apkinfo.getUid() != null && ad.equals(userService.selectTypeByUuid(apkinfo.getUid()).getType())) {
      return appService.selectAllInfo();
    }else if (apkinfo.getUid() == null  && apkinfo.getApktag() == null) {
      return appService.selectAllInfo();
    } else {
      return appService.selectInfo(apkinfo);
    }
  }

  /**
   * 新增APP资源信息
   *
   * @param apkinfo
   * @return
   */
  @PostMapping("/addinfo")
  public Result addInfo(@RequestBody Apkinfo apkinfo) {
    return appService.addAppFileInfo(apkinfo);
  }

  /**
   * 修改APP资源信息
   *
   * @param apkinfo
   * @return
   */
  @PostMapping("/updateinfo")
  public Result updateInfo(@RequestBody Apkinfo apkinfo) {
    return appService.updateAppFileInfo(apkinfo);
  }

  /**
   * 删除APP资源信息
   *
   * @param apkinfo
   * @return
   */
  @PostMapping("/deleteinfo")
  public Result deleteInfo(@RequestBody Apkinfo apkinfo) {
    return appService.deleteAppFileInfo(apkinfo);
  }
}
