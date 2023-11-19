package org.libraryManagement.models;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data

public class Admin extends User{
    private String password;
}
