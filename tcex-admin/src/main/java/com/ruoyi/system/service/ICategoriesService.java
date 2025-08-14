package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Categories;

/**
 * 分类 (categories)Service接口
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
public interface ICategoriesService 
{
    /**
     * 查询分类 (categories)
     * 
     * @param id 分类 (categories)主键
     * @return 分类 (categories)
     */
    public Categories selectCategoriesById(Long id);

    /**
     * 查询分类 (categories)列表
     * 
     * @param categories 分类 (categories)
     * @return 分类 (categories)集合
     */
    public List<Categories> selectCategoriesList(Categories categories);

    /**
     * 新增分类 (categories)
     * 
     * @param categories 分类 (categories)
     * @return 结果
     */
    public int insertCategories(Categories categories);

    /**
     * 修改分类 (categories)
     * 
     * @param categories 分类 (categories)
     * @return 结果
     */
    public int updateCategories(Categories categories);

    /**
     * 批量删除分类 (categories)
     * 
     * @param ids 需要删除的分类 (categories)主键集合
     * @return 结果
     */
    public int deleteCategoriesByIds(Long[] ids);

    /**
     * 删除分类 (categories)信息
     * 
     * @param id 分类 (categories)主键
     * @return 结果
     */
    public int deleteCategoriesById(Long id);
}
