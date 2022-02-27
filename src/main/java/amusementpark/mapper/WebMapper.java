package amusementpark.mapper;

import amusementpark.model.Webinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.02.26 18:48
 */
@Mapper
public interface WebMapper {

    int addWebInfo(Webinfo webinfo);

    List<Webinfo> selectWebInfo(Webinfo webinfo);

    List<Webinfo> selectWhen(Webinfo webinfo);

    int deleteWebInfo(Webinfo webinfo);

    int deleteWebInfoByUid(Webinfo webinfo);

    int updateWebInfo(Webinfo webinfo);
}
