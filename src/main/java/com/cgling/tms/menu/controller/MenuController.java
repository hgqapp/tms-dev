package com.cgling.tms.menu.controller;

import com.cgling.commons.beans.paging.PageData;
import com.cgling.commons.beans.paging.PageRequest;
import com.cgling.commons.utils.BeanMapper;
import com.cgling.tms.menu.bean.condition.MenuCondition;
import com.cgling.tms.menu.bean.dto.MenuInfoDto;
import com.cgling.tms.menu.bean.vo.MenuPageVo;
import com.cgling.tms.menu.model.MenuInfoModel;
import com.cgling.tms.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/get")
    public MenuInfoDto get(Long menuId){
        return BeanMapper.map(menuService.getMenuInfo(menuId), MenuInfoDto.class);
    }

    @GetMapping("/getList")
    public List<MenuInfoDto> getList(MenuCondition condition){
        return BeanMapper.mapAsList(menuService.getMenuList(condition), MenuInfoDto.class);
    }

    @GetMapping("/getPage")
    public PageData getPage(MenuCondition condition, PageRequest pageRequest){
        pageRequest
                .fieldMapping("name","name")
                .fieldMapping("type","type")
                .fieldMapping("status","status")
                .fieldMapping("createTime","create_time")
                .fieldMapping("updateTime","update_time")
                .buildSort();
        return menuService.getMenuPage(condition, pageRequest).convert(MenuPageVo.class);
    }

    @PostMapping("/create")
    public Long create(MenuInfoDto menuInfo){
        return menuService.create(BeanMapper.map(menuInfo, MenuInfoModel.class));
    }

    @PostMapping("/update")
    public boolean update(MenuInfoDto menuInfo){
        return menuService.update(BeanMapper.map(menuInfo, MenuInfoModel.class));
    }

    @PostMapping("/delete")
    public boolean delete(Long menuId){
        return menuService.delete(menuId);
    }

    @PostMapping("/batchDelete")
    public boolean batchDelete(@RequestParam("menuIds[]") List<Long> menuIds){
        return menuService.delete(menuIds);
    }
}
