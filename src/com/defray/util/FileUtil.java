package com.defray.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileUtil {

    private Logger logger = Logger.getLogger(LogUtil.class);

    /**
     * 根据后缀名查找文件列表
     * @param path  待查找的目录
     * @param extName   查找的后缀名
     * @return
     */
    public List<File> findFileByExtName(String path, String extName) {
        File ftpDir = new File(path);
        List<File> fileList = new ArrayList<File>();
        if(ftpDir.isDirectory()){
            String[] tempList = ftpDir.list();
            for (String str : tempList) {
                System.out.println(str);
            }
        }else{
            logger.error("目录不存在[" + path + "]");
        }
        return fileList;
    }
}
