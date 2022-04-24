package Reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自定义元数据对象处理器
 */
@Component
@Slf4j
public class MetaObjectHandler implements com.baomidou.mybatisplus.core.handlers.MetaObjectHandler {

    /**
     * 插入操作，自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充[insert]...");
        log.info(metaObject.toString());

        //插入时 填充字段 设置创建时间
        metaObject.setValue("createTime", LocalDateTime.now());
        //插入时 填充字段 设置更改时间
        metaObject.setValue("updateTime",LocalDateTime.now());
        //插入时 填充字段 设置创建人
        metaObject.setValue("createUser",BaseContext.getCurrentId());
        //插入时 填充字段 设置更改人
        metaObject.setValue("updateUser",BaseContext.getCurrentId());

    }

    /**
     * 修改操作，自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充[update]...");
        log.info(metaObject.toString());
        //插入时 填充字段 设置更改时间
        metaObject.setValue("updateTime",LocalDateTime.now());
        //插入时 填充字段 设置更改人  从线程中get到id
        metaObject.setValue("updateUser",BaseContext.getCurrentId());
    }
}
