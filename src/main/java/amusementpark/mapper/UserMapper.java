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

    public User isUser(User user);

    public User userLogin(@Param("username") String username, @Param("password") String password);

    public int registerUser(@Param("username") String username, @Param("password") String password);

    public int updateUser(User user);

    public List<User> selectUser(User user);

    public int deleteUser(User user);

}
