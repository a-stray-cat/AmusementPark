package amusementpark.serviceImpl;

import amusementpark.mapper.UserMapper;
import amusementpark.model.User;
import amusementpark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.02.26 13:28
 */
@Service
public class UserServiceImpl implements UserService {


  @Autowired
  UserMapper userMapper;

  @Override
  public User isUser(User user) {
    return userMapper.isUser(user);
  }

  @Override
  public int userLogin(User user) {

    int i = -1;//默认登录失败

    User isUser = userMapper.isUser(user);
    if (isUser != null) {
      User isTrue = userMapper.userLogin(user.getUsername(), user.getPassword());
      if (isTrue == null) {
        i = 1;//密码错误
      } else {
        i = 0;//登录成功
      }
    }
    return i;
  }

  @Override
  public int registerUser(User user) {
    User isUser = userMapper.isUser(user);
    int i = -1;//用户名存在
    if (isUser == null) {
      i = userMapper.registerUser(user.getUsername(), user.getPassword());
    }
    return i;
  }

  @Override
  public int updateUser(User user) {
    User isUser = userMapper.isUser(user);
    int i = -1;//密码错误
    if (isUser != null) {
      user.setPassword(user.getNewp());
      i = userMapper.updateUser(user);
    }
    return i;
  }

  @Override
  public List<User> selectUser(User user) {
      return userMapper.selectUser(user);
  }

  @Override
  public int deleteUser(User user) {
    return userMapper.deleteUser(user);
  }
}
