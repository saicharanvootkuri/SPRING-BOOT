package com.springboot.studentrelations.Dtos;

import lombok.Data;

@Data
public class StudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String branch;
    private String mobileNumber;

}
