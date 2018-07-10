package com.glindia.condominio.rest.resources;

import com.glindia.condominio.model.Imovel;
import com.glindia.condominio.rest.AbstractCrudResource;
import com.glindia.condominio.services.AbstractCrudService;
import com.glindia.condominio.services.ImovelService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("imoveis")
public class ImovelResource extends AbstractCrudResource<Imovel> {

    @Inject
    private ImovelService service;

    @Override
    protected AbstractCrudService<Imovel> getService() {
        return service;
    }

}
