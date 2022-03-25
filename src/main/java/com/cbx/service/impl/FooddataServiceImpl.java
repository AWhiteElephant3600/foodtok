package com.cbx.service.impl;

import com.cbx.entity.Fooddata;
import com.cbx.mapper.FooddataMapper;
import com.cbx.service.FooddataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author:cbx
 * @since 2022-03-23
 */
@Service
public class FooddataServiceImpl extends ServiceImpl<FooddataMapper, Fooddata> implements FooddataService {

    @Autowired
    private FooddataMapper fooddataMapper;

    @Override
    public void update(Long id) {
        fooddataMapper.update(id);
    }

    @Override
    public List<Fooddata> selectUserlike(Long id) {
        List<Fooddata> fooddata = fooddataMapper.selectUserlike(id);
        return fooddata;
    }

    @Override
    public void updatelikefood(Fooddata fooddata) {
        fooddataMapper.updatelikefood(fooddata);
    }

    @Override
    public Fooddata mygetById(Long id) {
        Fooddata fooddata = fooddataMapper.mygetById(id);
        return fooddata;
    }

    @Override
    public void deletelike(Long id) {
        fooddataMapper.downlikenum(id);
    }

    @Override
    public void deletelikefood(Fooddata temp) {
        fooddataMapper.deletelike(temp);
    }

    @Override
    public void deletecollect(Fooddata temp) {
        fooddataMapper.deletecollect(temp);
    }

    @Override
    public void updatecollect(Fooddata temp) {
        fooddataMapper.updatecollect(temp);
    }

    @Override
    public List<Fooddata> selectUsercollect(Long id) {
        List<Fooddata> fooddata = fooddataMapper.selectUsercollect(id);
        return fooddata;
    }
}
