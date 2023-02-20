package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Pedido {
	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> items;
	
	public Pedido (String nombre, String direccion)
	{
		Random rand = new Random(); //instance of random class
	    int upperbound = 10000000;
	    int int_random = rand.nextInt(upperbound);
		this.nombreCliente = nombre;
		this.direccionCliente = direccion;
		numeroPedidos += 1;
		idPedido += int_random;
		this.items = new ArrayList<Producto>();
	}
	public int getidPedido()
	{
		return idPedido;
	}
	
	public int getnumPedidos() 
	{
		return numeroPedidos;
	}
	
	public ArrayList<Producto> getItems()
	{
		return items;
	}
	
	public void agregarProducto(Producto nuevoitem)
	{
		items.add(nuevoitem);
	}
	
	public int getPrecioNetoPedido()
	{
		int total = 0;
		for (Producto prdt : items)
			total += prdt.getPrecio();
		return total;
	}
	
	public int getCaloriasPedido()
	{
		int cals = 0;
		for (Producto prdt : items)
			cals += prdt.getCalorias();
		return cals;
	}
	
	public String generarTextoFactura()
	{
		String answ = "\n Precio neto:\n"+getPrecioNetoPedido()+"\n";
		answ += "\n Calorías totales:\n"+getCaloriasPedido()+"\n";
		answ += "\nDatos del cliente:\nNombre: "+nombreCliente+"\nDirección: "+direccionCliente;
		
		return answ;
	}
	
}
