package Modelo;

import java.util.ArrayList;

public class ProductoAjustado extends Producto {

	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	public ProductoAjustado(ProductoMenu pbase)
	{
		this.base = pbase;
		this.agregados = new ArrayList<>();
		this.eliminados = new ArrayList<>();
	}
	
	public void Agregar(Ingrediente item)
	{
		agregados.add(item);
	}
	public void Eliminar(Ingrediente item)
	{
		eliminados.add(item);
	}
	@Override
	public int getPrecio() {
		int precio = base.getPrecio();
		for (Ingrediente item : agregados)
				precio += item.getcostoAdicional();
		return precio;
	}

	@Override
	public String getNombre() {
		String nombre = base.getNombre();
		for (Ingrediente item : agregados)
				nombre = nombre + " con " + item.getNombre();
		for (Ingrediente item : eliminados)
				nombre = nombre + " sin " + item.getNombre();
		return nombre;
	}

	@Override
	public int getCalorias() {
		int calorias = base.getCalorias();
		for (Ingrediente item : agregados)
			calorias += item.getCalorias();
		for (Ingrediente item : eliminados)
			calorias -= item.getCalorias();
		return calorias;
	}

	@Override
	public String generarTextoFactura() {
		String txtfac = "Precio:\n" + getPrecio() + "\nCalorías:\n" + getCalorias();
		return txtfac;
	}

}
