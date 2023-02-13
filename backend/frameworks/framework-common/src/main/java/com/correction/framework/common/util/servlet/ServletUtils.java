package com.correction.framework.common.util.servlet;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.correction.framework.common.util.json.JsonUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 客户端工具类
 *
 */
public class ServletUtils {

    /**
     * 返回 JSON 字符串
     *
     * @param response 响应
     * @param object 对象，会序列化成 JSON 字符串
     */
    @SuppressWarnings("deprecation") // 必须使用 APPLICATION_JSON_UTF8_VALUE，否则会乱码
    public static void writeJSON(HttpServletResponse response, Object object) {
        String content = JsonUtils.toJsonString(object);
        ServletUtil.write(response, content, MediaType.APPLICATION_JSON_UTF8_VALUE);
    }

    /**
     * 返回附件
     *
     * @param response 响应
     * @param filename 文件名
     * @param content 附件内容
     * @throws IOException
     */
    public static void writeAttachment(HttpServletResponse response, String filename, byte[] content) throws IOException {
        // 设置 header 和 contentType
        response.setHeader("Access-Control-Expose-Headers","*");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename, "UTF-8"));
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        // 输出附件
        IoUtil.write(response.getOutputStream(), false, content);
    }

    public static void writeAsFileStream(File file, HttpServletResponse response) {
        OutputStream os = null;
        InputStream is = null;
        try {
            response.setHeader("Access-Control-Expose-Headers","*");
            os = response.getOutputStream();
            is = new FileInputStream(file);
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(file.getName(), "UTF-8"));
            IoUtil.copy(is, os);
            response.flushBuffer();
        } catch (Exception e) {
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
    }



    public static File downloadFileFromUrl(String url,String temppath) {
        File f = null;
        try {
            URL httpUrl = new URL(url);
            f = new File(temppath);
            if (!f.getParentFile().exists()){
                f.getParentFile().mkdirs();
            }
            FileUtils.copyURLToFile(httpUrl, f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }


    /**
     * @param request 请求
     * @return ua
     */
    public static String getUserAgent(HttpServletRequest request) {
        String ua = request.getHeader("User-Agent");
        return ua != null ? ua : "";
    }

    /**
     * 获得请求
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (!(requestAttributes instanceof ServletRequestAttributes)) {
            return null;
        }
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    public static String getUserAgent() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        return getUserAgent(request);
    }

    public static String getClientIP() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        return ServletUtil.getClientIP(request);
    }

    public static boolean isJsonRequest(ServletRequest request) {
        return StrUtil.startWithIgnoreCase(request.getContentType(), MediaType.APPLICATION_JSON_VALUE);
    }

    public static void writeAsFileDelStream(File file, HttpServletResponse response) {
        OutputStream os = null;
        InputStream is = null;
        try {
            response.setHeader("Access-Control-Expose-Headers","*");
            os = response.getOutputStream();
            is = new FileInputStream(file);
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
            IoUtil.copy(is, os);
            response.flushBuffer();
        } catch (Exception e) {
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
            file.delete();
        }
    }
}
