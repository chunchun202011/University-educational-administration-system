package com.cy.school1.service;

import com.cy.school1.entity.SdeptTable;

import java.util.List;

public interface ISdeptService {
    /**
     * 根据父代号来查询专业信息
     * @param parent
     * @return
     */
    List<SdeptTable> getByParent(String parent);

    String getNameBySid(String sid);
}
