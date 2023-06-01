package edu.jdc.swll.berld.Berld.model.dtos;

import edu.jdc.swll.berld.Berld.model.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private Long id;
    private RoleType name;
}
