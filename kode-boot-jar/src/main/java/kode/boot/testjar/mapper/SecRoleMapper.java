package kode.boot.testjar.mapper;

import kode.boot.testjar.domain.SecRole;

public interface SecRoleMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecRole record);

    int insertSelective(SecRole record);

    SecRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecRole record);

    int updateByPrimaryKey(SecRole record);
}