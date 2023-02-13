package com.correction.backend.modules.zhjiao.constant;

import liquibase.pro.packaged.S;

/**
 * 智慧矫
 */
public class ZhihjiaoConstant {

    /**
     * 登录url
     */
    public static final String ACCESS_TOKEN = "https://api.zhjiao.com/v1/oauth2/login?userName={0}&password={1}&loginType=1";

    /**
     * 心理评估列表
     */
    public static final String PSYCHOLOGICAL_EVLUATION = "https://api.zhjiao.com/v1/apperRiskAssess/listApperRiskAssess?districtId={0}&pageNo={1}&pageSize={2}";

    /**
     * 人员定位
     */
    public static final String POSITIONING_PERSONNEL = "https://api.zhjiao.com/v1/location/listApperLocation?districtId={0}" ;

    /**
     * 电子围栏 Electronic fence
     */
    public static final String ELECTRONIC_FENCE = "https://api.zhjiao.com/v1/area/list?districtId={0}&pageNo={1}&pageSize={2}";

    /**
     * 签到记录
     */
    public static final String SIGN_RECORD = "https://api.zhjiao.com/v1/signLog/list/signCode?districtId={0}&pageNo={1}&pageSize={2}";

    /**
     * 违规提醒 Violation Alert
     */
    public static final String VIOLATION_ALERT = "https://api.zhjiao.com/v1/violation/list?districtId={0}&pageNo={1}&pageSize={2}&createTimeAsc=true";

    /**
     * 动态定位：点击人员信息获取详情
     */
    public static final String POSITIONING_USER_DETAIL = "https://api.zhjiao.com/v1/location/baseInfoAndSign?districtId={0}&apperId={1}";

    /**
     * 动态定位：获取区列表
     */
    public static final String POSITIONING_STREE_LIST = "https://api.zhjiao.com/v1/street/listStreetByPerson?districtId={0}";

    /**
     * 视频抽查获取人员列表
     */
    public static final String VIEDO_USER_URL = "https://api.zhjiao.com/v1/apper/listApper?districtId={0}&pageNo={1}&pageSize={2}";

    /**
     * 视频抽查接口地址
     */
    public static final String VIEDO_URL = "https://www.zhjiao.com/videoCheck/index.html?id={0}&username={1}";

    /**
     * 电子围栏-人员列表
     * https://api.zhjiao.com/v1/area/list/apper?districtId=11&areaId=157
     */
    public static final String ELECTRONIC_FENCE_USERS_LIST = "https://api.zhjiao.com/v1/area/list/apper?districtId={0}&areaId={1}";

    /**
     * 心理评估-查看报告
     */
    public static final String POSITIONING_PERSONNEL_REPORT = "https://api.zhjiao.com/v1/apper/baseInfo/{0}?districtId={1}";
}
