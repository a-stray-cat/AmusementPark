package amusementpark.service;

import amusementpark.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.02.26 13:23
 */

@Service
public interface UserService {

    User isUser(User user);

    User selectTypeByUuid(@Param("uuid") String uuid);

    int userLogin(User user);

    int registerUser(User user);

    int updateUser(User user);

    int adminUpdateUser(User user);

    List<User> selectUser(User user);

    int deleteUser(User user);
}
