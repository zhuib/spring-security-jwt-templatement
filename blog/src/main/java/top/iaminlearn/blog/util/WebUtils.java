package top.iaminlearn.blog.util;

import javax.servlet.http.HttpServletResponse;

/**
 * Date: 2022/5/15 20:52
 */
public class WebUtils {

    // 将字符串写入到响应中
    public static String renderString(HttpServletResponse response, String string) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
