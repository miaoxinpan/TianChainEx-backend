package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PostTagsMapper;
import com.ruoyi.system.domain.PostTags;
import com.ruoyi.system.service.IPostTagsService;

/**
 * 文章-标签关联 (post_tags)Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
@Service
public class PostTagsServiceImpl implements IPostTagsService 
{
    @Autowired
    private PostTagsMapper postTagsMapper;

    /**
     * 查询文章-标签关联 (post_tags)
     * 
     * @param postId 文章-标签关联 (post_tags)主键
     * @return 文章-标签关联 (post_tags)
     */
    @Override
    public PostTags selectPostTagsByPostId(Long postId)
    {
        return postTagsMapper.selectPostTagsByPostId(postId);
    }

    /**
     * 查询文章-标签关联 (post_tags)列表
     * 
     * @param postTags 文章-标签关联 (post_tags)
     * @return 文章-标签关联 (post_tags)
     */
    @Override
    public List<PostTags> selectPostTagsList(PostTags postTags)
    {
        return postTagsMapper.selectPostTagsList(postTags);
    }

    /**
     * 新增文章-标签关联 (post_tags)
     * 
     * @param postTags 文章-标签关联 (post_tags)
     * @return 结果
     */
    @Override
    public int insertPostTags(PostTags postTags)
    {
        return postTagsMapper.insertPostTags(postTags);
    }

    /**
     * 修改文章-标签关联 (post_tags)
     * 
     * @param postTags 文章-标签关联 (post_tags)
     * @return 结果
     */
    @Override
    public int updatePostTags(PostTags postTags)
    {
        return postTagsMapper.updatePostTags(postTags);
    }

    /**
     * 批量删除文章-标签关联 (post_tags)
     * 
     * @param postIds 需要删除的文章-标签关联 (post_tags)主键
     * @return 结果
     */
    @Override
    public int deletePostTagsByPostIds(Long[] postIds)
    {
        return postTagsMapper.deletePostTagsByPostIds(postIds);
    }

    /**
     * 删除文章-标签关联 (post_tags)信息
     * 
     * @param postId 文章-标签关联 (post_tags)主键
     * @return 结果
     */
    @Override
    public int deletePostTagsByPostId(Long postId)
    {
        return postTagsMapper.deletePostTagsByPostId(postId);
    }
}
