package amusementpark.util;

import net.sf.json.JSONObject;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.02.27 14:17
 */


//工具类 封装只有两种结果的返回结果

public class Result {
  public JSONObject twoCases(int i){
      JSONObject result = new JSONObject();
      if (i == 1) {
          result.put("state", i);
          result.put("message", "成功！");
      } else {
          result.put("state", i);
          result.put("message", "失败！");
      }
      return result;
  }
}
