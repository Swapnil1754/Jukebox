package org.example.DAOImplClasses;

import org.example.DAOInterfaces.PlayListsInterface;
import org.example.DBConnection;
import org.example.Model.PlayList_Details;
import org.example.Model.PlayLists;
import org.example.Play;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayListsImpl implements PlayListsInterface {
    @Override
    public List<PlayLists> displayAllPlayLists(String ch,long Uid) {
        Scanner scanObj=new Scanner(System.in);
        Connection connection= DBConnection.getConnection();
        List<PlayLists>playLists=new ArrayList<>();
        List<PlayList_Details>playList_details=new ArrayList<>();
        try {
            int a = 0;
            String query = "select * from PlayLists where Uid=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,Uid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                a = resultSet.getInt(1);
                String b = resultSet.getString(2);
                String c = resultSet.getString(3);
                long d = resultSet.getLong(4);
                PlayLists playlist = new PlayLists(a, b, c, d);
                playLists.add(playlist);
                System.out.println(resultSet.getInt("listNo") + "\t" + resultSet.getString("playlist") + "\t" + resultSet.getString("pType"));
                System.out.println("------------------------------------------------------------------------------------");
            }
            System.out.println("\n");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }try {
            System.out.println("Enter List Number You want to view");
            int list=scanObj.nextInt();
        String query1="select * from PlaylistDetails where listNo=?";
            PreparedStatement preparedStatement1=connection.prepareStatement(query1);
            preparedStatement1.setInt(1,list);
            ResultSet resultSet1=preparedStatement1.executeQuery();
            System.out.println("List No :"+list+"\n");
            System.out.printf("%1s %8s","Song id","Song Name\n");
            while (resultSet1.next()) {
                int p = resultSet1.getInt(1);
                int q = resultSet1.getInt(2);
                int r = resultSet1.getInt(3);
                String s = resultSet1.getString(4);
                int t = resultSet1.getInt(5);
                String u = resultSet1.getString(6);
                String v = resultSet1.getString(7);
                PlayList_Details pd = new PlayList_Details(p, q, r, s, t, u, v);
                playList_details.add(pd);
                if (ch.equalsIgnoreCase("Songs")) {
                    System.out.println(resultSet1.getInt("songid") + "\t" + resultSet1.getString("sname"));
                } else if (ch.equalsIgnoreCase("Podcasts")) {
                    System.out.println(resultSet1.getInt("pod_id") + "\t" + resultSet1.getString("pname"));
                }
                System.out.println("------------------------------------------------------------------------------------");
            }
            System.out.println("\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return playLists;
    }

    @Override
    public void playPlayList() {
        Scanner scanObj = new Scanner(System.in);
        Connection connection = DBConnection.getConnection();
        Play play = new Play();
        int x = 0;
        String b = null;
        try {
            System.out.println("Enter list no you want to play");
             int list = scanObj.nextInt();
            String query0 = "select listNo from Playlists where listno=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query0);
            preparedStatement.setInt(1, list);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                x = resultSet.getInt("listNo");
            }

                String query1 = "select file_P from PlaylistDetails where listNo=?";
                PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
                preparedStatement1.setInt(1, x);
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                while (resultSet1.next()) {
                    b = resultSet1.getString("file_P");
                    play.readAudio(b, 1);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deletePlayList(){
        Scanner scanObj=new Scanner(System.in);
        Connection connection=DBConnection.getConnection();
        try {
            System.out.println("Enter List Number You want to Delete");
            int listNo=scanObj.nextInt();
            String query="delete from PlayLists where listNo="+listNo+";";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            int row=preparedStatement.executeUpdate();
            System.out.println("List Deleted Successfully...!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
