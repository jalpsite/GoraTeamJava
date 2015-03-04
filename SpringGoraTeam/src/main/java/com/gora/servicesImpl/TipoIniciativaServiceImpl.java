package com.gora.servicesImpl;


import com.gora.dao.TipoiniciativaDao;
import com.gora.dominio.Tipoiniciativa;
import com.gora.services.TipoIniciativaService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;





import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:10 PM
 * com.gora.dominio
 */


@Service
@Transactional
public class TipoIniciativaServiceImpl implements TipoIniciativaService {

    @Inject
    private TipoiniciativaDao tipoIniciativaDao;

	@Override	
	public void save(Tipoiniciativa tipoiniciativa) {
		tipoIniciativaDao.save(tipoiniciativa);
	}

	@Override	
	public void update(Tipoiniciativa tipoiniciativa) {
		tipoIniciativaDao.update(tipoiniciativa);
	}

	@Override	
	public Tipoiniciativa findById(Long id) {
		return tipoIniciativaDao.findById(id);
	}

	@Override	
	public List<Tipoiniciativa> findAll() {
		return tipoIniciativaDao.findAll();
	}

   

}
