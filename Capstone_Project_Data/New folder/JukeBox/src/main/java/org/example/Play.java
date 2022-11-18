package org.example;
import org.example.DAOImplClasses.*;
import org.example.Model.PlayLists;
import org.example.Model.Podcast;
import org.example.Model.Song;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class Play {
    Clip clip;
    AudioInputStream audioInputStream;
    String file_P;
    long currentFrame;
    String status;
    static int count1=0;
    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);
        System.out.println("Welcome...!!! \n1. Register \n2. Login \n3. Exit");
        int ans = scanObj.nextInt();
        if (ans == 2) {
            System.out.println("Please Enter Your UserId");
            long Uid = scanObj.nextLong();
            System.out.println("Please Enter Your Password");
            String passwrd = scanObj.next();
            long x = 0;
            String y = null;
            try {
                Connection connection = DBConnection.getConnection();
                String query = "select Uid,passwrd from User where Uid=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setLong(1, Uid);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    x = resultSet.getLong("Uid");
                    y = resultSet.getString("passwrd");
                }
                    if (x == Uid) {
                        if (y.equalsIgnoreCase(passwrd)) {
                            Swapnil:
                            System.out.println("What Do You Want to Listen (Songs/podcasts)");
                            String ch = scanObj.next();
                            if (ch.equalsIgnoreCase("Songs")) {
                                while (true) {
                                    System.out.println("1. Create New PlayList \n2. Access Existing Playlists \n3. Play Plalist \n4. Delete PlayList \n5. Search Song \n6. LogOut \n7. Sort");
                                    int choice = scanObj.nextInt();
                                    switch (choice) {
                                        case 1:
                                            PlayList_DetailsImpl playList_details = new PlayList_DetailsImpl() {
                                                @Override
                                                public void createPlayList(long Uid) {
                                                    super.createPlayList(Uid);
                                                }
                                            };
                                            playList_details.createPlayList(Uid);
                                            break;
                                        case 2:
                                            PlayListsImpl playLists = new PlayListsImpl() {
                                                @Override
                                                public List<PlayLists> displayAllPlayLists(String ch, long Uid) {
                                                    return super.displayAllPlayLists(ch, Uid);
                                                }
                                            };
                                            playLists.displayAllPlayLists(ch, Uid);
                                            break;
                                        case 3:
                                            PlayListsImpl playLists1 = new PlayListsImpl() {
                                                @Override
                                                public void playPlayList() {
                                                    super.playPlayList();
                                                }
                                            };
                                            playLists1.playPlayList();
                                            break;
                                        case 4:
                                            PlayListsImpl playLists2 = new PlayListsImpl() {
                                                @Override
                                                public void deletePlayList() {
                                                    super.deletePlayList();
                                                }
                                            };
                                            playLists2.deletePlayList();
                                            break;
                                        case 5:
                                            System.out.println("Enter Song name You want to Search");
                                            String sname = scanObj.next().trim();
                                            Songimpl songimpl = new Songimpl() {
                                                @Override
                                                public Song searchSong(String sname) {
                                                    return super.searchSong(sname.trim());
                                                }
                                            };
                                            songimpl.searchSong(sname.trim());
                                            String path = null;
                                            System.out.println("Do You want to Play This Song ? (Yes/No)");
                                            String a = scanObj.next().trim();
                                            if (a.equalsIgnoreCase("Yes")) {
                                                try {
                                                    String q = "select file_P from Song where sname=?";
                                                    PreparedStatement preparedStatement1 = connection.prepareStatement(q);
                                                    preparedStatement1.setString(1, sname.trim());
                                                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                                                    while (resultSet1.next()) {
                                                        path = resultSet1.getString("file_P");
                                                        Play play = new Play();
                                                        play.readAudio(path, 1);
                                                    }
                                                } catch (SQLException e) {
                                                    throw new RuntimeException(e);
                                                }
                                            }
                                            break;
                                        case 6:
                                            String[] k = {"abc"};
                                            main(k);
                                            break;
                                        case 7:
                                            Songimpl songimpl1=new Songimpl(){
                                                @Override
                                                public List<Song> sortSongs() {
                                                    return super.sortSongs();
                                                }
                                            };
                                            songimpl1.sortSongs();
                                            break;
                                        default:
                                            System.out.println("Invalid Choice Please Try Again...!!!");
                                    }
                                }

                            } else if (ch.equalsIgnoreCase("Podcasts")) {
                                while (true) {
                                    System.out.println("1. Create New PlayList \n2. Access Existing Playlists \n3. Play Plalist \n4. Delete PlayList \n5. Search podcast \n6. LogOut \n7. Sort");
                                    int choice1 = scanObj.nextInt();
                                    switch (choice1) {
                                        case 1:
                                            PlayList_DetailsImpl playList_details = new PlayList_DetailsImpl() {
                                                @Override
                                                public void createPlayList(long Uid) {
                                                    super.createPlayList(Uid);
                                                }
                                            };
                                            playList_details.createPlayList(Uid);
                                            break;
                                        case 2:
                                            PlayListsImpl playLists = new PlayListsImpl() {
                                                @Override
                                                public List<PlayLists> displayAllPlayLists(String ch, long Uid) {
                                                    return super.displayAllPlayLists(ch, Uid);
                                                }
                                            };
                                            playLists.displayAllPlayLists(ch, Uid);
                                            break;
                                        case 3:
                                            PlayListsImpl playLists1 = new PlayListsImpl() {
                                                @Override
                                                public void playPlayList() {
                                                    super.playPlayList();
                                                }
                                            };
                                            playLists1.playPlayList();
                                            break;
                                        case 4:
                                            PlayListsImpl playLists2 = new PlayListsImpl() {
                                                @Override
                                                public void deletePlayList() {
                                                    super.deletePlayList();
                                                }
                                            };
                                            playLists2.deletePlayList();
                                            break;
                                        case 5:
                                            System.out.println("Enter Podcast name to Search");
                                            String pname = scanObj.next();
                                            PodcastImpl podcast = new PodcastImpl() {
                                                @Override
                                                public Podcast searchPodcast(String pname) {
                                                    return super.searchPodcast(pname);
                                                }
                                            };
                                            podcast.searchPodcast(pname);
                                            String p=null;
                                            System.out.println("Do You Want to play This Song ? (Yes/No");
                                            String a=scanObj.next();
                                            if (a.equalsIgnoreCase("Yes")) {
                                                try {
                                                    String q = "select file_P from Podcast where pname=?";
                                                    PreparedStatement preparedStatement1 = connection.prepareStatement(q);
                                                    preparedStatement1.setString(1, pname.trim());
                                                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                                                    while (resultSet1.next()) {
                                                        p = resultSet1.getString("file_P");
                                                        Play play = new Play();
                                                        play.readAudio(p, 1);
                                                    }
                                                } catch (SQLException e) {
                                                    throw new RuntimeException(e);
                                                }
                                            }

                                            break;
                                        case 6:
                                            String[] k = {"abc"};
                                            main(k);
                                            break;
                                        case 7:
                                            PodcastImpl podcast1=new PodcastImpl(){
                                                @Override
                                                public List<Podcast> sortPodcasts() {
                                                    return super.sortPodcasts();
                                                }
                                            };
                                            podcast1.sortPodcasts();
                                            break;
                                        default:
                                            System.out.println("invalid Choice");
                                    }
                                }
                            }
                        } else {
                            System.out.println("Incorrect Password, Please Try Again...!!!");
                            String[] p = {"pqr"};
                            main(p);
                        }
                    } else {
                        System.out.println("Incorrect User Id, Please try Again");
                    }
            }catch(SQLException e){
                    throw new RuntimeException(e);
                }
            } else if (ans == 1) {
                UserImpl user = new UserImpl() {
                    @Override
                    public void userRegistration() {
                        super.userRegistration();
                    }
                };
                user.userRegistration();
            } else if (ans == 3) {
                System.exit(0);
            }
        }

    public Play(){

    }
    public void playAudio1(String file_P,int count) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        count1=count;
        this.file_P=file_P;
        audioInputStream= AudioSystem.getAudioInputStream(new File(file_P).getAbsoluteFile());
        clip=AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(count1);
    }
    public void playFile(){
        clip.start();
        status="play";
    }
    public void pause(){
        if (status.equals("paused")) {
            System.out.println("audio is already paused");
            return;
        }
        currentFrame = clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }
    public void resumeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (status.equals("play")) {
            System.out.println("Audio is already being played");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        playFile();
    }
    public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        playFile();
    }
    public void next() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        jump(10);
        }
        public void jump(long c) {
        if (c>0 && c<clip.getMicrosecondLength()){
            clip.stop();
            clip.close();
            currentFrame=c;
            clip.setMicrosecondPosition(c);
            this.playFile();
        }
        }
    public void stop() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }
    public void exit(){
        String[] p={};
        currentFrame = 0L;
        clip.stop();
        clip.close();
        main(p);
    }
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(file_P).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void readAudio(String audioSrcFile,int count) {
        Play playAudio = new Play();
        int choice = 0;
        count = count-1;
        try {

            playAudio.playAudio1(audioSrcFile,count);

            playAudio.playFile();
            Scanner scanner = new Scanner(System.in);
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");
                System.out.println("5. next");
                System.out.println("6. Exit");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                }
                switch (choice) {
                    case 1:
                        playAudio.pause();
                        break;
                    case 2:
                        playAudio.resumeAudio();
                        break;
                    case 3:
                        playAudio.restart();
                        break;
                    case 4:
                        playAudio.stop();
                        break;
                    case 5:
                        playAudio.next();
                        break;
                    case 6:
                        playAudio.exit();
                        break;
                    default:
                        System.out.println("Invalid Input...!!!");
                }
        } catch (Exception ex) {
            System.out.println("Error with playing sound." + ex);
        }
    }
}