package uz.malis.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;

@Data
public class ConsumerResponseDtoMAIN {
  private Long id;
  private String personalAccount;
  private String coatoCode;
  private Long streetId;
  private BaseDto street;
  private String buildingNumber;
  private String flatNumber;
  private String corpusNumber;
  private Long coatoLocationId;
  private String note;
  private String inventoryCode;
  private Long habitationDivisionId;
  private BaseDto habitationDivision;
  private Long agentId;
  private AgentResponseDto agent;
  private Long bookId;
  private BaseDto book;
  private Long brigadeId;
  private BaseDto brigade;
  private Long transformerId;
  private BaseDto transformer;
  private Long tariffId;
  private TariffResponseDto tariff;
  private String contractNumber;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate applicationDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate contractionDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate tariffInputDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate contractRenewalDate;
  private Long january;
  private Long february;
  private Long march;
  private Long april;
  private Long may;
  private Long june;
  private Long july;
  private Long august;
  private Long september;
  private Long october;
  private Long november;
  private Long december;
  private Long additionalSubstationId;
  private String fider1;
  private String fider2;
  private Long housingTypeId;
  private Long housingCategoryId;
  private Boolean gazConnection;
  private Boolean centralHeating;
  private Long houseApplianceAmount;
  private Long houseApplianceCapacity;
  private Long connectionCapacity;
  private Long socketAmount;
  private Long overallConsumptionCapacity;
  private Long residentsAmount;
  private String notes;
  private Boolean fromMip2;
  private Long presentReading;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime presentReadingDate;
  private Long previousReading;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime previousReadingDate;
  private Long previousCycleNumber;
  private Long presentCycleNumber;
  private MeterResponseDto meter;
  private ConsumerDetailResponseDto consumerDetail;
  private StatusResponseDto accountingStatus;
  private StatusResponseDto consumerStatus;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime statusUpdateAt;
  private Long consumptionLoss;

}
