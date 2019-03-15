package com.alankin.gateway.web.controller;

import com.alankin.common.util.key.SnowflakeIdWorker;
import com.alankin.gateway.web.utils.UserUtils;
import com.alankin.gateway.web.utils.Utils;
import com.alankin.gateway.web.vo.ListVo.IdReqVO;
import com.alankin.gateway.web.vo.ListVo.ListReqVO;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alankin.ucenter.dao.model.StorageImage;
import com.alankin.ucenter.dao.model.StorageImageExample;
import com.alankin.ucenter.dao.model.UserBase;
import com.alankin.ucenter.dao.model.UserBaseExample;
import com.alankin.ucenter.rpc.api.StorageImageService;
import com.alankin.ucenter.rpc.api.UserBaseService;
import com.github.pagehelper.PageInfo;
import com.github.tobato.fastdfs.FdfsClientConfig;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.proto.storage.DownloadFileWriter;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 注册控制器
 * Created by alankin.
 */
@Controller
@Api(value = "存储接口", description = "存储接口")
@RequestMapping(value = "/api/storage", method = RequestMethod.POST)
public class StorageContoller {
    @Autowired
    FastFileStorageClient fastFileStorageClient;
    @Autowired
    StorageImageService storageImageService;
    @Autowired
    ThumbImageConfig thumbImageConfig;

    //上传文件会自动绑定到MultipartFile中
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    @PostMapping(value = "/upload", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "文件上传", notes = "文件上传")
    public Result upload(HttpServletRequest request, @ApiParam(value = "上传的文件", required = true) MultipartFile file) throws Exception {
//        System.out.println(description);
//        //如果文件不为空，写入上传路径
//        if(!file.isEmpty()) {
//            //上传文件路径
//            String path = request.getServletContext().getRealPath("/images/");
//            //上传文件名
//            String filename = file.getOriginalFilename();
//            File filepath = new File(path,filename);
//            //判断路径是否存在，如果不存在就创建一个
//            if (!filepath.getParentFile().exists()) {
//                filepath.getParentFile().mkdirs();
//            }
//            //将上传文件保存到一个目标文件当中
//            file.transferTo(new File(path + File.separator + filename));
//            return "success";
//        } else {
//            return "error";
//        }

//        File file = new File("I:\\alankin\\songProject\\loan-manage-server\\yunyun-gateway\\yunyun-gateway-web\\src\\main\\resources\\images\\20180524233824.png");
//        StorePath [group=group1, path=M00/00/00/wKjrglwrVY6ABYESAAVnIPDfJKM801.png]
        StorePath storePath = fastFileStorageClient.uploadFile(null, file.getInputStream(), file.getSize(), Utils.getExtensionName(file.getOriginalFilename()));
        String path = storePath.getPath();
        StorageImage storageImage = new StorageImage();
        storageImage.setFullPath(storePath.getFullPath());
        storageImage.setStoragePath(path);
        storageImage.setStorageGroup(storePath.getGroup());
        storageImage.setOriginalName(file.getOriginalFilename());
        storageImage.setStorageName(path.substring(path.lastIndexOf("/")));
        storageImage.setSize(file.getSize());
        storageImage.setUid(new SnowflakeIdWorker(0, 0).nextId());
        storageImageService.insertSelective(storageImage);
        return new Result(ResultConstant.SUCCESS, storageImage);
    }

    //上传文件会自动绑定到MultipartFile中
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    @PostMapping(value = "/uploadAndCreateThumb", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "文件上传", notes = "文件上传")
    public Result uploadAndCreateThumb(HttpServletRequest request, @ApiParam(value = "上传的文件", required = true) MultipartFile file) throws Exception {
        StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), Utils.getExtensionName(file.getOriginalFilename()), null);
        String path = storePath.getPath();
        StorageImage storageImage = new StorageImage();
        storageImage.setFullPath(storePath.getFullPath());
        storageImage.setStoragePath(path);
        storageImage.setStorageGroup(storePath.getGroup());
        storageImage.setOriginalName(file.getOriginalFilename());
        storageImage.setStorageName(path.substring(path.lastIndexOf("/")));
        storageImage.setSize(file.getSize());
        storageImage.setUid(new SnowflakeIdWorker(0, 0).nextId());
        storageImage.setThumbImagePath(thumbImageConfig.getThumbImagePath(storePath.getPath()));
        storageImageService.insertSelective(storageImage);
        return new Result(ResultConstant.SUCCESS, storageImage);
    }

    @ApiOperation(value = "获取图片路径等基本信息")
    @RequestMapping(value = "getStorage")
    @ResponseBody
    public Result getStorage(@RequestBody IdReqVO idReqVO) {
        StorageImage storageImage = storageImageService.selectByPrimaryKey(idReqVO.getId());
        if (storageImage == null) {
            return new Result(ResultConstant.FAILED);
        }
        return new Result(ResultConstant.SUCCESS, storageImage);
    }

