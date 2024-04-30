package com.cy.school1.mapper;

import com.cy.school1.entity.Manager;
import com.cy.school1.entity.Student;
import com.cy.school1.entity.Teacher;
import com.cy.school1.vo.StudentSelectVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*用户模块的持久层接口*/
//@Mapper
public interface UserMapper {
    /*
    * 插入用户的数据
    * student 用户的数据
    * @return 受影响的行数（增删改都受影响的行数，返回值判断是否成功）
    * */
    Integer insert(Student student);

    /* 插入教师信息 */
    Integer insertT(Teacher teacher);

    /*
    * 根据学号来查询学生数据
    * @return 如果找到对应的用户就返回数据，如果没有找到就返回null值
    * */
    Student findBySno(String sno);

    /* 查教师数据 */
    Teacher findByTno(String tno);

    /* 查教师数据 */
    Manager findByMno(String mno);

    /*
    *根据用户的sno来修改用户密码
    * sno 用户的sno
    * password 用户输入的密码
    * modifiedUser 修改的执行者
    * modifiedTime 修改的时间
    * return 返回值为受影响的行数
    *
    * */
    Integer updatePasswordBySno(String sno,
                               String password,
                               String modifiedUser,
                               Date modifiedTime);
    /*
    * 根据用户sno查询数据
    * 如果找到则返回对象，否则返回null
    *
    * */
//    Student findBySno(String sno);

    /*
    * 更新用户的数据信息
    * user 用户的数据
    * return 返回值为受影响的行数
    *
    *
    * */
    Integer updateInfoBySno(Student student);

    /*
    * @Param("SQL映射文件中#{}占位符的变量名"):解决的问题：当SQL语句的占位符
    * 和映射的接口方法参数名不一致时，需要将某个参数强行注入到某个占位符变量上时，
    * 可以使用@Param注解来标注映射的关系
    *
    * 根据sno修改用户头像
    *
    *
    * */
    Integer updateAvatarBySno(
            @Param("sno") String sno,    //占位符注入到sql语句当中
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    /* 查询所有学生信息 */
    List<Student> selectAllStudent();

    /*
     * 条件查询
     *  参数接收：
     *    1.散装参数：如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")
     *    2.对象参数
     *    3.map集合参数
     * @param sdept
     * @param classes
     * @param sno
     * @return
     */
//    List<Student> selectByCondition(@Param("sdept") String sdept,@Param("classes") String classes,@Param("sno") String sno);

//      List<Student> selectByCondition(Student student);

    List<Student> selectByCondition(Map map);

    // 单条件动态查询
    List<Student> selectByConditionSingle(Student student);

    //修改功能
    int updateStudent(Student student);

    //删除功能
    void deleteBySno(String sno);

    //批量删除
    void deleteBySnos(@Param("snos") String[] snos);

    //三个条件查询所有学生
//    List<Student> selectByConditionAnd(Student student);
    List<Student> selectByConditionAnd(@Param("key1") String key1,@Param("value1") String value1,
                                       @Param("key2") String key2,@Param("value2") String value2);

    List<Student> selectByConditionOr(@Param("key1") String key1,@Param("value1") String value1,
                                       @Param("key2") String key2,@Param("value2") String value2);
    List<Student> selectByConditionNot(@Param("key1") String key1,@Param("value1") String value1,
                                       @Param("key2") String key2,@Param("value2") String value2);

    //查询选了自己课程的学生
    List<StudentSelectVO> selectMyStudent(String tno);

    //查询所有老师
    List<Teacher> findAllTeachers();

    //删除学生(is_delete=1)
    void deleteFalseBySno(String sno);

    /* 查询所有学生信息 */
    List<Student> findNotDeleteStudent();

    /*查询未录入成绩的学生*/
    List<Student> notScoreStudent(@Param("cno") String cno);

}
