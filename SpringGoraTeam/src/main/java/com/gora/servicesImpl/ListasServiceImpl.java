package com.gora.servicesImpl;

import com.gora.dao.ListasDao;
import com.gora.dominio.Atributo;
import com.gora.dominio.Cargo;
import com.gora.dominio.Carrera;
import com.gora.dominio.Competencia;
import com.gora.dominio.Grado;
import com.gora.dominio.Habilidades;
import com.gora.dominio.Lista;
import com.gora.dominio.Tipodocumento;
import com.gora.dominio.Ubigeo;
import com.gora.dominio.Universidad;
import com.gora.services.ListasService;

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
public class ListasServiceImpl implements ListasService {

    @Inject
    private ListasDao listasDao;
    

	@Override
	public List<Ubigeo> getDepartamentos() {
		return listasDao.getDepartamentos();
	}

	@Override
	public List<Ubigeo> getProvincias(String dep) {
		return listasDao.getProvincias(dep);
	}

	@Override
	public List<Ubigeo> getDistritos(String dep, String prov) {
		return listasDao.getDistritos(dep,prov);
	}

	@Override
	public List<Universidad> getUniversidades() {
		return listasDao.getUniversidades();
	}

	@Override
	public List<Carrera> getCarreras() {
		return listasDao.getCarreras();
	}

	@Override
	public List<Grado> getGrados() {
		return listasDao.getGrados();
	}

	@Override
	public List<Competencia> getCompetencias() {
		return listasDao.getCompetencias();
	}
	/*
	@Override
	public List<Atributo> getAtributos() {
		return listasDao.getAtributos();
	}
	*/
	@Override
	public List<Tipodocumento> getTipoDocumentos() {
		return listasDao.getTipoDocumentos();
	}

	@Override
	public List<Lista> getLista(Long idbloque) {
		return listasDao.getLista(idbloque);
	}

	@Override
	public List<Cargo> getCargos() {
		return listasDao.getCargos();
	}

	@Override
	public List<Habilidades> getHabilidades() {
		return listasDao.getHabilidades();
	}

	@Override
	public List<Atributo> getAtributos() {
		return listasDao.getAtributos();
	}

	@Override
	public List<Ubigeo> getUbigeo(Long idUbigeo) {
		return listasDao.getUbigeo(idUbigeo);
	}

}
