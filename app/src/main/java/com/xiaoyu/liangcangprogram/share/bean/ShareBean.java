package com.xiaoyu.liangcangprogram.share.bean;

import java.util.List;

/**
 * Created by yuxiaobai on 2017/1/9.
 */

public class ShareBean {

    /**
     * meta : {"status":0,"server_time":"2017-01-09 11:22:20","account_id":0,"cost":0.125663,"errdata":null,"errmsg":""}
     * version : 1
     * data : {"has_more":true,"num_items":"13924","items":[{"goods_id":"255553","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255553.jpg","goods_name":"InstincToy Muckey","price":"0","owner_id":"1000035635","comment_count":"13","like_count":"15","liked":"0","sale_by":"other","goods_url":"https://www.amazon.com/INSTINCTOY-Mukki-mini-Muckey-Thailand/dp/B01JU6AVS0/ref=sr_1_1?s=boost&amp;ie=UTF8&amp;qid=1479894550&amp;sr=1-1&amp;keywords=InstincToy+Muckey","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255550","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255550.jpg","goods_name":"Anatomical Balloon Dog","price":"0","owner_id":"1000035635","comment_count":"6","like_count":"63","liked":"0","sale_by":"other","goods_url":"https://www.amazon.com/4D-Master-Balloon-Dog-Anatomy/dp/B018JAZ9E4/ref=sr_1_1?s=boost&amp;ie=UTF8&amp;qid=1479892597&amp;sr=1-1&amp;keywords=Anatomical+Balloon+Dog","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255547","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255547.jpg","goods_name":"Aventon Mataro Fixed Gear Bike","price":"0","owner_id":"1000035635","comment_count":"7","like_count":"16","liked":"0","sale_by":"other","goods_url":"https://www.aventon.com/","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255545","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255545.jpg","goods_name":"Doctor Martins Shoes","price":"0","owner_id":"1000035635","comment_count":"7","like_count":"110","liked":"0","sale_by":"other","goods_url":"http://www.drmartens.com/us/","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255538","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255538.jpg","goods_name":"\"Me Talk Pretty One Day\" by David Sedaris","price":"0","owner_id":"1000035635","comment_count":"5","like_count":"9","liked":"0","sale_by":"other","goods_url":"https://www.amazon.com/Me-Talk-Pretty-One-Day/dp/0316776963/ref=sr_1_1?s=boost&amp;ie=UTF8&amp;qid=1479890100&amp;sr=1-1&amp;keywords=%22Me+Talk+Pretty+One+Day%22+by+David+Sedaris","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255533","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255533.jpg","goods_name":"The Chunkies by Alex Solis","price":"0","owner_id":"1000035636","comment_count":"1","like_count":"2","liked":"0","sale_by":"other","goods_url":"https://www.kickstarter.com/projects/alexmdc/famous-chunkies","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255532","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255532.jpg","goods_name":"Adrift II by James Jean","price":"0","owner_id":"1000035636","comment_count":"4","like_count":"10","liked":"0","sale_by":"other","goods_url":"http://411posters.com/2016/11/adrift-ii-by-james-jean/","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255531","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255531.jpg","goods_name":"MYO gesture control armband肌肉控制臂环","price":"0","owner_id":"1000035636","comment_count":"1","like_count":"10","liked":"0","sale_by":"other","goods_url":"https://www.amazon.com/Myo-Gesture-Control-Armband-Black/dp/B00O66E58M/ref=sr_1_1?ie=UTF8&amp;qid=1479887035&amp;sr=8-1&amp;keywords=MYO+gesture+control+armband","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255530","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255530.jpg","goods_name":"RHA A750i Isolating in-ear headphones","price":"0","owner_id":"1000035636","comment_count":"4","like_count":"7","liked":"0","sale_by":"other","goods_url":"https://www.amazon.com/RHA-MA750i-Isolating-Headphone-Microphone/dp/B00ELAM8NC/ref=sr_1_fkmr0_2?ie=UTF8&amp;qid=1479886890&amp;sr=8-2-fkmr0&amp;keywords=RHA+A750i+Isolating+in-ear+headphones","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255529","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255529.jpg","goods_name":"UNIQLO Supima Cotton crew neck tee","price":"0","owner_id":"1000035636","comment_count":"0","like_count":"1","liked":"0","sale_by":"other","goods_url":"https://detail.tmall.com/item.htm?id=43745513298","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"}]}
     */

