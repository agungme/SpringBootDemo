package com.springboot.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @SequenceGenerator(name="tickets_id_seq",
            sequenceName="tickets_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="tickets_id_seq")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "userId")
    private Long userId;


}
