package cn.companyname.cocoa_project.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 完成 Json输出工作
 *
 * @author CoCo
 */
public class JsonUtil {
    public static void doJson(Object object, HttpServletResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PrintWriter out = response.getWriter();
            out.print(objectMapper.writeValueAsString(object));
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
