package com.yupi.springbootinit.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.springbootinit.model.entity.Chart;
import com.yupi.springbootinit.service.ChartService;
import com.yupi.springbootinit.mapper.ChartMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
* @author Dan Wang
* @description 针对表【chart(图表信息表)】的数据库操作Service实现
* @createDate 2023-09-21 10:08:50
*/
@Service
public class ChartServiceImpl extends ServiceImpl<ChartMapper, Chart>
    implements ChartService{

    @Override
    public boolean saveBatch(Collection<Chart> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Chart> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Chart> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Chart entity) {
        return false;
    }

    @Override
    public Chart getOne(Wrapper<Chart> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Chart> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Chart> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }
}




