package com.correction.backend.modules.information.controller;

import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserListOutputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserSearchInputDTO;
import com.correction.backend.modules.handleCorrection.convert.MCorrectionUserConvert;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import com.correction.backend.modules.information.controller.dto.*;
import com.correction.backend.modules.information.convert.MInformationMessageConvert;
import com.correction.backend.modules.information.entity.InformationAnnouncementMessage;
import com.correction.backend.modules.information.entity.InformationMessage;
import com.correction.backend.modules.information.service.InformationAnnouncementMessageService;
import com.correction.backend.modules.information.service.InformationMessageService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

@Api(tags = "消息通知-消息通知相关接口")
@RestController
@RequestMapping("/infomation")
@Validated
public class InformationController {

    @Resource
    private InformationMessageService informationMessageService;

    @Resource
    private InformationAnnouncementMessageService informationAnnouncementMessageService;

    @GetMapping("/page")
    @ApiOperation("获取消息通知列表（分页）")
    public CommonResult<PageResult<InformationMessageListOutputDTO>> getPageList(@Valid InformationMessageSearchInputDTO reqVO) {
        PageResult<InformationMessage> pageList = informationMessageService.pageListByEntity(reqVO);
        List<InformationMessageListOutputDTO> list = new ArrayList<>();
        for (InformationMessage informationMessage : pageList.getList()) {
            list.add(MInformationMessageConvert.INSTANCE.toList(informationMessage));
        }
        return success(new PageResult<InformationMessageListOutputDTO>(list, pageList.getTotal()));
    }

    @GetMapping("/infoPage")
    @ApiOperation("获取公告列表")
    public CommonResult<PageResult<InformationAnnouncementMessage>> infoPage(@Valid InformationAnnouncementMessageSearchInputDTO reqVO) {
        PageResult<InformationAnnouncementMessage> pageList = informationAnnouncementMessageService.pageListByEntity(reqVO);
        return success(pageList);
    }


    @PostMapping("/doRead")
    @ApiOperation("设置已读")
    public CommonResult<Boolean> createCorrectionUser(@Valid @RequestBody InformationReadDTO reqDTO) {
        informationMessageService.doRead(reqDTO);
        return success(true);
    }

    @PostMapping("/doReadAll")
    @ApiOperation("一键已读")
    public CommonResult<Boolean> doReadAll() {
        informationMessageService.doRead(WebFrameworkUtils.getLoginUserId());
        return success(true);
    }


    @PostMapping("/sendAnnouncement")
    @ApiOperation("发送公告")
    public CommonResult<Boolean> sendAnnouncement(@Valid @RequestBody InformationAnnouncementMessageDTO reqDTO) {
        informationMessageService.sendAnnouncement(reqDTO);
        return success(true);
    }

    @PostMapping("/setEnable")
    @ApiOperation("设置是否有效")
    public CommonResult<Boolean> setEnable(@Valid @RequestBody InformationAnnouncementMessageDTO reqDTO) {
        informationMessageService.setEnable(reqDTO);
        return success(true);
    }

    @PostMapping("deleteInfo")
    @ApiOperation("删除公告")
    public CommonResult<Boolean> deleteInfo(@Valid @RequestParam Long id) {
        informationMessageService.delete(id);
        return success(true);
    }

}
