package com.alankin.common.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * BaseService接口
 * Created by alankin on 2017/01/07.
 */
public interface BaseService<Record, Example> {

    /**
     * 根据条件查询记录数量
     *
     * @param example
     * @return
     */
    int countByExample(Example example);

    /**
     * 根据条件删除记录
     *
     * @param example
     * @return
     */
    int deleteByExample(Example example);

    /**
     * 根据主键删除记录
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据主键删除记录
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入记录
     *
     * @param record
     * @return
     */
    int insert(Record record)throws Exception;

    /**
     * 插入记录有效字段
     *
     * @param record
     * @return
     */
    int insertSelective(Record record) throws Exception;

    /**
     * 根据条件查询记录，附带BLOB字段
     *
     * @param example
     * @return
     */
    List<Record> selectByExampleWithBLOBs(Example example);

    /**
     * 根据条件查询记录
     *
     * @param example
     * @return
     */
    List<Record> selectByExample(Example example);

    List<Record> selectAllBeanByMethod(String method, Object param);

    Map selectByMethod(String method, Object param);

    Record selectBeanByMethod(String method, Object param);

    List<Map> selectAllByMethod(String method, Object param);

    List<Map> selectAllByMethod(String method);

    /**
     * 根据条件查询记录
     *
     * @param example
     * @return
     */
    List<Map> selectMapByExample(Example example);

    /**
     * 根据条件查询记录并按页码分页，附带BLOB字段
     *
     * @param example  条件
     * @param pageNum  页数
     * @param pageSize 每页记录数
     * @return
     */
    List<Record> selectByExampleWithBLOBsForStartPage(Example example, Integer pageNum, Integer pageSize);

    /**
     * 根据条件查询记录并按页码分页
     *
     * @param example  条件
     * @param pageNum  页数
     * @param pageSize 每页记录数
     * @return
     */
    PageInfo<Record> selectByExampleForStartPage(Example example, Integer pageNum, Integer pageSize);

    PageInfo<Record> selectByExampleForStartPage(Example example, Integer pageNum, Integer pageSize, boolean count);

    PageInfo selectForStartPageByMethod(String method, Object param, Integer pageNum, Integer pageSize, boolean count);

    PageInfo selectForStartPageByMethod(String method, Object param, Integer pageNum, Integer pageSize);

    PageInfo selectForStartPageByMethod(String method, Integer pageNum, Integer pageSize);

    PageInfo selectForStartPageByMethod(String method, Integer pageNum, Integer pageSize, boolean count);

    /**
     * 根据条件查询记录并按最后记录数分页，附带BLOB字段
     *
     * @param example 条件
     * @param offset  跳过数量
     * @param limit   查询数量
     * @return
     */
    List<Record> selectByExampleWithBLOBsForOffsetPage(Example example, Integer offset, Integer limit);

    /**
     * 根据条件查询记录并按最后记录数分页
     *
     * @param example 条件
     * @param offset  跳过数量
     * @param limit   查询数量
     * @return
     */
    List<Record> selectByExampleForOffsetPage(Example example, Integer offset, Integer limit);

    /**
     * 根据条件查询第一条记录
     *
     * @param example
     * @return
     */
    Record selectFirstByExample(Example example);

    /**
     * 根据条件查询第一条记录，附带BLOB字段
     *
     * @param example
     * @return
     */
    Record selectFirstByExampleWithBLOBs(Example example);

    /**
     * 根据主键查询记录
     *
     * @param id
     * @return
     */
    Record selectByPrimaryKey(Long id);

    /**
     * 根据主键查询记录(主键类型为Integer)
     *
     * @param id
     * @return
     */
    Record selectByPrimaryKey(Integer id);

    /**
     * 根据条件更新有效字段
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

    /**
     * 根据条件更新记录有效字段，附带BLOB字段
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") Example example);

    /**
     * 根据条件更新记录
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Record record, @Param("example") Example example);

    /**
     * 根据主键更新记录有效字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Record record);

    /**
     * 根据主键更新记录，附带BLOB字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(Record record);

    /**
     * 根据主键更新记录
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Record record);

    /**
     * 根据主键批量删除记录
     *
     * @param ids
     * @return
     */
    int deleteByPrimaryKeys(String ids);

    int deleteByPrimaryIntegerKeys(String[] ids);

    int deleteByPrimaryKeys(String[] ids);

    /**
     * 初始化mapper
     */
    void initMapper();

}