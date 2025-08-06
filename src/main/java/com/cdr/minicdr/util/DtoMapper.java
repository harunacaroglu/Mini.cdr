package com.cdr.minicdr.util;

import com.cdr.minicdr.dto.CdrRequestDto;
import com.cdr.minicdr.dto.CdrResponseDto;
import com.cdr.minicdr.model.CDR;


public class DtoMapper {

    public static CDR toEntity(CdrRequestDto dto) {
        CDR entity = new CDR();
        entity.setANumber(dto.getANumber());
        entity.setBNumber(dto.getBNumber());
        entity.setImsi(dto.getImsi());
        entity.setImei(dto.getImei());
        entity.setDirection(dto.getDirection());
        entity.setResult(dto.getResult());
        entity.setSetupDuration(dto.getSetupDuration());
        entity.setConversationDuration(dto.getConversationDuration());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setCellId(dto.getCellId());
        entity.setLacId(dto.getLacId());
        return entity;
    }

    public static CdrResponseDto toDto(CDR entity) {
        CdrResponseDto dto = new CdrResponseDto();
        dto.setId(entity.getId());
        dto.setANumber(entity.getANumber());
        dto.setBNumber(entity.getBNumber());
        dto.setImsi(entity.getImsi());
        dto.setImei(entity.getImei());
        dto.setDirection(entity.getDirection());
        dto.setResult(entity.getResult());
        dto.setSetupDuration(entity.getSetupDuration());
        dto.setConversationDuration(entity.getConversationDuration());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setCellId(entity.getCellId());
        dto.setLacId(entity.getLacId());
        return dto;
    }
}
