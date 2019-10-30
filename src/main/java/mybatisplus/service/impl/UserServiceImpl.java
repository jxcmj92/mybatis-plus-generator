package mybatisplus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import mybatisplus.entity.User;
import mybatisplus.mapper.UserMapper;
import mybatisplus.service.IUserService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 *  服务实现类
 *
 * @author chenmingjian
 * @since 2019-10-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> page(Page<User> page, User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        return userMapper.selectPage(page, queryWrapper);
    }
}
