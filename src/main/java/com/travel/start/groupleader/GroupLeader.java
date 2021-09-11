package com.travel.start.groupleader;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * User: Ilmars MEDNIS
 * Created: 07.09.2021
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)

@Entity
@Table(name = "group_leaders", schema = "viaggio")

public class GroupLeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(name = "gl_first_name")
    @NotBlank(message = "Group leader's First Name is required")
    private String glFirstName;

    @Column(name = "gl_last_name")
    @NotBlank(message = "Group leader's Last Name is required")
    private String glLastName;

    @Transient
    private String glFullName;

    @Column(name = "gl_DOB")
    @NotBlank(message = "Group leader's Date of Birth is required")
    private LocalDate glDOB;

    @Transient
    private Integer glAge;

    @Column(name = "gl_gender")
    @NotBlank(message = "Group leader's gender is required")
    private String glGender;

    @Column(name = "gl_soc_sec_no")
    @NotBlank(message = "Group leader's Social Security number is required")
    private String glSocialSecurityNo;

    @Column(name = "gl_passport_no")
    @NotBlank(message = "Group leader's Passport number is required")
    private String glPassportNo;

    @Column(name = "gl_passport_exp_date")
    @NotBlank(message = "Group leader's Passport Expiry date is required")
    private LocalDate glPassportExpireDate;

    @Column(name = "gl_id_card_no")
    private String glIdCardNo;

    @Column(name = "gl_mobile_phone")
    @NotBlank(message = "Group leader's Mobile Phone number is required")
    @Size(min = 8, max = 17, message = "Phone number should be a minimum of 8 characters and maximum of 17 characters")
    private String glMobilePhone;

    @Column(name = "gl_email", unique = true)
    @NotBlank(message = "Group leader's Email address is required")
    @Email(message = "Email is invalid")
    private String glEmail;

    @Column(name = "gl_address")
    @NotBlank(message = "Group leader's Address is required")
    private String glAddress;

    @Column(name = "gl_city")
    @NotBlank(message = "Group leader's Address City is required")
    private String glCity;

    @Column(name = "gl_state")
    private String glState;

    @Column(name = "gl_zip_code")
    @NotBlank(message = "Group leader's Address ZIP Code is required")
    private String glZip;

    @Column(name = "gl_country")
    @NotBlank(message = "Group leader's Address Country is required")
    private String glCountry;

    @Column(name = "gl_special_notes")
    private String glSpecialNotes;

    @Column(name = "notes")
    private String glNotes;

    @Column(name = "registered")
    private LocalDateTime glRegistered;

    @Column(name = "last_edited")
    private LocalDateTime glLastEdited;

    // Getter with years (age) auto calculation
    private Integer getGlAge() {
        return Period.between(this.glDOB, LocalDate.now()).getYears();
    }

    // Getter with FullName concatenation
    public String getGlFullName() {
        return this.glFirstName + " " + this.glLastName;
    }

}
