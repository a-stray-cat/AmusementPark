package amusementpark.service;

import amusementpark.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.02.26 13:23
 */

@Service
public interface UserService {

    public User isUser(User user);

    public int userLogin(User user);

    public int registerUser(User user);

    public int updateUser(User user);

    public List<User> selectUser(User user);

    public int deleteUser(User user);
}