    private MetaBean meta;
    private int version;
    private DataBean data;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class MetaBean {
        /**
         * status : 0
         * server_time : 2017-01-09 11:22:20
         * account_id : 0
         * cost : 0.125663
         * errdata : null
         * errmsg :
         */

        private int status;
        private String server_time;
        private int account_id;
        private double cost;
        private Object errdata;
        private String errmsg;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getServer_time() {
            return server_time;
        }

        public void setServer_time(String server_time) {
            this.server_time = server_time;
        }

        public int getAccount_id() {
            return account_id;
        }

        public void setAccount_id(int account_id) {
            this.account_id = account_id;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public Object getErrdata() {
            return errdata;
        }

        public void setErrdata(Object errdata) {
            this.errdata = errdata;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }
    }

    public static class DataBean {
        /**
         * has_more : true
         * num_items : 13924
         * items : [{"goods_id":"255553","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255553.jpg","goods_name":"InstincToy Muckey","price":"0","owner_id":"1000035635","comment_count":"13","like_count":"15","liked":"0","sale_by":"other","goods_url":"https://www.amazon.com/INSTINCTOY-Mukki-mini-Muckey-Thailand/dp/B01JU6AVS0/ref=sr_1_1?s=boost&amp;ie=UTF8&amp;qid=1479894550&amp;sr=1-1&amp;keywords=InstincToy+Muckey","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255550","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255550.jpg","goods_name":"Anatomical Balloon Dog","price":"0","owner_id":"1000035635","comment_count":"6","like_count":"63","liked":"0","sale_by":"other","goods_url":"https://www.amazon.com/4D-Master-Balloon-Dog-Anatomy/dp/B018JAZ9E4/ref=sr_1_1?s=boost&amp;ie=UTF8&amp;qid=1479892597&amp;sr=1-1&amp;keywords=Anatomical+Balloon+Dog","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255547","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255547.jpg","goods_name":"Aventon Mataro Fixed Gear Bike","price":"0","owner_id":"1000035635","comment_count":"7","like_count":"16","liked":"0","sale_by":"other","goods_url":"https://www.aventon.com/","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255545","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255545.jpg","goods_name":"Doctor Martins Shoes","price":"0","owner_id":"1000035635","comment_count":"7","like_count":"110","liked":"0","sale_by":"other","goods_url":"http://www.drmartens.com/us/","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255538","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255538.jpg","goods_name":"\"Me Talk Pretty One Day\" by David Sedaris","price":"0","owner_id":"1000035635","comment_count":"5","like_count":"9","liked":"0","sale_by":"other","goods_url":"https://www.amazon.com/Me-Talk-Pretty-One-Day/dp/0316776963/ref=sr_1_1?s=boost&amp;ie=UTF8&amp;qid=1479890100&amp;sr=1-1&amp;keywords=%22Me+Talk+Pretty+One+Day%22+by+David+Sedaris","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255533","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255533.jpg","goods_name":"The Chunkies by Alex Solis","price":"0","owner_id":"1000035636","comment_count":"1","like_count":"2","liked":"0","sale_by":"other","goods_url":"https://www.kickstarter.com/projects/alexmdc/famous-chunkies","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255532","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255532.jpg","goods_name":"Adrift II by James Jean","price":"0","owner_id":"1000035636","comment_count":"4","like_count":"10","liked":"0","sale_by":"other","goods_url":"http://411posters.com/2016/11/adrift-ii-by-james-jean/","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255531","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255531.jpg","goods_name":"MYO gesture control armband肌肉控制臂环","price":"0","owner_id":"1000035636","comment_count":"1","like_count":"10","liked":"0","sale_by":"other","goods_url":"https://www.amazon.com/Myo-Gesture-Control-Armband-Black/dp/B00O66E58M/ref=sr_1_1?ie=UTF8&amp;qid=1479887035&amp;sr=8-1&amp;keywords=MYO+gesture+control+armband","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255530","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255530.jpg","goods_name":"RHA A750i Isolating in-ear headphones","price":"0","owner_id":"1000035636","comment_count":"4","like_count":"7","liked":"0","sale_by":"other","goods_url":"https://www.amazon.com/RHA-MA750i-Isolating-Headphone-Microphone/dp/B00ELAM8NC/ref=sr_1_fkmr0_2?ie=UTF8&amp;qid=1479886890&amp;sr=8-2-fkmr0&amp;keywords=RHA+A750i+Isolating+in-ear+headphones","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"},{"goods_id":"255529","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255529.jpg","goods_name":"UNIQLO Supima Cotton crew neck tee","price":"0","owner_id":"1000035636","comment_count":"0","like_count":"1","liked":"0","sale_by":"other","goods_url":"https://detail.tmall.com/item.htm?id=43745513298","is_gift":0,"discount_price":"0","coupon_flag":"False","promotion_imgurl":"null"}]
         */

        private boolean has_more;
        private String num_items;
        private List<ItemsBean> items;

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public String getNum_items() {
            return num_items;
        }

        public void setNum_items(String num_items) {
            this.num_items = num_items;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * goods_id : 255553
             * goods_image : http://imgs-qn.iliangcang.com/ware/goods/big/2/255/255553.jpg
             * goods_name : InstincToy Muckey
             * price : 0
             * owner_id : 1000035635
             * comment_count : 13
             * like_count : 15
             * liked : 0
             * sale_by : other
             * goods_url : https://www.amazon.com/INSTINCTOY-Mukki-mini-Muckey-Thailand/dp/B01JU6AVS0/ref=sr_1_1?s=boost&amp;ie=UTF8&amp;qid=1479894550&amp;sr=1-1&amp;keywords=InstincToy+Muckey
             * is_gift : 0
             * discount_price : 0
             * coupon_flag : False
             * promotion_imgurl : null
             */

            private String goods_id;
            private String goods_image;
            private String goods_name;
            private String price;
            private String owner_id;
            private String comment_count;
            private String like_count;
            private String liked;
            private String sale_by;
            private String goods_url;
            private int is_gift;
            private String discount_price;
            private String coupon_flag;
            private String promotion_imgurl;

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getOwner_id() {
                return owner_id;
            }

            public void setOwner_id(String owner_id) {
                this.owner_id = owner_id;
            }

            public String getComment_count() {
                return comment_count;
            }

            public void setComment_count(String comment_count) {
                this.comment_count = comment_count;
            }

            public String getLike_count() {
                return like_count;
            }

            public void setLike_count(String like_count) {
                this.like_count = like_count;
            }

            public String getLiked() {
                return liked;
            }

            public void setLiked(String liked) {
                this.liked = liked;
            }

            public String getSale_by() {
                return sale_by;
            }

            public void setSale_by(String sale_by) {
                this.sale_by = sale_by;
            }

            public String getGoods_url() {
                return goods_url;
            }

            public void setGoods_url(String goods_url) {
                this.goods_url = goods_url;
            }

            public int getIs_gift() {
                return is_gift;
            }

            public void setIs_gift(int is_gift) {
                this.is_gift = is_gift;
            }

            public String getDiscount_price() {
                return discount_price;
            }

            public void setDiscount_price(String discount_price) {
                this.discount_price = discount_price;
            }

            public String getCoupon_flag() {
                return coupon_flag;
            }

            public void setCoupon_flag(String coupon_flag) {
                this.coupon_flag = coupon_flag;
            }

            public String getPromotion_imgurl() {
                return promotion_imgurl;
            }

            public void setPromotion_imgurl(String promotion_imgurl) {
                this.promotion_imgurl = promotion_imgurl;
            }
        }
    }
}
