package kode.boot.testjar.mapper;

import kode.boot.testjar.domain.SecUser;

public interface SecUserMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecUser record);

    int insertSelective(SecUser record);

    SecUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecUser record);

    int updateByPrimaryKey(SecUser record);
}