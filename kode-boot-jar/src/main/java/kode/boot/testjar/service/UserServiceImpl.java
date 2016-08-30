package kode.boot.testjar.service;

import kode.boot.testjar.mapper.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author Stark
 * @since 1.0, 2016/7/26
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    AppUserMapper appUserMapper;

    @Override
    public int countAllUser() {
        return appUserMapper.countAllUser();
    }

    @Override
    @PreAuthorize("authenticated and #userId == 1")
    public int getUserStatus(long userId) {
        return 2;
    }
}
