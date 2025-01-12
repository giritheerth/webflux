package com.core.webFlux.services;

import com.core.webFlux.dto.OrganizationDto;
import com.core.webFlux.entity.Organization;
import reactor.core.publisher.Mono;

public class OrganizationService {
    // save org
    Mono<Organization> saveOrg(OrganizationDto organizationDto);
}
