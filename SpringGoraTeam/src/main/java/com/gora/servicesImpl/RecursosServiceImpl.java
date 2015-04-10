package com.gora.servicesImpl;


import com.gora.dao.RecursosDao;
import com.gora.dominio.Recursos;
import com.gora.services.RecursosService;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import org.springframework.transaction.annotation.Transactional;
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
public class RecursosServiceImpl implements RecursosService {

    @Inject
    private RecursosDao recursosDao;

	@Override
	public void save(Recursos rec) {
		recursosDao.save(rec);
	}

	@Override
	public void update(Recursos rec) {
		recursosDao.update(rec);
	}

	@Override
	public Recursos findById(Long id) {
		return recursosDao.findById(id);
	}

	@Override
	public List<Recursos> findAll() {		
        return recursosDao.findAll();
	}

    

}
