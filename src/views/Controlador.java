package views;

import data.Persistencia;
import domain.*;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import javax.swing.JOptionPane;

public class Controlador {
    public static Agregaranimales agregaranimales;
    public static Menuanimales menuanimales;
    
    public static void guardarAnimal(Mamifero mamifero){
        Persistencia.agregarAnimal(mamifero);
    }
    
     public static void salir(Menuanimales vista){
        vista.dispose();
    }
    
    public static void volver (Agregaranimales vista){
        vista.dispose();
        new Menuanimales().setVisible(true);
        
    }
    
    public static void volveer (ListarAnimalesView vista){
        vista.dispose();
        new Menuanimales().setVisible(true);
        
    }
    
    public static void vistaagregar (Menuanimales vista){
        vista.dispose();
        new Agregaranimales().setVisible(true);
    }
    
    public static void vistalista (Menuanimales vista){
        vista.dispose();
        new ListarAnimalesView().setVisible(true);
    }
    
    public static ArrayList<Pais> getPaises(){
        return Persistencia.getPaises();
    }
  
    public static TipoAlimentacion[] getTiposAlimentacion(){
        return  TipoAlimentacion.values();
    }
    public static ArrayList<Especie> getEspecies(){
        return Persistencia.getEspecies();
    }
    public static ArrayList<Sector> getSectores(){
        return Persistencia.getSectores();
    }
    
    public static ArrayList<AnimalViewModel> getAnimales(){
        ArrayList<AnimalViewModel> animales = new ArrayList<>();
        for(Mamifero animal : Persistencia.getAnimales()){
            animales.add(new AnimalViewModel(animal));
        }
        return animales;
    }
    
    
   public static void agregarAnimal (Mamifero mamifero){
       Persistencia.agregarAnimal(mamifero);
   }
    
  /*  public static void cargarTabla(ListarAnimalesView vista) {
        //reconfigura el modelo que se aplica en la JTabla
        vista.getModelo().setColumnCount(0);
        vista.getModelo().setNumRows(0);
        vista.getModelo().addColumn("Fabricante");
        vista.getModelo().addColumn("Codigo");
        vista.getModelo().addColumn("Descripcion");
        vista.getModelo().addColumn("Cantidad");
        vista.getModelo().addColumn("Precio");
        // alimenta al modelo filas con los datos de las personas
        for (Producto producto : lista.getLista()) {
            Object[] fila = new Object[5];
            fila[0] = producto.getTipo();
            fila[1] = producto.getCodigo();
            fila[2] = producto.getDescripcion();
            fila[3] = producto.getCantidad();
            fila[4] = producto.getPrecio();
            vista.getModelo().addRow(fila);
        }
        vista.getTabla().setModel(vista.getModelo());
        // 40 pixel de ancho a la columna 0
        //vista.getTabla().getColumnModel().getColumn(0).setPreferredWidth(40);
        //vista.getTabla().getColumnModel().getColumn(1).setPreferredWidth(10);
    }*/
  
    
    public static ComidaViewModel  calcularComida(){
        double totalCarnivoros = Persistencia.getTotalComida(TipoAlimentacion.CARNIVORO);
        double totalHerbivoros = Persistencia.getTotalComida(TipoAlimentacion.HERBIVORO);
        return new ComidaViewModel(totalCarnivoros, totalHerbivoros);
    }
    
    
   /*public void actualizar(ListarAnimalesView vista) {
        listarAnimales(vista);
      
    }*/
    
    
}
