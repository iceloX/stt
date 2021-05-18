package com.aiit.controller;

import com.aiit.utils.returns.CommonEnum;
import com.aiit.utils.returns.JsonResult;
import com.aiit.pojo.Activity;
import com.aiit.service.IActivityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author icelo
 * @Date 2021/5/2
 * @Descriptions 活动类
 */
@RestController
@CrossOrigin
@RequestMapping("activity")
public class ActivityController {

    IActivityService activityService;

    @Autowired
    public void setActivityService(IActivityService activityService) {
        this.activityService = activityService;
    }

    /**
     * 根据活动的状态 （活动的状态：-1 未开始，0 进行中，1 已结束）查询活动，若后面的参数为空，则查询所有的社团；
     * @param status
     * @return
     */
    @GetMapping({"all", "/all/{status}"})
    public JsonResult getActivityByStatus(@Validated(Integer.class) @PathVariable(value = "status", required = false) Integer status) {
        List<Activity> activities;
        if (status == null) {
            activities = activityService.list();
        } else {
            activities = activityService.list(new QueryWrapper<Activity>().eq("status", status));
        }
        return JsonResult.success(activities);
    }

    /**
     * 根据活动的id查询
     *
     * @param id 传入的id
     * @return 查询的社团
     */
    @GetMapping({"id", "id/{id}"})
    public JsonResult getCommunityById(@PathVariable(value = "id", required = false) Long id) {
        Activity activity;
        if (id == null) {
            return JsonResult.error(CommonEnum.PARAME_NOT_EMTYPE.getResultCode(), CommonEnum.PARAME_NOT_EMTYPE.getResultMessage());
        }
        activity = activityService.getOne(new QueryWrapper<Activity>().eq("id", id));
        return JsonResult.success(activity);
    }

    /**
     * 根据活动名字进行查询（包括模糊查询）
     *
     * @param name 传入的参数
     * @return 查询匹配的社团
     */
    @GetMapping("name/{name}")
    public JsonResult getCommunityByName(@PathVariable(value = "name", required = false) String name) {
        List activities;
        if (name.isEmpty()) {
            return JsonResult.error(CommonEnum.PARAME_NOT_EMTYPE.getResultCode(), CommonEnum.PARAME_NOT_EMTYPE.getResultMessage());
        }
        activities = activityService.list(new QueryWrapper<Activity>().like("name", name));

        return JsonResult.success(activities);
    }

    /**
     * 根据社团id查询所有的活动
     *
     * @return
     */
    @GetMapping("/community/{id}")
    public JsonResult getActivityByComId(@PathVariable("id") Long id) {
        List<Activity> activities;
        if (id == null) {
            return JsonResult.error(CommonEnum.PARAME_NOT_EMTYPE.getResultCode(), CommonEnum.PARAME_NOT_EMTYPE.getResultMessage());
        }
        activities = activityService.list(
                new QueryWrapper<Activity>()
                        .inSql("id", "select act_id from com_act where com_id =" + id));

        return JsonResult.success(activities);
    }
}
