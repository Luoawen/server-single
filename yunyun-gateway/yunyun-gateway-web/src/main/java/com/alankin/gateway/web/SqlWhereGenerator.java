package com.alankin.gateway.web;

import com.alankin.common.annotation.EndTime;
import com.alankin.common.annotation.StartTime;
import com.alankin.common.annotation.WhereEqual;
import com.alankin.common.annotation.WhereLike;
import com.alankin.common.util.*;
import com.alankin.gateway.web.vo.request.*;
import org.apache.velocity.VelocityContext;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 代码生成类
 * Created by alankin on 2017/4/26.
 */
public class SqlWhereGenerator {

    // 根据命名规范，只修改此常量值即可
    private static String TARGET_CLASS_PACKAGE_NAME = "com.alankin.gateway.web.vo.request";

    static {

    }

    /**
     * 自动代码生成
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
//        generatorListReqWhere(ApplyOrderReqVo.class, TARGET_CLASS_PACKAGE_NAME);
//        generatorListReqWhere(CusUserListReqVo.class, TARGET_CLASS_PACKAGE_NAME);
//        generatorListReqWhere(ChannelAcountListReqVo.class, TARGET_CLASS_PACKAGE_NAME);
//        generatorListReqWhere(LoanReceiptListReqVo.class, TARGET_CLASS_PACKAGE_NAME);
        generatorListReqWhere(BrrowerListReqVo.class, TARGET_CLASS_PACKAGE_NAME);
    }

    // generatorConfig模板路径
    private static String sqlTemplate = "/template/sqlTemplate.vm";

    /**
     * 根据模板生成generatorConfig.xml文件
     *
     * @throws Exception
     */
    public static void generatorListReqWhere(Class targetClass, String target_class_package_name) throws Exception {
        System.out.println("*************************开始生成*************************");
        sqlTemplate = MybatisGeneratorUtil.class.getResource(sqlTemplate).getPath().replaceFirst("/", "");
        String basePath = SqlWhereGenerator.class.getResource("/").getPath().replace("/target/classes/", "");
        String targetPath = basePath + "/src/main/java/" + target_class_package_name.replaceAll("\\.", "/") + "/" + targetClass.getSimpleName() + ".xml";
        System.out.println(targetPath);

        File targetXML_FILE = new File(targetPath);
        if (targetXML_FILE.exists()) {
            deleteDir(targetXML_FILE);
        }
        try {
            VelocityContext context = new VelocityContext();
            Field[] declaredFields = targetClass.getDeclaredFields();
            List dataList = new ArrayList();
            for (Field declaredField : declaredFields) {
                WhereEqual whereEqual = declaredField.getDeclaredAnnotation(WhereEqual.class);
                if (whereEqual != null) {
                    String name = whereEqual.dbFieldName();
                    dataList.add(new DataBean(declaredField.getName(),name, 0));
                }
                WhereLike whereLike = declaredField.getDeclaredAnnotation(WhereLike.class);
                if (whereLike != null) {
                    String name = whereLike.dbFieldName();
                    dataList.add(new DataBean(declaredField.getName(),name, 1));
                }
                StartTime startTime = declaredField.getDeclaredAnnotation(StartTime.class);
                EndTime endTime = declaredField.getDeclaredAnnotation(EndTime.class);
                if (startTime != null) {
                    String name = startTime.dbFieldName();
                    dataList.add(new DataBean(declaredField.getName(), name, 2));
                }
                if (endTime != null) {
                    String name = endTime.dbFieldName();
                    dataList.add(new DataBean(declaredField.getName(), name, 3));
                }
            }
            context.put("dataList", dataList);
            VelocityUtil.generate(sqlTemplate, targetPath, context);
            System.out.println("*************************完成*************************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 递归删除非空文件夹
    public static void deleteDir(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteDir(files[i]);
            }
        }
        dir.delete();
    }

    public static class DataBean {
        int type;//0为=值 1为like值 2为startTime  3为endTime
        String fieldName = "";
        String dbFieldName = "";

        public DataBean(String fieldName, int type) {
            this.type = type;
            this.fieldName = fieldName;
        }

        public DataBean(String fieldName, String dbFieldName, int type) {
            this.type = type;
            this.fieldName = fieldName;
            this.dbFieldName = dbFieldName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getDbFieldName() {
            return dbFieldName;
        }

        public void setDbFieldName(String dbFieldName) {
            this.dbFieldName = dbFieldName;
        }
    }
}
