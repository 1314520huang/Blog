package com.netstudy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.netstudy.bean.MyType;
import com.netstudy.dao.MyTypeMapper;
import com.netstudy.service.MyTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 类别表 服务实现类
 * </p>
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Service
public class MyTypeServiceImpl extends ServiceImpl<MyTypeMapper, MyType> implements MyTypeService {

    @Override
    public List<MyType> list() {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByAsc("name");
        return this.list(queryWrapper);
    }
}
