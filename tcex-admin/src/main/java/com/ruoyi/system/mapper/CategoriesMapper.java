package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Categories;

/**
 * 分类 (categories)Mapper接口
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
public interface CategoriesMapper 
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
     * 删除分类 (categories)
     * 
     * @param id 分类 (categories)主键
     * @return 结果
     */
    public int deleteCategoriesById(Long id);

    /**
     * 批量删除分类 (categories)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCategoriesByIds(Long[] ids);
}
