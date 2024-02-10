package services;

import entities.news;
import interfaces.Inews;
import utils.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class newsService implements Inews<news> {


    @Override
    public void addnews(news news) {
        String requete = "INSERT INTO news (title, source, content) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().getCon().prepareStatement(requete);
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getSource());
            preparedStatement.setString(3, news.getContent());
            preparedStatement.executeUpdate();
            System.out.println("News added!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updatenews(news news) {
        String requete = "UPDATE news\n" +
                         "SET column2 = ?, column3 = ?, column4 = ?\n" +
                         "WHERE id = ?;\n";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().getCon().prepareStatement(requete);
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getSource());
            preparedStatement.setString(3, news.getContent());
            preparedStatement.setInt(4, news.getId());
            preparedStatement.executeUpdate();
            System.out.println("News Updated!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deletenews(news news) {
        String requete = "DELETE FROM news WHERE id = ?";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().getCon().prepareStatement(requete);
            preparedStatement.setInt(1, news.getId());
            preparedStatement.executeUpdate(requete);
            System.out.println("Deleted!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<news> getAlldata() {
        List<news> list = new ArrayList<>();
        String requete = "SELECT * FROM news";
        try {
            Statement srt = MyConnection.getInstance().getCon().createStatement();
            ResultSet rs = srt.executeQuery(requete);
            while(rs.next()){
                news n = new news();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setSource(rs.getString("source"));
                n.setContent(rs.getString("content"));
                list.add(n);
            }
            System.out.println("Added!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
