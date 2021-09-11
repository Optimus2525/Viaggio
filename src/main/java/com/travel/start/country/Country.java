package com.travel.start.country;

/**
 * User: Ilmars MEDNIS
 * Created: 29.08.2021
 */

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)

@Entity
@Table(name = "countries", schema = "viaggio")
public class Country {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name ="id", nullable = false, unique = true)
    private Long countryId;

    @Column(name ="country_name", nullable = false)
    private String countryName;

    @Column(name="country_iso_code")
    private String countryISOCode;

    @Column(name="country_isd_code")
    private String countryISDCode;
}
