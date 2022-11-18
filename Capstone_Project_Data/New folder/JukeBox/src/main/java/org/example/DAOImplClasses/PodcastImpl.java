package org.example.DAOImplClasses;

import org.example.DAOInterfaces.PodcastInterface;
import org.example.DBConnection;
import org.example.Model.Podcast;
import org.example.Model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PodcastImpl implements PodcastInterface {
    @Override
    public List<Podcast> displayAllPodcasts() {
        Connection connection= DBConnection.getConnection();
        List<Podcast> podcasts=new ArrayList<>();
        try {
            String query="select * from Podcast;";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int a=resultSet.getInt(1);
                String b=resultSet.getString(2);
                String c=resultSet.getString(3);
                String d=resultSet.getString(4);
                String e=resultSet.getString(5);
                Podcast pod=new Podcast(a,b,c,d,e);
                podcasts.add(pod);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return podcasts;
    }

    @Override
    public List<Podcast> sortPodcasts() {
        Connection connection=DBConnection.getConnection();
        List<Podcast>podcasts=new ArrayList<>();
        try {
            String query="select * from podcast;";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int a=resultSet.getInt(1);
                String b=resultSet.getString(2);
                String c=resultSet.getString(3);
                String d=resultSet.getString(4);
                String e=resultSet.getString(5);
                Podcast pod=new Podcast(a,b,c,d,e);
                podcasts.add(pod);
            }
            Collections.sort(podcasts,(p1,p2)->p1.getPname().compareTo(p2.getPname()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(podcasts);
        return podcasts;
    }

    @Override
    public Podcast searchPodcast(String pname) {
        Connection connection=DBConnection.getConnection();
        Podcast podcast=null;
        try {
            String query="select * from Podcast where pname=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,pname);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int a=resultSet.getInt(1);
                String b=resultSet.getString(2);
                String c=resultSet.getString(3);
                String d=resultSet.getString(4);
                String e=resultSet.getString(5);
                podcast= new Podcast(a,b,c,d,e);
                podcast.getPname();
                System.out.println(b);
                podcast.getPname();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return podcast;
    }
}
