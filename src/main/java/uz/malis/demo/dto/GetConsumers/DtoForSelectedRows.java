package uz.malis.demo.dto.GetConsumers;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoForSelectedRows {
  private Long id;
  private String personalAccount;
  private String address;
  private String coatoCode;
  private String fullName;
  private Long lastReadingPlus;
  private LocalDate lastReadingDate;


}
