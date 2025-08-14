package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CommentsMapper;
import com.ruoyi.system.domain.Comments;
import com.ruoyi.system.service.ICommentsService;

/**
 * 评论 (comments)Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
@Service
public class CommentsServiceImpl implements ICommentsService 
{
    @Autowired
    private CommentsMapper commentsMapper;

    /**
     * 查询评论 (comments)
     * 
     * @param id 评论 (comments)主键
     * @return 评论 (comments)
     */
    @Override
    public Comments selectCommentsById(Long id)
    {
        return commentsMapper.selectCommentsById(id);
    }

    /**
     * 查询评论 (comments)列表
     * 
     * @param comments 评论 (comments)
     * @return 评论 (comments)
     */
    @Override
    public List<Comments> selectCommentsList(Comments comments)
    {
        return commentsMapper.selectCommentsList(comments);
    }

    /**
     * 新增评论 (comments)
     * 
     * @param comments 评论 (comments)
     * @return 结果
     */
    @Override
    public int insertComments(Comments comments)
    {
        return commentsMapper.insertComments(comments);
    }

    /**
     * 修改评论 (comments)
     * 
     * @param comments 评论 (comments)
     * @return 结果
     */
    @Override
    public int updateComments(Comments comments)
    {
        return commentsMapper.updateComments(comments);
    }

    /**
     * 批量删除评论 (comments)
     * 
     * @param ids 需要删除的评论 (comments)主键
     * @return 结果
     */
    @Override
    public int deleteCommentsByIds(Long[] ids)
    {
        return commentsMapper.deleteCommentsByIds(ids);
    }

    /**
     * 删除评论 (comments)信息
     * 
     * @param id 评论 (comments)主键
     * @return 结果
     */
    @Override
    public int deleteCommentsById(Long id)
    {
        return commentsMapper.deleteCommentsById(id);
    }
}
