package com.cbx.service;

import com.cbx.entity.Fooddata;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author:cbx
 * @since 2022-03-23
 */
public interface FooddataService extends IService<Fooddata> {

    void update(Long id);

    List<Fooddata> selectUserlike(Long id);

    void updatelikefood(Fooddata fooddata);

    Fooddata mygetById(Long id);

    void deletelike(Long id);

    void deletelikefood(Fooddata temp);

    void deletecollect(Fooddata temp);

    void updatecollect(Fooddata temp);

    List<Fooddata> selectUsercollect(Long id);
}
