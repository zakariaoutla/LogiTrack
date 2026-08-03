package org.laicose.logitrack.mapper;

import org.laicose.logitrack.dto.request.ClientReqDto;
import org.laicose.logitrack.dto.response.ClientResDto;
import org.laicose.logitrack.model.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(ClientReqDto clientReqDto);

    List<ClientResDto> toDtoList(List<Client> clients);

    ClientResDto toResponseDto(Client client);
}
