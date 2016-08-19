package kode.boot.testjar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Stark
 * @since 1.0, 2016/7/26
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public int countAllUser() {
        return userMapper.countAllUser();
    }
}
