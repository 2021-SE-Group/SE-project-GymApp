package com.londonfitness.GUI;

import com.londonfitness.GUI.ourComponent.example.tableExample.BookingTableModel;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.RawLFClass;
import com.londonfitness.simDAO.table.Booking;
import com.londonfitness.simDAO.table.LFClass;
import com.londonfitness.simDAO.table.persons.Coach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class STALL extends JPanel{
    private Storage storage;
    private JTable Coach_Class;

    private JTextField tf_1;
    private JTextField tf_2;
    private JTextField tf_3;
    private JTextField tf_4;
    private JFrame frame;
    private JFrame frame_menu;
    private JFrame frame_suc;

    public JPanel getPanel_in(Storage storage){
        //Smooth
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }

        final JPanel panel_in = new JPanel();

        frame = new JFrame("COACH SERVICE");
        frame.setBounds(100, 100, 450, 400);
        frame.setLocationRelativeTo(null);//middle
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(false);

        frame_suc = new JFrame("DOWN");
        frame_suc.setBounds(100, 100, 230, 200);
        frame_suc.setLocationRelativeTo(null);//middle
        //frame_suc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_suc.getContentPane().setLayout(null);
        frame_suc.setVisible(false);

        frame_menu = new JFrame("COACH SERVICE");
        frame_menu.setBounds(100, 100, 450, 400);
        frame_menu.setLocationRelativeTo(null);//middle
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_menu.getContentPane().setLayout(null);
        frame_menu.setVisible(false);

        Font f_0 = new Font("Times New Roman",Font.BOLD,20);
        JLabel l_1 = new JLabel("Welcome to Trainer Service");
        l_1.setBounds(72, 35, 300, 21);
        l_1.setFont(f_0);
        panel_in.add(l_1);

        JLabel l_2 = new JLabel("Please enter your coach ID:");
        l_2.setBounds(52, 85, 300, 21);
        l_2.setFont(f_0);
        panel_in.add(l_2);

        tf_1 = new JTextField();
        tf_1.setBounds(302, 85, 40, 30);
        panel_in.add(tf_1);
        tf_1.setColumns(10);

        JButton b_1 = new JButton("LOG IN NOW!");
        b_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_menu.setContentPane(getPanel00(storage, tf_1.getText()));
                frame_menu.setVisible(true);
            }
        });
        b_1.setBounds(122, 205, 75, 29);
        panel_in.add(b_1);

        return panel_in;
    }
    //menu
    public JPanel getPanel00(Storage storage, String coach_ID){

        final JPanel panel00 = new JPanel();

        //panel00.setBounds(100, 100, 450, 400);
        panel00.setLayout(null);


        Font f_0 = new Font("Times New Roman",Font.BOLD,20);

        JLabel l_1 = new JLabel("Welcome to Trainer Service");
        l_1.setBounds(102, 35, 300, 21);
        l_1.setFont(f_0);
        panel00.add(l_1);
        //frame.getContentPane().add(l_1);

        /*
        JLabel l_2 = new JLabel("Sir." + name);
        l_2.setBounds(152, 57, 300, 21);
        l_2.setFont(f_0);
        panel00.add(l_2);
        //frame.getContentPane().add(l_2);
         */

        JButton b_1 = new JButton("Upload Video");
        b_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //ST001 a = new ST001(name);
                //panel00.remove(panel00);
                frame.setContentPane(getPanel01(storage.lfClasses, coach_ID));
                frame.setVisible(true);
            }
        });
        b_1.setBounds(152, 85, 123, 29);
        panel00.add(b_1);
        //frame.getContentPane().add(b_1);

        JButton b_2 = new JButton("My Class");
        b_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST002 a = new ST002(name);
                frame.setBounds(100, 100, 850, 400);
                frame.setLocationRelativeTo(null);//middle
                frame.setContentPane(getPanel02(storage, coach_ID));
                frame.setVisible(true);
            }
        });
        b_2.setBounds(152, 125, 123, 29);
        panel00.add(b_2);
        //frame.getContentPane().add(b_2);


        //maintaining  ---> change to 07
        JButton b_3 = new JButton("My profile");
        b_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST004 a = new ST004(name);
                frame.setContentPane(getPanel07(storage.coaches, coach_ID));
                //frame_suc.setContentPane(getPanel_maintain());
                frame.setVisible(true);
            }
        });
        b_3.setBounds(152, 165, 123, 29);
        panel00.add(b_3);
        //frame.getContentPane().add(b_3);

        JButton b_4 = new JButton("Drop Class Rate");
        b_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST005 a = new ST005(name);
                frame.setContentPane(getPanel05(storage.bookings, coach_ID));
                frame.setVisible(true);
                //frame_suc.setContentPane(getPanel_maintain());
                //frame_suc.setVisible(true);
            }
        });
        b_4.setBounds(152, 205, 123, 29);
        panel00.add(b_4);
        //frame.getContentPane().add(b_4);

        JButton b_5 = new JButton("Check Videos");
        b_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //System.exit(0);
                //mainFrame a = new mainFrame();
                frame.setBounds(100, 100, 850, 400);
                frame.setLocationRelativeTo(null);//middle
                frame.setContentPane(getPanel06(storage, coach_ID));
                frame.setVisible(true);
            }
        });
        b_5.setBounds(152, 245, 123, 29);
        panel00.add(b_5);
        //frame.getContentPane().add(b_5);

        //frame.setContentPane(panel00);

        //background picture
        /*
        JLabel bgp_1 = new JLabel();
        bgp_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\stevenyangitee-segroup-project-master\\segroup-project\\src\\main\\java\\com\\londonfitness\\GUI\\timg3.jpg"));
        bgp_1.setBounds(0,0,450,450);
        frame.getContentPane().add(bgp_1);
*/

        JButton b_6 = new JButton("Back");
        b_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_menu.setVisible(false);
            }
        });
        b_6.setBounds(350,300,65,29);
        panel00.add(b_6);

        return panel00;
    }
    //upload videos
    public JPanel getPanel01(ArrayList<LFClass> LFClass, String coach_ID){
/*
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setLocationRelativeTo(null);//middle
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
*/
        frame.setBounds(100, 100, 450, 400);
        frame.setLocationRelativeTo(null);//middle

        Font f_0 = new Font("Times New Roman",Font.BOLD,20);

        JPanel panel01 = new JPanel();
        panel01.setLayout(null);

        JLabel l_1 = new JLabel("Please Input Information of Your Video.");
        l_1.setBounds(52, 45, 380, 21);
        l_1.setFont(f_0);
        panel01.add(l_1);
        // frame.getContentPane().add(l_1);

        JLabel l_2 = new JLabel("URL:");
        l_2.setBounds(102, 75, 100, 21);
        panel01.add(l_2);

        tf_1 = new JTextField();
        tf_1.setBounds(102, 95, 240, 30);
        panel01.add(tf_1);
        //frame.getContentPane().add(tf_1);
        tf_1.setColumns(10);

        JLabel l_3 = new JLabel("Name:");
        l_3.setBounds(102, 125, 100, 21);
        panel01.add(l_3);

        tf_2 = new JTextField();
        tf_2.setBounds(102, 145, 240, 30);
        panel01.add(tf_2);
        tf_2.setColumns(10);

        JLabel l_4 = new JLabel("Category:");
        l_4.setBounds(102, 175, 100, 21);
        panel01.add(l_4);

        tf_3 = new JTextField();
        tf_3.setBounds(102, 195, 240, 30);
        panel01.add(tf_3);
        tf_3.setColumns(10);

        JLabel l_5 = new JLabel("Duration:");
        l_5.setBounds(102, 225, 100, 21);
        panel01.add(l_5);

        tf_4 = new JTextField();
        tf_4.setBounds(102, 245, 240, 30);
        panel01.add(tf_4);
        tf_4.setColumns(10);


        JButton b_1 = new JButton("ADD");
        b_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                /******************************************/
                /*
                File file = new File("C:\\Users\\ASUS\\Desktop\\stevenyangitee-segroup-project-master\\segroup-project\\src\\main\\java\\com\\londonfitness\\GUI\\" +"\\ST_Video.txt");
                FileWriter f=null;
                BufferedWriter f1=null;


                try {
                    f = new FileWriter("C:\\Users\\ASUS\\Desktop\\stevenyangitee-segroup-project-master\\segroup-project\\src\\main\\java\\com\\londonfitness\\GUI\\" +"\\ST_Video.txt", true);
                    f1=new BufferedWriter(f);
                    //String tempString = null;
                    //BufferedReader reader = null;
                    //while ((tempString = reader.readLine()) != null) {
                    //f1.newLine();
                    //}
                    f1.write(tf_1.getText()+"\n");
                } catch (Exception e2) {
                    // TODO: handle exception
                }finally {
                    try {
                        f1.close();
                        f.close();
                    } catch (Exception e3) {
                        // TODO: handle exception
                    }
                }
*/
                /******************************************/
                /*
                PrintWriter wf = null;

                try {
                    wf = new PrintWriter(file);
                    wf.println(tf_1.getText());
                    wf.close();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                */
                //System.out.println("ADD: " + tf_1.getText());
                //frame.dispose();
                //frame.setVisible(false);
                //ST001_sub01 a = new ST001_sub01(name);
                LFClass ad = new LFClass(new RawLFClass());
                //ad.c_video_URL = tf_1.getText();
                //ad.Date = new Date(System.currentTimeMillis());
                //need change, vision 1.0
                ad.raw.ID = String.valueOf(Integer.valueOf(LFClass.get(LFClass.size()-1).raw.ID) + 1);
                ad.raw.coach_ID = coach_ID;
                ad.raw.name = tf_2.getText();
                ad.raw.category_ID = tf_3.getText();
                ad.raw.duration = Long.valueOf(tf_4.getText());
                ad.raw.resource_URL = tf_1.getText();
                //ad.raw.price = "Unsettled";



                LFClass.add(ad);

                frame_suc.setContentPane(getPanel01_sub());
                frame_suc.setVisible(true);
                frame.setVisible(false);
            }
        });
        b_1.setBounds(122, 285, 75, 29);
        panel01.add(b_1);
        //frame.getContentPane().add(b_1);

        JButton b_2 = new JButton("BACK");
        b_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST000 b = new ST000(name);
                //frame.setContentPane(getPanel00(storage, coach_ID));
                frame.setVisible(false);
            }
        });
        b_2.setBounds(232, 285, 75, 29);
        panel01.add(b_2);
        //frame.getContentPane().add(b_2);
