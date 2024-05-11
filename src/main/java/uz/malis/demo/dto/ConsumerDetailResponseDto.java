package uz.malis.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ConsumerDetailResponseDto {

  private Long id;
  private String firstName;
  private String lastName;
  private String middleName;
  private String documentType;
  private String documentSerialNumber;
  private String givenBy;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime givendate;
  private String pin;
  private String tin;
  private Long languageId;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime birthdate;
  private String phoneNumber;
  private String mobilePhone;
  private Boolean deathStatus;
  private Boolean agreed;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime agreementDate;
  private String fullName = firstName + " " + lastName + " " + middleName;
}
