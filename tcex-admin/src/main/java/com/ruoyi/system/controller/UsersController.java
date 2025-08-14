package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Users;
import com.ruoyi.system.service.IUsersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户 (users)Controller
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
@RestController
@RequestMapping("/system/users")
public class UsersController extends BaseController
{
    @Autowired
    private IUsersService usersService;

    /**
     * 查询用户 (users)列表
     */
    @PreAuthorize("@ss.hasPermi('system:users:list')")
    @GetMapping("/list")
    public TableDataInfo list(Users users)
    {
        startPage();
        List<Users> list = usersService.selectUsersList(users);
        return getDataTable(list);
    }

    /**
     * 导出用户 (users)列表
     */
    @PreAuthorize("@ss.hasPermi('system:users:export')")
    @Log(title = "用户 (users)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Users users)
    {
        List<Users> list = usersService.selectUsersList(users);
        ExcelUtil<Users> util = new ExcelUtil<Users>(Users.class);
        util.exportExcel(response, list, "用户 (users)数据");
    }

    /**
     * 获取用户 (users)详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:users:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(usersService.selectUsersById(id));
    }

    /**
     * 新增用户 (users)
     */
    @PreAuthorize("@ss.hasPermi('system:users:add')")
    @Log(title = "用户 (users)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Users users)
    {
        return toAjax(usersService.insertUsers(users));
    }

    /**
     * 修改用户 (users)
     */
    @PreAuthorize("@ss.hasPermi('system:users:edit')")
    @Log(title = "用户 (users)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Users users)
    {
        return toAjax(usersService.updateUsers(users));
    }

    /**
     * 删除用户 (users)
     */
    @PreAuthorize("@ss.hasPermi('system:users:remove')")
    @Log(title = "用户 (users)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(usersService.deleteUsersByIds(ids));
    }
}
