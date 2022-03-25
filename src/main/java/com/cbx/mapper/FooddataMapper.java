package com.cbx.mapper;

import com.cbx.entity.Fooddata;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author:cbx
 * @since 2022-03-23
 */
@Mapper
public interface FooddataMapper extends BaseMapper<Fooddata> {

    void update(Long id);

    List<Fooddata> selectUserlike(Long id);

    void updatelikefood(Fooddata fooddata);

    Fooddata mygetById(Long id);

    void downlikenum(Long id);

    void deletelike(Fooddata temp);

    void deletecollect(Fooddata temp);

    void updatecollect(Fooddata temp);

    List<Fooddata> selectUsercollect(Long id);
}
