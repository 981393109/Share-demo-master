package com.correction.backend.modules.information.convert;

import com.correction.backend.modules.information.controller.dto.InformationMessageCreateInputDTO;
import com.correction.backend.modules.information.controller.dto.InformationMessageListOutputDTO;
import com.correction.backend.modules.information.controller.dto.InformationMessageSearchInputDTO;
import com.correction.backend.modules.information.controller.dto.InformationMessageUpdateInputDTO;
import com.correction.backend.modules.information.entity.InformationMessage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description:  转换类
 * @Date: 2022-11-27
 */

@Mapper
public interface MInformationMessageConvert {

    MInformationMessageConvert INSTANCE = Mappers.getMapper(MInformationMessageConvert.class);

    InformationMessage toInformationMessage(InformationMessageSearchInputDTO informationMessageSearchInputDTO);

    InformationMessage toInformationMessage(InformationMessageCreateInputDTO informationMessageCreateInputDTO);

    InformationMessage toInformationMessage(InformationMessageUpdateInputDTO informationMessageUpdateInputDTO);

    InformationMessageListOutputDTO toList(InformationMessage informationMessage);

    List<InformationMessageListOutputDTO> toList(List<InformationMessage> informationMessages);
}