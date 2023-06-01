package edu.jdc.swll.berld.Berld.model.dtos;

import edu.jdc.swll.berld.Berld.model.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;
    private String email;
    private String username;
    private String password;
    private List<Role> roles = new ArrayList<>();
}
