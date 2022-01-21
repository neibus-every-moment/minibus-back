package com.minibus.moment.dto;

import com.minibus.moment.domain.reportCategory.ReportCategory;
import lombok.*;

import java.util.List;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportCategoryDto {

    private List<ReportCategory> data;

}
