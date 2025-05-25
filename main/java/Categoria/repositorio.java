package Categoria;

import Modelo.entidade.Categoria;
import Modelo.repositorio.implement.CrudRepositorioImplement;

public class repositorio extends CrudRepositorioImplement{

    private static void build() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public repositorio () {
        super(Categoria.class);
        
    }
    
    
    public static void main(String[] args) {
        Categoria.CategoriaBuilder categoria = Categoria.builder()
                .nome("Livro");
                .build();
        
        repositorio repositorio = new repositorio() {};
        
        repositorio.salvar(categoria);
    }
    
}
