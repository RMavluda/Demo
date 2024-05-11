package uz.malis.demo.dto;

import lombok.Data;

@Data
public class AgentResponseDto {
    private Long id;
    private String code;
    private String firstName;
    private String lastName;
    private String middleName;
    private String mobilePhone;
    private String status;

}
