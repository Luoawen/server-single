import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.net.www.content.image.png;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by alankin on 2019/1/1.
 */
@ContextConfiguration(locations = {"classpath*:applicationContext-fastdfs.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class GatewayTest {
    @Autowired
    FastFileStorageClient fastFileStorageClient;

    @Test
    public void uploadFile() throws Exception {
//        File file = new File("/home/duhui/code/fastdfsdemo/src/test/resources/images/54af9bcdN78b67b5a.jpg");
//        File file = new File("I:\\alankin\\songProject\\loan-manage-server\\yunyun-gateway\\yunyun-gateway-web\\src\\main\\resources\\images\\20180524233824.png");
//        I:\alankin\songProject\loan-server-single\yunyun-gateway\yunyun-gateway-web\src\main\resources\images\20180524233824.
        File file = new File("I:\\alankin\\songProject\\loan-server-single\\yunyun-gateway\\yunyun-gateway-web\\src\\main\\resources\\images\\20180524233824.png");
        StorePath storePath = fastFileStorageClient.uploadFile(null, new FileInputStream(file), file.length(), "png");
        System.out.println(storePath + "---------------");
//StorePath [group=group1, path=M00/00/00/wKiMgFwsKReAHlvNAAVnIPDfJKM803.png]
//StorePath [group=group1, path=M00/00/00/wKjrglyJ6q-AEMetAAVnIPDfJKM694.png]//本地
    }

    @Test
    public void deleteFile() throws Exception {
        fastFileStorageClient.deleteFile("group1", "M00/00/82/rBBfblyHBbeAI_yDAC9GzNs8wIE603.jpg");
        System.out.println("--------deleteFile完成-------");
    }
}

