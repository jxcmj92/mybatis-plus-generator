package mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import mybatisplus.entity.User;

/**
 *  服务类
 */
public interface IUserService extends IService<User> {

   /**
    * 分页查询
    * @param page 分页条件
    * @param user 对象
    * @return 返回结果
    */
   IPage<User> page(Page<User> page, User user);

}
