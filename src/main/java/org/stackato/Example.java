package org.stackato;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
 
@Named
@SessionScoped
public class Example implements Serializable {
	
    @Inject
    private InjectionExample ie;
    
	private String name = "Coucou";
	
	public Example(){
//		name = ie.getProperties();

	}
	 
	public String getName() {
		return ie.getProperties();
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
