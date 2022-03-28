package ClassSystem.service;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;

public interface StudentService {
    //获取学生列表,page值
    ServicePost StudentList(PageHelp pageHelp);
}
