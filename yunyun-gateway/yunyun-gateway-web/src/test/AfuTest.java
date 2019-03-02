import com.alankin.gateway.web.utils.Constants;
import com.alibaba.fastjson.JSONObject;
import com.zhicheng.echo.star.enums.ReasonEnum;
import com.zhicheng.echo.star.utils.HttpClientUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alankin on 2019/2/25.
 */
public class AfuTest {

    /**
     * 欺诈进阶版（无设备指纹）
     */
    @Test
    public void qiZhaTest() {
        Map<String, String> vo = new HashMap<>();

        //开始查询
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        //用户名
        nameValuePairs.add(new BasicNameValuePair("user_name", Constants.qizha_user_name));
        //rc4秘钥
        nameValuePairs.add(new BasicNameValuePair("sign", Constants.qizha_sign));
        //接口业务码 参考接口文档
        nameValuePairs.add(new BasicNameValuePair("api_name", Constants.api_name_jinjie));
        // 查询原因
        // LOAN_AUDIT：贷款审批 LOAN_MANAGE：贷后管理 CREDIT_CARD_AUDIT：信用卡审批
        // GUARANTEE_AUDIT:担保资格审查 PRE_GUARANTEE_AUDIT:保前审查
        nameValuePairs.add(new BasicNameValuePair("query_reason", "LOAN_AUDIT"));
        //查询条件,格式为 json 格式
        nameValuePairs.add(new BasicNameValuePair("params", gennerateRequetParam(vo).toJSONString()));
        String s = HttpClientUtil.doPost(Constants.url, nameValuePairs, "utf-8");
        System.out.println("欺诈数据:>>>>>>>>>>>>>>>>>>");
        System.out.println(s);
    }

    /**
     * 进阶版（无设备指纹参数构建）
     *
     * @param vo
     * @return
     */
    public JSONObject gennerateRequetParam(Map<String, String> vo) {
        JSONObject dataJson = new JSONObject();
        dataJson.put("amount_business", "0");
        dataJson.put("id_no", "352201198902285830");//被查询人身份证号 18 位以内
        dataJson.put("name", "郑祖钦");//被查询人姓名 2-30 位
        dataJson.put("mobile", "15892128293");//被查询人姓名 2-30 位
        dataJson.put("bank_no", "");
        return dataJson;
    }

    /**
     * 多头
     */
    @Test
    public void mutiTest() {
        /*查询条件拼接 开始*/
        JSONObject dataJson = new JSONObject();
        dataJson.put("id_no", "352201198902285830");//被查询人身份证号 18 位以内
        dataJson.put("name", "郑祖钦");//被查询人姓名 2-30 位
        //开始查询
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        //用户名
        nameValuePairs.add(new BasicNameValuePair("user_name", Constants.muti_user_name));
        //rc4秘钥
        nameValuePairs.add(new BasicNameValuePair("sign", Constants.muti_sign));
        //接口业务码 参考接口文档
        nameValuePairs.add(new BasicNameValuePair("api_name", Constants.api_name));
        // 查询原因
        // LOAN_AUDIT：贷款审批 LOAN_MANAGE：贷后管理 CREDIT_CARD_AUDIT：信用卡审批
        // GUARANTEE_AUDIT:担保资格审查 PRE_GUARANTEE_AUDIT:保前审查
        nameValuePairs.add(new BasicNameValuePair("query_reason", ReasonEnum.LOAN_AUDIT.getType()));
        //查询条件,格式为 json 格式
        nameValuePairs.add(new BasicNameValuePair("params", dataJson.toJSONString()));
        String s = HttpClientUtil.doPost(Constants.url, nameValuePairs, "utf-8");
        System.out.println("多头数据:>>>>>>>>>>>>>>>>>>");
        System.out.println(s);

    }
}
