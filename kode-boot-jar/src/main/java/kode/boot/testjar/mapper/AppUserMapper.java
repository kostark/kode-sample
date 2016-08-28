package kode.boot.testjar.mapper;

import kode.boot.testjar.domain.AppUser;

public interface AppUserMapper extends BaseMapper<AppUser, Long> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(AppUser record);

    AppUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppUser record);

    int updateByPrimaryKey(AppUser record);

    int countAllUser();
}