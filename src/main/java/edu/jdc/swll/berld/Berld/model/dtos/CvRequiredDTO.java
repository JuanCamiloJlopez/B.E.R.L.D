package edu.jdc.swll.berld.Berld.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CvRequiredDTO {

    private String description;
    private Instant announcementDate;
    private Boolean available;
    private Integer vacancyNumber;

}
