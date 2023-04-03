package com.meatup.meatup.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String uid;
    private String email;
    private String displayName;
}
