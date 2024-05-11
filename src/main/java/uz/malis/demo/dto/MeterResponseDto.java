package uz.malis.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MeterResponseDto {

    private Long id;
    private Long meterTypeId;
    private MeterTypeResponseDto meterType;
    private String meterSerialNumber;
    private String uzstandSealNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate uzstandSealDate;
    private String energosbitSealNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime energoSbitSealDate;
    private String bpiSealNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate bpiSealDate;
    private Boolean hasMinus;
    private Long installationReadingPlus;
    private Long installationReadingMinus;
    private Long meterCapacity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate meterActivationDate;
    private Long meterStatusId;
    private BaseDto meterState;
    private Long meterInstallationLocationId;
    private BaseDto meterInstallationLocation;
    private Long previousCycle;
    private Long presentCycle;
    private String certificateInstrumentNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate verificationDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-d")
    private LocalDate certificateExpireDate;
    private String blankNumber;
    private String indicatorLegalEntityName;
    private Boolean askueConnection;
    private String askueTypeId;
    private String latitude;
    private String longitude;
    private Long readingPlus;
    private Long readingMinus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate readingDate;
    private Long lastReadingPlus;
    private Long lastReadingMinus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate lastReadingDate;
    private Long transformationCoefficientId;
    private TransformationCoefficientResponseDto transformationCoefficient;
    private String lastMinusCycleNumber;
    private String disconnectionAskue;
}