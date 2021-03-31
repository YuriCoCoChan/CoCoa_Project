package cn.companyname.cocoa_project.utils;

import sun.security.krb5.internal.PAData;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * 文件上传
 *
 * @author CoCo
 */
@MultipartConfig
public class FileUtil {

    /**
     * 若 "checkPath" 不存在则创建目录
     *
     * @param checkPath ;
     */
    public static void createDire(String checkPath) {
        File dirFile = new File(checkPath);
        //若该目录不存在则创建
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
    }

    /**
     * 文件上传
     *
     * @param request  请求对象 ;
     * @param partName 前台表项值;
     * @param path     由业务层拼接的真实路径
     * @return ;
     */
    public static Boolean partFileUpload(HttpServletRequest request, String partName, String path) {
        try {
            Part part = request.getPart(partName);
            path = request.getServletContext().getRealPath(path);
            part.write(path);
            return true;
        } catch (IOException | ServletException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除文件
     *
     * @param path 路径;
     */
    public static void deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }

    public static Boolean isExist(HttpServletRequest request, String checkPath) {
        String contextPath = request.getServletContext().getRealPath(checkPath);
        File dirFile = new File(contextPath);
        if (dirFile.exists()) {
            return true;
        }
        return false;
    }


}
