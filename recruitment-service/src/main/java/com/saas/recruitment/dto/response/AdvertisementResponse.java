package com.saas.recruitment.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementResponse extends BaseResponse {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String announcementType;
    private Integer occurrence;
    private String applicationStatus;
    private UUID recruitmentId;
    private List<MediaTypeResponse> mediaTypes;
}
