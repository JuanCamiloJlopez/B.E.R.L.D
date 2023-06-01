package edu.jdc.swll.berld.Berld.model.dtos;

import edu.jdc.swll.berld.Berld.model.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoutineDTO {

    private Long id;
    private String description;
    private Client client;
}
