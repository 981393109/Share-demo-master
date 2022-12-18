package com.correction.backend.modules.information.convert;

import com.correction.backend.modules.information.controller.dto.InformationAnnouncementMessageDTO;
import com.correction.backend.modules.information.entity.InformationAnnouncementMessage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 公告信息 转换类
 * @Date: 2022-12-04
 */

@Mapper
public interface MInformationAnnouncementMessageConvert {

    MInformationAnnouncementMessageConvert INSTANCE = Mappers.getMapper(MInformationAnnouncementMessageConvert.class);

    InformationAnnouncementMessage toEntity (InformationAnnouncementMessageDTO dto);

}