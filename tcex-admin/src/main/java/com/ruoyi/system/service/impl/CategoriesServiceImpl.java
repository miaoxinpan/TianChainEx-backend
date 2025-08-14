package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CategoriesMapper;
import com.ruoyi.system.domain.Categories;
import com.ruoyi.system.service.ICategoriesService;

/**
 * 分类 (categories)Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
@Service
public class CategoriesServiceImpl implements ICategoriesService 
{
    @Autowired
    private CategoriesMapper categoriesMapper;

    /**
     * 查询分类 (categories)
     * 
     * @param id 分类 (categories)主键
     * @return 分类 (categories)
     */
    @Override
    public Categories selectCategoriesById(Long id)
    {
        return categoriesMapper.selectCategoriesById(id);
    }

    /**
     * 查询分类 (categories)列表
     * 
     * @param categories 分类 (categories)
     * @return 分类 (categories)
     */
    @Override
    public List<Categories> selectCategoriesList(Categories categories)
    {
        return categoriesMapper.selectCategoriesList(categories);
    }

    /**
     * 新增分类 (categories)
     * 
     * @param categories 分类 (categories)
     * @return 结果
     */
    @Override
    public int insertCategories(Categories categories)
    {
        return categoriesMapper.insertCategories(categories);
    }

    /**
     * 修改分类 (categories)
     * 
     * @param categories 分类 (categories)
     * @return 结果
     */
    @Override
    public int updateCategories(Categories categories)
    {
        return categoriesMapper.updateCategories(categories);
    }

    /**
     * 批量删除分类 (categories)
     * 
     * @param ids 需要删除的分类 (categories)主键
     * @return 结果
     */
    @Override
    public int deleteCategoriesByIds(Long[] ids)
    {
        return categoriesMapper.deleteCategoriesByIds(ids);
    }

    /**
     * 删除分类 (categories)信息
     * 
     * @param id 分类 (categories)主键
     * @return 结果
     */
    @Override
    public int deleteCategoriesById(Long id)
    {
        return categoriesMapper.deleteCategoriesById(id);
    }
}
