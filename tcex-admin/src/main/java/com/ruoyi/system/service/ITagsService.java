package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Tags;

/**
 * 标签 (tags)Service接口
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
public interface ITagsService 
{
    /**
     * 查询标签 (tags)
     * 
     * @param id 标签 (tags)主键
     * @return 标签 (tags)
     */
    public Tags selectTagsById(Long id);

    /**
     * 查询标签 (tags)列表
     * 
     * @param tags 标签 (tags)
     * @return 标签 (tags)集合
     */
    public List<Tags> selectTagsList(Tags tags);

    /**
     * 新增标签 (tags)
     * 
     * @param tags 标签 (tags)
     * @return 结果
     */
    public int insertTags(Tags tags);

    /**
     * 修改标签 (tags)
     * 
     * @param tags 标签 (tags)
     * @return 结果
     */
    public int updateTags(Tags tags);

    /**
     * 批量删除标签 (tags)
     * 
     * @param ids 需要删除的标签 (tags)主键集合
     * @return 结果
     */
    public int deleteTagsByIds(Long[] ids);

    /**
     * 删除标签 (tags)信息
     * 
     * @param id 标签 (tags)主键
     * @return 结果
     */
    public int deleteTagsById(Long id);
}
