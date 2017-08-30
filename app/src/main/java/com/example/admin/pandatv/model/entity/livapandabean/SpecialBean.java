package com.example.admin.pandatv.model.entity.livapandabean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by LiYRong on 2017/8/28.
 *
 * 这是熊猫直播特别节目的bean
 */

public class SpecialBean {

    /**
     * videoset : {"0":{"vsid":"VSET100167308855","relvsid":"","name":"熊猫频道-特别节目","img":"http://p1.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809044488847.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167308855","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"2013-05-01","sbpd":"其他","desc":"熊猫频道采访野生动物保护专家、熊猫守护使、到访基地的名人，以人类的角度展现熊猫世界。","playdesc":"","zcr":"","fcl":""},"count":"262"}
     * video : [{"vsid":"VSET100167308855","order":"256","vid":"7d826d24b4e443ad88dd59ad03d50dfe","t":"《特别节目》 20170828 大熊猫竟然每天都要干这些事情无数次！","url":"http://tv.cntv.cn/video/VSET100167308855/7d826d24b4e443ad88dd59ad03d50dfe","ptime":"2017-08-28 14:56:34","img":"http://p3.img.cctvpic.com/fmspic/2017/08/28/7d826d24b4e443ad88dd59ad03d50dfe-43.jpg?p=2&h=120","len":"00:01:05","em":"CM01"},{"vsid":"VSET100167308855","order":"255","vid":"51ad9c0361ee4eea87f6c4b1dc09880a","t":"《特别节目》 20170828 七夕之单身狗们的福利","url":"http://tv.cntv.cn/video/VSET100167308855/51ad9c0361ee4eea87f6c4b1dc09880a","ptime":"2017-08-28 14:46:03","img":"http://p2.img.cctvpic.com/fmspic/2017/08/28/51ad9c0361ee4eea87f6c4b1dc09880a-36.jpg?p=2&h=120","len":"00:00:51","em":"CM01"},{"vsid":"VSET100167308855","order":"254","vid":"f197b5c8b0a2449b9d82ab8adb00c006","t":"《特别节目》 幸福的\u201c胖哒\u201d","url":"http://tv.cntv.cn/video/VSET100167308855/f197b5c8b0a2449b9d82ab8adb00c006","ptime":"2017-08-26 21:50:00","img":"http://p4.img.cctvpic.com/fmspic/2017/08/27/f197b5c8b0a2449b9d82ab8adb00c006-1690.jpg?p=2&h=120","len":"00:56:02","em":"CM01"},{"vsid":"VSET100167308855","order":"253","vid":"c38d42416d604d97bba556438e459a2d","t":"《特别节目》 20170825 斧头山\u201c吻熊大盗\u201d--梅奶妈","url":"http://tv.cntv.cn/video/VSET100167308855/c38d42416d604d97bba556438e459a2d","ptime":"2017-08-25 15:19:43","img":"http://p3.img.cctvpic.com/fmspic/2017/08/25/c38d42416d604d97bba556438e459a2d-129.jpg?p=2&h=120","len":"00:04:42","em":"CM01"},{"vsid":"VSET100167308855","order":"252","vid":"a21f061b34784b8d8fc5894c47f9be57","t":"《大熊猫生日季》 20170823 超级明星\u201c宝宝\u201d的生日趴！","url":"http://tv.cntv.cn/video/VSET100167308855/a21f061b34784b8d8fc5894c47f9be57","ptime":"2017-08-23 11:24:53","img":"http://p5.img.cctvpic.com/fmspic/2017/08/23/a21f061b34784b8d8fc5894c47f9be57-1272.jpg?p=2&h=120","len":"00:42:22","em":"CM01"},{"vsid":"VSET100167308855","order":"251","vid":"4f1bd9a98eb845ddbc0a4a8b27f71062","t":"《在现场》 20170822 抱西瓜瞧好戏！看奶爸如何应对三个\u201c熊孩子\u201d","url":"http://tv.cntv.cn/video/VSET100167308855/4f1bd9a98eb845ddbc0a4a8b27f71062","ptime":"2017-08-22 10:38:39","img":"http://p3.img.cctvpic.com/fmspic/2017/08/22/4f1bd9a98eb845ddbc0a4a8b27f71062-1929.jpg?p=2&h=120","len":"01:03:37","em":"CM01"},{"vsid":"VSET100167308855","order":"250","vid":"d7d1820649cc428eb3f481a43b32ddb8","t":"《网红小灰灰\u201c成实\u201d一岁生日快乐》 20170819","url":"http://tv.cntv.cn/video/VSET100167308855/d7d1820649cc428eb3f481a43b32ddb8","ptime":"2017-08-19 10:09:18","img":"http://p2.img.cctvpic.com/fmspic/2017/08/19/d7d1820649cc428eb3f481a43b32ddb8-1809.jpg?p=2&h=120","len":"00:59:32","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100167308855","relvsid":"","name":"熊猫频道-特别节目","img":"http://p1.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809044488847.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167308855","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"2013-05-01","sbpd":"其他","desc":"熊猫频道采访野生动物保护专家、熊猫守护使、到访基地的名人，以人类的角度展现熊猫世界。","playdesc":"","zcr":"","fcl":""}
         * count : 262
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100167308855
             * relvsid :
             * name : 熊猫频道-特别节目
             * img : http://p1.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809044488847.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167308855
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl : 熊猫直播
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 熊猫频道采访野生动物保护专家、熊猫守护使、到访基地的名人，以人类的角度展现熊猫世界。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100167308855
         * order : 256
         * vid : 7d826d24b4e443ad88dd59ad03d50dfe
         * t : 《特别节目》 20170828 大熊猫竟然每天都要干这些事情无数次！
         * url : http://tv.cntv.cn/video/VSET100167308855/7d826d24b4e443ad88dd59ad03d50dfe
         * ptime : 2017-08-28 14:56:34
         * img : http://p3.img.cctvpic.com/fmspic/2017/08/28/7d826d24b4e443ad88dd59ad03d50dfe-43.jpg?p=2&h=120
         * len : 00:01:05
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}
