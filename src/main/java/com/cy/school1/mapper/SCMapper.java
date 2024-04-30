package com.cy.school1.mapper;

import com.cy.school1.entity.SC;
import com.cy.school1.entity.Student;
import com.cy.school1.vo.SCVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 *插入选修课数据
 * SC：选修课数据
 * return:受影响的行数
 */
public interface SCMapper {
    Integer insert(SC sc);

    /**
     *
     * 更新选修课和学期的数量
     * @param sno 学号
     * @param cno 课程号
     * @param term 学期的数量
     * @param modifiedUser 修改者
     * @param modifiedTime 修改时间
     * @return 受影响行数
     */
    Integer updateTermBySnoCno(String sno,String cno,
                               Integer term,String modifiedUser,
                               Date modifiedTime);

    /**
     *
     * 根据学号和课程号查询选修数据
     * @param sno 学号
     * @param cno 课程号
     * @return 选修课数据
     */
    SC findBySnoCno(String sno,String cno);


    /**
     * 查询添加到选课列表的课程信息
     * @param sno 学号
     * @return course,sc联合查询的数据
     */
    List<SCVO> findVOBySno(String sno);

    /**
     * 根据cno的值查询选修列表的这个课程数据是否存在
     * @param cnos 课程号集合
     * @return
     */
    List<SCVO> findVOByCno(String[] cnos);

    Integer deleteSC(String sno,String cno);

    Integer deleteManySCs(String sno,String[] cnos);

    List<SCVO> findAllStudentsSCs();

    SCVO findSC(String sno,String cno);

    int updateSC(@Param("newCno") String newCno, @Param("sno") String sno,
                 @Param("cno") String cno,@Param("modifiedUser")String modifiedUser,
                 @Param("modifiedTime")Date ModifiedTime);

    Integer addSC(SC sc);

    List<SCVO> findMyStuSC(String tno);

    List<SCVO> selectByConditionAnd(@Param("tno") String tno,@Param("key1") String key1, @Param("value1") String value1,
                                       @Param("key2") String key2, @Param("value2") String value2);

    List<SCVO> selectByConditionOr(@Param("tno") String tno,@Param("key1") String key1, @Param("value1") String value1,
                                    @Param("key2") String key2, @Param("value2") String value2);

    List<SCVO> selectByConditionNot(@Param("tno") String tno,@Param("key1") String key1, @Param("value1") String value1,
                                    @Param("key2") String key2, @Param("value2") String value2);


    //管理员查询选课
    List<SCVO> selectByConditionMAnd(@Param("key1") String key1, @Param("value1") String value1,
                                    @Param("key2") String key2, @Param("value2") String value2);

    List<SCVO> selectByConditionMOr(@Param("key1") String key1, @Param("value1") String value1,
                                   @Param("key2") String key2, @Param("value2") String value2);

    List<SCVO> selectByConditionMNot(@Param("key1") String key1, @Param("value1") String value1,
                                    @Param("key2") String key2, @Param("value2") String value2);
}