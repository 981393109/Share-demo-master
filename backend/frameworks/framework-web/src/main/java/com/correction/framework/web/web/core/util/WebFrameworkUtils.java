package com.correction.framework.web.web.core.util;

import com.correction.framework.common.enums.UserTypeEnum;
import com.correction.framework.common.pojo.CommonResult;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * 专属于 web 包的工具类
 *
 */
public class WebFrameworkUtils {

    private static final String REQUEST_ATTRIBUTE_LOGIN_USER_ID = "login_user_id";

    private static final String REQUEST_ATTRIBUTE_LOGIN_ORG_ID = "login_org_id";
    private static final String REQUEST_ATTRIBUTE_LOGIN_ORG_NUM = "login_org_num";

    private static final String REQUEST_ATTRIBUTE_COMMON_RESULT = "common_result";

    public static void setLoginUserId(ServletRequest request, Long userId) {
        request.setAttribute(REQUEST_ATTRIBUTE_LOGIN_USER_ID, userId);
    }

    /**
     * 获得当前用户的编号，从请求中
     *
     * @param request 请求
     * @return 用户编号
     */
    public static Long getLoginUserId(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        return (Long) request.getAttribute(REQUEST_ATTRIBUTE_LOGIN_USER_ID);
    }


    public static String getLoginOrgNum(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        return (String) request.getAttribute(REQUEST_ATTRIBUTE_LOGIN_ORG_NUM);
    }

    public static String  getLoginOrgNum() {
        HttpServletRequest request = getRequest();
        return getLoginOrgNum(request);
    }

    public static Long getLoginUserId() {
        HttpServletRequest request = getRequest();
        return getLoginUserId(request);
    }

    public static Integer getUserType(HttpServletRequest request) {
        return UserTypeEnum.ADMIN.getValue();
    }

    public static void setCommonResult(ServletRequest request, CommonResult<?> result) {
        request.setAttribute(REQUEST_ATTRIBUTE_COMMON_RESULT, result);
    }

    public static CommonResult<?> getCommonResult(ServletRequest request) {
        return (CommonResult<?>) request.getAttribute(REQUEST_ATTRIBUTE_COMMON_RESULT);
    }

    private static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (!(requestAttributes instanceof ServletRequestAttributes)) {
            return null;
        }
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        return servletRequestAttributes.getRequest();
    }

    public static void setLoginOrgId(HttpServletRequest request, Long orgId,String orgNum) {
        request.setAttribute(REQUEST_ATTRIBUTE_LOGIN_ORG_ID, orgId);
        request.setAttribute(REQUEST_ATTRIBUTE_LOGIN_ORG_NUM, orgNum);
    }

    public static Long getLoginOrgId() {
        HttpServletRequest request = getRequest();
        return getLoginOrgId(request);
    }

    private static Long getLoginOrgId(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        return (Long) request.getAttribute(REQUEST_ATTRIBUTE_LOGIN_ORG_ID);
    }
}
