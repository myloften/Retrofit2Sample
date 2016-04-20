package com.loften.retrofit2sample.bean;

import java.util.List;

/**
 * Created by loften on 16/4/19.
 */
public class GrilBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-03-06 14:11","title":"性感女神绮里嘉爆乳浴室裸体玫瑰","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_252e691406782824eec43d7eadc3d2568-760x500.jpg","url":"http://m.xxxiao.com/521"},{"ctime":"2016-03-06 14:11","title":"明星壁纸赵丽颖高清桌面","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_4f5d4bcd03ee2ef0c60bfc0e17a00ea6-760x500.jpg","url":"http://m.xxxiao.com/2004"},{"ctime":"2016-03-06 14:11","title":"静美许诺 Sabrina","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/07/m.xxxiao.com_1d5cbb3cf0d723224aa5dc740c8042d0-760x500.jpg","url":"http://m.xxxiao.com/2154"},{"ctime":"2016-03-06 14:11","title":"中国乳神峰起樊玲","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/07/m.xxxiao.com_ed8dedecf4d4a62f60528676f6649b85-760x500.jpg","url":"http://m.xxxiao.com/2187"},{"ctime":"2016-03-06 14:11","title":"乳神张优红装演绎古代美女魅惑人心写真","description":"美女图片","picUrl":"http://t1.27270.com/uploads/150725/8-150H5101Q1N6.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/50954.html"},{"ctime":"2016-03-06 14:11","title":"气质美女迷人风情艺术照","description":"美女图片","picUrl":"http://t1.27270.com/uploads/150725/8-150H5161925546.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/51890.html"},{"ctime":"2016-03-06 14:11","title":"混血美女貌美动人写真照","description":"美女图片","picUrl":"http://t1.27270.com/uploads/150727/8-150HGG92c05.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/50227.html"},{"ctime":"2016-03-06 14:11","title":"刘娅希黑色内衣大秀丰满双乳诱人照","description":"美女图片","picUrl":"http://t1.27270.com/uploads/tu/201507/378/slt.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/122561.html"},{"ctime":"2016-03-06 14:11","title":"黛欣霓爆乳野辣写真","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_952ef7f7e44e4bdaf7718d20c99d66ff4-760x500.jpg","url":"http://m.xxxiao.com/647"},{"ctime":"2016-03-06 14:11","title":"黄衫妩媚睡美人","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_6bb61e3b7bce0931da574d19d1d82c886-760x500.jpg","url":"http://m.xxxiao.com/359"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-03-06 14:11
     * title : 性感女神绮里嘉爆乳浴室裸体玫瑰
     * description : 美女图片
     * picUrl : http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_252e691406782824eec43d7eadc3d2568-760x500.jpg
     * url : http://m.xxxiao.com/521
     */

    private List<NewslistEntity> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistEntity> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistEntity> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistEntity {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
