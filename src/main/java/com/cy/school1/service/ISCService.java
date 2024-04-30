package com.cy.school1.service;

import com.cy.school1.vo.CourseVO;
import com.cy.school1.vo.SCVO;
import org.apache.ibatis.annotations.Param;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

public interface ISCService {
    /**
     * 将选修课添加到列表中
     * @param sno 学号
     * @param cno 课程号
     * @param term 学期数
     * @Param sname 修改者名字
     */
    void addToSCCart(String sno,String cno,Integer term,String sname);

    List<SCVO> getVOBySno(String sno);

    /**
     * 更新用户的选课列表数量
     * @param cno
     * @param sno
     * @param sname
     * @return 更新成功后的数量
     */
    Integer addTerm(String cno,String sno,String sname);

    Integer reduceTerm(String cno,String sno,String sname);

    List<SCVO> getVOByCno(String sno,String[] cnos);

    void deleteSC(String sno,String cno);

    Integer deleteManySCs(String sno,String[] cnos);

    List<SCVO> findAllStudentsSCs();

    SCVO findSC(String sno,String cno);

    int updateSC(String newCno, String sno,
                 String cno,String modifiedUser);

    //学生自己添加选课
    Integer saddSC(String sno, String cno);

    //管理员添加选课
    Integer maddSC(String mno, String sno,String cno);

    // 找到选我的课的学生
    List<SCVO> findMyStuSC(String tno);

    //三种条件查询
    List<SCVO> selectByCondition(String tno,
                                 @Param("condition") String condition,
                                 @Param("key1") String key1, @Param("value1") String value1,
                                  @Param("key2") String key2, @Param("value2") String value2);

    //三种条件查询
    List<SCVO> selectByConditionAnd(String tno,
                                 @Param("key1") String key1, @Param("value1") String value1,
                                 @Param("key2") String key2, @Param("value2") String value2);

    //三种条件查询
    List<SCVO> selectByMCondition(@Param("condition") String condition,
                                 @Param("key1") String key1, @Param("value1") String value1,
                                 @Param("key2") String key2, @Param("value2") String value2);


}
