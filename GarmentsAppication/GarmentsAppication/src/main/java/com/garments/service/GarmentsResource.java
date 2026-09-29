/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garments.service;

import Entity.Garmentmaster;
import com.garments.dao.GarmentsDAO;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/garments")
@RolesAllowed("OWNER")

public class GarmentsResource {

    @Inject
    private GarmentsDAO dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Garmentmaster> getGarments(
            @QueryParam("category") String category,
            @QueryParam("priceRange") String priceRange) {

        return dao.getGarments(category, priceRange);
    }
}
