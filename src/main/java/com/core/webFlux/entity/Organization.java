package com.core.webFlux.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
public @Data class Organization implements Serializable {
    @Id
    private String orgId;
    private String orgName;
    private String orgEmail;
    private Long contact;
    private boolean isActive;
}
