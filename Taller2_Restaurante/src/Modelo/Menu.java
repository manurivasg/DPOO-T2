package Modelo;

import java.util.Map;

public class Menu {

	private Map<String, ProductoMenu> Productos;
	private Map<String, Ingrediente> Ingredientes;
	
	public Menu(Map<String, ProductoMenu> pproductos, Map<String, Ingrediente> pingredientes)
	{
		this.Productos = pproductos;
		this.Ingredientes = pingredientes;
	}
	
	public Map<String, ProductoMenu> getmenupr()
	{
		return Productos;
	}

	public Map<String, Ingrediente> getmenuingr()
	{
		return Ingredientes;
	}

}
