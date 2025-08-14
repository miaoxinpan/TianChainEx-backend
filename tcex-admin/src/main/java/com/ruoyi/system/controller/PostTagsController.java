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
import com.ruoyi.system.domain.PostTags;
import com.ruoyi.system.service.IPostTagsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章-标签关联 (post_tags)Controller
 * 
 * @author ruoyi
 * @date 2025-07-24
 */
@RestController
@RequestMapping("/system/potags")
public class PostTagsController extends BaseController
{
    @Autowired
    private IPostTagsService postTagsService;

    /**
     * 查询文章-标签关联 (post_tags)列表
     */
    @PreAuthorize("@ss.hasPermi('system:tags:list')")
    @GetMapping("/list")
    public TableDataInfo list(PostTags postTags)
    {
        startPage();
        List<PostTags> list = postTagsService.selectPostTagsList(postTags);
        return getDataTable(list);
    }

    /**
     * 导出文章-标签关联 (post_tags)列表
     */
    @PreAuthorize("@ss.hasPermi('system:tags:export')")
    @Log(title = "文章-标签关联 (post_tags)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PostTags postTags)
    {
        List<PostTags> list = postTagsService.selectPostTagsList(postTags);
        ExcelUtil<PostTags> util = new ExcelUtil<PostTags>(PostTags.class);
        util.exportExcel(response, list, "文章-标签关联 (post_tags)数据");
    }

    /**
     * 获取文章-标签关联 (post_tags)详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:tags:query')")
    @GetMapping(value = "/{postId}")
    public AjaxResult getInfo(@PathVariable("postId") Long postId)
    {
        return success(postTagsService.selectPostTagsByPostId(postId));
    }

    /**
     * 新增文章-标签关联 (post_tags)
     */
    @PreAuthorize("@ss.hasPermi('system:tags:add')")
    @Log(title = "文章-标签关联 (post_tags)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PostTags postTags)
    {
        return toAjax(postTagsService.insertPostTags(postTags));
    }

    /**
     * 修改文章-标签关联 (post_tags)
     */
    @PreAuthorize("@ss.hasPermi('system:tags:edit')")
    @Log(title = "文章-标签关联 (post_tags)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PostTags postTags)
    {
        return toAjax(postTagsService.updatePostTags(postTags));
    }

    /**
     * 删除文章-标签关联 (post_tags)
     */
    @PreAuthorize("@ss.hasPermi('system:tags:remove')")
    @Log(title = "文章-标签关联 (post_tags)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{postIds}")
    public AjaxResult remove(@PathVariable Long[] postIds)
    {
        return toAjax(postTagsService.deletePostTagsByPostIds(postIds));
    }
}
