package com.cy.school1.mapper;

import com.cy.school1.entity.SdeptTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface SdeptMapper {
    /**
     * 根据父代号查询信息
     * @param parent 父代号
     * @return 某个父代号下的所有专业列表
     */
    List<SdeptTable> findByParent(String parent); //根据父代号进行查询

    String findNameBySid(String sid);

    List<SdeptTable> selectAll();

}
