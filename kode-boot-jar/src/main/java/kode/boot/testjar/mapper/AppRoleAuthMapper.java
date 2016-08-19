package kode.boot.testjar.mapper;

import kode.boot.testjar.domain.AppRoleAuth;

public interface AppRoleAuthMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppRoleAuth record);

    int insertSelective(AppRoleAuth record);

    AppRoleAuth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppRoleAuth record);

    int updateByPrimaryKey(AppRoleAuth record);
}