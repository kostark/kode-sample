package kode.boot.testjar.mapper;

import kode.boot.testjar.domain.SecRoleAuth;

public interface SecRoleAuthMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecRoleAuth record);

    int insertSelective(SecRoleAuth record);

    SecRoleAuth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecRoleAuth record);

    int updateByPrimaryKey(SecRoleAuth record);
}