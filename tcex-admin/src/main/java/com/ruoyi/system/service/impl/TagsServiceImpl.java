package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TagsMapper;
import com.ruoyi.system.domain.Tags;
import com.ruoyi.system.service.ITagsService;

/**
 * 标签 (tags)Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
@Service
public class TagsServiceImpl implements ITagsService 
{
    @Autowired
    private TagsMapper tagsMapper;

    /**
     * 查询标签 (tags)
     * 
     * @param id 标签 (tags)主键
     * @return 标签 (tags)
     */
    @Override
    public Tags selectTagsById(Long id)
    {
        return tagsMapper.selectTagsById(id);
    }

    /**
     * 查询标签 (tags)列表
     * 
     * @param tags 标签 (tags)
     * @return 标签 (tags)
     */
    @Override
    public List<Tags> selectTagsList(Tags tags)
    {
        return tagsMapper.selectTagsList(tags);
    }

    /**
     * 新增标签 (tags)
     * 
     * @param tags 标签 (tags)
     * @return 结果
     */
    @Override
    public int insertTags(Tags tags)
    {
        return tagsMapper.insertTags(tags);
    }

    /**
     * 修改标签 (tags)
     * 
     * @param tags 标签 (tags)
     * @return 结果
     */
    @Override
    public int updateTags(Tags tags)
    {
        return tagsMapper.updateTags(tags);
    }

    /**
     * 批量删除标签 (tags)
     * 
     * @param ids 需要删除的标签 (tags)主键
     * @return 结果
     */
    @Override
    public int deleteTagsByIds(Long[] ids)
    {
        return tagsMapper.deleteTagsByIds(ids);
    }

    /**
     * 删除标签 (tags)信息
     * 
     * @param id 标签 (tags)主键
     * @return 结果
     */
    @Override
    public int deleteTagsById(Long id)
    {
        return tagsMapper.deleteTagsById(id);
    }
}
