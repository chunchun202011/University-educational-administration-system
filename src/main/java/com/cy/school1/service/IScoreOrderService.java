package com.cy.school1.service;

import com.cy.school1.entity.SCOrder;
import com.cy.school1.entity.ScoreRecord;
import com.cy.school1.vo.OrderVO;
import com.cy.school1.vo.SCVO;
import com.cy.school1.vo.ScoreVO;

import java.util.List;

public interface IScoreOrderService {

    ScoreRecord create(String[] snos,String cno,String tno);

    List<ScoreVO> findAllScoreOrderItems();

    List<ScoreVO> getScoreVOBySnos(String[] snos,String cno);


}
