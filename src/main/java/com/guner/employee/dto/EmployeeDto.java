package com.guner.employee.dto;


import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel()
public class EmployeeDto {

    @ApiModelProperty(value = "Employee Id")
    private Long id;

    @NotNull
    @ApiModelProperty(required = true, value = "Employee FirstName")
    private String firstName;

    @NotNull
    @ApiModelProperty(required = true, value = "Employee LastName")
    private String lastName;

    @ApiModelProperty(required = true, value = "Employee EMail")
    private String emailId;

    @ApiModelProperty(required = true, value = "Employee Phone Number")
    private String phoneNumber;
}
