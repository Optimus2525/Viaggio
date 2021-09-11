package com.travel.start.pax;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Period;

/**
 * User: Ilmars MEDNIS
 * Created: 29.08.2021
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)

@Entity
@Table(name = "pax", schema = "viaggio")

public class Pax {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pax_id", nullable = false, unique = true)
    private Long paxId;

    @Column(name = "pax_name")
    @NotBlank(message = "PAX Name is required")
    private String paxName;

    @NotBlank(message = "PAX Surname is required")
    @Column(name = "pax_surname")
    private String paxSurname;

    @Transient
    private String paxFullName;

    @NotBlank(message = "PAX Date of Birth is required")
    @Column(name = "pax_dob")
    private LocalDate paxDOB;

    @Transient
    private Integer paxAge;

    @NotBlank(message = "PAX Gender is required")
    @Column(name = "pax_gender")
    private String paxGender;

    @NotBlank(message = "PAX Phone Number is required")
    @Column(name = "pax_phone")
    private String paxPhone;

    @NotBlank(message = "PAX E-mail Address is required")
    @Column(name = "pax_email")
    private String paxEmail;

    @NotBlank(message = "PAX Country of Residence is required")
    @Column(name = "pax_country")
    private String paxCountryOfResidence;

    @NotBlank(message = "PAX Address is required")
    @Column(name = "pax_address")
    private String paxAddress;

    public Integer getPaxAge() {
        return Period.between(this.paxDOB, LocalDate.now()).getYears();
    }

    public String getFullName() {
        return this.paxName + " " + this.paxSurname;
    }

}
