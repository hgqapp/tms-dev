package com.cgling.tms.permission.controller;

import com.cgling.commons.beans.paging.PageData;
import com.cgling.commons.beans.paging.PageRequest;
import com.cgling.commons.utils.BeanMapper;
import com.cgling.tms.permission.bean.condition.PermissionCondition;
import com.cgling.tms.permission.bean.dto.PermissionInfoDto;
import com.cgling.tms.permission.bean.vo.PermissionPageVo;
import com.cgling.tms.permission.model.PermissionInfoModel;
import com.cgling.tms.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author houguangqiang
 * @date 2017-12-08
 * @since 1.0
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/get")
    public PermissionInfoDto get(Long permissionId){
        return BeanMapper.map(permissionService.getPermissionInfo(permissionId), PermissionInfoDto.class);
    }

    @GetMapping("/getPage")
    public PageData getPage(PermissionCondition condition, PageRequest pageRequest){
        pageRequest
                .fieldMapping("name","name")
                .fieldMapping("code","code")
                .fieldMapping("createTime","create_time")
                .fieldMapping("updateTime","update_time")
                .buildSort();
        return permissionService.getPermissionPage(condition, pageRequest).convert(PermissionPageVo.class);
    }

    @GetMapping("/create")
    public Long create(PermissionInfoDto permissionInfo, Long menuId){
        PermissionInfoModel permissionInfoModel = BeanMapper.map(permissionInfo, PermissionInfoModel.class);
        return permissionService.create(permissionInfoModel, menuId);
    }

    @PostMapping("/update")
    public boolean update(PermissionInfoDto permissionInfo){
        PermissionInfoModel permissionInfoModel = BeanMapper.map(permissionInfo, PermissionInfoModel.class);
        return permissionService.update(permissionInfoModel);
    }

    @PostMapping("/delete")
    public boolean delete(Long permissionId){
        return permissionService.delete(permissionId);
    }

    @PostMapping("/batchDelete")
    public boolean batchDelete(@RequestParam("permissionIds[]") List<Long> permissionIds){
        return permissionService.delete(permissionIds);
    }
}
