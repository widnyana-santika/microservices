package com.idpuwid.notification.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String surname;
    private String gender;
    private Date dob;
    private String phoneNumber;
}
