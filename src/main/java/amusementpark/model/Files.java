package amusementpark.model;

import java.io.Serializable;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.05 17:56
 */
public class Files implements Serializable {

    private static final long serialVersionUID=1L;
    /**
     * 文件存储路径
     */
    private String filePath;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件后缀名
     */
    private String fileSuffix;

    /**
     * 文件存储新文件名
     */
    private String newFileName;

    public Files() {
    }

    public Files(String filePath, String fileName, String fileSuffix, String newFileName) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileSuffix = fileSuffix;
        this.newFileName = newFileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    @Override
    public String toString() {
        return "Files{" +
                "filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileSuffix='" + fileSuffix + '\'' +
                ", newFileName='" + newFileName + '\'' +
                '}';
    }
}
