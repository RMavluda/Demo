package uz.malis.demo.dto;

import lombok.Data;

@Data
public class TransformationCoefficientResponseDto {
    private Long id;
    private String code;
    private Long value;
    private Boolean status;
}
