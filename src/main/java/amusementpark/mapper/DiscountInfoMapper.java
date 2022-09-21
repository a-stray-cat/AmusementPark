package amusementpark.mapper;

import amusementpark.model.Discountinfo;
import amusementpark.model.Result;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.02 16:09
 */
@Mapper
public interface DiscountInfoMapper {
    //插入信息
    int insertDiscountInfo(Discountinfo discountinfo);

    List<Discountinfo> selectDiscountInfo();

    void deleteAppInfo(Discountinfo discountinfo);
}
