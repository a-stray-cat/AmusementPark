package amusementpark.model;

public class Webinfo {
    /**
     * 网站的唯一标识
     */
    private String webuuid;

    /**
     * 用户ID
     */
    private String uid;

    /**
     * 网站名称
     */
    private String webname;

    /**
     * 网站地址
     */
    private String weburl;

    /**
     * 网站说明
     */
    private String webmessage;

    /**
     * 分类标签
     */
    private String webtag;

    public String getWebuuid() {
        return webuuid;
    }

    public void setWebuuid(String webuuid) {
        this.webuuid = webuuid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getWebname() {
        return webname;
    }

    public void setWebname(String webname) {
        this.webname = webname;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public String getWebmessage() {
        return webmessage;
    }

    public void setWebmessage(String webmessage) {
        this.webmessage = webmessage;
    }

    public String getWebtag() {
        return webtag;
    }

    public void setWebtag(String webtag) {
        this.webtag = webtag;
    }
}