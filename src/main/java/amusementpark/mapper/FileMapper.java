package amusementpark.mapper;

import amusementpark.model.Fileinfo;
import amusementpark.model.Files;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.05 17:50
 */
@Mapper
public interface FileMapper {

    /**
     * 根据id获取文件
     * @param id
     * @return
     */
    Files selectFileByFileName(String filename);

    void insertFile(Files files);
}
