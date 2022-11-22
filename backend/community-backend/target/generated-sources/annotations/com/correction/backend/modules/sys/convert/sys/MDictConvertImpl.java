package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.DictOutDTO;
import com.correction.backend.modules.sys.entity.Dict;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-22T03:43:43+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MDictConvertImpl implements MDictConvert {

    @Override
    public List<DictOutDTO> convertList(List<Dict> list) {
        if ( list == null ) {
            return null;
        }

        List<DictOutDTO> list1 = new ArrayList<DictOutDTO>( list.size() );
        for ( Dict dict : list ) {
            list1.add( dictToDictOutDTO( dict ) );
        }

        return list1;
    }

    protected DictOutDTO dictToDictOutDTO(Dict dict) {
        if ( dict == null ) {
            return null;
        }

        DictOutDTO dictOutDTO = new DictOutDTO();

        dictOutDTO.setDictName( dict.getDictName() );
        dictOutDTO.setDictCode( dict.getDictCode() );
        dictOutDTO.setDictType( dict.getDictType() );
        dictOutDTO.setDictValue( dict.getDictValue() );
        dictOutDTO.setUseType( dict.getUseType() );

        return dictOutDTO;
    }
}
