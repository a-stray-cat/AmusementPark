package amusementpark.mapper;

import amusementpark.model.Apkinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.17 11:20
 */
@Mapper
public interface AppMapper {
    /**
     * 新增软件资源信息
     * @param apkinfo
     */
    void insertFileInfo(Apkinfo apkinfo);

    /**
     * 查询所有软件资源
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
     * 更新软件资源信息
     * @param apkinfo
     */
    void updateAppInfo(Apkinfo apkinfo);

    void deleteAppInfo(Apkinfo apkinfo);
}
