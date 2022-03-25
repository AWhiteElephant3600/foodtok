package com.cbx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cbx.common.lang.Result;
import com.cbx.entity.Fooddata;
import com.cbx.entity.User;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author:cbx
 * @since 2022-03-23
 */
@RestController
public class FooddataController extends BaseController {

    static int i = 1;
    /**
     * 首页的swiper会请求五张图片 和图片的名字 介绍 点赞数 是否收藏
     * @return
     */
    @PostMapping("/swiper")
    public Result swiper(@RequestBody User user){
        Long id = user.getId();
        List<Fooddata> likefooddata = fooddataService.selectUserlike(id);
        List<Fooddata> collectfooddata = fooddataService.selectUsercollect(id);
        if (FooddataController.i == 8){
            FooddataController.i = 1;
        }
        Page<Fooddata> page = new Page<>(FooddataController.i, 5);
        FooddataController.i++;
        Page<Fooddata> pageData = fooddataService.page(page, new QueryWrapper<Fooddata>()
        .inSql("foodname","select foodname from fooddata where CHAR_LENGTH(foodname) < 5")
        .select("foodname","introduce","foodbigimg","likenum","id"));
        for (Fooddata record : pageData.getRecords()) {
            for (Fooddata fooddata : likefooddata) {
                if (record.getId() == fooddata.getId()){
                    record.setIslike(1);
                }
            }
        }

        for (Fooddata record : pageData.getRecords()) {
            for (Fooddata fooddata : collectfooddata) {
                if (record.getId() == fooddata.getId()){
                    record.setIscollect(1);
                }
            }
        }
        return Result.succ(pageData);
    }

    @PostMapping("/updatelike")
    public Result updatelike(@RequestBody Fooddata fooddata){
        Long id = fooddata.getId();
        Long userid = fooddata.getUserid();
        Fooddata temp = fooddataService.mygetById(id);
        temp.setUserid(userid);
        if (fooddata.getIslike() == 0){
            fooddataService.deletelike(id);
            fooddataService.deletelikefood(temp);
            return Result.succ(null);
        }

        fooddataService.update(id);
        fooddataService.updatelikefood(temp);
        return Result.succ(null);
    }

    @PostMapping("/updatecollect")
    public Result updatecollect(@RequestBody Fooddata fooddata){
        Long id = fooddata.getId();
        Long userid = fooddata.getUserid();
        Fooddata temp = fooddataService.mygetById(id);
        temp.setUserid(userid);
        if (fooddata.getIscollect() == 0){
            fooddataService.deletecollect(temp);
            return Result.succ(null);
        }
        fooddataService.updatecollect(temp);
        return Result.succ(null);
    }




}
