package com.alm.controller;

import com.alm.commons.BaseController;
import com.alm.commons.PageInfo;
import com.alm.entity.Admins;
import com.alm.service.AdminsService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author anluming
 * @since 2018-12-01
 */
@Controller
@RequestMapping("/admins")
public class AdminsController extends BaseController {

    @Autowired private AdminsService adminsService;
    
    @GetMapping("/manager")
    public String manager() {
        return "adminsList";
    }
    
    @PostMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(Admins admins, Integer page, Integer rows, String sort,String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        EntityWrapper<Admins> ew = new EntityWrapper<Admins>(admins);
        Page<Admins> pages = getPage(page, rows, sort, order);
        pages = adminsService.selectPage(pages, ew);
        pageInfo.setRows(pages.getRecords());
        pageInfo.setTotal(pages.getTotal());
        return pageInfo;
    }
    
    /**
     * 添加页面
     * @return
     */
    @GetMapping("/addPage")
    public String addPage() {
        return "admin/admins/adminsAdd";
    }
    
    /**
     * 添加
     * @param 
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object add(@Valid Admins admins) {
       /* admins.setCreateTime(new Date());
        admins.setUpdateTime(new Date());
        admins.setDeleteFlag(0);*/
        boolean b = adminsService.insert(admins);
        if (b) {
            return renderSuccess("添加成功！");
        } else {
            return renderError("添加失败！");
        }
    }
    
    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Object delete(Long id) {
        Admins admins = new Admins();
        /*admins.setId(id);
        admins.setUpdateTime(new Date());
        admins.setDeleteFlag(1);*/
        boolean b = adminsService.updateById(admins);
        if (b) {
            return renderSuccess("删除成功！");
        } else {
            return renderError("删除失败！");
        }
    }
    
    /**
     * 编辑
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/editPage")
    public String editPage(Model model, Long id) {
        Admins admins = adminsService.selectById(id);
        model.addAttribute("admins", admins);
        return "admin/admins/adminsEdit";
    }
    
    /**
     * 编辑
     * @param 
     * @return
     */
    @PostMapping("/edit")
    @ResponseBody
    public Object edit(@Valid Admins admins) {
        //admins.setUpdateTime(new Date());
        boolean b = adminsService.updateById(admins);
        if (b) {
            return renderSuccess("编辑成功！");
        } else {
            return renderError("编辑失败！");
        }
    }
}
