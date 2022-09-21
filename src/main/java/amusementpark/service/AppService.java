package amusementpark.service;

import amusementpark.model.Apkinfo;
import amusementpark.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.17 11:20
 */
@Service
public interface AppService {

    /**
     * 新增APP资源信息
     * @param apkinfo
     * @return
     */
    Result addAppFileInfo(Apkinfo apkinfo);

    /**
     * 查询所有资源信息
     * @return
     */
    List<Apkinfo> selectAllInfo();

    /**
     * 条件查询
     * @param apkinfo
     * @return
     */
    List<Apkinfo> selectInfo(Apkinfo apkinfo);

    /**
     * 修改APP资源信息
     * @param apkinfo
     * @return
     */
    Result updateAppFileInfo(Apkinfo apkinfo);

    /**
     * 新增APP资源信息
     * @param apkinfo
     * @return
     */
    Result deleteAppFileInfo(Apkinfo apkinfo);
}
