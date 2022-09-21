package amusementpark.controller;

import amusementpark.model.Discountinfo;
import amusementpark.model.Result;
import amusementpark.service.DiscountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.02 15:57
 */
@RestController
@RequestMapping("/discount")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    /**
     * 新增折扣信息
     * 通过定时任务获取信息
     */
    @PostMapping("/add")
    public int insertDiscountInfo(@RequestBody Discountinfo discountinfo){
        return discountService.insertDiscount(discountinfo);
    }

    /**
     * 查询折扣信息
     *
     */
    @RequestMapping("/query")
    public List<Discountinfo> selectDiscountInfo(){
        return discountService.selectDiscountInfo();
    }

    /**
     * 删除折扣信息
     *
     */
    @RequestMapping("/delete")
    public Result updateDiscountInfo(@RequestBody Discountinfo discountinfo){
        return discountService.deleteDiscountInfo(discountinfo);
    }
}
