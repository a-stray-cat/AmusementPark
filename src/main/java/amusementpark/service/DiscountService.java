package amusementpark.service;

import amusementpark.model.Discountinfo;
import amusementpark.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.02 15:59
 */
@Service
public interface DiscountService {

    //插入信息
    int insertDiscount(Discountinfo discountinfo);

    List<Discountinfo> selectDiscountInfo();

    Result deleteDiscountInfo(Discountinfo discountinfo);

}
