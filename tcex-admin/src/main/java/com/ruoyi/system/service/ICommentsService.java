package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Comments;

/**
 * 评论 (comments)Service接口
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
public interface ICommentsService 
{
    /**
     * 查询评论 (comments)
     * 
     * @param id 评论 (comments)主键
     * @return 评论 (comments)
     */
    public Comments selectCommentsById(Long id);

    /**
     * 查询评论 (comments)列表
     * 
     * @param comments 评论 (comments)
     * @return 评论 (comments)集合
     */
    public List<Comments> selectCommentsList(Comments comments);

    /**
     * 新增评论 (comments)
     * 
     * @param comments 评论 (comments)
     * @return 结果
     */
    public int insertComments(Comments comments);

    /**
     * 修改评论 (comments)
     * 
     * @param comments 评论 (comments)
     * @return 结果
     */
    public int updateComments(Comments comments);

    /**
     * 批量删除评论 (comments)
     * 
     * @param ids 需要删除的评论 (comments)主键集合
     * @return 结果
     */
    public int deleteCommentsByIds(Long[] ids);

    /**
     * 删除评论 (comments)信息
     * 
     * @param id 评论 (comments)主键
     * @return 结果
     */
    public int deleteCommentsById(Long id);
}
