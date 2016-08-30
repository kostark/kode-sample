package kode.boot.testjar.service;

import org.springframework.security.access.prepost.PreAuthorize;

/**
 * @author Stark
 * @since 1.0, 2016/7/26
 */
public interface AppUserService {
    int countAllUser();


    int getUserStatus(long userId);
}
