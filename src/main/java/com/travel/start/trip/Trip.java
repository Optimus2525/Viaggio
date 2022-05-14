package com.travel.start.trip;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * User: Ilmars MEDNIS
 * Created: 28.08.2021
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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

    @Column(name = "trip_code", nullable = false, unique = true)
    private String tripCode;

    @Transient
    private Integer tripTotalDays;

    @Column(name = "trip_number_pax", nullable = false)
    private Integer tripNumberOfPAX;


    //--- Joint fields start

//    private Long trippartnerId;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "trip_partner_id", nullable = false)
//    private TripPartner tripPartner;

//--- Joint fields end


    // Getter with days auto calculation
    public Integer getTripTotalDays() {
        return Period.between(tripStartDate, tripEndDate).getDays() + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Trip trip = (Trip) o;
        return tripId != null && Objects.equals(tripId, trip.tripId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
