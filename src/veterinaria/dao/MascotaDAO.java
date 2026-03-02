package com.veterinaria.dao;

import com.veterinaria.model.Mascota;
import com.veterinaria.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

    // INSERTAR
    public void insertar(Mascota mascota) {
        String sql = "INSERT INTO mascota (nombre, especie, raza, edad, propietario) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, mascota.getNombre());
            ps.setString(2, mascota.getEspecie());
            ps.setString(3, mascota.getRaza());
            ps.setInt(4, mascota.getEdad());
            ps.setString(5, mascota.getPropietario());

            ps.executeUpdate();
            System.out.println("Mascota registrada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar mascota.");
            e.printStackTrace();
        }
    }

    // CONSULTAR (LISTAR)
    public List<Mascota> listar() {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM mascota";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setId(rs.getInt("id"));
                mascota.setNombre(rs.getString("nombre"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setEdad(rs.getInt("edad"));
                mascota.setPropietario(rs.getString("propietario"));

                lista.add(mascota);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar mascotas.");
            e.printStackTrace();
        }

        return lista;
    }

    // ACTUALIZAR
    public void actualizar(Mascota mascota) {
        String sql = "UPDATE mascota SET nombre=?, especie=?, raza=?, edad=?, propietario=? WHERE id=?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, mascota.getNombre());
            ps.setString(2, mascota.getEspecie());
            ps.setString(3, mascota.getRaza());
            ps.setInt(4, mascota.getEdad());
            ps.setString(5, mascota.getPropietario());
            ps.setInt(6, mascota.getId());

            ps.executeUpdate();
            System.out.println("Mascota actualizada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al actualizar mascota.");
            e.printStackTrace();
        }
    }

    // ELIMINAR
    public void eliminar(int id) {
        String sql = "DELETE FROM mascota WHERE id=?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Mascota eliminada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar mascota.");
            e.printStackTrace();
        }
    }
}