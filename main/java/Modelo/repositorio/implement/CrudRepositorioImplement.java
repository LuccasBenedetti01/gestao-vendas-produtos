package Modelo.repositorio.implement;

import Modelo.conexao.ConexaoMySQL;
import Modelo.repositorio.CrudRepositorio;
import Modelo.util.SQLFormato;
import Modelo.util.SQLFormatoAtualizar;
import Modelo.util.SQLFormatoInserir;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.Set;
import org.reflections.ReflectionUtils;
        
public abstract class CrudRepositorioImplement<T> implements CrudRepositorio<T> {

    
    private Class<T> t;

    public CrudRepositorioImplement(Class<T> t) {
        this.t = t;
    }
    
   
    @Override
    public boolean salvar(T t) {
        Object id = null; 
        Set<Field> campos = ReflectionUtils.getFields(this.t, e -> true);
       
        try {
              for (Field campos : campos) {
            
            if (campo.getName().equalsIgnoreCase("id")){
                id = campos.get(t);
            }
        }
        
        if (id == null) {
              SQLFormato sql = new SQLFormatoInserir(this.t);
              return persistencia(sql.format(), t, false);
        }
        
        
        SQLFormato sql = new SQLFormatoAtualizar(this.t);
        return persistencia(sql.formato(), t, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private boolean persistencia(String sql, Object t, boolean atualizar) {
        try {
            PreparedStatement ps = ConexaoMySQL.obterConexao().prepareStatement(sql);
            
            preencherPrepareedStatement(t, ps, atualiza);
            
            int resultado = ps.executeUpdate();
            
            return resultado == 1; 
            
        } catch (Exception e) {
            throw new RuntimeException(e));
        }
    }
    
    private void preencherPrepareedStatement(Object t, PreparedStatement ps) {
        int contador = 1;
         Set<Field> campos = ReflectionUtils.getFields(this.t, e -> true);
       
        try {
              for (Field campos : campos) {
               campo.setAccesible(true);
               if (atualiza && campo.getName().equalsIgnoreCase("id")) {
               ps.setObject(campos.size(), campo.get(t));
               continue; 
           }   
                  
           ps.setObject(contador, campo.get(t));
           contador++;
          }
      } catch(Exception e){
          throw new RuntimeException(e);
      }
    }
}

 