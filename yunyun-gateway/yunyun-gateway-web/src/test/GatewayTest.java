import com.alankin.gateway.web.vo.ListVo.ListReqVO;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alankin.ucenter.dao.model.*;
import com.alankin.ucenter.rpc.api.StorageImageService;
import com.alankin.ucenter.rpc.api.SysUserBaseService;
import com.alankin.ucenter.rpc.api.UserBaseService;
import com.github.pagehelper.PageInfo;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.www.content.image.png;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * Created by alankin on 2019/1/1.
 */
@ContextConfiguration(locations = {"classpath*:applicationContext*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class GatewayTest {
    @Autowired
    FastFileStorageClient fastFileStorageClient;
    @Autowired
    StorageImageService storageImageService;
    @Autowired
    SysUserBaseService sysUserBaseService;
    @Autowired
    UserBaseService userBaseService;

    @Test
    public void uploadFile() throws Exception {
//        File file = new File("/home/duhui/code/fastdfsdemo/src/test/resources/images/54af9bcdN78b67b5a.jpg");
//        File file = new File("I:\\alankin\\songProject\\loan-manage-server\\yunyun-gateway\\yunyun-gateway-web\\src\\main\\resources\\images\\20180524233824.png");
//        I:\alankin\songProject\loan-server-single\yunyun-gateway\yunyun-gateway-web\src\main\resources\images\20180524233824.
        File file = new File("D:\\project\\loan-server-single\\yunyun-gateway\\yunyun-gateway-web\\src\\main\\resources\\images\\20180524233824.png");
        StorePath storePath = fastFileStorageClient.uploadFile(null, new FileInputStream(file), file.length(), "png");
        System.out.println(storePath + "---------------");
//StorePath [group=group1, path=M00/00/00/wKiMgFwsKReAHlvNAAVnIPDfJKM803.png]
//StorePath [group=group1, path=M00/00/00/wKjrglyJ6q-AEMetAAVnIPDfJKM694.png]//本地
    }

    @Test
    public void deleteFile() throws Exception {
        fastFileStorageClient.deleteFile("group1", "M00/00/5B/rBBfblyA2R2Aei2LADW0aoaQFoA630.jpg");
        System.out.println("--------deleteFile完成-------");
    }

    @Test
    public void deleteStorage() throws Exception {
        StorageImageExample example = new StorageImageExample();
//        List<StorageImage> storageImages = storageImageService.selectByExampleForOffsetPage(example, 0, 1000);
        List<StorageImage> storageImages = storageImageService.selectByExample(example);
//        PageInfo<StorageImage> storageImagePageInfo = storageImageService.selectByExampleForStartPage(example, 1, 400);
//        List<StorageImage> storageImages = storageImagePageInfo.getList();
        for (StorageImage storageImage : storageImages) {
            System.out.println(storageImage);
            UserBaseExample userBaseExample = new UserBaseExample();
            userBaseExample.createCriteria().andIdCardPhoto1EqualTo(storageImage.getUid());
            userBaseExample.or().andIdCardPhoto2EqualTo(storageImage.getUid());
            userBaseExample.or().andIdCardPhoto3EqualTo(storageImage.getUid());
            int countUser = userBaseService.countByExample(userBaseExample);

            SysUserBaseExample sysUserBaseExample = new SysUserBaseExample();
            sysUserBaseExample.createCriteria().andWchatQrcodeEqualTo(storageImage.getUid());
            int countSysUser = sysUserBaseService.countByExample(sysUserBaseExample);
            if (countUser < 1 && countSysUser < 1) {//系统用户和用户都没有该照片
                if (deleteFile(storageImage)) {
                    storageImageService.deleteByPrimaryKey(storageImage.getUid());
                }
            }
        }
    }

    //按用户注册时间删除
    @Test
    public void cleanStorage() {
//        List<StorageImage> storageImages = storageImageService.selectByExample(new StorageImageExample());
//        for (StorageImage storageImage : storageImages) {
//            storageImage.getUid();
//        }
//        fastFileStorageClient.deleteFile("");

        UserBaseExample example = new UserBaseExample();
        example.setOrderByClause("create_time asc");
        PageInfo<UserBase> userBasePageInfo = userBaseService.selectByExampleForStartPage(example, 15, 400);
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
}

