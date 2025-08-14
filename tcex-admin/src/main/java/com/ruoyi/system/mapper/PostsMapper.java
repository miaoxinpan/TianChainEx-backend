package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Posts;

/**
 * 文章 (posts)Mapper接口
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
public interface PostsMapper 
{
    /**
     * 查询文章 (posts)
     * 
     * @param id 文章 (posts)主键
     * @return 文章 (posts)
     */
    public Posts selectPostsById(Long id);

    /**
     * 查询文章 (posts)列表
     * 
     * @param posts 文章 (posts)
     * @return 文章 (posts)集合
     */
    public List<Posts> selectPostsList(Posts posts);

    /**
     * 新增文章 (posts)
     * 
     * @param posts 文章 (posts)
     * @return 结果
     */
    public int insertPosts(Posts posts);

    /**
     * 修改文章 (posts)
     * 
     * @param posts 文章 (posts)
     * @return 结果
     */
    public int updatePosts(Posts posts);

    /**
     * 删除文章 (posts)
     * 
     * @param id 文章 (posts)主键
     * @return 结果
     */
    public int deletePostsById(Long id);

    /**
     * 批量删除文章 (posts)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePostsByIds(Long[] ids);
}
