package com.xiaoyu.liangcangprogram.daren.bean;

import java.util.List;

/**
 * Created by yuxiaobai on 2017/1/10.
 */

public class LikesBean {

    /**
     * meta : {"status":0,"server_time":"2017-01-10 18:46:27","account_id":0,"cost":0.181434,"errdata":null,"errmsg":""}
     * version : 1
     * data : {"has_more":false,"num_items":"7","items":{"user_id":"137","user_name":"田原","is_daren":"1","email":"highwayone@163.com","user_image":{"self_img":"1","orig":"http://imgs-qn.iliangcang.com/ware/userhead/orig/1/137.jpg?t=1484045187","mid":"http://imgs-qn.iliangcang.com/ware/userhead/mid/1/137.jpg?t=1484045187","tmb":"http://imgs-qn.iliangcang.com/ware/userhead/tmb/1/137.jpg?t=1484045187"},"user_desc":"著名创作歌手、演员、导演","friend":"0","like_count":"7","recommendation_count":"5","following_count":"2","followed_count":"2797","template_id":"0","goods":[{"goods_id":"2528","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/2/2528.jpg?t=1392521214","goods_name":" New Friends Tumbler Bear by Kosta Boda","price":"1599.00","owner_id":"134","comment_count":"2","like_count":"224","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"548","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/1/548.jpg?t=1392521214","goods_name":"绝对伏特加2011摩登限量装","price":"168.00","owner_id":"21","comment_count":"0","like_count":"118","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"2588","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/2/2588.jpg?t=1392521214","goods_name":"法国tagine保温帽子砂锅","price":"108.00","owner_id":"16","comment_count":"1","like_count":"123","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"1682","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/1/1682.jpg?t=1392521214","goods_name":"VintageConfections星球棒棒糖","price":"279.00","owner_id":"23","comment_count":"9","like_count":"810","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"2537","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/2/2537.jpg?t=1392521214","goods_name":"Dries Van Noten 牛津鞋","price":"3850.00","owner_id":"84","comment_count":"0","like_count":"230","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"1889","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/1/1889.jpg?t=1392521214","goods_name":"HERRINGBONE丝巾","price":"756.00","owner_id":"16","comment_count":"0","like_count":"110","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"2066","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/2/2066.jpg?t=1392521214","goods_name":"Y's by Yohji Yamamoto Fur Tote","price":"2590.00","owner_id":"69","comment_count":"1","like_count":"151","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"}]}}
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
         * server_time : 2017-01-10 18:46:27
         * account_id : 0
         * cost : 0.181434
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
         * num_items : 7
         * items : {"user_id":"137","user_name":"田原","is_daren":"1","email":"highwayone@163.com","user_image":{"self_img":"1","orig":"http://imgs-qn.iliangcang.com/ware/userhead/orig/1/137.jpg?t=1484045187","mid":"http://imgs-qn.iliangcang.com/ware/userhead/mid/1/137.jpg?t=1484045187","tmb":"http://imgs-qn.iliangcang.com/ware/userhead/tmb/1/137.jpg?t=1484045187"},"user_desc":"著名创作歌手、演员、导演","friend":"0","like_count":"7","recommendation_count":"5","following_count":"2","followed_count":"2797","template_id":"0","goods":[{"goods_id":"2528","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/2/2528.jpg?t=1392521214","goods_name":" New Friends Tumbler Bear by Kosta Boda","price":"1599.00","owner_id":"134","comment_count":"2","like_count":"224","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"548","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/1/548.jpg?t=1392521214","goods_name":"绝对伏特加2011摩登限量装","price":"168.00","owner_id":"21","comment_count":"0","like_count":"118","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"2588","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/2/2588.jpg?t=1392521214","goods_name":"法国tagine保温帽子砂锅","price":"108.00","owner_id":"16","comment_count":"1","like_count":"123","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"1682","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/1/1682.jpg?t=1392521214","goods_name":"VintageConfections星球棒棒糖","price":"279.00","owner_id":"23","comment_count":"9","like_count":"810","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"2537","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/2/2537.jpg?t=1392521214","goods_name":"Dries Van Noten 牛津鞋","price":"3850.00","owner_id":"84","comment_count":"0","like_count":"230","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"1889","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/1/1889.jpg?t=1392521214","goods_name":"HERRINGBONE丝巾","price":"756.00","owner_id":"16","comment_count":"0","like_count":"110","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"2066","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/2/2066.jpg?t=1392521214","goods_name":"Y's by Yohji Yamamoto Fur Tote","price":"2590.00","owner_id":"69","comment_count":"1","like_count":"151","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"}]}
         */

        private boolean has_more;
        private String num_items;
        private ItemsBean items;

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

        public ItemsBean getItems() {
            return items;
        }

