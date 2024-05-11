package uz.malis.demo.dto;

import lombok.Data;

@Data
public class StatusResponseDto {
      private Long id;
      private String nameUz;
      private String nameRu;
      private String nameCrl;
      private String code;
      private String statusType;
}
