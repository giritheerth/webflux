package com.core.webFlux.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
// implement serializable since it can be converted into byte stream for certain aspects like networking, database persistence.
public class OrganizationDto  implements Serializable {
    private String orgId;
    private String orgName;
    private String orgEmail;
    private boolean isActive;
    private Long contact;
}
