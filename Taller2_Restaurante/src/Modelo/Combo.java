package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Combo extends Producto {

	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo;
	
	
	public Combo(String pnombre, double pdescuento, ArrayList<ProductoMenu> pproductos)
	{
		this.descuento = pdescuento;
		this.nombreCombo = pnombre;
		this.itemsCombo = pproductos;
	}
	@Override
	public int getPrecio() 
	{
		Iterator<ProductoMenu> iterador = itemsCombo.iterator();
		int total = 0;
	    while(iterador.hasNext()) {
	    	ProductoMenu elemento = iterador.next();
	    	double precio = elemento.getPrecio();
	    	total += precio;
	    }
	    int final1  = (int) (total*(1-(descuento*0.01)));
		return final1;
	}

	@Override
	public String getNombre() 
	{
		return nombreCombo;
	}

	@Override
	public int getCalorias() 
	{
		Iterator<ProductoMenu> iterador = itemsCombo.iterator();
		int cals = 0;
	    while(iterador.hasNext()) {
	    	ProductoMenu elemento = iterador.next();
	    	int calorias = elemento.getCalorias();
	    	cals += calorias;
	    }
	    return cals;
	}

	@Override
	public String generarTextoFactura() 
	{
		String txtfac = "Precio:\n" + getPrecio() + "\nCalorías:\n" + getCalorias();
		return txtfac;
	}

}
