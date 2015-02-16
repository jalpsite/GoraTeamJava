package com.gora.daoImpl;

import java.util.List;





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

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class ListasDaoImpl  implements ListasDao {
	@Autowired
    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ubigeo> getDepartamentos() {
		Query query=getCurrentSession().createQuery("select distinct(a.departamento) from Ubigeo a order by a.departamento");
		return query.list();
	}	

	@SuppressWarnings("unchecked")
	@Override
	public List<Ubigeo> getProvincias(String dep) {
		Query query=getCurrentSession().createQuery("select distinct(a.provincia) from Ubigeo a where a.departamento= :dep order by a.provincia");
		query.setParameter("dep", dep);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ubigeo> getDistritos(String dep,String prov) {
		Query query=getCurrentSession().createQuery("select a.idubigeo, a.distrito from Ubigeo a where a.provincia= :prov and a.departamento= :dep order by a.distrito");
		query.setParameter("prov", prov);
		query.setParameter("dep", dep);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Universidad> getUniversidades() {
		Query query=getCurrentSession().createQuery("select a.iduniversidad, a.nombre from Universidad a");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carrera> getCarreras() {
		Query query=getCurrentSession().createQuery("select a.idcarrera, a.nombre from Carrera a");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grado> getGrados() {
		Query query=getCurrentSession().createQuery("select a.idgrado, a.descripcion from Grado a");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Competencia> getCompetencias() {
		Query query=getCurrentSession().createQuery("select a.idcompetencia, a.descripcion from Competencia a");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tipodocumento> getTipoDocumentos() {
		Query query=getCurrentSession().createQuery("select a.idtipodocumento, a.descripcion from Tipodocumento a");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lista> getLista(Long idbloque) {
		Query query=getCurrentSession().createQuery("select a.codigo, a.descripcion from Lista a where a.idbloque= :id and a.estado='A'");
		query.setParameter("id", idbloque);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> getCargos() {		
		return getCurrentSession().createQuery("select a.idcargo, a.descripcion from Cargo a").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Habilidades> getHabilidades() {
		Query query=getCurrentSession().createQuery("select a.idhabilidades, a.descripcion from Habilidades a");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atributo> getAtributos() {
		Query query=getCurrentSession().createQuery("select a.idatributo, a.descripcion from Atributo a");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ubigeo> getUbigeo(Long idUbigeo) {
		Query query=getCurrentSession().createQuery("select a from Ubigeo a where a.idubigeo=:id");
		query.setParameter("id", idUbigeo);
		return query.list();
	}

	

}