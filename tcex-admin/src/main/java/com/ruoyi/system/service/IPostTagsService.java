package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PostTags;

/**
 * 文章-标签关联 (post_tags)Service接口
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
public interface IPostTagsService 
{
    /**
     * 查询文章-标签关联 (post_tags)
     * 
     * @param postId 文章-标签关联 (post_tags)主键
     * @return 文章-标签关联 (post_tags)
     */
    public PostTags selectPostTagsByPostId(Long postId);

    /**
     * 查询文章-标签关联 (post_tags)列表
     * 
     * @param postTags 文章-标签关联 (post_tags)
     * @return 文章-标签关联 (post_tags)集合
     */
    public List<PostTags> selectPostTagsList(PostTags postTags);

    /**
     * 新增文章-标签关联 (post_tags)
     * 
     * @param postTags 文章-标签关联 (post_tags)
     * @return 结果
     */
    public int insertPostTags(PostTags postTags);

    /**
     * 修改文章-标签关联 (post_tags)
     * 
     * @param postTags 文章-标签关联 (post_tags)
     * @return 结果
     */
    public int updatePostTags(PostTags postTags);

    /**
     * 批量删除文章-标签关联 (post_tags)
     * 
     * @param postIds 需要删除的文章-标签关联 (post_tags)主键集合
     * @return 结果
     */
    public int deletePostTagsByPostIds(Long[] postIds);

    /**
     * 删除文章-标签关联 (post_tags)信息
     * 
     * @param postId 文章-标签关联 (post_tags)主键
     * @return 结果
     */
    public int deletePostTagsByPostId(Long postId);
}
