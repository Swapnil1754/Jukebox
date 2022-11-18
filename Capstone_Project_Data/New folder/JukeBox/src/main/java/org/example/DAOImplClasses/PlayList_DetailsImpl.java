package org.example.DAOImplClasses;

import org.example.DAOInterfaces.PlayListDetails_Interfa;
import org.example.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public  class PlayList_DetailsImpl implements PlayListDetails_Interfa {
    @Override
    public void createPlayList(long Uid) {
        Scanner scanObj = new Scanner(System.in);
        Connection connection = DBConnection.getConnection();
        System.out.println("Which Playlist You want to Create ? (Songs/Podcasts)");
        String x = scanObj.next();
        int c = 0;
        if (x.equalsIgnoreCase("Songs")) {
            String a = null;
            String b = null;
            System.out.println("Enter Name of Playlist You want to Create");
            String pname = scanObj.next();
            System.out.println("Please Enter Playlist Type/Genre");
            String type = scanObj.next();
            try {
                String query00 = "insert into PlayLists(playlist,pType,Uid) values(?,?,?);";
                PreparedStatement preparedStatement00 = connection.prepareStatement(query00);
                preparedStatement00.setString(1, pname);
                preparedStatement00.setString(2, type);
                preparedStatement00.setLong(3, Uid);
                int row0 = preparedStatement00.executeUpdate();
                System.out.println("Your List Created Successfully...!!!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            while (true) {
                System.out.println("1. add Song \n2. Exit");
                int choice = scanObj.nextInt();
                switch (choice) {
                    case 1:
                        try {
                            String query000 = "select * from Song";
                            PreparedStatement preparedStatement000 = connection.prepareStatement(query000);
                            ResultSet resultSet000 = preparedStatement000.executeQuery();
                            while (resultSet000.next()) {
                                System.out.println(resultSet000.getInt(1) + "\t" + resultSet000.getString(2));
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                        System.out.println("Enter Song id");
                        int songid = scanObj.nextInt();
                        try {
                            String query0 = "select sname,file_P from Song where songid=?";
                            PreparedStatement preparedStatement = connection.prepareStatement(query0);
                            preparedStatement.setInt(1, songid);
                            ResultSet resultSet = preparedStatement.executeQuery();
                            while (resultSet.next()) {
                                a = resultSet.getString("sname");
                                b = resultSet.getString("file_P");
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                        try {
                            String query00 = "select listNo from Playlists where Uid=?";
                            PreparedStatement preparedStatement00 = connection.prepareStatement(query00);
                            preparedStatement00.setLong(1, Uid);
                            ResultSet resultSet00 = preparedStatement00.executeQuery();
                            while (resultSet00.next()) {
                                c = resultSet00.getInt("listNo");
                            }
                            String query = "insert into PlaylistDetails(listNo,songid,sname,file_P) values(?,?,?,?);";
                            PreparedStatement preparedStatement1 = connection.prepareStatement(query);
                            preparedStatement1.setInt(1, c);
                            preparedStatement1.setInt(2, songid);
                            preparedStatement1.setString(3, a);
                            preparedStatement1.setString(4, b);
                            int row = preparedStatement1.executeUpdate();
                            System.out.println("Your Song Added Successfully...!!!");
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        //System.exit(0);
                        return;
                }
            }
        } else if (x.equalsIgnoreCase("Podcasts")) {
            String a = null;
            String b = null;
            System.out.println("Enter Name of Playlist You want to Create");
            String pname = scanObj.next();
            System.out.println("Please Enter Playlist Type/Genre");
            String type = scanObj.next();
            try {
                try {
                    String query00 = "insert into PlayLists(playlist,pType,Uid) values(?,?,?);";
                    PreparedStatement preparedStatement00 = connection.prepareStatement(query00);
                    preparedStatement00.setString(1, pname);
                    preparedStatement00.setString(2, type);
                    preparedStatement00.setLong(3, Uid);
                    int row0 = preparedStatement00.executeUpdate();
                    System.out.println("Your List Created Successfully...!!!");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                while (true) {
                    System.out.println("1. add Podcast \n2. Exit");
                    int choice = scanObj.nextInt();
                    switch (choice) {
                        case 1:
                            try {
                                String query0 = "select * from Podcast";
                                PreparedStatement preparedStatement = connection.prepareStatement(query0);
                                ResultSet resultSet = preparedStatement.executeQuery();
                                while (resultSet.next()) {
                                    System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2));
                                }
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("Enter Podcast id");
                            int pod_id = scanObj.nextInt();
                            try {
                                String query00 = "select pname,file_P from Podcast where pod_id=?";
                                PreparedStatement preparedStatement = connection.prepareStatement(query00);
                                preparedStatement.setInt(1, pod_id);
                                ResultSet resultSet = preparedStatement.executeQuery();
                                while (resultSet.next()) {
                                    a = resultSet.getString("pname");
                                    b = resultSet.getString("file_P");
                                }
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            try {
                                String query000 = "select listNo from Playlists where Uid=?";
                                PreparedStatement preparedStatement000 = connection.prepareStatement(query000);
                                preparedStatement000.setLong(1, Uid);
                                ResultSet resultSet000 = preparedStatement000.executeQuery();
                                while (resultSet000.next()) {
                                    c = resultSet000.getInt("listNo");
                                }
                                String query = "insert into PlaylistDetails(listNo,pod_id,pname,file_P) values(?,?,?,?);";
                                PreparedStatement preparedStatement1 = connection.prepareStatement(query);
                                preparedStatement1.setInt(1, c);
                                preparedStatement1.setInt(2, pod_id);
                                preparedStatement1.setString(3, a);
                                preparedStatement1.setString(4, b);
                                int row = preparedStatement1.executeUpdate();
                                System.out.println("Your Podcast Added Successfully...!!!");
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 2:
                            System.exit(0);
                        default:
                            System.out.println("Invalid Choice...!!!");
                    }
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Invalid Choice...!!!");
        }
    }
}
