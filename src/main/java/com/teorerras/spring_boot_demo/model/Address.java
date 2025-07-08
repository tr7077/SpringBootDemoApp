package com.teorerras.spring_boot_demo.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {
    private String country;
    private String state;
    private String city;
    private String address;
    private String postalCode;
}
