package com.travel.start.trippartner;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
@Table(name = "trip_partner", schema = "viaggio")

public class TripPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(name = "partner_name")
    @NotBlank(message = "Trip Partner's Name is required")
    private String partnerName;

    @Column(name = "partner_contact_first_name")
    @NotBlank(message = "Trip Partner's Name is required")
    private String partnerContactFirstName;

    @Column(name = "partner_contact_last_name")
    @NotBlank(message = "Trip Partner's Contact Person's Name is required")
    private String partnerContactLastName;

    @Column(name = "partner_contact_mobile_phone")
    @NotBlank(message = "Trip Partner's Contact Person's Mobile Phone is required")
    @Size(min = 8, max = 17, message = "Phone number should be a minimum of 8 characters and maximum of 17 characters")
    private String partnerContactMobilePhone;

    @Column(name = "partner_contact_landline_phone")
    private String partnerContactLandlinePhone;

    @Column(name = "partner_contact_email", unique = true)
    @NotBlank(message = "Trip Partner's Contact Person's Email is required")
    @Email(message = "Email is invalid")
    private String partnerContactEmail;

    @Column(name = "partner_mobile_phone")
    @NotBlank(message = "Trip Partner's Mobile Phone is required")
    @Size(min = 8, max = 17, message = "Phone number should be a minimum of 8 characters and maximum of 17 characters")
    private String partnerMobilePhone;

    @Column(name = "partner_landline_phone")
    private String partnerLandlinePhone;

    @Column(name = "partner_emergency_phone")
    private String partnerEmergencyPhone;

    @Column(name = "partner_email", unique = true)
    @NotBlank(message = "Trip Partner's Email is required")
    @Email(message = "Email is invalid")
    private String partnerEmailEmail;

    @Column(name = "partner_vat_number")
    private String partnerVatNumber;

    @Column(name = "partner_bank_name")
    private String partnerBankName;

    @Column(name = "partner_bank_iban")
    private String partnerBankIBAN;

    @Column(name = "partner_bank_swift_code")
    private String partnerBankSWIFT;

    @Column(name = "partner_address")
    @NotBlank(message = "Trip Partner's Address is required")
    private String partnerAddress;

    @Column(name = "partner_city")
    @NotBlank(message = "Trip Partner's City is required")
    private String partnerCity;

    @Column(name = "partner_state")
    @NotBlank(message = "Trip Partner's State is required")
    private String partnerState;

    @Column(name = "partner_zip_code")
    private String partnerZipCode;

    @Column(name = "partner_country")
    @NotBlank(message = "Trip Partner's Country is required")
    private String partnerCountry;

    @Column(name = "notes")
    private String partnerNotes;

    @Column(name = "registered")   // automatic
    private LocalDateTime registered;

    @Column(name = "last_edited")  // automatic
    private LocalDateTime LastEdited;

}
