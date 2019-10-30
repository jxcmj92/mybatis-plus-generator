package mybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mybatisplus.entity.User;
import mybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@ApiOperation(value = "")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

     @Autowired
     private IUserService iUserService;


     @ApiOperation(value = "分页查询")
     @RequestMapping("/listPage")
     public R page(@RequestBody Page<User> page, User user) {
         IPage<User> listPage = iUserService.page(page, user);
         return R.ok(listPage);
     }


     @ApiOperation(value = "新增")
     @RequestMapping("/save")
     public R save(@RequestBody User user) {
         return iUserService.save(user) ? R.ok(null) : R.failed("添加失败");
     }


     @ApiOperation(value = "删除")
     @RequestMapping("/delete")
     public R delete(String id) {
         Assert.hasText(id, "id不能为空");
         return iUserService.removeById(id) ? R.ok(null) : R.failed("删除失败");
     }

     @ApiOperation(value = "批量删除")
     @RequestMapping("/batchDelete")
     public R batchDelete(List<String> ids) {
         Assert.notEmpty(ids, "集合不能为空");
         return iUserService.removeByIds(ids) ? R.ok(null) : R.failed("删除失败");
     }


     @ApiOperation(value = "修改")
     @RequestMapping("/update")
     public R update(@RequestBody User user) {
         return iUserService.updateById(user) ? R.ok(null) : R.failed("更新失败");
     }


     @ApiOperation(value = "通过id查询")
     @RequestMapping("/getOneById")
     public R info(String id) {
         Assert.hasText(id, "id不能为空");
         User user = iUserService.getById(id);
         return R.ok(user);
     }
}

