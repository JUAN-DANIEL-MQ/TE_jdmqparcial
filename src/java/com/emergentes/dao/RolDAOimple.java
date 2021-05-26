package com.emergentes.dao;

import com.emergentes.modelo.Rol;
import com.emergentes.util.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RolDAOimple extends ConexionBD implements RolDAO {

    @Override
    public void insert(Rol rol) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO roles (descripcion) values (?)");
            ps.setString(1, rol.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Rol rol) throws Exception {
       try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE roles SET descripcion = ? where id = ?");
            ps.setString(1, rol.getDescripcion());
            ps.setInt(2, rol.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM roles WHERE id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Rol getById(int id) throws Exception {
        Rol rl = new Rol();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM roles WHERE id = ?");
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                rl.setId(rs.getInt("id"));
                rl.setDescripcion(rs.getString("descripcion"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return rl;
    }

    @Override
    public List<Rol> getAll() throws Exception {
        List<Rol> lista = null;
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM roles");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Rol>();
            while (rs.next()){
                Rol rele =  new Rol();
                
                rele.setId(rs.getInt("id"));
                rele.setDescripcion(rs.getString("descripcion"));
                
                lista.add(rele);
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
