package com.cgling.tms.permission.mapper;

import com.cgling.commons.beans.paging.PageRequest;
import com.cgling.tms.permission.bean.condition.PermissionCondition;
import com.cgling.tms.permission.model.PermissionInfoModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionInfoModelMapper {
    
    int deleteByPrimaryKey(Long permissionId);

    int insert(PermissionInfoModel record);

    int insertSelective(PermissionInfoModel record);

    PermissionInfoModel selectByPrimaryKey(Long permissionId);

    int updateByPrimaryKeySelective(PermissionInfoModel record);

    int updateByPrimaryKey(PermissionInfoModel record);

    int deleteByPermissionIds(@Param("permissionIds") List<Long> permissionIds);

    PermissionInfoModel getByCode(String code);

    int getTotalCountByCondition(@Param("condition") PermissionCondition condition);

    List<PermissionInfoModel> getPageByCondition(@Param("condition") PermissionCondition condition, @Param("pageRequest") PageRequest pageRequest);

    int deleteByPermissionIdAndType(Long permissionId, byte type);
}