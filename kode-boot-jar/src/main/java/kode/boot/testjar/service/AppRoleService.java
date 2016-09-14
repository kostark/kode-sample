package kode.boot.testjar.service;

import kode.boot.testjar.domain.AppResource;

import java.util.List;

/**
 * 用户服务
 *
 * @version 1.0
 * @since 2016/8/30
 */
public interface AppRoleService {
    List<AppResource> getAuthByRoleId(long roleId);


}
