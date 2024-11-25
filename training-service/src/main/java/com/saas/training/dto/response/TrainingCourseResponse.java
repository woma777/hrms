package com.saas.training.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingCourseResponse extends BaseResponse {

    private String courseName;
    private String description;
    private UUID courseCategoryId;
}
