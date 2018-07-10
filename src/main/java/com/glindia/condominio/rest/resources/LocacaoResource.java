package com.glindia.condominio.rest.resources;

import com.glindia.condominio.model.Locacao;
import com.glindia.condominio.rest.AbstractCrudResource;
import com.glindia.condominio.services.AbstractCrudService;
import com.glindia.condominio.services.LocacaoService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("locacoes")
public class LocacaoResource extends AbstractCrudResource<Locacao> {

    @Inject
    private LocacaoService service;

    @Override
    protected AbstractCrudService<Locacao> getService() {
        return service;
    }

}
