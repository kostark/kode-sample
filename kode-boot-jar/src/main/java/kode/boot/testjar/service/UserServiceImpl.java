package kode.boot.testjar.service;

import kode.boot.testjar.mapper.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
}
