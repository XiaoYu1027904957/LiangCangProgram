package com.xiaoyu.liangcangprogram.daren.bean;

import java.util.List;

/**
 * Created by yuxiaobai on 2017/1/10.
 */

public class GoodsBean {

    /**
     * meta : {"status":0,"server_time":"2017-01-10 23:13:50","account_id":0,"cost":0.022698,"errdata":null,"errmsg":""}
     * version : 1
     * data : {"has_more":false,"num_items":1,"items":{"goods_id":"102939","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/102/102939.jpg","goods_url":"http://www.sumayzoy.com/smz_p_leather/5.html","goods_name":"素面造  MoXx - 手缝手拿","goods_desc":"粗狂的皮子，纯手工缝制，每个都独一无二","price":"1200.00","comment_count":"0","like_count":"7","liked":"0","owner_id":"121530857","shipping_type":"1","shipping_time":"3","shipping_str":"现货商品3天发货","owner_name":"亚洲","is_daren":"1","owner_desc":"椅子很忙","headimg":"http://imgs-qn.iliangcang.com/ware/userhead/orig/3/121/530/121530857.jpg?t=1484061230","rec_reason":"","is_gift":"0","images_item":["http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137772.jpg","http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137773.jpg","http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137774.jpg","http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137775.jpg","http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137776.jpg"],"is_sold_out":"1","sold_out_img_url":"http://imgs-qn.iliangcang.com/ware/upload/big/2/302/302400.jpg","sku_inv":[],"goods_info":[]}}
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
         * server_time : 2017-01-10 23:13:50
         * account_id : 0
         * cost : 0.022698
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
         * has_more : false
         * num_items : 1
         * items : {"goods_id":"102939","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/102/102939.jpg","goods_url":"http://www.sumayzoy.com/smz_p_leather/5.html","goods_name":"素面造  MoXx - 手缝手拿","goods_desc":"粗狂的皮子，纯手工缝制，每个都独一无二","price":"1200.00","comment_count":"0","like_count":"7","liked":"0","owner_id":"121530857","shipping_type":"1","shipping_time":"3","shipping_str":"现货商品3天发货","owner_name":"亚洲","is_daren":"1","owner_desc":"椅子很忙","headimg":"http://imgs-qn.iliangcang.com/ware/userhead/orig/3/121/530/121530857.jpg?t=1484061230","rec_reason":"","is_gift":"0","images_item":["http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137772.jpg","http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137773.jpg","http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137774.jpg","http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137775.jpg","http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137776.jpg"],"is_sold_out":"1","sold_out_img_url":"http://imgs-qn.iliangcang.com/ware/upload/big/2/302/302400.jpg","sku_inv":[],"goods_info":[]}
         */

        private boolean has_more;
        private int num_items;
        private ItemsBean items;

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public int getNum_items() {
            return num_items;
        }

        public void setNum_items(int num_items) {
            this.num_items = num_items;
        }

        public ItemsBean getItems() {
            return items;
        }

        public void setItems(ItemsBean items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * goods_id : 102939
             * goods_image : http://imgs-qn.iliangcang.com/ware/goods/big/2/102/102939.jpg
             * goods_url : http://www.sumayzoy.com/smz_p_leather/5.html
             * goods_name : 素面造  MoXx - 手缝手拿
             * goods_desc : 粗狂的皮子，纯手工缝制，每个都独一无二
             * price : 1200.00
             * comment_count : 0
             * like_count : 7
             * liked : 0
             * owner_id : 121530857
             * shipping_type : 1
             * shipping_time : 3
             * shipping_str : 现货商品3天发货
             * owner_name : 亚洲
             * is_daren : 1
             * owner_desc : 椅子很忙
             * headimg : http://imgs-qn.iliangcang.com/ware/userhead/orig/3/121/530/121530857.jpg?t=1484061230
             * rec_reason :
             * is_gift : 0
             * images_item : ["http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137772.jpg","http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137773.jpg","http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137774.jpg","http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137775.jpg","http://imgs-qn.iliangcang.com/ware/upload/big/2/137/137776.jpg"]
             * is_sold_out : 1
             * sold_out_img_url : http://imgs-qn.iliangcang.com/ware/upload/big/2/302/302400.jpg
             * sku_inv : []
             * goods_info : []
             */

            private String goods_id;
            private String goods_image;
            private String goods_url;
            private String goods_name;
            private String goods_desc;
            private String price;
            private String comment_count;
            private String like_count;
            private String liked;
            private String owner_id;
            private String shipping_type;
            private String shipping_time;
            private String shipping_str;
            private String owner_name;
            private String is_daren;
            private String owner_desc;
            private String headimg;
            private String rec_reason;
            private String is_gift;
            private String is_sold_out;
            private String sold_out_img_url;
            private List<String> images_item;
            private List<?> sku_inv;
            private List<?> goods_info;

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

            public String getGoods_url() {
                return goods_url;
            }

            public void setGoods_url(String goods_url) {
                this.goods_url = goods_url;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_desc() {
                return goods_desc;
            }

            public void setGoods_desc(String goods_desc) {
                this.goods_desc = goods_desc;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
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

            public String getOwner_id() {
                return owner_id;
            }

            public void setOwner_id(String owner_id) {
                this.owner_id = owner_id;
            }

            public String getShipping_type() {
                return shipping_type;
            }

            public void setShipping_type(String shipping_type) {
                this.shipping_type = shipping_type;
            }

            public String getShipping_time() {
                return shipping_time;
            }

            public void setShipping_time(String shipping_time) {
                this.shipping_time = shipping_time;
            }

            public String getShipping_str() {
                return shipping_str;
            }

            public void setShipping_str(String shipping_str) {
                this.shipping_str = shipping_str;
            }

            public String getOwner_name() {
                return owner_name;
            }

            public void setOwner_name(String owner_name) {
                this.owner_name = owner_name;
            }

            public String getIs_daren() {
                return is_daren;
            }

            public void setIs_daren(String is_daren) {
                this.is_daren = is_daren;
            }

            public String getOwner_desc() {
                return owner_desc;
            }

            public void setOwner_desc(String owner_desc) {
                this.owner_desc = owner_desc;
            }

            public String getHeadimg() {
                return headimg;
            }

            public void setHeadimg(String headimg) {
                this.headimg = headimg;
            }

            public String getRec_reason() {
                return rec_reason;
            }

            public void setRec_reason(String rec_reason) {
                this.rec_reason = rec_reason;
            }

            public String getIs_gift() {
                return is_gift;
            }

            public void setIs_gift(String is_gift) {
                this.is_gift = is_gift;
            }

            public String getIs_sold_out() {
                return is_sold_out;
            }

            public void setIs_sold_out(String is_sold_out) {
                this.is_sold_out = is_sold_out;
            }

            public String getSold_out_img_url() {
                return sold_out_img_url;
            }

            public void setSold_out_img_url(String sold_out_img_url) {
                this.sold_out_img_url = sold_out_img_url;
            }

            public List<String> getImages_item() {
                return images_item;
            }

            public void setImages_item(List<String> images_item) {
                this.images_item = images_item;
            }

            public List<?> getSku_inv() {
                return sku_inv;
            }

            public void setSku_inv(List<?> sku_inv) {
                this.sku_inv = sku_inv;
            }

            public List<?> getGoods_info() {
                return goods_info;
            }

            public void setGoods_info(List<?> goods_info) {
                this.goods_info = goods_info;
            }
        }
    }
}
