package com.travel.start.ztl;

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
@Table(name = "ztl", schema = "viaggio")

public class ZTL {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(name = "trip_id")
    private Long trip_Id;

    @Column(name = "ztl_name")
    @NotBlank(message = "ZTL name is required")
    private String ztlName;

    @Column(name = "currency_code")
    @NotBlank(message = "Currency Code is required")
    private String usedCurrency;

    @Column(name = "currency_date")
    @NotBlank(message = "Currency rate date is required")
    private LocalDate currencyDate;

    @Column(name = "currency_rate", nullable = false, columnDefinition = "Decimal(10,3) default '1.000'")
    @ColumnDefault("1.000")
    private BigDecimal currencyRate;

    @Column(name = "ztl_price_curr", columnDefinition = "Decimal(10,3)")
    private BigDecimal ztlPriceInCurrency;

    @Column(name = "ztl_price_eur", columnDefinition = "Decimal(10,3)")
    private BigDecimal ztlPriceInEuro;

    @Column(name = "notes")
    private String ztlNotes;

    @Column(name = "registered")
    private LocalDateTime ztlRegistered;

    @Column(name = "last_edited")
    private LocalDateTime ztlLastEdited;

}
