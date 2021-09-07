package com.travel.start.tollroad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * User: Ilmars MEDNIS
 * Created: 07.09.2021
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)

@Entity
@Table(name = "toll_roads", schema = "viaggio")

public class TollRoad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(name = "trip_id")
    private Long tripId;

    @Column(name = "toll_road_section")
    @NotBlank(message = "Toll Road Section name is required")
    private String tollRoadSection;

    @Column(name = "currency_code")
    @NotBlank(message = "Currency Code is required")
    private String usedCurrency;

    @Column(name = "currency_date")
    @NotBlank(message = "Currency rate date is required")
    private LocalDate currencyDate;

    @Column(name = "currency_rate", nullable = false, columnDefinition = "Decimal(10,3) default '1.000'")
    @ColumnDefault("1.000")
    private BigDecimal currencyRate;

    @Column(name = "toll_road_price_curr", columnDefinition = "Decimal(10,3)")
    private BigDecimal tollRoadPriceInCurrency;

    @Column(name = "toll_road_price_eur", columnDefinition = "Decimal(10,3)")
    private BigDecimal tollRoadPriceInEuro;

    @Column(name = "notes")
    private String tollRoadNotes;

    @Column(name = "registered")
    private LocalDateTime tollRoadRegistered;

    @Column(name = "last_edited")
    private LocalDateTime tollToadLastEdited;

}
