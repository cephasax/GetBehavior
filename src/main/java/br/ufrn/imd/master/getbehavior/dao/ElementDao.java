package br.ufrn.imd.master.getbehavior.dao;

import javax.ejb.Stateless;

import br.ufrn.imd.master.getbehavior.domain.Element;

@Stateless
public class ElementDao extends GenericDao{

	public ElementDao() {
		super(Element.class);
		// TODO Auto-generated constructor stub
	}

}
