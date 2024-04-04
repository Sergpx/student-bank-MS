package com.example.studentms.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@RequiredArgsConstructor
@Builder
//@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Setter
    String firstName;
    @Setter
    String lastName;
    @Setter
    @Column(nullable = false, unique = true)
    String accountNumber;

    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "group_id", nullable = false)
    @Setter
    @ManyToOne
    private Group group;
}
