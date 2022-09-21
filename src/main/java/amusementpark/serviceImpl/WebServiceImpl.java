package amusementpark.serviceImpl;

import amusementpark.mapper.WebMapper;
import amusementpark.model.Webinfo;
import amusementpark.service.WebService;
import org.apache.commons.lang.StringUtils;
import org.jsoup.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.02.26 18:48
 */
@Service
public class WebServiceImpl implements WebService {

  @Autowired WebMapper webMapper;

  @Override
  public int addWebInfo(Webinfo webinfo) {
    return webMapper.addWebInfo(webinfo);
  }

  @Override
  public List<Webinfo> selectWebInfo(Webinfo webinfo) {
    webinfo.setWebuuid("");

    if (StringUtils.isNotBlank(webinfo.getWebtag())) {
      String tag = webinfo.getWebtag();
      webinfo.setWebtag("%" + tag + "%");
    }
    if (StringUtils.isNotBlank(webinfo.getWebname())) {
      String name = webinfo.getWebname();
      webinfo.setWebname("%" + name + "%");
    }
    if (StringUtils.isNotBlank(webinfo.getWebmessage())) {
      String mes = webinfo.getWebmessage();
      webinfo.setWebmessage("%" + mes + "%");
    }

    return webMapper.selectWebInfo(webinfo);
  }

  @Override
  public List<Webinfo> selectWhen(Webinfo webinfo) {
    return webMapper.selectWhen(webinfo);
  }

  @Override
  public int deleteWebInfo(Webinfo webinfo) {
    return webMapper.deleteWebInfo(webinfo);
  }

  @Override
  public int deleteWebInfoByUid(Webinfo webinfo) {
    return webMapper.deleteWebInfoByUid(webinfo);
  }

  @Override
  public int updateWebInfo(Webinfo webinfo) {
    return webMapper.updateWebInfo(webinfo);
  }
}
