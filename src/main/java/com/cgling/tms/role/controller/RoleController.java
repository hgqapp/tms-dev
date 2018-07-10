package com.cgling.tms.role.controller;

import com.cgling.commons.beans.paging.PageData;
import com.cgling.commons.beans.paging.PageRequest;
import com.cgling.commons.utils.BeanMapper;
import com.cgling.tms.common.consts.Permissions;
import com.cgling.tms.role.bean.condition.RoleCondition;
import com.cgling.tms.role.bean.dto.RoleInfoDto;
import com.cgling.tms.role.bean.vo.RolePageVo;
import com.cgling.tms.role.model.RoleInfoModel;
import com.cgling.tms.role.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author houguangqiang
 * @date 2017-12-08
 * @since 1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/get")
    @RequiresPermissions(Permissions.FOUNDATION_ROLE_READ)
    public RoleInfoDto get(Long roleId){
        return BeanMapper.map(roleService.getRoleInfo(roleId), RoleInfoDto.class);
    }


    @GetMapping("/getList")
    @RequiresPermissions(Permissions.FOUNDATION_ROLE_READ)
    public List<RoleInfoDto> getList(RoleCondition condition){
        return BeanMapper.mapAsList(roleService.getRoleList(condition), RoleInfoDto.class);
    }

    @GetMapping("/getPage")
    @RequiresPermissions(Permissions.FOUNDATION_ROLE_READ)
    public PageData getPage(RoleCondition condition, PageRequest pageRequest){
        pageRequest
                .fieldMapping("name","name")
                .fieldMapping("createTime","create_time")
                .fieldMapping("updateTime","update_time")
                .buildSort();
        return roleService.getRolePage(condition, pageRequest).convert(RolePageVo.class);
    }

    @PostMapping("/create")
    @RequiresPermissions(Permissions.FOUNDATION_ROLE_CREATE)
    public Long create(RoleInfoDto roleInfo){
        return roleService.create(BeanMapper.map(roleInfo, RoleInfoModel.class));
    }

    @PostMapping("/update")
    @RequiresPermissions(Permissions.FOUNDATION_ROLE_UPDATE)
    public boolean update(RoleInfoDto roleInfo){
        return roleService.update(BeanMapper.map(roleInfo, RoleInfoModel.class));
    }

    @PostMapping("/delete")
    @RequiresPermissions(Permissions.FOUNDATION_ROLE_DELETE)
    public boolean delete(Long roleId){
        return roleService.delete(roleId);
    }

    @PostMapping("/batchDelete")
    @RequiresPermissions(Permissions.FOUNDATION_ROLE_DELETE)
    public boolean batchDelete(@RequestParam("roleIds[]") List<Long> roleIds){
        return roleService.delete(roleIds);
    }
}
