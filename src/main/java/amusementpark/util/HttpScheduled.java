package amusementpark.util;

import amusementpark.controller.DiscountController;
import amusementpark.model.Discountinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.02 15:48
 */
@Component
public class HttpScheduled {
  static final int TIME = 1000 * 60 * 60 * 24;
  static final int MAX_PAGE= 6;

  @Autowired
  DiscountController discountController;

  //@Scheduled(fixedDelay = TIME)
  public void getDiscountInfo() {
    int counts = 0;
    int countf = 0;
    for (int i = 1; i < MAX_PAGE; i++) {
      List<Discountinfo> list =  new HttpClientUtil().getDiscountInfo(i);
      for (int j = 0;j < list.size(); j++) {
        int state = discountController.insertDiscountInfo(list.get(j));
        if (state == 0){
          countf++;
        } else {
          counts++;
        }
      }
    }
    System.out.println("定时任务执行成功！"+"插入成功"+counts+"条数据，插入失败"+countf+"条数据！");
  }
}
