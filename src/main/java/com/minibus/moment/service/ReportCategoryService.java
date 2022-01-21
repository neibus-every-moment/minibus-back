package com.minibus.moment.service;

import com.minibus.moment.domain.report.ReportRepository;
import com.minibus.moment.domain.reportCategory.ReportCategory;
import com.minibus.moment.domain.reportCategory.ReportCategoryRepository;
import com.minibus.moment.dto.ReportCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportCategoryService {

    private final ReportCategoryRepository reportCategoryRepository;

    public ReportCategoryDto getReportCategoryList() {
        List<ReportCategory> reportCategories = reportCategoryRepository.findAll();
        return ReportCategoryDto.builder()
                .data(reportCategories)
                .build();
    }
}
