package com.aiit.controller;

import com.aiit.utils.returns.CommonEnum;
import com.aiit.utils.returns.JsonResult;
import com.aiit.pojo.Community;
import com.aiit.service.ICommunityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author icelo
 * @Date 2021/4/29
 * @Descriptions
 */
@RestController
@RequestMapping("/community")
@CrossOrigin // 跨越请求的注解
// @Api(value = "community-controller")
public class CommunityController {

    ICommunityService communityService;

    @Autowired
    public void setCommunityService(ICommunityService communityService) {
        this.communityService = communityService;
    }

    /**
     * 查询社团的状态（社团状态：1 正在运营，0 停止运营） 若查询的参数为空，则查询所有的社团
     *
     * @return json
     */
    @GetMapping({"all", "all/{status}"})
    public JsonResult getAllCommunities(@PathVariable(value = "status", required = false) Integer status) {
        List<Community> communities;
        if (status == null) {
            communities = communityService.list();
        } else {
            communities = communityService.list(new QueryWrapper<Community>().eq("status", status));
        }
        return JsonResult.success(communities);
    }

    /**
     * 根据社团的id查询
     *
     * @param id 传入的id
     * @return 查询的社团
     */
    @GetMapping({"id", "id/{id}"})
    public JsonResult getCommunityById(@PathVariable(value = "id", required = false) Long id) {
        Community community;
        if (id == null) {
            return JsonResult.error(CommonEnum.PARAME_NOT_EMTYPE.getResultCode(), CommonEnum.PARAME_NOT_EMTYPE.getResultMessage());
        }
        community = communityService.getOne(new QueryWrapper<Community>().eq("id", id));
        return JsonResult.success(community);
    }

    /**
     * 根据社团名字进行查询（包括模糊查询）
     *
     * @param name 传入的参数
     * @return 查询匹配的社团
     */
    @GetMapping({"name/{name}", "name"})
    public JsonResult getCommunityByName(@PathVariable(value = "name", required = false) String name) {
        List<Community> communities;
        if (name.isEmpty()) {
            return JsonResult.error(CommonEnum.PARAME_NOT_EMTYPE.getResultCode(), CommonEnum.PARAME_NOT_EMTYPE.getResultMessage());
        }
        communities = communityService.list(new QueryWrapper<Community>().like("name", name));
        return JsonResult.success(communities);
    }

    /**
     * 根据分数高低排序社团
     *
     * @return json
     */
    @GetMapping("top")
    public JsonResult getCommunityTop() {
        List<Community> communities = communityService.list(new QueryWrapper<Community>().orderByDesc("score"));
        return JsonResult.success(communities);
    }


}
