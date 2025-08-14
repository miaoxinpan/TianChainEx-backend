package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PostsMapper;
import com.ruoyi.system.domain.Posts;
import com.ruoyi.system.service.IPostsService;

/**
 * 文章 (posts)Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
@Service
public class PostsServiceImpl implements IPostsService 
{
    @Autowired
    private PostsMapper postsMapper;

    /**
     * 查询文章 (posts)
     * 
     * @param id 文章 (posts)主键
     * @return 文章 (posts)
     */
    @Override
    public Posts selectPostsById(Long id)
    {
        return postsMapper.selectPostsById(id);
    }

    /**
     * 查询文章 (posts)列表
     * 
     * @param posts 文章 (posts)
     * @return 文章 (posts)
     */
    @Override
    public List<Posts> selectPostsList(Posts posts)
    {
        return postsMapper.selectPostsList(posts);
    }

    /**
     * 新增文章 (posts)
     * 
     * @param posts 文章 (posts)
     * @return 结果
     */
    @Override
    public int insertPosts(Posts posts)
    {
        posts.setCreatedAt(new Date());
        posts.setSlug("title");
        posts.setExcerpt("test");
        posts.setAuthorId(1L);
        return postsMapper.insertPosts(posts);
    }

    /**
     * 修改文章 (posts)
     * 
     * @param posts 文章 (posts)
     * @return 结果
     */
    @Override
    public int updatePosts(Posts posts)
    {
        return postsMapper.updatePosts(posts);
    }

    /**
     * 批量删除文章 (posts)
     * 
     * @param ids 需要删除的文章 (posts)主键
     * @return 结果
     */
    @Override
    public int deletePostsByIds(Long[] ids)
    {
        return postsMapper.deletePostsByIds(ids);
    }

    /**
     * 删除文章 (posts)信息
     * 
     * @param id 文章 (posts)主键
     * @return 结果
     */
    @Override
    public int deletePostsById(Long id)
    {
        return postsMapper.deletePostsById(id);
    }
}
