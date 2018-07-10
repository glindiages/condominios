package com.glindia.condominio.services;

import com.glindia.condominio.model.Locacao;
import com.glindia.condominio.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class LocacaoService extends AbstractCrudService<Locacao> {
    
    @Inject
    private GenericDao<Locacao> dao;

    @Override
    protected GenericDao<Locacao> getDao() {
        return dao;
    }
    
}
