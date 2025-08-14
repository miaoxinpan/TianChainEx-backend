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
import com.ruoyi.system.domain.Posts;
import com.ruoyi.system.service.IPostsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章 (posts)Controller
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
@RestController
@RequestMapping("/system/posts")
public class PostsController extends BaseController
{
    @Autowired
    private IPostsService postsService;

    /**
     * 查询文章 (posts)列表
     */
    @PreAuthorize("@ss.hasPermi('system:posts:list')")
    @GetMapping("/list")
    public TableDataInfo list(Posts posts)
    {
        startPage();
        List<Posts> list = postsService.selectPostsList(posts);
        return getDataTable(list);
    }

    /**
     * 导出文章 (posts)列表
     */
    @PreAuthorize("@ss.hasPermi('system:posts:export')")
    @Log(title = "文章 (posts)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Posts posts)
    {
        List<Posts> list = postsService.selectPostsList(posts);
        ExcelUtil<Posts> util = new ExcelUtil<Posts>(Posts.class);
        util.exportExcel(response, list, "文章 (posts)数据");
    }

    /**
     * 获取文章 (posts)详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:posts:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(postsService.selectPostsById(id));
    }

    /**
     * 新增文章 (posts)
     */
    @PreAuthorize("@ss.hasPermi('system:posts:add')")
    @Log(title = "文章 (posts)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Posts posts)
    {
        return toAjax(postsService.insertPosts(posts));
    }

    /**
     * 修改文章 (posts)
     */
    @PreAuthorize("@ss.hasPermi('system:posts:edit')")
    @Log(title = "文章 (posts)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Posts posts)
    {
        return toAjax(postsService.updatePosts(posts));
    }

    /**
     * 删除文章 (posts)
     */
    @PreAuthorize("@ss.hasPermi('system:posts:remove')")
    @Log(title = "文章 (posts)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(postsService.deletePostsByIds(ids));
    }
}
