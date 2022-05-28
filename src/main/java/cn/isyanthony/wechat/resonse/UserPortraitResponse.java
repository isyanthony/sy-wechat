package cn.isyanthony.wechat.resonse;

import lombok.Data;

/**
 * @author: Syanthony
 * @Date: 2022/5/14
 * @Version: 1.0.0
 * @description: 获取画像分布数据
 */
@Data
public class UserPortraitResponse {
    /**
     * 时间范围，如："20170611-20170617"
     */
    String ref_date;
    /**
     * 新用户画像
     */
    VisitUv visit_uv_new;
    /**
     * 用户画像
     */
    VisitUv visit_uv;
}

/**
 * 用户画像
 */
@Data
class VisitUv {
    /**
     * 分布类型
     */
    Integer index;
    /**
     * 省份，如北京、广东等
     */
    BasicResponse province;
    /**
     * 市，如北京、广州等
     */
    BasicResponse city;
    /**
     * 性别，包括男、女、未知
     */
    BasicResponse genders;
    /**
     * 终端类型，包括 iPhone，android，其他
     */
    BasicResponse platforms;
    /**
     * 机型，如苹果 iPhone 6，OPPO R9 等
     */
    BasicResponse devices;
    /**
     * 年龄，包括17岁以下、18-24岁等区间
     */
    BasicResponse ages;
}

/**
 * 用户画像基本属性
 */
@Data
class BasicResponse {
    /**
     * 属性值id
     */
    Integer id;

    /**
     * 属性值
     */
    String name;

    /**
     * 该场景下访问量
     */
    Integer value;
}
