package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Tags;
import com.ruoyi.system.service.ITagsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 标签 (tags)Controller
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
@RestController
@RequestMapping("/system/tags")
public class TagsController extends BaseController
{
    @Autowired
    private ITagsService tagsService;

    /**
     * 查询标签 (tags)列表
     */
    @PreAuthorize("@ss.hasPermi('system:tags:list')")
    @GetMapping("/list")
    public TableDataInfo list(Tags tags)
    {
        startPage();
        List<Tags> list = tagsService.selectTagsList(tags);
        return getDataTable(list);
    }

    /**
     * 导出标签 (tags)列表
     */
    @PreAuthorize("@ss.hasPermi('system:tags:export')")
    @Log(title = "标签 (tags)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Tags tags)
    {
        List<Tags> list = tagsService.selectTagsList(tags);
        ExcelUtil<Tags> util = new ExcelUtil<Tags>(Tags.class);
        util.exportExcel(response, list, "标签 (tags)数据");
    }

    /**
     * 获取标签 (tags)详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:tags:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tagsService.selectTagsById(id));
    }

    /**
     * 新增标签 (tags)
     */
    @PreAuthorize("@ss.hasPermi('system:tags:add')")
    @Log(title = "标签 (tags)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Tags tags)
    {
        return toAjax(tagsService.insertTags(tags));
    }

    /**
     * 修改标签 (tags)
     */
    @PreAuthorize("@ss.hasPermi('system:tags:edit')")
    @Log(title = "标签 (tags)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Tags tags)
    {
        return toAjax(tagsService.updateTags(tags));
    }

    /**
     * 删除标签 (tags)
     */
    @PreAuthorize("@ss.hasPermi('system:tags:remove')")
    @Log(title = "标签 (tags)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tagsService.deleteTagsByIds(ids));
    }
}
