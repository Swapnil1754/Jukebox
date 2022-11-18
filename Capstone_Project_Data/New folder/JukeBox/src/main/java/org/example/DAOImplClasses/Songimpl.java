package org.example.DAOImplClasses;

import org.example.DAOInterfaces.SongIntreface;
import org.example.DBConnection;
import org.example.Model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Songimpl implements SongIntreface {
    @Override
    public List<Song> displayAllSongs() {
        Connection connection= DBConnection.getConnection();
        List <Song> songs=new ArrayList<>();
        try {
            String query="select * from Song;";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int a=resultSet.getInt(1);
                String b=resultSet.getString(2);
                String c=resultSet.getString(3);
                String d=resultSet.getString(4);
                String e=resultSet.getString(5);
                String f=resultSet.getString(6);
                Song sobj=new Song(a,b,c,d,e,f);
                songs.add(sobj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }

    @Override
    public List<Song> sortSongs() {
        String b=null;
        Connection connection=DBConnection.getConnection();
        List<Song> songs=new ArrayList<>();
        try {
            String query="select * from Song;";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int a = resultSet.getInt(1);
                 b = resultSet.getString(2);
                String c = resultSet.getString(3);
                String d = resultSet.getString(4);
                String e = resultSet.getString(5);
                String f = resultSet.getString(6);
                Song song = new Song(a, b, c, d, e, f);
                songs.add(song);
            }
            Collections.sort(songs,(p1,p2)->p1.getSname().compareTo(p2.getSname()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(songs);
        return songs;
    }

    @Override
    public Song searchSong(String sname) {
        Connection connection=DBConnection.getConnection();
        Song song=null;String b=null;
        try {
            String query="select * from Song where sname=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,sname.trim());
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int a=resultSet.getInt(1);
                 b = resultSet.getString(2);
                String c=resultSet.getString(3);
                String d=resultSet.getString(4);
                String e=resultSet.getString(5);
                String f=resultSet.getString(6);
                song= new Song(a,b,c,d,e,f);
            }
            System.out.println(b);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            System.out.println("Error.........");
        }
        return song;
    }
}