/*
        //background picture
        JLabel bgp_1 = new JLabel();
        bgp_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\stevenyangitee-segroup-project-master\\segroup-project\\src\\main\\java\\com\\londonfitness\\GUI\\timg3.jpg"));
        bgp_1.setBounds(0,0,450,450);
        frame.getContentPane().add(bgp_1);
 */
        return panel01;
    }
    //Class check
    public JPanel getPanel02(Storage storage, String coach_ID){
/*
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setLocationRelativeTo(null);//middle
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
*/
        Font f_0 = new Font("Times New Roman",Font.BOLD,20);

        JPanel panel02 = new JPanel();
        panel02.setLayout(null);

        JLabel l_1 = new JLabel("My Class");
        l_1.setBounds(377, 35, 300, 21);
        l_1.setFont(f_0);
        panel02.add(l_1);
        //frame.getContentPane().add(l_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(62, 71, 730, 204);
        panel02.add(scrollPane);
        //frame.getContentPane().add(scrollPane);




        int num = 0;
        int check_num = 0;
        for(int i = 0; i < storage.bookings.size(); i++){
            Booking v = storage.bookings.get(i);
            if(v.raw.coach_ID.equals(coach_ID)){
                check_num++;
            }
        }


        Object[][] BC = new Object[check_num][6];
        for(int i = 0; i < storage.bookings.size(); i++){
            Booking b = storage.bookings.get(i);
            if(b.raw.coach_ID.equals(coach_ID)){
                BC[num][0] = b.raw.ID;
                BC[num][1] = b.externKey_coach.raw.name;
                BC[num][2] = b.externKey_trainee.raw.name;
                BC[num][3] = b.externKey_lfClass.raw.name;
                BC[num][4] = b.raw.startDate;
                BC[num][5] = b.raw.times;
                num++;
            }
        }

/*
        Object[][] BC = new Object[storage.bookings.size()][6];
        //BookingTableModel[][] BC = new BookingTableModel[storage.bookings.size()][6];
        BookingTableModel a = new BookingTableModel(storage);
        for(int i = 0; i < storage.bookings.size(); i++){

                BC[i][0] = a.getValueAt(i,0);
                BC[i][1] = a.getValueAt(i,0);
                BC[i][2] = a.getValueAt(i,2);
                BC[i][3] = a.getValueAt(i,4);
                BC[i][4] = a.getValueAt(i,6);
                BC[i][5] = a.getValueAt(i,6);

        }
*/
/*
        Object[][] BC = new Object[storage.bookings.size()][6];
        for(int i = 0; i < storage.bookings.size(); i++){
            Booking b = storage.bookings.get(i);

                BC[i][0] = b.raw.ID;
                BC[i][1] = b.raw.coach_ID;
                BC[i][2] = b.raw.trainee_ID;
                BC[i][3] = b.raw.lfClass_ID;
                BC[i][4] = b.raw.startDate;
                BC[i][5] = b.raw.times;

        }
*/

        JTable tb_c = new JTable(
                BC,
                new String [] {
                "ID", "coach", "trainee", "lfClass", "startDate", "times"
                }
        );
        scrollPane.setViewportView(tb_c);
        //JTextArea textArea = new JTextArea();
        //textArea.setBackground(Color.LIGHT_GRAY);

        /****************************************/
        /*
        //get class information from files
        File file = new File("C:\\Users\\ASUS\\Desktop\\stevenyangitee-segroup-project-master\\segroup-project\\src\\main\\java\\com\\londonfitness\\GUI\\ST_CT.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            //once one line
            while ((tempString = reader.readLine()) != null) {
                //print
                textArea.append(line + "  " + tempString + "\n");
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

         */
/******************************************/
        //textArea.setText("14:00-16:00    Yoga    Mr.Wang"); //test line
        //textArea.setEnabled(false);
        //textArea.setDisabledTextColor(Color.BLACK);
        //scrollPane.setViewportView(textArea);

        JButton b_1 = new JButton("BACK");
        b_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST000 a = new ST000(name);
                frame.setBounds(100, 100, 450, 400);
                frame.setLocationRelativeTo(null);//middle
                frame.setVisible(false);
            }
        });
        b_1.setBounds(352, 290, 123, 29);
        panel02.add(b_1);
        //frame.getContentPane().add(b_1);

    /*
        //background picture
        JLabel bgp_1 = new JLabel();
        bgp_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\stevenyangitee-segroup-project-master\\segroup-project\\src\\main\\java\\com\\londonfitness\\GUI\\timg3.jpg"));
        bgp_1.setBounds(0,0,450,450);
        frame.getContentPane().add(bgp_1);

     */
        return panel02;
    }

    //maintaining ---> delete
    //Free time add
    public JPanel getPanel04(ArrayList<Coach> coaches, String coach_ID){
/*
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setLocationRelativeTo(null);//middle
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
*/
        Font f_0 = new Font("Times New Roman",Font.BOLD,20);

        JPanel panel04 = new JPanel();
        panel04.setLayout(null);

        JLabel l_1 = new JLabel("My Free Time");
        l_1.setBounds(162, 95, 300, 21);
        l_1.setFont(f_0);
        panel04.add(l_1);
        //frame.getContentPane().add(l_1);

        tf_2 = new JTextField();
        tf_2.setBounds(102, 135, 240, 30);
        panel04.add(tf_2);
        //frame.getContentPane().add(tf_1);
        tf_2.setColumns(10);



        JButton b_1 = new JButton("ADD");
        b_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                /*
                File file = new File("C:\\Users\\ASUS\\Desktop\\stevenyangitee-segroup-project-master\\segroup-project\\src\\main\\java\\com\\londonfitness\\GUI\\ST_FT.txt");
                FileWriter f=null;
                BufferedWriter f1=null;

                try {
                    f = new FileWriter("C:\\Users\\ASUS\\Desktop\\stevenyangitee-segroup-project-master\\segroup-project\\src\\main\\java\\com\\londonfitness\\GUI\\ST_FT.txt", true);
                    f1=new BufferedWriter(f);
                    f1.write(tf_1.getText()+"\n");
                } catch (Exception e2) {
                    // TODO: handle exception
                }finally {
                    try {
                        f1.close();
                        f.close();
                    } catch (Exception e3) {
                        // TODO: handle exception
                    }
                }
                */
                //frame.dispose();
                //frame.setVisible(false);
                //System.out.println("ADD: " + tf_1.getText());
                //ST004_sub01 a = new ST004_sub01(name);



                frame_suc.setContentPane(getPanel04_sub());
                frame_suc.setVisible(true);
                frame.setVisible(false);

            }
        });


        b_1.setBounds(122, 185, 75, 29);
        panel04.add(b_1);
        //frame.getContentPane().add(b_1);

        JButton b_2 = new JButton("BACK");
        b_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST000 b = new ST000(name);
                frame.setVisible(false);
            }
        });
        b_2.setBounds(232, 185, 75, 29);
        panel04.add(b_2);
        //frame.getContentPane().add(b_2);
