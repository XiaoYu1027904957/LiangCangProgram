package com.xiaoyu.liangcangprogram.shopping.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yuxiaobai on 2017/1/8.
 */

public class PinPaiBean  implements Serializable {

    /**
     * meta : {"status":0,"server_time":"2017-01-08 16:40:31","account_id":0,"cost":0.0045409999999999,"errdata":null,"errmsg":""}
     * version : 1
     * data : {"has_more":true,"num_items":"576","items":[{"brand_id":14,"brand_name":"Maison Martin Margiela Line 13","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/14.jpg"},{"brand_id":11,"brand_name":"sowhat","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/11.jpg"},{"brand_id":658,"brand_name":"KNOMO","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/658.jpg"},{"brand_id":657,"brand_name":"贝甜时光","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/657.jpg"},{"brand_id":656,"brand_name":"imblu","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/656.jpg"},{"brand_id":655,"brand_name":"粮赞","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/655.jpg"},{"brand_id":654,"brand_name":"JBL","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/654.jpg"},{"brand_id":653,"brand_name":"One&amp;One懿心懿意","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/653.jpg"},{"brand_id":652,"brand_name":"惜物造","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/652.jpg"},{"brand_id":651,"brand_name":"Slowosophy","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/651.jpg"},{"brand_id":650,"brand_name":"It's toasted","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/650.jpg"},{"brand_id":649,"brand_name":"Zubits","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/649.jpg"},{"brand_id":648,"brand_name":"巴九灵茶田","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/648.jpg"},{"brand_id":647,"brand_name":"PO:","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/647.jpg"},{"brand_id":646,"brand_name":"四象","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/646.jpg"},{"brand_id":645,"brand_name":"PaperPlay","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/645.jpg"},{"brand_id":644,"brand_name":"STShop","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/644.jpg"},{"brand_id":643,"brand_name":"Never","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/643.jpg"},{"brand_id":642,"brand_name":"友邦洋纸/polytrade paper","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/642.jpg"},{"brand_id":641,"brand_name":"让·吕克·图内文","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/641.jpg"}]}
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

    public static class MetaBean  implements Serializable {
        /**
         * status : 0
         * server_time : 2017-01-08 16:40:31
         * account_id : 0
         * cost : 0.0045409999999999
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

    public static class DataBean implements Serializable  {
        /**
         * has_more : true
         * num_items : 576
         * items : [{"brand_id":14,"brand_name":"Maison Martin Margiela Line 13","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/14.jpg"},{"brand_id":11,"brand_name":"sowhat","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/11.jpg"},{"brand_id":658,"brand_name":"KNOMO","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/658.jpg"},{"brand_id":657,"brand_name":"贝甜时光","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/657.jpg"},{"brand_id":656,"brand_name":"imblu","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/656.jpg"},{"brand_id":655,"brand_name":"粮赞","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/655.jpg"},{"brand_id":654,"brand_name":"JBL","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/654.jpg"},{"brand_id":653,"brand_name":"One&amp;One懿心懿意","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/653.jpg"},{"brand_id":652,"brand_name":"惜物造","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/652.jpg"},{"brand_id":651,"brand_name":"Slowosophy","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/651.jpg"},{"brand_id":650,"brand_name":"It's toasted","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/650.jpg"},{"brand_id":649,"brand_name":"Zubits","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/649.jpg"},{"brand_id":648,"brand_name":"巴九灵茶田","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/648.jpg"},{"brand_id":647,"brand_name":"PO:","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/647.jpg"},{"brand_id":646,"brand_name":"四象","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/646.jpg"},{"brand_id":645,"brand_name":"PaperPlay","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/645.jpg"},{"brand_id":644,"brand_name":"STShop","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/644.jpg"},{"brand_id":643,"brand_name":"Never","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/643.jpg"},{"brand_id":642,"brand_name":"友邦洋纸/polytrade paper","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/642.jpg"},{"brand_id":641,"brand_name":"让·吕克·图内文","brand_logo":"http://imgs-qn.iliangcang.com/ware/brand/641.jpg"}]
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

        public static class ItemsBean implements Serializable {
            /**
             * brand_id : 14
             * brand_name : Maison Martin Margiela Line 13
             * brand_logo : http://imgs-qn.iliangcang.com/ware/brand/14.jpg
             */

            private int brand_id;
            private String brand_name;
            private String brand_logo;

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public String getBrand_name() {
                return brand_name;
            }

            public void setBrand_name(String brand_name) {
                this.brand_name = brand_name;
            }

            public String getBrand_logo() {
                return brand_logo;
            }

            public void setBrand_logo(String brand_logo) {
                this.brand_logo = brand_logo;
            }
        }
    }
}
