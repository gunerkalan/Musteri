package com.guner.employee.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {

    @Id
    @SequenceGenerator(name="seq_employee",allocationSize = 1)
    @GeneratedValue(generator = "seq_employee",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name ="first_name", length = 100)
    private String firstName;

    @Column(name ="last_name", length = 100)
    private String lastName;

    @Column(name ="email", length = 100)
    private String emailId;

    @Column(name ="phone_number", length = 100)
    private String phoneNumber;

    @Column(name ="isactive")
    private Boolean IsActive;
}