/*
        //background picture
        JLabel bgp_1 = new JLabel();
        bgp_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\stevenyangitee-segroup-project-master\\segroup-project\\src\\main\\java\\com\\londonfitness\\GUI\\timg3.jpg"));
        bgp_1.setBounds(0,0,450,450);
        frame.getContentPane().add(bgp_1);
*/
        return panel04;
    }

    //maintaining --->complete
    //Drop Class rate
    public JPanel getPanel05(ArrayList<Booking> Bookings, String coach_ID){
/*
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setLocationRelativeTo(null);//middle
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
*/
        frame.setBounds(100, 100, 450, 400);
        frame.setLocationRelativeTo(null);//middle
        Font f_0 = new Font("Times New Roman",Font.BOLD,20);

        JPanel panel05 = new JPanel();
        panel05.setLayout(null);

        JLabel l_1 = new JLabel("My Drop Class Rate");
        l_1.setBounds(127, 95, 300, 21);
        l_1.setFont(f_0);
        panel05.add(l_1);
        //frame.getContentPane().add(l_1);

        /*
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(182, 131, 35, 35);
        frame.getContentPane().add(scrollPane);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setText("20");
        textArea.setEnabled(false);
        scrollPane.setViewportView(textArea);
        */
/*************************/
/*
        File file = new File("C:\\Users\\ASUS\\Desktop\\stevenyangitee-segroup-project-master\\segroup-project\\src\\main\\java\\com\\londonfitness\\GUI\\ST_DCR.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 0;
            for(int i = 0; i <= line; i++){
                tempString = reader.readLine();
                if(i == line){
                    JLabel l_3 = new JLabel(tempString);
                    l_3.setBounds(192, 131, 35, 35);
                    panel05.add(l_3);
                    //frame.getContentPane().add(l_3);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }


 */
        double drc_n = 0;
        double f = 0;
        double all = 0;

        for(int i = 0; i < Bookings.size(); i++){
            Booking mid = Bookings.get(i);
            if(mid.raw.coach_ID.equals(coach_ID)){
                all++;
                if(mid.raw.quit){
                    f++;
                }
            }

        }
        if(all != 0){
            drc_n = f/all;
        }else {
            drc_n = 0;
        }

        /************************/
        JLabel l_2 = new JLabel(String.format("%.2f", drc_n) + "%");
        l_2.setBounds(198, 131, 40, 35);
        panel05.add(l_2);
        //frame.getContentPane().add(l_2);

        JButton b_1 = new JButton("BACK");
        b_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST000 a = new ST000(name);
                frame.setVisible(false);
            }
        });
        b_1.setBounds(152, 185, 123, 29);
        panel05.add(b_1);
        //frame.getContentPane().add(b_1);
