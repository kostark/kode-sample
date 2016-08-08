package kode.boot.testjar.service;

import kode.boot.testjar.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * @author Stark
 * @since 1.0, 2016/7/26
 */
@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public int countAllUser() {
        return userMapper.countAllUser();
    }
}
