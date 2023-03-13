package ru.gb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence-generator")
    @SequenceGenerator(name = "sequence-generator",
            sequenceName = "user_sequence",
            initialValue = 1)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="mark")
    private Integer mark;

}
