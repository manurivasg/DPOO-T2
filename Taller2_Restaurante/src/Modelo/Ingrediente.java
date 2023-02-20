package Modelo;

public class Ingrediente {

	private String nombre;
	private int costoAdicional;
	int calorias;
	
	public Ingrediente( String pnombre, int pcostoAdicional, int pcalorias)
	{
		this.nombre = pnombre;
		this.costoAdicional = pcostoAdicional;
		this.calorias = pcalorias;
	}
	
	public String getNombre() 
	{
		return nombre;
	}

	public int getcostoAdicional() 
	{
		return costoAdicional;
	}

	public int getCalorias() 
	{
		return calorias;
	}


}
