package amusementpark.controller;

import amusementpark.model.Fileinfo;
import amusementpark.model.Result;
import amusementpark.service.SoftwareService;
import amusementpark.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.07 0:05
 */
@RestController
@RequestMapping("/software")
public class SoftwareController {

    private final String ad = "ad";

    private final SoftwareService softwareService;
    private final UserService userService;

    public SoftwareController(SoftwareService softwareService, UserService userService) {
        this.softwareService = softwareService;
        this.userService = userService;
    }

    /**
     * 查询软件资源
     * @param fileinfo
     * @return
     */
    @RequestMapping("/query")
    public List<Fileinfo> selectFileInfo(@RequestBody Fileinfo fileinfo) {
        if (fileinfo.getUid() != null && ad.equals(userService.selectTypeByUuid(fileinfo.getUid()).getType())) {
            return softwareService.selectAllInfo();
        }else if (fileinfo.getUid() == null && fileinfo.getSoftwaretag() == null) {
            return softwareService.selectAllInfo();
        } else {
            return softwareService.selectInfo(fileinfo);
        }
    }

    /**
     * 新增资源信息
     * @param fileinfo
     * @return
     */
    @PostMapping("/addinfo")
    public Result uploadInfo(@RequestBody Fileinfo fileinfo) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        fileinfo.setArticleid(uuid);
        return softwareService.uploadFilesInfo(fileinfo);
    }

    /**
     * 更新资源信息
     * @param fileinfo
     * @return
     */
    @PostMapping("/updateinfo")
    public Result updateInfo(@RequestBody Fileinfo fileinfo) {
        return softwareService.updateFilesInfo(fileinfo);
    }

    /**
     * 删除资源信息
     * @param fileinfo
     * @return
     */
    @PostMapping("/deleteinfo")
    public Result deleteInfo(@RequestBody Fileinfo fileinfo) {
        return softwareService.deleteFilesInfo(fileinfo);
    }
}
