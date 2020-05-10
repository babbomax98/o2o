package com.o2o.utils;

import com.o2o.dto.ImageHolder;
import net.coobird.thumbnailator.Thumbnails;

import net.coobird.thumbnailator.geometry.Positions;
import org.apache.commons.io.IOUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author shkstart
 * @create 2020-04-17 18:13
 */
public class ImageUtil {


    //处理缩略图
    public static String generateThumbnail(ImageHolder thumnail, String targetAddr) {
        String realFilName = getRandomFileName();
        String extension = getFileExtension(thumnail.getImageName());
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFilName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);//组成新生成的文件的路径
        try {
            Thumbnails.of(thumnail.getImage()).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("E:\\image\\item\\headtitle\\mark.jpg")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        return realFilName;
    }

    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    //创建目标路径所设计到的目录，
    public static void makeDirPath(String targetAddr) {
        String realFileParentPath=PathUtil.getImgBasePath()+targetAddr;
        File dirPath=new File(realFileParentPath);
        if (!dirPath.exists()){
            dirPath.mkdirs();
        }

    }

//    //获取输入文件流的扩展名
//    public static String getFileExtension(MultipartFile cFile) {
//        String orignalFileName=cFile.getOriginalFilename();
//        return orignalFileName.substring(orignalFileName.lastIndexOf("."));
//    }

    //生成随机文件名，当前年月日小时分钟秒钟+五位随机数
    public  static String getRandomFileName() {
        final SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        final Random r=new Random();
        int rannum=r.nextInt(89999)+10000;
        String nowTimeStr=sDateFormat.format(new Date());
        return nowTimeStr;
    }

    /*
    * storePath是文件的路径还是目录的路径
    * 如果storePath是文件路径则删除该文件
    * 如果storePath是目录路径则删除该目录下的所有文件
    * */

    public static void deleteFileOrPath(String storePath){
        File fileOrPath=new File(PathUtil.getImgBasePath()+storePath);
        if (fileOrPath.exists()){//首先判断是否存在
            if (fileOrPath.isDirectory()){//判断是否是目录文件
                File files[]=fileOrPath.listFiles();
                for (int i=0;i<files.length;i++){
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }

    }



    public static void main(String[] args) throws IOException {
      //  String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Thumbnails.of(new File("E:\\image\\item\\headtitle\\base.jpg")).size(200,200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("E:\\image\\item\\headtitle\\mark.jpg")),0.25f)
                .outputQuality(0.8f).toFile("E:\\image\\item\\headtitle\\newbase.jpg");
    }
    public static String generatrNormalImg(ImageHolder thumbnail,String targetAddr){
        String realFilName = getRandomFileName();
        String extension = getFileExtension(thumbnail.getImageName());
        makeDirPath(targetAddr);
        //获取文件存储的相对路径（带文件名）
        String relativeAddr = targetAddr + realFilName + extension;
        //获取文件要保存到的目标路径
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);//组成新生成的文件的路径
        //调用Thumbnail生成带有水印的图片
        try {
            Thumbnails.of(thumbnail.getImage()).size(337, 640)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("E:\\image\\item\\headtitle\\mark.jpg")), 0.25f)
                    .outputQuality(0.9f).toFile(dest);
        } catch (IOException e) {
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        //返回图片相对路径地址
        return realFilName;
    }
}
