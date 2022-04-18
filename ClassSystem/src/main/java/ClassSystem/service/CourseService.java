package ClassSystem.service;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;

public interface CourseService {
    //选课业务
    //获取未选课列表,page值
    ServicePost CourseNotList(PageHelp pageHelp);
    //获取已选课列表,page值
    ServicePost CourseList(PageHelp pageHelp);
}
