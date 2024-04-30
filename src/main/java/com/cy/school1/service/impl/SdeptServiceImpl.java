package com.cy.school1.service.impl;

import com.cy.school1.entity.SdeptTable;
import com.cy.school1.mapper.SdeptMapper;
import com.cy.school1.service.ISdeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SdeptServiceImpl implements ISdeptService {

    @Autowired(required = false)
    private SdeptMapper sdeptMapper;

    @Override
    public List<SdeptTable> getByParent(String parent) {
        List<SdeptTable> list = sdeptMapper.findByParent(parent);
        // 在进行网络数据的传输时，为了尽量避免无效数据的传递，可以将无效数据设为null，
        //节省流量，提升效率
//        for(SdeptTable s :list){
//            s.setParent(null);
//        }
        return list;
    }

    @Override
    public String getNameBySid(String sid) {
        return sdeptMapper.findNameBySid(sid);
    }
}
