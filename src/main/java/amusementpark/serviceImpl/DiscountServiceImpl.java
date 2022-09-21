package amusementpark.serviceImpl;

import amusementpark.mapper.DiscountInfoMapper;
import amusementpark.model.Discountinfo;
import amusementpark.model.ResponseCode;
import amusementpark.model.Result;
import amusementpark.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.02 15:59
 */
@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountInfoMapper discountInfoMapper;

    public DiscountServiceImpl(DiscountInfoMapper discountInfoMapper) {
        this.discountInfoMapper = discountInfoMapper;
    }

    @Override
    public int insertDiscount(Discountinfo discountinfo) {
        return discountInfoMapper.insertDiscountInfo(discountinfo);
    }

    @Override
    public List<Discountinfo> selectDiscountInfo() {
        return discountInfoMapper.selectDiscountInfo();
    }

    @Override
    public Result deleteDiscountInfo(Discountinfo discountinfo) {
        discountInfoMapper.deleteAppInfo(discountinfo);
        return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), "折扣信息删除成功");
    }
}
