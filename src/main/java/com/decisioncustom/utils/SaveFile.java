
package com.decisioncustom.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class SaveFile {

    public static void saveFile(String path,String fileUUID, MultipartFile filedata) {
        // TODO Auto-generated method stub
        // 根据配置文件获取服务器图片存放路径
        String picDir = "";

        String getPicUrl="http://localhost/upload/image";
        try {
            String saveFilePath = picDir;

/* 构建文件目录 */

            File fileDir = new File(path + "/" + fileUUID + filedata.getOriginalFilename());
            if (!fileDir.getParentFile().exists()) {
                fileDir.getParentFile().mkdirs();
            }
            //这里封装了读取配置文件的方法 配置文件中有图片的存放地址和获取地址
            picDir = getPicUrl;
            filedata.transferTo(fileDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void saveFiles(String path,String fileUUID, MultipartFile[] filedatas) {
        // TODO Auto-generated method stub
        // 根据配置文件获取服务器图片存放路径
        String picDir = "";

        String getPicUrl="http://localhost/common/img";
        try {
            String saveFilePath = picDir;
            for (MultipartFile filedata:filedatas) {

/* 构建文件目录 */

                File fileDir = new File(path + "/" + fileUUID + filedata.getOriginalFilename());
                if (!fileDir.exists()) {
                    fileDir.mkdirs();
                }
                //这里封装了读取配置文件的方法 配置文件中有图片的存放地址和获取地址
                picDir = getPicUrl;
                filedata.transferTo(fileDir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}