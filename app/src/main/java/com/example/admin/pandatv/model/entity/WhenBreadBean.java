package com.example.admin.pandatv.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by LiYRong on 2017/8/28.
 *
 * 这里是当熊更不让的bean类
 */

public class WhenBreadBean {

    /**
     * videoset : {"0":{"vsid":"VSET100332640004","relvsid":"","name":"当熊不让","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/3/15/VSETgpbnd9sJ0BP2qfKq00j2170315.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100332640004","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"其他","desc":"新节目《当熊不让》上线啦！每周五盘点当周最火视频和图片，让你一次看遍人气熊猫！","playdesc":"","zcr":"","fcl":""},"count":"24"}
     * video : [{"vsid":"VSET100332640004","order":"24","vid":"026839787dfb4eb597e724e835b44782","t":"《当熊不让》 20170825 第二十四期：大熊猫生日扎堆是什么体验？","url":"http://tv.cntv.cn/video/VSET100332640004/026839787dfb4eb597e724e835b44782","ptime":"2017-08-25 12:19:27","img":"http://p4.img.cctvpic.com/fmspic/2017/08/25/026839787dfb4eb597e724e835b44782-69.jpg?p=2&h=120","len":"00:01:58","em":"CM01"},{"vsid":"VSET100332640004","order":"23","vid":"dee52ff49d7c440baa78a9aa338ccf67","t":"《当熊不让》 20170818 第二十三期：你要的萌态我都有","url":"http://tv.cntv.cn/video/VSET100332640004/dee52ff49d7c440baa78a9aa338ccf67","ptime":"2017-08-18 13:12:40","img":"http://p5.img.cctvpic.com/fmspic/2017/08/18/dee52ff49d7c440baa78a9aa338ccf67-50.jpg?p=2&h=120","len":"00:01:47","em":"CM01"},{"vsid":"VSET100332640004","order":"22","vid":"35dbfb5c78d54e23ba328ce7d083c1cd","t":"《当熊不让》 20170811 第二十二期：悄悄告诉你，家门口才是风水宝地","url":"http://tv.cntv.cn/video/VSET100332640004/35dbfb5c78d54e23ba328ce7d083c1cd","ptime":"2017-08-11 13:35:44","img":"http://p4.img.cctvpic.com/fmspic/2017/08/11/35dbfb5c78d54e23ba328ce7d083c1cd-50.jpg?p=2&h=120","len":"00:01:16","em":"CM01"},{"vsid":"VSET100332640004","order":"21","vid":"85497ad11a39407ca5e03f8952d0d7e3","t":"《当熊不让》 20170728 第二十一期：见过美的，没见过我这么美的！","url":"http://tv.cntv.cn/video/VSET100332640004/85497ad11a39407ca5e03f8952d0d7e3","ptime":"2017-07-28 15:10:53","img":"http://p1.img.cctvpic.com/fmspic/2017/07/28/85497ad11a39407ca5e03f8952d0d7e3-50.jpg?p=2&h=120","len":"00:01:39","em":"CM01"},{"vsid":"VSET100332640004","order":"20","vid":"19726f36d1cc4299b16e881fe0a2a8ab","t":"《当熊不让》 20170721 第二十期：国内\u2014新生团子美颜盛世稳坐榜首","url":"http://tv.cntv.cn/video/VSET100332640004/19726f36d1cc4299b16e881fe0a2a8ab","ptime":"2017-07-21 12:51:41","img":"http://p3.img.cctvpic.com/fmspic/2017/07/21/19726f36d1cc4299b16e881fe0a2a8ab-50.jpg?p=2&h=120","len":"00:01:37","em":"CM01"},{"vsid":"VSET100332640004","order":"19","vid":"77ee585276254a8d920114ce312f87d1","t":"《当熊不让》 20170714 第十九期：热在三伏天，不服都不行","url":"http://tv.cntv.cn/video/VSET100332640004/77ee585276254a8d920114ce312f87d1","ptime":"2017-07-14 13:19:43","img":"http://p1.img.cctvpic.com/fmspic/2017/07/14/77ee585276254a8d920114ce312f87d1-79.jpg?p=2&h=120","len":"00:02:18","em":"CM01"},{"vsid":"VSET100332640004","order":"18","vid":"19852d41dcc74d4dadcc66b91c6d258d","t":"《当熊不让》 20170707 第十八期：想要伺候\u201c灰大王\u201d，得先练有个好手艺！","url":"http://tv.cntv.cn/video/VSET100332640004/19852d41dcc74d4dadcc66b91c6d258d","ptime":"2017-07-07 15:06:35","img":"http://p3.img.cctvpic.com/fmspic/2017/07/07/19852d41dcc74d4dadcc66b91c6d258d-70.jpg?p=2&h=120","len":"00:01:59","em":"CM01"}]
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
         * 0 : {"vsid":"VSET100332640004","relvsid":"","name":"当熊不让","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/3/15/VSETgpbnd9sJ0BP2qfKq00j2170315.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100332640004","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"其他","desc":"新节目《当熊不让》上线啦！每周五盘点当周最火视频和图片，让你一次看遍人气熊猫！","playdesc":"","zcr":"","fcl":""}
         * count : 24
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
             * vsid : VSET100332640004
             * relvsid :
             * name : 当熊不让
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/3/15/VSETgpbnd9sJ0BP2qfKq00j2170315.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100332640004
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl : 熊猫直播
             * sbsj :
             * sbpd : 其他
             * desc : 新节目《当熊不让》上线啦！每周五盘点当周最火视频和图片，让你一次看遍人气熊猫！
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
         * vsid : VSET100332640004
         * order : 24
         * vid : 026839787dfb4eb597e724e835b44782
         * t : 《当熊不让》 20170825 第二十四期：大熊猫生日扎堆是什么体验？
         * url : http://tv.cntv.cn/video/VSET100332640004/026839787dfb4eb597e724e835b44782
         * ptime : 2017-08-25 12:19:27
         * img : http://p4.img.cctvpic.com/fmspic/2017/08/25/026839787dfb4eb597e724e835b44782-69.jpg?p=2&h=120
         * len : 00:01:58
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
