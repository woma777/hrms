package com.saas.recruitment.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamResultResponse extends BaseResponse {
    private Double writtenExam;
    private Double interview;
    private Double CGPA;
    private Double experience;
    private Double practicalExam;
    private Double other;
    private Double total;
    private UUID applicantId;
    private UUID recruitmentId;
    private UUID assessmentWeightId;
}
