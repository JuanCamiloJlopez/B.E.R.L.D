package edu.jdc.swll.berld.Berld.model.mappers;
import edu.jdc.swll.berld.Berld.model.dtos.ClientDTO;
import edu.jdc.swll.berld.Berld.model.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO mapFromEntity(Client client);
}
