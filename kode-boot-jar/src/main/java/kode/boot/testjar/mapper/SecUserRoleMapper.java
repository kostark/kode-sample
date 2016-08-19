package kode.boot.testjar.mapper;

import kode.boot.testjar.domain.SecUserRole;

public interface SecUserRoleMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecUserRole record);

    int insertSelective(SecUserRole record);

    SecUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecUserRole record);

    int updateByPrimaryKey(SecUserRole record);
}