package amusementpark.mapper;

import amusementpark.model.Fileinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.07 0:05
 */
@Mapper
public interface SoftwareMapper {

    /**
     * 新增软件资源信息
     * @param fileinfo
     */
    void insertFileInfo(Fileinfo fileinfo);

    /**
     * 查询所有软件资源
     * @return
     */
    List<Fileinfo> selectAllInfo();

    /**
     * 条件查询
     * @param fileinfo
     * @return
     */
    List<Fileinfo> selectInfo(Fileinfo fileinfo);

    /**
     * 更新软件资源信息
     * @param fileinfo
     */
    void updateFileInfo(Fileinfo fileinfo);

    /**
     * 删除软件资源信息
     * @param fileinfo
     */
    void deleteFileInfo(Fileinfo fileinfo);

}
