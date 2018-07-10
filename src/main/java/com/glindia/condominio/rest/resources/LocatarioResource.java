package com.glindia.condominio.rest.resources;

import com.glindia.condominio.model.Locatario;
import com.glindia.condominio.rest.AbstractCrudResource;
import com.glindia.condominio.services.AbstractCrudService;
import com.glindia.condominio.services.LocatarioService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("locatarios")
public class LocatarioResource extends AbstractCrudResource<Locatario> {

    @Inject
    private LocatarioService service;

    @Override
    protected AbstractCrudService<Locatario> getService() {
        return service;
    }

}