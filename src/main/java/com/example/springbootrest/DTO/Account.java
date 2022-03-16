package com.example.springbootrest.DTO;

import com.example.springbootrest.DTO.enums.Gender;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Account {
    private Long id;
    private String firstName;
    private String lastName;
    private Optional<String> middleName;
    private Integer age;
    private Gender gender;
    private LocalDate birthday;
    private LocalDate creationTime;
    private BigDecimal balance = BigDecimal.ZERO;
}
