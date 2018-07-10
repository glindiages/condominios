package com.glindia.condominio.services;

import com.glindia.condominio.model.Locatario;
import com.glindia.condominio.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class LocatarioService extends AbstractCrudService<Locatario> {
    
    @Inject
    private GenericDao<Locatario> dao;

    @Override
    protected GenericDao<Locatario> getDao() {
        return dao;
    }
    
}