//    @ApiOperation(value = "清理无用图片")
//    @RequestMapping(value = "cleanStorage")
//    @ResponseBody
//    public Result cleanStorage() {
//        List<StorageImage> storageImages = storageImageService.selectByExample(new StorageImageExample());
//        for (StorageImage storageImage : storageImages) {
//            storageImage.getUid();
//        }
//        fastFileStorageClient.deleteFile("");
//        return new Result(ResultConstant.SUCCESS);
//    }

    @Autowired
    UserBaseService userBaseService;

    @ApiOperation(value = "清理无用图片")
    @RequestMapping(value = "cleanStorage")
    @ResponseBody
    public Result cleanStorage(@RequestBody ListReqVO listReqVO) {
//        List<StorageImage> storageImages = storageImageService.selectByExample(new StorageImageExample());
//        for (StorageImage storageImage : storageImages) {
//            storageImage.getUid();
//        }
//        fastFileStorageClient.deleteFile("");

        UserBaseExample example = new UserBaseExample();
        example.setOrderByClause("create_time asc");
        PageInfo<UserBase> userBasePageInfo = userBaseService.selectByExampleForStartPage(example, listReqVO.getPageNum(), listReqVO.getPageSize());
        List<UserBase> list = userBasePageInfo.getList();
        StorageImage storageImage1 = null;
        StorageImage storageImage2 = null;
        StorageImage storageImage3 = null;
        for (UserBase userBase : list) {
            if (userBase.getIdCardPhoto1() != null) {
                storageImage1 = storageImageService.selectByPrimaryKey(userBase.getIdCardPhoto1());
            }
            if (userBase.getIdCardPhoto2() != null) {
                storageImage2 = storageImageService.selectByPrimaryKey(userBase.getIdCardPhoto2());
            }
            if (userBase.getIdCardPhoto3() != null) {
                storageImage3 = storageImageService.selectByPrimaryKey(userBase.getIdCardPhoto3());
            }
            System.out.println("开始删除userUid:" + userBase.getUid() + ">>>>>>>>>>>>>>>>>>>>>>");
            if (deleteFile(storageImage1)) {
                userBase.setIdCardPhoto1(null);
                userBaseService.updateByPrimaryKey(userBase);
                if (storageImage1 != null) {
                    storageImageService.deleteByPrimaryKey(storageImage1.getUid());
                }
            }
            if (deleteFile(storageImage2)) {
                userBase.setIdCardPhoto2(null);
                userBaseService.updateByPrimaryKey(userBase);
                if (storageImage2 != null) {
                    storageImageService.deleteByPrimaryKey(storageImage2.getUid());
                }
            }
            if (deleteFile(storageImage3)) {
                userBase.setIdCardPhoto3(null);
                userBaseService.updateByPrimaryKey(userBase);
                if (storageImage3 != null) {
                    storageImageService.deleteByPrimaryKey(storageImage3.getUid());
                }
            }
            System.out.println("完成删除userUid:" + userBase.getUid() + "<<<<<<<<<<<<<<<<<<<<<");
            storageImage1 = null;
            storageImage2 = null;
            storageImage3 = null;
        }
        return new Result(ResultConstant.SUCCESS);
    }

    public boolean deleteFile(StorageImage storageImage) {
        if (storageImage != null) {
            System.out.println("开始删除storageImageUid:" + storageImage.getUid());
        }
        try {
            fastFileStorageClient.deleteFile(storageImage.getStorageGroup(), storageImage.getStoragePath());
            System.out.println("成功删除:" + storageImage.getFullPath());
        } catch (Exception e) {

        }
        try {
            fastFileStorageClient.deleteFile(storageImage.getStorageGroup(), storageImage.getThumbImagePath());
            System.out.println("成功删除Thumb:" + storageImage.getThumbImagePath());
        } catch (Exception e) {

        }
        return true;
    }

//    @RequestMapping(method = RequestMethod.GET, value = "thumbnail/{group}/{path}")
//    @ApiOperation(value = "文件下载", notes = "文件下载")
//    public void thumbnail(@PathVariable String group, @PathVariable String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        fastFileStorageClient.downloadFile(group, path, (DownloadCallback<String>) inputStream -> {
//            OutputStream outputStream = response.getOutputStream();
//            response.setHeader("Content-Disposition", "attachment;fileName=" + "headPic.jpg");
//            IOUtils.copy(inputStream, outputStream);
//            outputStream.flush();
//            return null;
//        });
//        // 获取缩略图路径
////        String path = thumbImageConfig.getThumbImagePath(storePath.getPath());
//        thumbImageConfig.getThumbImagePath()
////        fastFileStorageClient.getMetadata()
//        fastFileStorageClient.uploadImageAndCrtThumbImage()
////        http://localhost:8080/swagger-ui.html#!/storage-contoller/uploadUsingPOST
////        try (
////                InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
////                OutputStream outputStream = response.getOutputStream()) {
////            response.setContentType("application/x-download");
//////            response.addHeader("Content-Disposition", "attachment;filename=test.txt");
////            // 设置下载的响应头信息
////            response.setHeader("Content-Disposition",
////                    "attachment;fileName=" + "headPic.jpg");
////            IOUtils.copy(inputStream, outputStream);
////            outputStream.flush();
////        }
//    }

}
