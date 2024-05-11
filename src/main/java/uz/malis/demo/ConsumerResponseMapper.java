package uz.malis.demo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import uz.malis.demo.dto.CheckConsumerDto;
import uz.malis.demo.dto.CheckConsumerResponseDto;

@Mapper(componentModel = ComponentModel.SPRING, uses = {
    ConsumerStatusEnum.class
})
public interface ConsumerResponseMapper {

  @Mapping(target = "statusEnum", expression = "java(dto.getStatus() == true ? ConsumerStatusEnum.EXISTS : ConsumerStatusEnum.NOT_EXISTS)")
//  @Mapping(target = "statusEnum", source = "dto.status")
  CheckConsumerResponseDto fromFeignResponse(CheckConsumerDto dto);

//  @ValueMapping(source="Boolean.TRUE", target="EXISTS")
//  @ValueMapping(source="Boolean.FALSE", target="NOT_EXISTS")
//  @ValueMapping(source="null", target="NOT_EXISTS")
//  ConsumerStatusEnum map(Boolean status);

}
