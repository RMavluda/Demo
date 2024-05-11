package uz.malis.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class ConsumerFilterParams {
    private String multiFieldSearch;
    private String personalAccount;
    private String fullName;
    private String address;
    private Long agentId;
    private Long transformerId;
    private Long consumerStatusId;
    private String consumerStatusCode;
    private List<String> consumerStatusCodes;  //???
    private Long accountingStatusId;
    private String accountingStatusCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAtFrom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd't'hh:mm:ss")
    private LocalDateTime updatedAtTo;
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-mm-dd't'hh:mm:ss")
    private LocalDateTime paymentDateFrom;
    @JsonFormat(shape = Shape.STRING, pattern = "yyy-mm-dd't'hh:mm:ss")
    private LocalDateTime paymentDateTo;
    private String meterSerialNumber;
    private Long meterInstallationLocationId;
    private Long brigadeId;
    private Long habitationDivisionId;
    private Long streetId;
    private String buildingNumbe;
    private String flatNumber;
    private String corpusNumder;
    private String contractNumber;
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate contractionDateFrom;
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate contractionDateTo;
    private String workOrderTypeCode;
    private String documentSerialNumber;
    private String mobilePhone;
    private String phoneNumber;
    private String fullAddress;
    private String givenBy;
    private Long createdBy;
    private Long meterCapacity;
    private Long bookId;
    private Boolean askueConnection;
    private Long meterTypeId;
    private Long askueTypeId;
    private Long contractionAmountFrom;
    private Long contractionAmountTo;
    private Boolean hasLoss;
    private String coatoCode;
    private String pin;
    private Boolean hasMeter=true;

}
