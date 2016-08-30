package kode.boot.testjar.service;

import kode.boot.testjar.domain.AppAuth;

import java.util.List;

/**
 * 用户服务
 *
 * @version 1.0
 * @since 2016/8/30
 */
public interface AppRoleService {
    List<AppAuth> getAuthByRoleId(long roleId);


}
