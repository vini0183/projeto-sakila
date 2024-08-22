package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Film;

public class FilmDao {

    public List<Film> ler() {
        List<Film> lerFilmes = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("select * from film");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Film filmes = new Film();
                filmes.setFilm_id(rs.getInt("film_id"));
                filmes.setTitle(rs.getString("title"));
                filmes.setDescription(rs.getString("description"));
                filmes.setRelease_year(rs.getInt("release_year"));

                lerFilmes.add(filmes);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lerFilmes;
    }
    
    public void cadastrar(Film film) {

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement(
                    "INSERT INTO film (title,description,release_year) VALUES (?,?,?)"
            );

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getRelease_year());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Film selecionarFilme(int id) {
        Film filmeSelecionado = new Film();
        
        try {
            Connection connection = conexao.Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = connection.prepareStatement("SELECT * FROM film WHERE film_id = ?");
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                filmeSelecionado.setTitle(rs.getString("title"));
                filmeSelecionado.setDescription(rs.getString("description"));
                filmeSelecionado.setRelease_year(rs.getInt("release_year")); 
            }
            
            rs.close();
            stmt.close();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return filmeSelecionado;
    }
    
    public void deletar(int id) {

        try {

            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement(
                    "DELETE FROM film WHERE film_id = ?"
            );

            stmt.setInt(1, id);

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        public void atualizar(Film filmes) {

        try {

            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement(
                    "UPDATE film SET title = ? , description = ?, release_year = ? WHERE film_id = ?"
            );

            stmt.setString(1, filmes.getTitle());
            stmt.setString(2, filmes.getDescription());
            stmt.setInt(3, filmes.getRelease_year());
            stmt.setInt(4, filmes.getFilm_id());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    
}
