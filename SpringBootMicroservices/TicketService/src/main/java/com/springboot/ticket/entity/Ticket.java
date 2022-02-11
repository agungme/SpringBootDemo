package com.springboot.ticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;

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

    public Ticket() {

    }

    public Ticket(String name, Long userId) {
        super();
        this.name = name;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getUserId() {return userId;}
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
