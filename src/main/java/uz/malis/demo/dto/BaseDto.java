package uz.malis.demo.dto;

import lombok.Data;

@Data
public class BaseDto {
  private Long id;
  private Long code;
  private String nameUz;
  private String nameRu;
  private String nameCrl;
  private Boolean status;

}
