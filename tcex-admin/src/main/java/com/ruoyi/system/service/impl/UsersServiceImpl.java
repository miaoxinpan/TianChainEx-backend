package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UsersMapper;
import com.ruoyi.system.domain.Users;
import com.ruoyi.system.service.IUsersService;

/**
 * 用户 (users)Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
@Service
public class UsersServiceImpl implements IUsersService 
{
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 查询用户 (users)
     * 
     * @param id 用户 (users)主键
     * @return 用户 (users)
     */
    @Override
    public Users selectUsersById(Long id)
    {
        return usersMapper.selectUsersById(id);
    }

    /**
     * 查询用户 (users)列表
     * 
     * @param users 用户 (users)
     * @return 用户 (users)
     */
    @Override
    public List<Users> selectUsersList(Users users)
    {
        return usersMapper.selectUsersList(users);
    }

    /**
     * 新增用户 (users)
     * 
     * @param users 用户 (users)
     * @return 结果
     */
    @Override
    public int insertUsers(Users users)
    {
        return usersMapper.insertUsers(users);
    }

    /**
     * 修改用户 (users)
     * 
     * @param users 用户 (users)
     * @return 结果
     */
    @Override
    public int updateUsers(Users users)
    {
        return usersMapper.updateUsers(users);
    }

    /**
     * 批量删除用户 (users)
     * 
     * @param ids 需要删除的用户 (users)主键
     * @return 结果
     */
    @Override
    public int deleteUsersByIds(Long[] ids)
    {
        return usersMapper.deleteUsersByIds(ids);
    }

    /**
     * 删除用户 (users)信息
     * 
     * @param id 用户 (users)主键
     * @return 结果
     */
    @Override
    public int deleteUsersById(Long id)
    {
        return usersMapper.deleteUsersById(id);
    }
}
