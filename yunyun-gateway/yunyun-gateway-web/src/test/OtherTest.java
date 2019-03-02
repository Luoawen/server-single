import com.alankin.common.util.ValidationUtil;
import com.alankin.gateway.web.vo.request.SysUserReqVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by alankin on 2019/2/27.
 */
@ContextConfiguration(locations = {"classpath*:applicationContext-*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OtherTest {
    @Test
    public void testHibernateValidator() {
        SysUserReqVo sysUserReqVo = new SysUserReqVo();
        sysUserReqVo.setAuthCode("1111");
        sysUserReqVo.setPassword("1111");
//        sysUserReqVo.setPhone("1111");
        ValidationUtil.ValidResult validResult = ValidationUtil.validateBean(sysUserReqVo);
        if(validResult.hasErrors()){
            String errors = validResult.getErrors();
            System.out.println(errors);
        }
    }
}