        public void setItems(ItemsBean items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * user_id : 137
             * user_name : 田原
             * is_daren : 1
             * email : highwayone@163.com
             * user_image : {"self_img":"1","orig":"http://imgs-qn.iliangcang.com/ware/userhead/orig/1/137.jpg?t=1484045187","mid":"http://imgs-qn.iliangcang.com/ware/userhead/mid/1/137.jpg?t=1484045187","tmb":"http://imgs-qn.iliangcang.com/ware/userhead/tmb/1/137.jpg?t=1484045187"}
             * user_desc : 著名创作歌手、演员、导演
             * friend : 0
             * like_count : 7
             * recommendation_count : 5
             * following_count : 2
             * followed_count : 2797
             * template_id : 0
             * goods : [{"goods_id":"2528","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/2/2528.jpg?t=1392521214","goods_name":" New Friends Tumbler Bear by Kosta Boda","price":"1599.00","owner_id":"134","comment_count":"2","like_count":"224","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"548","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/1/548.jpg?t=1392521214","goods_name":"绝对伏特加2011摩登限量装","price":"168.00","owner_id":"21","comment_count":"0","like_count":"118","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"2588","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/2/2588.jpg?t=1392521214","goods_name":"法国tagine保温帽子砂锅","price":"108.00","owner_id":"16","comment_count":"1","like_count":"123","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"1682","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/1/1682.jpg?t=1392521214","goods_name":"VintageConfections星球棒棒糖","price":"279.00","owner_id":"23","comment_count":"9","like_count":"810","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"2537","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/2/2537.jpg?t=1392521214","goods_name":"Dries Van Noten 牛津鞋","price":"3850.00","owner_id":"84","comment_count":"0","like_count":"230","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"1889","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/1/1889.jpg?t=1392521214","goods_name":"HERRINGBONE丝巾","price":"756.00","owner_id":"16","comment_count":"0","like_count":"110","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"},{"goods_id":"2066","goods_image":"http://imgs-qn.iliangcang.com/ware/goods/big/2/2/2066.jpg?t=1392521214","goods_name":"Y's by Yohji Yamamoto Fur Tote","price":"2590.00","owner_id":"69","comment_count":"1","like_count":"151","liked":"0","is_outter":"1","sale_by":"other","promotion_imgurl":"http://imgs-qn.iliangcang.com"}]
             */

            private String user_id;
            private String user_name;
            private String is_daren;
            private String email;
            private UserImageBean user_image;
            private String user_desc;
            private String friend;
            private String like_count;
            private String recommendation_count;
            private String following_count;
            private String followed_count;
            private String template_id;
            private List<GoodsBean> goods;

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getIs_daren() {
                return is_daren;
            }

            public void setIs_daren(String is_daren) {
                this.is_daren = is_daren;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public UserImageBean getUser_image() {
                return user_image;
            }

            public void setUser_image(UserImageBean user_image) {
                this.user_image = user_image;
            }

            public String getUser_desc() {
                return user_desc;
            }

            public void setUser_desc(String user_desc) {
                this.user_desc = user_desc;
            }

            public String getFriend() {
                return friend;
            }

            public void setFriend(String friend) {
                this.friend = friend;
            }

            public String getLike_count() {
                return like_count;
            }

            public void setLike_count(String like_count) {
                this.like_count = like_count;
            }

            public String getRecommendation_count() {
                return recommendation_count;
            }

            public void setRecommendation_count(String recommendation_count) {
                this.recommendation_count = recommendation_count;
            }

            public String getFollowing_count() {
                return following_count;
            }

            public void setFollowing_count(String following_count) {
                this.following_count = following_count;
            }

            public String getFollowed_count() {
                return followed_count;
            }

            public void setFollowed_count(String followed_count) {
                this.followed_count = followed_count;
            }

            public String getTemplate_id() {
                return template_id;
            }

            public void setTemplate_id(String template_id) {
                this.template_id = template_id;
            }

            public List<GoodsBean> getGoods() {
                return goods;
            }

            public void setGoods(List<GoodsBean> goods) {
                this.goods = goods;
            }

            public static class UserImageBean {
                /**
                 * self_img : 1
                 * orig : http://imgs-qn.iliangcang.com/ware/userhead/orig/1/137.jpg?t=1484045187
                 * mid : http://imgs-qn.iliangcang.com/ware/userhead/mid/1/137.jpg?t=1484045187
                 * tmb : http://imgs-qn.iliangcang.com/ware/userhead/tmb/1/137.jpg?t=1484045187
                 */

                private String self_img;
                private String orig;
                private String mid;
                private String tmb;

                public String getSelf_img() {
                    return self_img;
                }

                public void setSelf_img(String self_img) {
                    this.self_img = self_img;
                }

                public String getOrig() {
                    return orig;
                }

                public void setOrig(String orig) {
                    this.orig = orig;
                }

                public String getMid() {
                    return mid;
                }

                public void setMid(String mid) {
                    this.mid = mid;
                }

                public String getTmb() {
                    return tmb;
                }

                public void setTmb(String tmb) {
                    this.tmb = tmb;
                }
            }

            public static class GoodsBean {
                /**
                 * goods_id : 2528
                 * goods_image : http://imgs-qn.iliangcang.com/ware/goods/big/2/2/2528.jpg?t=1392521214
                 * goods_name :  New Friends Tumbler Bear by Kosta Boda
                 * price : 1599.00
                 * owner_id : 134
                 * comment_count : 2
                 * like_count : 224
                 * liked : 0
                 * is_outter : 1
                 * sale_by : other
                 * promotion_imgurl : http://imgs-qn.iliangcang.com
                 */

                private String goods_id;
                private String goods_image;
                private String goods_name;
                private String price;
                private String owner_id;
                private String comment_count;
                private String like_count;
                private String liked;
                private String is_outter;
                private String sale_by;
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

                public String getIs_outter() {
                    return is_outter;
                }

                public void setIs_outter(String is_outter) {
                    this.is_outter = is_outter;
                }

                public String getSale_by() {
                    return sale_by;
                }

                public void setSale_by(String sale_by) {
                    this.sale_by = sale_by;
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
}
