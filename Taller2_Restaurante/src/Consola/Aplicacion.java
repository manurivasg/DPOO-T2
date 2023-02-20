package Consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import Modelo.Restaurante;
import Modelo.Producto;
import Modelo.Combo;
import Modelo.Ingrediente;
import Modelo.Pedido;
import Modelo.ProductoMenu;

public class Aplicacion 
{
	private static Restaurante restaurante;
	
	public void ejecutarAplicacion()
	{
		System.out.println("Bienvenidos al restaurante!\n");

		while (true);
		{
			try
			{
				mostrarApp();
				int opcion = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion == 1)
					{
					cargarArchivos();
					}
				
				else if (opcion == 2)
				{
					
					System.out.println("\nProductos: \n");
					mostrarMenu();
					System.out.println("\nCombos: \n");
					mostrarCombos();
				}
				
				else if (opcion == 3)
				{
					String nombreCliente = input("Ingrese el nombre del cliente");
					String direccionCliente = input("Ingrese la direccion del cliente");
					int ID = restaurante.iniciarPedido(nombreCliente, direccionCliente);
					System.out.println("ID del pedido en curso : " + Integer.toString(ID));
				}
				
				else if (opcion == 4)
				{
					
				}
					
				else if (opcion==5)
				{
					String ID = input("Ingrese el ID");
					Pedido pedidosolicitado = restaurante.getPedidoEnCurso().get(ID);
					ArrayList<Modelo.Producto> items = pedidosolicitado.getItems();
					for (Modelo.Producto elementos: items);
					{
						System.out.println(elementos.getNombre() + "\nPrecio: $ " + elementos.getPrecio());
					}
				}
				
				else if(opcion==6)
				{
					String ID = input("Ingrese el ID para facturación");
					Pedido pedidosolicitado = restaurante.getPedidoEnCurso().get(ID);
					ArrayList<Modelo.Producto> listaitems = pedidosolicitado.getItems();
					String factura = pedidosolicitado.generarTextoFactura();
					System.out.println("\n Factura: \n");
					for (Modelo.Producto elements: listaitems)
					{
						System.out.println("\nProducto: " + elements.getNombre() + "\n" + elements.generarTextoFactura());				
					}
					System.out.println(factura);
				}
				
				else
				{
					System.out.println("Adios :)");
					break;
				}
			}
	public void mostrarApp()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Cargar archivos");
		System.out.println("2. Mostrar Menu");
		System.out.println("3. Iniciar Pedido");
		System.out.println("4. Agregar producto");
		System.out.println("5. Consultar informacion de un pedido");
		System.out.println("6. Ir a facturación");
		System.out.println("7. Salir de la aplicación\n");
	}
	
	public void mostrarMenu()
	{
		int n = 0;
		for (ProductoMenu element : restaurante.getMenu())
		{
			System.out.println(Integer.toString(n) +". "+ element.getNombre() + " " + Integer.toString(element.getPrecio()));
			n += 1;
		}
	}
	public void mostrarCombos()
	{
		int n = 22;
		for (Combo element : restaurante.getCombos())
		{
			System.out.println(Integer.toString(n) +". "+ element.getNombre() + " " + Integer.toString(element.getPrecio()));
			n += 1;
		}
	}
	
	public void mostrarIngredientes()
	{
		int n = 0;
		for (Ingrediente element : restaurante.getIngredientes())
		{
			System.out.println(Integer.toString(n) +". "+ element.getNombre() + " " + Integer.toString(element.getcostoAdicional()));
			n += 1;
		}
	}
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;	
	}

	public void cargarArchivos()
	{
		try
		{
			Restaurante menu = new Restaurante();
			menu.cargarIngredientes();
			menu.cargarProductos();
			menu.cargarCombos();
			restaurante = menu;
			System.out.println("Carga realizada.");
		}
		
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}
	}
	
	public void iniciarPedido()
	{
		
	}
	
	public static void main(String[] args)
	{
		Aplicacion app = new Aplicacion();
		app.ejecutarAplicacion();
		
	}
	
}
