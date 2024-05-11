package uz.malis.demo.dto;

import lombok.Data;

@Data
public class MeterTypeResponseDto {
    private Long id;
    private String code;
    private String nameUz;
    private String nameRu;
    private String nameCrl;
    private Boolean status;
    private String meterManufacturerId;
    private String average;
    private Long physicalConsumerAmount;
    private Long legalConsumerAmount;
    private Boolean detail;
    private String admissibleCurrentAmper;
    private Long meterCapacity;
    private Boolean multiTariff;
    private Boolean realMeter;
    private Long transferred;
    private Long distributionPeriod;
    private Long transformationCoefficientId;
    private String permissibleVoltage;
    private String accuracyClass;

}
