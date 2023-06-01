package edu.jdc.swll.berld.Berld.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {

    private Long id;
    private String productName;
    private  Boolean available;

}
