package amusementpark.controller;

import amusementpark.model.User;
import amusementpark.model.Webinfo;
import amusementpark.service.UserService;
import amusementpark.service.WebService;
import amusementpark.util.Result;
import net.sf.json.JSONObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.02.26 18:47
 */
@RestController
@RequestMapping("/web")
public class WebController {

  private final String ad = "ad";

  private final WebService webService;
  private final UserService userService;

  public WebController(WebService webService, UserService userService) {
    this.webService = webService;
    this.userService = userService;
  }

  @PostMapping("/add")
  public JSONObject addWebInfo(@Validated @RequestBody Webinfo webinfo) {
    Webinfo newWeb = new Webinfo();
    Result result = new Result();

    newWeb.setUid(webinfo.getUid());
    newWeb.setWeburl(webinfo.getWeburl());

    if (webService.selectWhen(newWeb).isEmpty()) {
      return result.twoCases(webService.addWebInfo(webinfo));
    } else {
      return result.twoCases(0);
    }
  }

  @PostMapping("/select")
  public List<Webinfo> selectWebInfo(@RequestBody Webinfo webinfo) {
    if (webinfo.getUid() != null && ad.equals(userService.selectTypeByUuid(webinfo.getUid()).getType())) {
      return webService.selectWebInfo(webinfo);
    }else if (webinfo.getUid() == null) {
      return webService.selectWebInfo(webinfo);
    } else {
      return webService.selectWhen(webinfo);
    }
  }

  @PostMapping("/delete")
  public JSONObject deleteWebInfo(@RequestBody Webinfo webinfo) {
    User user = userService.selectTypeByUuid(webinfo.getUid());
    Result result = new Result();
    if ((ad).equals(user.getType())) {
      return result.twoCases(webService.deleteWebInfo(webinfo));
    } else {
      return result.twoCases(webService.deleteWebInfoByUid(webinfo));
    }
  }

  @PostMapping("/update")
  public JSONObject updateWebInfo(@RequestBody Webinfo webinfo) {
    Result result = new Result();
    return result.twoCases(webService.updateWebInfo(webinfo));
  }
}
