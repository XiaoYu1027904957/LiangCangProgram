package com.xiaoyu.liangcangprogram.ConstantUtils;

/**
 * Created by yuxiaobai on 2017/1/8.
 */

public class NetUrl {
    /**
     * 分类总
     */
    public static final String FEN_LEI = "http://mobile.iliangcang.com/goods/goodsCategory?app_key=Android&sig=430BD99E6C913B8B8C3ED109737ECF15%7C830952120106768&v=1.0";
    public static final String PIN_PAI = "http://mobile.iliangcang.com/brand/brandList?app_key=Android&count=20&page=1&sig=430BD99E6C913B8B8C3ED109737ECF15%7C830952120106768&v=1.0";
    public static final String SHOU_YE = "http://mobile.iliangcang.com/goods/newShopHome?app_key=Android&sig=3780CB0808528F7CE99081D295EE8C0F%7C116941220826768&uid=626138098&user_token=0516ed9429352c8e1e3bd11c63ba6f54&v=1.0";
    public static final String ZHUAN_TI = "http://mobile.iliangcang.com/goods/shopSpecial?app_key=Android&count=10&page=1&sig=3780CB0808528F7CE99081D295EE8C0F%7C116941220826768&uid=626138098&user_token=0516ed9429352c8e1e3bd11c63ba6f54&v=1.0";
    public static final String DA_REN = "http://mobile.iliangcang.com/user/masterList?app_key=Android&count=18&page=1&sig=BF287AF953103F390674E73DDA18CFD8|639843030233268&v=1.0";
    public static final String SHARE = "http://mobile.iliangcang.com/goods/goodsShare?app_key=Android&count=10&page=1&sig=3E75F2A66A266F2CCE4FE69B60EE0BD6%7C219146020650568&type=0&v=1.0";
    public static final String FENLEI_DETIAL_HEAD = "http://mobile.iliangcang.com/goods/goodsShare?app_key=Android&cat_code=";
    public static final String FENLEI_DETIAL_FOOT = "&count=10&coverId=1&page=1&sig=6E1DEF1DAFF84909ECD98F32FE6CDAD5%7C536890620070968&v=1.0";
    public static final String PIN_PAI_HEAD = "http://mobile.iliangcang.com/brand/brandShopList?app_key=Android&brand_id=";
    public static final String PIN_PAI_FOOT = "&count=20&page=1&sig=430BD99E6C913B8B8C3ED109737ECF15%7C830952120106768&v=1.0";
    public static final String LI_WU_HEAD = "http://mobile.iliangcang.com/goods/goodsList?app_key=Android&count=10&list_id=";
    public static final String LI_WU_FOOT = "&page=1&sig=DFD7151CC9D607E396FE108FE270FFF3%7C366534120395468&v=1.0";
    /**
     * http://mobile.iliangcang.com/user/masterFollowed?app_key=Android&count=12&owner_id=999998864&page=1&sig=BF287AF953103F390674E73DDA18CFD8%7C639843030233268&v=1.0
     */
    public static final String DA_REN_DETIALS_HEAD = "http://mobile.iliangcang.com/user/masterFollowed?app_key=Android&count=12&owner_id=";
    public static final String DA_REN_DETIALS_FOOT = "&page=1&sig=BF287AF953103F390674E73DDA18CFD8%7C639843030233268&v=1.0";
    /**
     * 粉丝
     * http://mobile.iliangcang.com/user/masterFollowed?app_key=Android&count=12&owner_id=999998864&page=1&sig=BF287AF953103F390674E73DDA18CFD8%7C639843030233268&v=1.0
     * <p>
     * 关注
     * http://mobile.iliangcang.com/user/masterFollow?app_key=Android&count=12&owner_id=137&page=1&sig=BF287AF953103F390674E73DDA18CFD8|639843030233268&v=1.0
     * <p>
     * 喜欢
     * http://mobile.iliangcang.com/user/masterLike?app_key=Android&count=12&owner_id=137&page=1&sig=BF287AF953103F390674E73DDA18CFD8|639843030233268&v=1.0
     * <p>
     * 推荐
     * http://mobile.iliangcang.com/user/masterListInfo?app_key=Android&count=10&owner_id=137&page=1&sig=BF287AF953103F390674E73DDA18CFD8%7C639843030233268&v=1.0
     */
//  粉丝
    public static final String FANS_DAREN_HEAD = "http://mobile.iliangcang.com/user/masterFollowed?app_key=Android&count=12&owner_id=";
    public static final String FANS_DAREN_FOOT = "&page=1&sig=BF287AF953103F390674E73DDA18CFD8%7C639843030233268&v=1.0";
    //       推荐
    public static final String TUIJIAN_DAREN_HEAD = "http://mobile.iliangcang.com/user/masterListInfo?app_key=Android&count=10&owner_id=";
    public static final String TUIJAN_DAREN_FOOT = "&page=1&sig=BF287AF953103F390674E73DDA18CFD8%7C639843030233268&v=1.0";
    //    喜欢
    public static final String LIKE_DAREN_HEAD = "http://mobile.iliangcang.com/user/masterLike?app_key=Android&count=12&owner_id=";
    public static final String LIKE_DAREN_FOOT = "&page=1&sig=BF287AF953103F390674E73DDA18CFD8|639843030233268&v=1.0";
    //    关注
    public static final String GUANZHU_DAREN_HEAD = "http://mobile.iliangcang.com/user/masterFollow?app_key=Android&count=12&owner_id=";
    public static final String GUAZHU_DAREN_FOOT = "&page=1&sig=BF287AF953103F390674E73DDA18CFD8|639843030233268&v=1.0";
//    货物详情
    /**
     * http://mobile.iliangcang.com/goods/goodsDetail?app_key=Android&goods_id=102939&sig=BF287AF953103F390674E73DDA18CFD8%7C639843030233268&v=1.0
     */
    public static final String GOODS_HEAD = "http://mobile.iliangcang.com/goods/goodsDetail?app_key=Android&goods_id=";
    public static final String GOODS_FOOT = "&sig=BF287AF953103F390674E73DDA18CFD8%7C639843030233268&v=1.0";
    /**
     * http://mobile.iliangcang.com/topic/magazineList?app_key=Android&sig=3E75F2A66A266F2CCE4FE69B60EE0BD6%7C219146020650568&v=1.0
     */
    public static final String MAGAZINE = "http://mobile.iliangcang.com/topic/magazineList?app_key=Android&sig=3E75F2A66A266F2CCE4FE69B60EE0BD6%7C219146020650568&v=1.0";
}
