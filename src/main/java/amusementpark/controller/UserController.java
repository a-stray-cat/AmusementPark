package amusementpark.controller;

import amusementpark.model.User;
import amusementpark.service.UserService;
import amusementpark.util.AESUtil;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.02.26 13:17
 */
@RestController
@RequestMapping("/user")
public class UserController {

  private final String ad = "ad";

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
   * 登录接口
   *
   * @return JSONObject
   */
  @PostMapping("/login")
  public JSONObject userLogin(@RequestBody User user) {
    JSONObject result = new JSONObject();
    int i = userService.userLogin(user);
    switch (i) {
      case 0:
        result.put("state", i);
        result.put("token", AESUtil.encrypt(user.getUsername()));
        result.put("message", "登录成功！");
        break;
      case 1:
        result.put("state", i);
        result.put("message", "密码错误！");
        break;
      default:
        result.put("state", i);
        result.put("message", "用户名不存在！");
    }
    return result;
  }

  /**
   * 添加用户
   *
   * @return JSONObject
   */
  @PostMapping("/register")
  public JSONObject registerUser(@RequestBody User user) {
    JSONObject result = new JSONObject();
    int i = userService.registerUser(user);
    switch (i) {
      case 1:
        result.put("state", i);
        result.put("message", "注册成功！");
        break;
      case 0:
        result.put("state", i);
        result.put("message", "注册失败！");
        break;
      default:
        result.put("state", i);
        result.put("message", "用户名已存在！");
    }
    return result;
  }
  /**
   * 修改用户
   *
   * @return JSONObject
   */
  @PostMapping("/update")
  public JSONObject updateUser(@RequestBody User user) {
    JSONObject result = new JSONObject();
    int i = -1;
    if ((ad).equals(user.getType())) {
      i = userService.adminUpdateUser(user);
    } else {
      i = userService.updateUser(user);
    }
    if (i == 1) {
      result.put("state", i);
      result.put("message", "修改成功！");
    } else {
      result.put("state", i);
      result.put("message", "原密码错误！");
    }
    return result;
  }

  /**
   * 查询用户
   *
   * @return List
   */
  @PostMapping("/select")
  public List<User> selectUser(@RequestBody User user) {
    if ((ad).equals(user.getType())) {
      return userService.selectUser(user);
    } else if (user.getUserToken() != null) {
      user.setUsername(AESUtil.decrypt(user.getUserToken()));
      return userService.selectUser(user);
    } else {
      return null;
    }
  }
  /**
   * 查询用户权限
   *
   * @return List
   */
  @PostMapping("/selectUser")
  public int selectUserIs(@RequestBody User user) {
    if (user.getUsername() != null && user.getPassword() != null) {
      List<String> type =
          userService.selectUser(user).stream().map(User::getType).collect(Collectors.toList());
      if (type.size() != 0) {
        if ((ad).equals(type.get(0))) {
          // 管理员
          return 99;
        } else {
          // 普通用户
          return 0;
        }
      } else {
        return -1;
      }
    } else {
      return -1;
    }
  }
  /**
   * 删除用户
   *
   * @return List
   */
  @PostMapping("/delete")
  public JSONObject deleteUser(@RequestBody User user) {
    JSONObject result = new JSONObject();
    if ((ad).equals(user.getType()) || (userService.isUser(user) != null)) {
      if (userService.deleteUser(user) == 1) {
        result.put("state", 1);
        result.put("message", "删除成功！");
      }
      return result;
    } else {
      result.put("state", 0);
      result.put("message", "删除失败！");
      return result;
    }
  }
}
