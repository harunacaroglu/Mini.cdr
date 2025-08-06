package com.cdr.minicdr.service;

import com.cdr.minicdr.dto.CdrRequestDto;
import com.cdr.minicdr.dto.CdrResponseDto;
import com.cdr.minicdr.model.CDR;
import com.cdr.minicdr.repository.CDRRepository;
import com.cdr.minicdr.util.DtoMapper;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CDRServiceImpl implements CDRService {

    private static final Logger log = LoggerFactory.getLogger(CDRServiceImpl.class);
    private final CDRRepository cdrRepository;

    public CDRServiceImpl(CDRRepository cdrRepository) {
        this.cdrRepository = cdrRepository;
    }

    @Override
    public CdrResponseDto saveCDR(CdrRequestDto dto) {
        CDR entity = DtoMapper.toEntity(dto);
        CDR saved = cdrRepository.save(entity);
        log.debug("CDR saved: {}", saved);
        return DtoMapper.toDto(saved);
    }

    @Override
    public List<CdrResponseDto> saveAllCDRs(List<CdrRequestDto> dtoList) {
        List<CDR> entities = dtoList.stream()
                .map(DtoMapper::toEntity)
                .collect(Collectors.toList());

        List<CDR> savedList = cdrRepository.saveAll(entities);
        log.debug("CDR list saved. Total count: {}", savedList.size());

        return savedList.stream()
                .map(DtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CdrResponseDto> getAllCDRs() {
        return cdrRepository.findAll()
                .stream()
                .map(DtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CdrResponseDto> getCDRsByANumber(String aNumber) {
        return cdrRepository.findByaNumber(aNumber)
                .stream()
                .map(DtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CdrResponseDto> getCDRsByBNumber(String bNumber) {
        return cdrRepository.findBybNumber(bNumber)
                .stream()
                .map(DtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
