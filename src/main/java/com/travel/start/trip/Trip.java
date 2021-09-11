package com.travel.start.trip;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

/**
 * User: Ilmars MEDNIS
 * Created: 28.08.2021
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)

@Entity
@Table(name = "trips", schema="viaggio")

public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trip_id", nullable = false, unique = true)
    private Long tripId;

    @Column(name = "trip_name", nullable = false)
    private String tripName;

    @Column(name = "trip_country", nullable = false)
    private String tripCountry;

    @Column(name = "trip_strt_date", nullable = false)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate tripStartDate;

    @Column(name = "trip_end_date", nullable = false)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate tripEndDate;

    @Transient
    private Integer tripTotalDays;

    @Column(name = "trip_number_pax", nullable = false)
    private Integer tripNumberOfPAX;


    //--- Joint fields start

    private Long trippartnerId;

    //--- Joint fields end


    // Getter with days auto calculation
    public Integer getTripTotalDays() {
        return Period.between(tripStartDate, tripEndDate).getDays() + 1;
    }


}
