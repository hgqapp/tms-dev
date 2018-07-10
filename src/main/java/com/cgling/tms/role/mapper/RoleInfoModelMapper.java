package com.cgling.tms.role.mapper;

import com.cgling.commons.beans.paging.PageRequest;
import com.cgling.tms.role.bean.condition.RoleCondition;
import com.cgling.tms.role.model.RoleInfoModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleInfoModelMapper {
    
    int deleteByPrimaryKey(Long roleId);

    int insert(RoleInfoModel record);

    int insertSelective(RoleInfoModel record);

    RoleInfoModel selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(RoleInfoModel record);

    int updateByPrimaryKey(RoleInfoModel record);

    int deleteByRoleIds(@Param("roleIds") List<Long> roleIds);

    RoleInfoModel getByName(String name);

    Integer getMaxOrders();

    int getTotalCountByCondition(@Param("condition") RoleCondition condition);

    List<RoleInfoModel> getPageByCondition(@Param("condition") RoleCondition condition, @Param("pageRequest") PageRequest pageRequest);

    List<RoleInfoModel> getByRoleIds(@Param("roleIds") List<Long> roleIds);

    List<RoleInfoModel> getListByCondition(@Param("condition") RoleCondition condition);
    
}