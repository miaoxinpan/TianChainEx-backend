package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Users;

/**
 * 用户 (users)Mapper接口
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
public interface UsersMapper 
{
    /**
     * 查询用户 (users)
     * 
     * @param id 用户 (users)主键
     * @return 用户 (users)
     */
    public Users selectUsersById(Long id);

    /**
     * 查询用户 (users)列表
     * 
     * @param users 用户 (users)
     * @return 用户 (users)集合
     */
    public List<Users> selectUsersList(Users users);

    /**
     * 新增用户 (users)
     * 
     * @param users 用户 (users)
     * @return 结果
     */
    public int insertUsers(Users users);

    /**
     * 修改用户 (users)
     * 
     * @param users 用户 (users)
     * @return 结果
     */
    public int updateUsers(Users users);

    /**
     * 删除用户 (users)
     * 
     * @param id 用户 (users)主键
     * @return 结果
     */
    public int deleteUsersById(Long id);

    /**
     * 批量删除用户 (users)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUsersByIds(Long[] ids);
}
