package amusementpark.mapper;

import amusementpark.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.02.26 13:26
 */

@Mapper
public interface UserMapper {

    User isUser(User user);

    User selectTypeByUuid(@Param("uuid") String uuid);

    User userLogin(@Param("username") String username, @Param("password") String password);

    int registerUser(@Param("username") String username, @Param("password") String password);

    int updateUser(User user);

    List<User> selectUser(User user);

    int deleteUser(User user);

}
