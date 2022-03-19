package StudentInfo;

import StudentInfo.dao.CourseplanMapper;
import StudentInfo.entity.CoursePlan;
import StudentInfo.service.CourseplanService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class test {
    public CourseplanService courseplanService;
    public static void main(String[] args) {
        try {
            //读取mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
            //SqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //生产SqlSession  默认事务是手动提交
            SqlSession sqlSession = factory.openSession();
            //获得接口对象
            CourseplanMapper mapper = sqlSession.getMapper(CourseplanMapper.class);
            //调用方法
            List<CoursePlan> coursePlanName = mapper.findAllCoursePlan("0003");
            System.out.println(coursePlanName);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
