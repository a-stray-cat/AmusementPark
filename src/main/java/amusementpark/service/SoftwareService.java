package amusementpark.service;

import amusementpark.model.Fileinfo;
import amusementpark.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.07 0:04
 */
@Service
public interface SoftwareService {
    /**
     * 新增软件资源信息
     * @param fileinfo
     * @return
     */
    Result uploadFilesInfo(Fileinfo fileinfo);

    /**
     * 查询所有资源信息
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
     * @return
     */
    Result updateFilesInfo(Fileinfo fileinfo);

    /**
     * 删除软件资源信息
     * @param fileinfo
     * @return
     */
    Result deleteFilesInfo(Fileinfo fileinfo);
}