/*
        //background picture
        JLabel bgp_1 = new JLabel();
        bgp_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\stevenyangitee-segroup-project-master\\segroup-project\\src\\main\\java\\com\\londonfitness\\GUI\\timg3.jpg"));
        bgp_1.setBounds(0,0,450,450);
        frame.getContentPane().add(bgp_1);
        */
        return panel05;
    }
    //upload success
    public JPanel getPanel01_sub(){
        Font f_0 = new Font("Times New Roman",Font.BOLD,20);

        JPanel panel01_sub = new JPanel();
        panel01_sub.setLayout(null);

        JLabel l_1 = new JLabel("Upload Success");
        l_1.setBounds(50, 40, 300, 21);
        l_1.setFont(f_0);
        panel01_sub.add(l_1);
        //frame.getContentPane().add(l_1);

        JButton b_2 = new JButton("BACK");
        b_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST001 a = new ST001(name);
                frame_suc.setVisible(false);
            }
        });
        b_2.setBounds(70, 80, 75, 29);
        panel01_sub.add(b_2);
        //frame.getContentPane().add(b_2);

        return panel01_sub;
    }
    //upload success
    public JPanel getPanel04_sub(){
        Font f_0 = new Font("Times New Roman",Font.BOLD,20);

        JPanel panel04_sub = new JPanel();
        panel04_sub.setLayout(null);

        JLabel l_1 = new JLabel("Upload Success");
        l_1.setBounds(50, 40, 300, 21);
        l_1.setFont(f_0);
        panel04_sub.add(l_1);
        //frame.getContentPane().add(l_1);

        JButton b_2 = new JButton("BACK");
        b_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST004 a = new ST004(name);
                frame_suc.setVisible(false);
            }
        });
        b_2.setBounds(70, 80, 75, 29);
        panel04_sub.add(b_2);
        //frame.getContentPane().add(b_2);

        return panel04_sub;
    }

    //maintaining
    public JPanel getPanel_maintain(){
        Font f_0 = new Font("Times New Roman",Font.BOLD,13);

        JPanel panel_maintain = new JPanel();
        panel_maintain.setLayout(null);

        JLabel l_1 = new JLabel("This function is under maintaining");
        l_1.setBounds(18, 40, 300, 21);
        l_1.setFont(f_0);
        panel_maintain.add(l_1);
        //frame.getContentPane().add(l_1);

        JButton b_2 = new JButton("BACK");
        b_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST004 a = new ST004(name);
                frame_suc.setVisible(false);
            }
        });
        b_2.setBounds(70, 80, 75, 29);
        panel_maintain.add(b_2);
        //frame.getContentPane().add(b_2);

        return panel_maintain;
    }

    //My videos
    public JPanel getPanel06(Storage storage, String coach_ID){
/*
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setLocationRelativeTo(null);//middle
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
*/
        Font f_0 = new Font("Times New Roman",Font.BOLD,20);

        JPanel panel06 = new JPanel();
        panel06.setLayout(null);

        JLabel l_1 = new JLabel("My Videos");
        l_1.setBounds(377, 35, 300, 21);
        l_1.setFont(f_0);
        panel06.add(l_1);
        //frame.getContentPane().add(l_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(62, 71, 730, 204);
        panel06.add(scrollPane);
        //frame.getContentPane().add(scrollPane);


        int num = 0;
        int check_num = 0;
        for(int i = 0; i < storage.lfClasses.size(); i++){
            LFClass v = storage.lfClasses.get(i);
            if(v.raw.coach_ID==coach_ID){
                check_num++;
            }
        }
        Object[][] BC = new Object[check_num][6];

        for(int i = 0; i < storage.lfClasses.size(); i++){
            LFClass b = storage.lfClasses.get(i);
            if(b.raw.coach_ID==coach_ID){
                //BC[i][0] = b.c_video_URL;
                BC[num][0] = b.raw.ID;
                BC[num][1] = b.raw.name;
                BC[num][2] = b.raw.coach_ID;
                BC[num][3] = b.raw.category_ID;
                BC[num][4] = b.raw.duration;
                BC[num][5] = b.raw.resource_URL;
                //BC[num][5] = b.raw.price;
                num++;
            }

        }
        JTable tb_c = new JTable(
                BC,
                new String [] {
                        "ID", "Name", "Coach", "Category", "Duration", "URL"
                }
        );
        scrollPane.setViewportView(tb_c);
        //JTextArea textArea = new JTextArea();
        //textArea.setBackground(Color.LIGHT_GRAY);

        /****************************************/
        /*
        //get class information from files
        File file = new File("C:\\Users\\ASUS\\Desktop\\stevenyangitee-segroup-project-master\\segroup-project\\src\\main\\java\\com\\londonfitness\\GUI\\ST_CT.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            //once one line
            while ((tempString = reader.readLine()) != null) {
                //print
                textArea.append(line + "  " + tempString + "\n");
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

         */
/******************************************/
        //textArea.setText("14:00-16:00    Yoga    Mr.Wang"); //test line
        //textArea.setEnabled(false);
        //textArea.setDisabledTextColor(Color.BLACK);
        //scrollPane.setViewportView(textArea);

        JButton b_1 = new JButton("BACK");
        b_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST000 a = new ST000(name);
                frame.setBounds(100, 100, 450, 400);
                frame.setLocationRelativeTo(null);//middle
                frame.setVisible(false);
            }
        });
        b_1.setBounds(352, 290, 123, 29);
        panel06.add(b_1);
        //frame.getContentPane().add(b_1);

    /*
        //background picture
        JLabel bgp_1 = new JLabel();
        bgp_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\stevenyangitee-segroup-project-master\\segroup-project\\src\\main\\java\\com\\londonfitness\\GUI\\timg3.jpg"));
        bgp_1.setBounds(0,0,450,450);
        frame.getContentPane().add(bgp_1);

     */
        return panel06;
    }

    //check profile
    public JPanel getPanel07(ArrayList<Coach> coaches, String coach_ID){
        Font f_0 = new Font("Times New Roman",Font.BOLD,20);
        frame.setBounds(100, 100, 450, 400);
        frame.setLocationRelativeTo(null);//middle

        JPanel panel07 = new JPanel();
        panel07.setLayout(null);

        JLabel l_1 = new JLabel("My Profile");
        l_1.setBounds(162, 95, 300, 21);
        l_1.setFont(f_0);
        panel07.add(l_1);
        //frame.getContentPane().add(l_1);

        String a = new String();

        for(int i = 0; i < coaches.size(); i++){
            Coach mid = coaches.get(i);
            if(mid.raw.ID.equals(coach_ID)){
                a = mid.raw.c_profile_URL;
                break;
            }
        }


        JLabel l_2 = new JLabel(a);
        l_2.setBounds(128, 131, 150, 35);
        panel07.add(l_2);

        JButton b_1 = new JButton("BACK");
        b_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST000 a = new ST000(name);
                frame.setVisible(false);
            }
        });
        b_1.setBounds(152, 185, 123, 29);
        panel07.add(b_1);

        return panel07;
    }


}
