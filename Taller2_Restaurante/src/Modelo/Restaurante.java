package Modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Restaurante 
{
	private ArrayList<ProductoMenu> menu;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Combo> combos;
	private Map<String, Pedido> pedidoEnCurso;
	private ArrayList<Pedido> pedidos;
	private Map<String,ProductoMenu> mapa;
	
	public Restaurante()
	{
		this.pedidoEnCurso = new HashMap<>();
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public int iniciarPedido(String nombreCliente, String direccionCliente)
	{
		Pedido nuevopedido = new Pedido(nombreCliente, direccionCliente);
		int ID = nuevopedido.getidPedido();
		pedidoEnCurso.put(Integer.toString(ID), nuevopedido);
		pedidos.add(nuevopedido);
		return ID;
	}
	
	public void cargarProductos() throws FileNotFoundException, IOException
	{
		ArrayList<ProductoMenu> productos = new ArrayList<>();
		Map<String,ProductoMenu> mpprod = new HashMap<>();

		BufferedReader br = new BufferedReader(new FileReader(".\\data/menu.txt"));
									
		String linea = br.readLine();
		while (linea != null) 
		{
			String[] partes = linea.split(";");
			String nombreProducto = partes[0];
			int precio = Integer.parseInt(partes[1]);
			int calorias = Integer.parseInt(partes[2]);
			ProductoMenu producto = new ProductoMenu(nombreProducto, precio, calorias);
			mpprod.put(nombreProducto, producto);
			productos.add(producto);
			linea = br.readLine(); 
		}
		br.close();
		menu = productos;
		mapa = mpprod;
	}
	
	public ArrayList<ProductoMenu> getMenu()
	{
		return menu;
	}
	
	public void cargarCombos() throws FileNotFoundException, IOException
	{
		ArrayList<Combo> combos = new ArrayList<>();

		BufferedReader br = new BufferedReader(new FileReader(".\\data/combos.txt"));
									
		String linea = br.readLine();
		while (linea != null) 
		{
			String[] partes = linea.split(";");
			String nombreCombo = partes[0];
			String precio1 = (partes[1]);
			String precio2 = precio1.replace("%", "");
			double descuento = Double.parseDouble(precio2);
			
			ArrayList<ProductoMenu> productosCombo = new ArrayList<>();
			productosCombo.add(mapa.get(partes[2]));
			productosCombo.add(mapa.get(partes[3]));
			productosCombo.add(mapa.get(partes[4]));

			Combo nCombo = new Combo(nombreCombo, descuento, productosCombo);
			combos.add(nCombo);
			
			linea = br.readLine(); 
		}
		br.close();
		this.combos = combos;
	}

	public ArrayList<Combo> getCombos()
	{
		return combos;
	}
	
	public void cargarIngredientes() throws FileNotFoundException, IOException
	{
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();

		BufferedReader br = new BufferedReader(new FileReader(".\\data/ingredientes.txt"));
										
		String linea = br.readLine();
		while (linea != null) 
		{
			String[] partes = linea.split(";");
			String nombreIngrediente = partes[0];
			int precio = Integer.parseInt(partes[1]);
			int calorias = Integer.parseInt(partes[2]);
			Ingrediente elingrediente = new Ingrediente(nombreIngrediente, precio, calorias);
			ingredientes.add(elingrediente);

			linea = br.readLine();
		}

		br.close();
		this.ingredientes = ingredientes;
	}
	
	public ArrayList<Ingrediente> getIngredientes()
	{
		return ingredientes;
	}
	
	public Map<String, Pedido> getPedidoEnCurso()
	{
		return pedidoEnCurso;
	}
}
