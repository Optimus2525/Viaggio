package com.travel.start.agent;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "agent", schema = "viaggio")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Agent {
    @Id
    @Column(name = "agent_id", nullable = false)
    private Long id;

    @Column(name = "agent_first_name", nullable = false, unique = true)
    private String agentFirstName;

    @Column(name = "agent_surname_name", nullable = false)
    private String agentLastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "cell_phone", nullable = false)
    private String cellPhone;

}