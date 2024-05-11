package uz.malis.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class DemoApplication {

  private ConsumersFeignClient consumersFeignClient;


  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  CommandLineRunner runner() {
    return (args) -> {

//      ConsumerFilterParams filterParams = new ConsumerFilterParams();

/*
      PageableParams pageableParams = new PageableParams();
      pageableParams.setPage(0);
      pageableParams.setSize(10);
      pageableParams.setSort(List.of());*/


//      var headers = new HashMap<String, String>();
//
//      headers.put("coatoCode", "26287");
//      headers.put("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJBeEtsZld2b3R1YXZLMmwwUHdoYUtMb29RT0RvaUlkamFyMXlDRWJCWTVFIn0.eyJleHAiOjE3MTYwMTY0MzgsImlhdCI6MTcxNTE1MjQzOCwianRpIjoiOTE0MjAyN2EtZGQxYy00YWQ1LWFkNDEtZjRkNTlhZTdhYzRiIiwiaXNzIjoiaHR0cDovLzE5Mi4xNjguMjUuNTc6ODA4MC9yZWFsbXMvSGV0S2V5Y2xvYWsiLCJhdWQiOlsicmVhbG0tbWFuYWdlbWVudCIsImJyb2tlciIsImFjY291bnQiXSwic3ViIjoiNWQwYmY3OWQtMDJiNi00NjQ1LWFhYzMtMGQxMjhmMTcyMGNjIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiaGV0LWxvZ2luIiwic2Vzc2lvbl9zdGF0ZSI6IjA4ZDY2MzJjLWU0NDUtNDk1Yi1iMGIxLWU3OGMyZjdjMzVlMCIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiYXBwLWFkbWluIiwiZGVmYXVsdC1yb2xlcy1oZXRrZXljbG9hayJdfSwicmVzb3VyY2VfYWNjZXNzIjp7InJlYWxtLW1hbmFnZW1lbnQiOnsicm9sZXMiOlsidmlldy1pZGVudGl0eS1wcm92aWRlcnMiLCJ2aWV3LXJlYWxtIiwibWFuYWdlLWlkZW50aXR5LXByb3ZpZGVycyIsImltcGVyc29uYXRpb24iLCJyZWFsbS1hZG1pbiIsImNyZWF0ZS1jbGllbnQiLCJtYW5hZ2UtdXNlcnMiLCJxdWVyeS1yZWFsbXMiLCJ2aWV3LWF1dGhvcml6YXRpb24iLCJxdWVyeS1jbGllbnRzIiwicXVlcnktdXNlcnMiLCJtYW5hZ2UtZXZlbnRzIiwibWFuYWdlLXJlYWxtIiwidmlldy1ldmVudHMiLCJ2aWV3LXVzZXJzIiwidmlldy1jbGllbnRzIiwibWFuYWdlLWF1dGhvcml6YXRpb24iLCJtYW5hZ2UtY2xpZW50cyIsInF1ZXJ5LWdyb3VwcyJdfSwiaGV0LWxvZ2luIjp7InJvbGVzIjpbInJlYWxtLWN1c3RvbS1yb2xlIiwidW1hX3Byb3RlY3Rpb24iXX0sImJyb2tlciI6eyJyb2xlcyI6WyJyZWFkLXRva2VuIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50Iiwidmlldy1hcHBsaWNhdGlvbnMiLCJ2aWV3LWNvbnNlbnQiLCJ2aWV3LWdyb3VwcyIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwibWFuYWdlLWNvbnNlbnQiLCJkZWxldGUtYWNjb3VudCIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcGhvbmUgcHJvZmlsZSIsInNpZCI6IjA4ZDY2MzJjLWU0NDUtNDk1Yi1iMGIxLWU3OGMyZjdjMzVlMCIsInVwbiI6ImFkbWluIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJhZGRyZXNzIjp7fSwidXNlcl9pZCI6IjE4IiwiY29hdG9fY29kZSI6IjAwMDAwIiwibmFtZSI6IlN1cGVyIGFkbWluIC0iLCJncm91cHMiOlsiMTAwMDEiLCIxMDAxMCIsInN1cGVyLWFkbWluIiwiYXBwLWFkbWluIiwiZGVmYXVsdC1yb2xlcy1oZXRrZXljbG9hayJdLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJhZG1pbiIsImdpdmVuX25hbWUiOiJTdXBlciBhZG1pbiIsImZhbWlseV9uYW1lIjoiLSJ9.H0lh4g7tXr6OuhzVla8fIwzJtI9FJdcAWijnOzeINYgPaHD3kRLxHcG5IH23ZL43HwKCNc8K3DM5Fx_vhNW1EJFgBvrz3VGHMGPLhybrsL10mh2bI_mKfbkevgGX8uhXLW1fluHu25GJR3yoG2u0EKK0tc58JbGjqRm17TshnUm_YPyAY9z_OlE9SfeNC4Sn6KqKUw3K5sq1XlZNxQJ3Nvrx7IEQMFSkVPd5gXtbq-Bx9OJeOmIYY3fKj4BRZ7uzgrviaE7iDlJ3Y-syrK4pUmbxfzbm-s0P9zfM_N4S_OHZaqKdOL6cE3UTlb8clKnHtTUuG80xViyd8SIsYnrnkQ");
//
//
//      List<ConsumerResponseDtoMAIN> response = consumersFeignClient.getConsumers(
//            filterParams, headers
//      );
//
//      System.out.println(response);
    };
  }




/*      @Bean
      CommandLineRunner runner() {
        return (arg) -> {

        var consumerId = 6614391;
        var coatoCode = "26287";

        var headers = new HashMap<String, String>();
        headers.put("coatoCode", "26287");
        headers.put("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJBeEtsZld2b3R1YXZLMmwwUHdoYUtMb29RT0RvaUlkamFyMXlDRWJCWTVFIn0.eyJleHAiOjE3MTYwMTY0MzgsImlhdCI6MTcxNTE1MjQzOCwianRpIjoiOTE0MjAyN2EtZGQxYy00YWQ1LWFkNDEtZjRkNTlhZTdhYzRiIiwiaXNzIjoiaHR0cDovLzE5Mi4xNjguMjUuNTc6ODA4MC9yZWFsbXMvSGV0S2V5Y2xvYWsiLCJhdWQiOlsicmVhbG0tbWFuYWdlbWVudCIsImJyb2tlciIsImFjY291bnQiXSwic3ViIjoiNWQwYmY3OWQtMDJiNi00NjQ1LWFhYzMtMGQxMjhmMTcyMGNjIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiaGV0LWxvZ2luIiwic2Vzc2lvbl9zdGF0ZSI6IjA4ZDY2MzJjLWU0NDUtNDk1Yi1iMGIxLWU3OGMyZjdjMzVlMCIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiYXBwLWFkbWluIiwiZGVmYXVsdC1yb2xlcy1oZXRrZXljbG9hayJdfSwicmVzb3VyY2VfYWNjZXNzIjp7InJlYWxtLW1hbmFnZW1lbnQiOnsicm9sZXMiOlsidmlldy1pZGVudGl0eS1wcm92aWRlcnMiLCJ2aWV3LXJlYWxtIiwibWFuYWdlLWlkZW50aXR5LXByb3ZpZGVycyIsImltcGVyc29uYXRpb24iLCJyZWFsbS1hZG1pbiIsImNyZWF0ZS1jbGllbnQiLCJtYW5hZ2UtdXNlcnMiLCJxdWVyeS1yZWFsbXMiLCJ2aWV3LWF1dGhvcml6YXRpb24iLCJxdWVyeS1jbGllbnRzIiwicXVlcnktdXNlcnMiLCJtYW5hZ2UtZXZlbnRzIiwibWFuYWdlLXJlYWxtIiwidmlldy1ldmVudHMiLCJ2aWV3LXVzZXJzIiwidmlldy1jbGllbnRzIiwibWFuYWdlLWF1dGhvcml6YXRpb24iLCJtYW5hZ2UtY2xpZW50cyIsInF1ZXJ5LWdyb3VwcyJdfSwiaGV0LWxvZ2luIjp7InJvbGVzIjpbInJlYWxtLWN1c3RvbS1yb2xlIiwidW1hX3Byb3RlY3Rpb24iXX0sImJyb2tlciI6eyJyb2xlcyI6WyJyZWFkLXRva2VuIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50Iiwidmlldy1hcHBsaWNhdGlvbnMiLCJ2aWV3LWNvbnNlbnQiLCJ2aWV3LWdyb3VwcyIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwibWFuYWdlLWNvbnNlbnQiLCJkZWxldGUtYWNjb3VudCIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcGhvbmUgcHJvZmlsZSIsInNpZCI6IjA4ZDY2MzJjLWU0NDUtNDk1Yi1iMGIxLWU3OGMyZjdjMzVlMCIsInVwbiI6ImFkbWluIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJhZGRyZXNzIjp7fSwidXNlcl9pZCI6IjE4IiwiY29hdG9fY29kZSI6IjAwMDAwIiwibmFtZSI6IlN1cGVyIGFkbWluIC0iLCJncm91cHMiOlsiMTAwMDEiLCIxMDAxMCIsInN1cGVyLWFkbWluIiwiYXBwLWFkbWluIiwiZGVmYXVsdC1yb2xlcy1oZXRrZXljbG9hayJdLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJhZG1pbiIsImdpdmVuX25hbWUiOiJTdXBlciBhZG1pbiIsImZhbWlseV9uYW1lIjoiLSJ9.H0lh4g7tXr6OuhzVla8fIwzJtI9FJdcAWijnOzeINYgPaHD3kRLxHcG5IH23ZL43HwKCNc8K3DM5Fx_vhNW1EJFgBvrz3VGHMGPLhybrsL10mh2bI_mKfbkevgGX8uhXLW1fluHu25GJR3yoG2u0EKK0tc58JbGjqRm17TshnUm_YPyAY9z_OlE9SfeNC4Sn6KqKUw3K5sq1XlZNxQJ3Nvrx7IEQMFSkVPd5gXtbq-Bx9OJeOmIYY3fKj4BRZ7uzgrviaE7iDlJ3Y-syrK4pUmbxfzbm-s0P9zfM_N4S_OHZaqKdOL6cE3UTlb8clKnHtTUuG80xViyd8SIsYnrnkQ");
        ConsumerResponseDtoMAIN response = consumersFeignClient.findConsumer(
            (long) consumerId, coatoCode, headers);

        System.out.println(response);

      };
    }*/

  // ___________________________________________________________________________________________

/*


  @Bean
  CommandLineRunner runner() {
    return (arg) -> {

      var personalAcc = "1474029";
      var coatoCode = "26287";

      var headers = new HashMap<String, String>();
      headers.put("Coato-Code", "26287");
      headers.put("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJBeEtsZld2b3R1YXZLMmwwUHdoYUtMb29RT0RvaUlkamFyMXlDRWJCWTVFIn0.eyJleHAiOjE3MTU5NDU5ODksImlhdCI6MTcxNTA4MTk4OSwianRpIjoiNGQyZTViYjQtZjg3OC00YWEwLWIzNDMtMzIxYjM2ZmRlZGRlIiwiaXNzIjoiaHR0cDovLzE5Mi4xNjguMjUuNTc6ODA4MC9yZWFsbXMvSGV0S2V5Y2xvYWsiLCJhdWQiOlsicmVhbG0tbWFuYWdlbWVudCIsImJyb2tlciIsImFjY291bnQiXSwic3ViIjoiNWQwYmY3OWQtMDJiNi00NjQ1LWFhYzMtMGQxMjhmMTcyMGNjIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiaGV0LWxvZ2luIiwic2Vzc2lvbl9zdGF0ZSI6IjBlNjgxZGE2LTFkMmEtNDI3Zi04YmFhLWIyOGE3MzQ0ZjA1OSIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiYXBwLWFkbWluIiwiZGVmYXVsdC1yb2xlcy1oZXRrZXljbG9hayJdfSwicmVzb3VyY2VfYWNjZXNzIjp7InJlYWxtLW1hbmFnZW1lbnQiOnsicm9sZXMiOlsidmlldy1pZGVudGl0eS1wcm92aWRlcnMiLCJ2aWV3LXJlYWxtIiwibWFuYWdlLWlkZW50aXR5LXByb3ZpZGVycyIsImltcGVyc29uYXRpb24iLCJyZWFsbS1hZG1pbiIsImNyZWF0ZS1jbGllbnQiLCJtYW5hZ2UtdXNlcnMiLCJxdWVyeS1yZWFsbXMiLCJ2aWV3LWF1dGhvcml6YXRpb24iLCJxdWVyeS1jbGllbnRzIiwicXVlcnktdXNlcnMiLCJtYW5hZ2UtZXZlbnRzIiwibWFuYWdlLXJlYWxtIiwidmlldy1ldmVudHMiLCJ2aWV3LXVzZXJzIiwidmlldy1jbGllbnRzIiwibWFuYWdlLWF1dGhvcml6YXRpb24iLCJtYW5hZ2UtY2xpZW50cyIsInF1ZXJ5LWdyb3VwcyJdfSwiaGV0LWxvZ2luIjp7InJvbGVzIjpbInJlYWxtLWN1c3RvbS1yb2xlIiwidW1hX3Byb3RlY3Rpb24iXX0sImJyb2tlciI6eyJyb2xlcyI6WyJyZWFkLXRva2VuIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50Iiwidmlldy1hcHBsaWNhdGlvbnMiLCJ2aWV3LWNvbnNlbnQiLCJ2aWV3LWdyb3VwcyIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwibWFuYWdlLWNvbnNlbnQiLCJkZWxldGUtYWNjb3VudCIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcGhvbmUgcHJvZmlsZSIsInNpZCI6IjBlNjgxZGE2LTFkMmEtNDI3Zi04YmFhLWIyOGE3MzQ0ZjA1OSIsInVwbiI6ImFkbWluIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJhZGRyZXNzIjp7fSwidXNlcl9pZCI6IjE4IiwiY29hdG9fY29kZSI6IjAwMDAwIiwibmFtZSI6IlN1cGVyIGFkbWluIC0iLCJncm91cHMiOlsiMTAwMDEiLCIxMDAxMCIsInN1cGVyLWFkbWluIiwiYXBwLWFkbWluIiwiZGVmYXVsdC1yb2xlcy1oZXRrZXljbG9hayJdLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJhZG1pbiIsImdpdmVuX25hbWUiOiJTdXBlciBhZG1pbiIsImZhbWlseV9uYW1lIjoiLSJ9.AViWU6oUMtwl3_UDKwkgqAlpdQRonGaROvg-zpHwSLMX2qx9pMEN-vXMW2Xv_IDkoZKT_50nXPyEAbyFoGAvQd8U1hzg7cMTqODs1IERDq4L0_n5gV4q0WD2BAQdAF3cUx5NvDHGM4O2DhShCswHgBeQq0Vd5rqBMSCTuca2ukJnD7-NsHSNpTejiGsJEWoUxiR5CAS6lxEkcV9dK79KF4KYR-lw1eWPSkERs2Dw-KAVyHM9qDHK5IkarLckYIR5wpRrKXSaDzxb4gqBJnolZJVO_Qa12dZUP1f0fVxT9G5lLZE4V7mLsWJv4nyzO736CE4Vo4LUZbTPDc_8RjTs2Q");


      CheckConsumerDto response = consumersFeignClient.checkConsumer(
          personalAcc, coatoCode, headers
      );

      System.out.println(response);






    };
  }
*/



 /*
 ```
  ConsumerResponseDtoMAIN(
      id=6614391,
      personalAccount=1474029,
      coatoCode=26287,
      streetId=435464,
      street=BaseDto(
      id=435464,
      code=null,
      nameUz=BOBUR UL ,
      nameRu=BOBUR UL ,
      nameCrl=BOBUR UL ,
      status=true),
      buildingNumber=67/3,
      flatNumber=29,
      corpusNumber=null,
      coatoLocationId=2320,
      note=тугри,
      inventoryCode=10:05:02:02:01:5011:0001:029,
      habitationDivisionId=206615,
      habitationDivision=BaseDto(
      id=206615,
      code=null,
      nameUz=Бобур     Яккасарай,
      nameRu=Бобур     Яккасарай,
      nameCrl=Бобур     Яккасарай,
      status=true), agentId=113062,
      agent=AgentResponseDto(
      id=113062,
      code=402,
      firstName=Латипов,
      lastName=Мирджамол,
      middleName=-,
      mobilePhone=998973339130,
      status=true),
      bookId=264015,
      book=null,
      brigadeId=168000,
      brigade=null,
      transformerId=744955,
      transformer=BaseDto(
      id=744955,
      code=42277,
      nameUz=0390-2,
      nameRu=0390-2,
      nameCrl=0390-2,
      status=true),
      tariffId=54,
 !!!!!!     tariff=TariffResponseDto(price=29500),!!!!!!!!!!
      contractNumber=20381869,
      applicationDate=2023-11-08,
      contractionDate=2016-12-31,
      tariffInputDate=2019-08-14,
      contractRenewalDate=2016-12-31,
      january=150000,
      february=150000,
      march=150000,
      april=150000,
      may=150000,
      june=150000,
      july=150000,
      august=150000,
      september=150000,
      october=150000,
      november=150000,
      december=150000,
      additionalSubstationId=null,
      fider1=null,
      fider2=null,
      housingTypeId=2,
      housingCategoryId=21,
      gazConnection=true,
      centralHeating=true,
      houseApplianceAmount=0,
      houseApplianceCapacity=0,
      connectionCapacity=0,
      socketAmount=0,
      overallConsumptionCapacity=0,
      residentsAmount=0,
      notes=тугри,
      fromMip2=false,
      presentReading=4526000,
      presentReadingDate=2023-03-30T00:00,
      previousReading=4525000,
      previousReadingDate=2023-03-29T00:00,
      previousCycleNumber=null,
      presentCycleNumber=null,
      meter=MeterResponseDto(
      id=41352606,
      meterTypeId=6549,
      meterType=MeterResponseDto(
      id=6549,
      meterTypeId=6549,
      meterType=MeterTypeResponseDto(
      id=6549,
      code=3725,
      nameUz=EX-18,
      nameRu=EX-18,
      nameCrl=EX-18,
      status=true,
      meterManufacturerId=null,
      average=null,
      physicalConsumerAmount=0,
      legalConsumerAmount=0,
      detail=true,
      admissibleCurrentAmper=5(60),
!!!!!      meterCapasity=null, !!!!!!!  meterCapasity=6
      multiTariff=true,
      realMeter=true,
      transferred=6629,
      distributionPeriod=10,
      transformationCoefficientId=2,
      permissibleVoltage=275,
      accuracyClass=1),
      meterSerialNumber=121205077432,
      uzstandSealNumber=2020,
      uzstandSealDate=2020-09-14,
      energosbitSealNumber=537902,
      energoSbitSealDate=null,
      bpiSealNumber=537902,
      bpiSealDate=2020-09-14,
      hasMinus=false,
      installationReadingPlus=10000,
      installationReadingMinus=0,
      meterCapacity=6,
      meterActivationDate=2020-09-14,
      meterStatusId=1,
      meterState=BaseDto(
      id=1,
      code=1,
      nameUz=Рабочий,
      nameRu=Рабочий,
      nameCrl=Рабочий,
      status=true),
      meterInstallationLocationId=8,
      meterInstallationLocation=BaseDto(
      id=8,
      code=8,
      nameUz=В подъезде,
      nameRu=В подъезде,
      nameCrl=В подъезде,
      status=true),
      previousCycle=0,
      presentCycle=0,
      certificateInstrumentNumber=1474029,
      verificationDate=2020-09-14,
      certificateExpireDate=2030-09-14,
      blankNumber=null,
      indicatorLegalEntityName=null,
      askueConnection=true,
      askueTypeId=7,
      latitude=null,
      longitude=null,
      readingPlus=4526000,
      readingMinus=0,
      readingDate=2023-03-29,
      lastReadingPlus=4526000,
      lastReadingMinus=0,
      lastReadingDate=2023-03-29,
      transformationCoefficientId=2,
      transformationCoefficient=TransformationCoefficientResponseDto(
      id=2,
      code=1,
      value=1,
      status=true),
      lastMinusCycleNumber=null,
      disconnectionAskue=null),
      consumerDetail=ConsumerDetailResponseDto(
      id=6614391,
      firstName=T,
      lastName=ERNAZAROV,
      middleName=D,
      documentType=PASSPORT,
      DocumentSerialNumber=AC4329487,
      givenBy=null,
      givendate=null,
      pin=31612920241458,
      tin=null,
      languageId=null,
      birthdate=null,
      phoneNumber=null,
      mobilePhone=998909001313,
      deathStatus=true,
      agreed=false,
      agreementDate=2020-01-21T17:34:49,
      fullName=ERNAZAROV T D),
      accountingStatus=StatusResponseDto(
      id=21,
      nameUz=Hisoblangan,
      nameRu=Рассчитан,
      nameCrl=Hisoblangan,
      code=1,
      statusType=ACCOUNTING_STATUS),
      consumerStatus=StatusResponseDto(
      id=1,
      nameUz=Введен,
      nameRu=null,
      nameCrl=null,
      code=1,
      statusType=CONSUMER_STATUS),
      statusUpdateAt=null,
      consumptionLoss=null)
```

 */


}
