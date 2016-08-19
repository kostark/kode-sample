package kode.boot.testjar.mapper;

import kode.boot.testjar.domain.AppRole;

public interface AppRoleMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppRole record);

    int insertSelective(AppRole record);

    AppRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppRole record);

    int updateByPrimaryKey(AppRole record);
}