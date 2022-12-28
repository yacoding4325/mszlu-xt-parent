package com.mszlu.xt.sso.model;

import lombok.Data;

/**
 * @author Jarno
 */
@Data
public class UserModel {

    private String nickname;
    private Integer sex;
    private String city;
    private String province;
    private String country;
    private String headImageUrl;
    private String mobile;
    private String name;
    private String inviteUrl;
    private String school;
    private String area;
    private String grade;
//    private List<BillModel> billModelList;
}
