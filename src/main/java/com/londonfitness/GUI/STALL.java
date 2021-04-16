package com.londonfitness.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class STALL {

    private JTextField tf_1;
    private JTextField tf_2;
    private JFrame frame;
    private JFrame frame_suc;

    public JPanel getPanel00(){
        //Mellow
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


        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setLocationRelativeTo(null);//middle
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(false);

        frame_suc = new JFrame();
        frame_suc.setBounds(100, 100, 230, 200);
        frame_suc.setLocationRelativeTo(null);//middle
        frame_suc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_suc.getContentPane().setLayout(null);
        frame_suc.setVisible(false);

        final JPanel panel00 = new JPanel();

        //panel00.setBounds(100, 100, 450, 400);
        panel00.setLayout(null);


        Font f_0 = new Font("Times New Roman",Font.BOLD,20);

        JLabel l_1 = new JLabel("Welcome to Trainer Service");
        l_1.setBounds(72, 35, 300, 21);
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
                frame.setContentPane(getPanel01());
                frame.setVisible(true);
            }
        });
        b_1.setBounds(122, 85, 123, 29);
        panel00.add(b_1);
        //frame.getContentPane().add(b_1);

        JButton b_2 = new JButton("My Class");
        b_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST002 a = new ST002(name);
                frame.setContentPane(getPanel02());
                frame.setVisible(true);
            }
        });
        b_2.setBounds(122, 125, 123, 29);
        panel00.add(b_2);
        //frame.getContentPane().add(b_2);

        JButton b_3 = new JButton("My Free time");
        b_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST004 a = new ST004(name);
                frame.setContentPane(getPanel04());
                frame.setVisible(true);
            }
        });
        b_3.setBounds(122, 165, 123, 29);
        panel00.add(b_3);
        //frame.getContentPane().add(b_3);

        JButton b_4 = new JButton("Drop Class Rate");
        b_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //ST005 a = new ST005(name);
                frame.setContentPane(getPanel05());
                frame.setVisible(true);
            }
        });
        b_4.setBounds(122, 205, 123, 29);
        panel00.add(b_4);
        //frame.getContentPane().add(b_4);

        JButton b_5 = new JButton("Log out");
        b_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //frame.dispose();
                //frame.setVisible(false);
                //System.exit(0);
                //mainFrame a = new mainFrame();
            }
        });
        b_5.setBounds(122, 245, 123, 29);
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

        return panel00;
    }
    public JPanel getPanel01(){
        //Mellow
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
/*
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setLocationRelativeTo(null);//middle
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
*/
        Font f_0 = new Font("Times New Roman",Font.BOLD,20);

        JPanel panel01 = new JPanel();
        panel01.setLayout(null);

        JLabel l_1 = new JLabel("Please input URL of video.");
        l_1.setBounds(112, 95, 300, 21);
        l_1.setFont(f_0);
        panel01.add(l_1);
        // frame.getContentPane().add(l_1);


        tf_1 = new JTextField();
        tf_1.setBounds(102, 135, 240, 30);
        panel01.add(tf_1);
        //frame.getContentPane().add(tf_1);
        tf_1.setColumns(10);

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

                frame_suc.setContentPane(getPanel01_sub());
                frame_suc.setVisible(true);
                frame.setVisible(false);
            }
        });
        b_1.setBounds(122, 185, 75, 29);
        panel01.add(b_1);
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
    public JPanel getPanel02(){
        //Mellow
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
        l_1.setBounds(177, 35, 300, 21);
        l_1.setFont(f_0);
        panel02.add(l_1);
        //frame.getContentPane().add(l_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(62, 71, 330, 204);
        panel02.add(scrollPane);
        //frame.getContentPane().add(scrollPane);


        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.LIGHT_GRAY);

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
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);
        scrollPane.setViewportView(textArea);

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
        b_1.setBounds(152, 290, 123, 29);
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
    public JPanel getPanel04(){
        //Mellow
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
    public JPanel getPanel05(){
        //Mellow
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
/*
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setLocationRelativeTo(null);//middle
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
*/
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

        /************************/
        JLabel l_2 = new JLabel("%");
        l_2.setBounds(212, 131, 30, 35);
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


}
