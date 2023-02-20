package Modelo;

public class ProductoMenu extends Producto {


	private String nombre;
	private int precioBase;
	private int calorias;
	
	public ProductoMenu(String pnombre, int pprecioBase, int pcalorias)
	{
		this.nombre = pnombre;
		this.precioBase = pprecioBase;
		this.calorias = pcalorias;
	}
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return precioBase;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public int getCalorias() {
		// TODO Auto-generated method stub
		return calorias;
	}

	@Override
	public String generarTextoFactura() {
		String txtfact = "Precio:\n" + getPrecio() + "\nCalorías:\n" + getCalorias();
		return txtfact;
	}

}
