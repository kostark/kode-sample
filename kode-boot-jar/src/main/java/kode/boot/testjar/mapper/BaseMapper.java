package kode.boot.testjar.mapper;

import java.io.Serializable;

/**
 * 基础隐射接口
 *
 * @author Stark
 * @since 1.0
 */
@SuppressWarnings("MybatisMapperInXmlInspection")
public interface BaseMapper<T extends Serializable, K extends Serializable> {

//    /**
//     * 通过主键查找对象
//     *
//     * @param key 主键
//     * @return 主键对应的实体
//     */
//    T selectByKey(K key);
//
//    /**
//     * 插入实体
//     *
//     * @param obj 插入的实体
//     * @return 受影响的行数
//     */
//    int insert(T obj);
//
//    /**
//     * 属性选择性插入实体
//     *
//     * @param obj 插入的实体
//     * @return 受影响的行数
//     */
//    int insertSelective(T obj);
//
//    /**
//     * 通过主键更新
//     *
//     * @param obj 待更新的实体
//     * @return 受影响的行数
//     */
//    int updateByKey(T obj);
//
//    /**
//     * 选择性更新实体信息
//     *
//     * @param obj 待更新的实体
//     * @return 受影响的行数
//     */
//    int updateByKeySelective(T obj);
//
//    /**
//     * 通过主键删除
//     *
//     * @param key 主键
//     * @return 受影响的行数
//     */
//    int deleteByKey(K key);
}
