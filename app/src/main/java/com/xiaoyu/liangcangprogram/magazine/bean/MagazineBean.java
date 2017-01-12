package com.xiaoyu.liangcangprogram.magazine.bean;

import java.util.List;



/**
 * 杂志数据bean
 */

public class MagazineBean {
    public Meat meat;
    public Data data;

    public MagazineBean() {
        meat = new Meat();
        data = new Data();
    }


    public class Data {
        private boolean has_more;
        private int num_items;
        private List<String> keys;
        private List<List<MagazineItemBean>> magazineItemBeens;

        public List<List<MagazineItemBean>> getMagazineItemBeens() {
            return magazineItemBeens;
        }

        public void setMagazineItemBeens(List<List<MagazineItemBean>> magazineItemBeens) {
            this.magazineItemBeens = magazineItemBeens;
        }

        public List<String> getKeys() {
            return keys;
        }

        public void setKeys(List<String> keys) {
            this.keys = keys;
        }

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
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }
}
