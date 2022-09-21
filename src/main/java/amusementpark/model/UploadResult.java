package amusementpark.model;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.04.06 11:32
 */
public class UploadResult extends Result{

    private int code;
    private String message;
    private Object data;
    private String fileName;
    private String filePath;
    private String filesuffix;

    public UploadResult() {
    }

    public UploadResult(int code, String message, Object data, String fileName, String filePath, String filesuffix) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.fileName = fileName;
        this.filePath = filePath;
        this.filesuffix = filesuffix;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilesuffix() {
        return filesuffix;
    }

    public void setFilesuffix(String filesuffix) {
        this.filesuffix = filesuffix;
    }

    @Override
    public String toString() {
        return "UploadResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", filesuffix='" + filesuffix + '\'' +
                '}';
    }
}
