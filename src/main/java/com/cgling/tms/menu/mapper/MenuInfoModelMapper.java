package com.cgling.tms.menu.mapper;

import com.cgling.commons.beans.paging.PageRequest;
import com.cgling.tms.menu.bean.condition.MenuCondition;
import com.cgling.tms.menu.model.MenuInfoModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuInfoModelMapper {
    
    int deleteByPrimaryKey(Long menuId);

    int insert(MenuInfoModel record);

    int insertSelective(MenuInfoModel record);

    MenuInfoModel selectByPrimaryKey(Long menuId);

    MenuInfoModel getByMenuId(Long menuId);

    int updateByPrimaryKeySelective(MenuInfoModel record);

    int updateByPrimaryKey(MenuInfoModel record);

    List<MenuInfoModel> getListByCondition(@Param("condition") MenuCondition condition);

    int getTotalCountByCondition(@Param("condition") MenuCondition condition);

    List<MenuInfoModel> getPageByCondition(@Param("condition") MenuCondition condition, @Param("pageRequest") PageRequest pageRequest);

    MenuInfoModel selectOneByParentIds(@Param("parentIds") List<Long> parentIds);

    Integer getMaxOrders();

    MenuInfoModel getByMenuIdAndStatus(@Param("menuId") Long menuId, @Param("status") byte status);

    MenuInfoModel getByName(String name);

    int deleteByMenuIds(@Param("menuIds") List<Long> menuIds);
}