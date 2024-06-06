package com.stock.dao;

import java.util.List;
import javax.persistence.*;

import com.stock.model.Insumo;

public class InsumoDAOImpl extends GenericDAOImpl<Insumo> implements InsumoDAO {

	public Class<Insumo> getClase() {
    	return Insumo.class;
    }
}
