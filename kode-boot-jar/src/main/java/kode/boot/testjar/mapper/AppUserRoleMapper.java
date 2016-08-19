package kode.boot.testjar.mapper;

import kode.boot.testjar.domain.AppUserRole;

public interface AppUserRoleMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppUserRole record);

    int insertSelective(AppUserRole record);

    AppUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppUserRole record);

    int updateByPrimaryKey(AppUserRole record);
}