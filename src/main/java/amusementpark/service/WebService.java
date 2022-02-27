package amusementpark.service;

import amusementpark.controller.WebController;
import amusementpark.model.Webinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.02.26 18:48
 */
@Service
public interface WebService {

    int addWebInfo(Webinfo webinfo);

    List<Webinfo> selectWebInfo(Webinfo webinfo);

    List<Webinfo> selectWhen(Webinfo webinfo);

    int deleteWebInfo(Webinfo webinfo);

    int deleteWebInfoByUid(Webinfo webinfo);

    int updateWebInfo(Webinfo webinfo);
}
