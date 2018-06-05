package ES;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

/*********************
 * All Rights Reserved
 *
 *  POUYAN SHALBAFAN
 * *******************/

public class StartPanel extends JFrame {
    StartPanel temp;
    JPanel p6;
    RSyntaxTextArea textArea;
    public StartPanel(String title) {
        /**Frame Setting**/
        super(title);
        temp = this;
        this.setLocation(170, 30);
        this.setSize(980, 692);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /**labels deceleration**/
        JLabel l1 = new JLabel(" Fitness Function:");
        JLabel l2 = new JLabel(" Use Elitism: ");
        JLabel l3 = new JLabel(" permutation Probability :");
        JLabel l4 = new JLabel(" CrossOver Probability :");
        JLabel l5 = new JLabel("Options");
        JLabel l6 = new JLabel(" Start Population Size :");
        JLabel l7 = new JLabel(" Num Of Dimensions :");
        JLabel l8 = new JLabel(" Use Costum Setting :");
        l5.setHorizontalAlignment(JLabel.CENTER);

        /**Panels deceleration**/


        JPanel p = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();

        /**Text Fields deceleration**/

        textArea = new RSyntaxTextArea(20, 80);
        textArea.setText(FitnessesText.ackley);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane js = new RTextScrollPane(textArea);
        js.setPreferredSize(new Dimension(100, 100));
        JTextField t3 = new JTextField("1.0");
        JTextField t4 = new JTextField("0.2");
        JTextField t5 = new JTextField("100");
        JTextField t6 = new JTextField("2");
        t3.setHorizontalAlignment(JTextField.CENTER);
        t4.setHorizontalAlignment(JTextField.CENTER);
        t3.setEnabled(false);
        t4.setEnabled(false);
        t5.setHorizontalAlignment(JTextField.CENTER);
        t6.setHorizontalAlignment(JTextField.CENTER);
        JButton insertCode = new JButton("Load My Code");
        JButton chooseScript = new JButton("Choose Java File");

        JButton start = new JButton("Start");
        JButton exit = new JButton("Exit");
        JButton ok = new JButton("About This!!");
        String atrr[] = {"Yes", "No"};
        String atrr2[] = {"No", "Yes"};
        String fitnesses[] = {"Ackley Function", "Rastrigin's Function" ,"Griewangk's Function",
                "Schwefel's Sine Root Function", "Rosenbrock's Saddle Function","n-dimensional circle"};
        JComboBox useElitism = new JComboBox(atrr);
        JComboBox useCustomSetting = new JComboBox(atrr2);
        JComboBox fitnessesCombo = new JComboBox(fitnesses);
        ((JLabel)useCustomSetting.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel)useElitism.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel)fitnessesCombo.getRenderer()).setHorizontalAlignment(JLabel.CENTER);





        p2.add(chooseScript);

        p2.add(insertCode);


        p1.setLayout(new GridBagLayout());
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.fill = GridBagConstraints.HORIZONTAL;
        gBC.ipady = 160;
        gBC.ipadx=0;
        gBC.weightx = 0.0;
        gBC.insets = new Insets(10, 0, 0, 10);
        gBC.gridx = 0;
        gBC.gridy = 0;
        p1.add(l1, gBC);
        gBC.insets = new Insets(11, 120, 0, 100);

        p1.add(fitnessesCombo, gBC);
        gBC.insets = new Insets(10, 0, 0, 10);
        gBC.weightx = 0.5;
        //gBC.ipadx=100;

        gBC.gridwidth = 2;
        gBC.gridx = 1;
        gBC.gridy = 0;
        p1.add(js, gBC);
        gBC.gridwidth = 1;
        //gBC.weightx = 0.5;


        gBC.ipady = 0;
        gBC.ipadx = 0;


        gBC.insets = new Insets(0, 0, 0, 0);
        gBC.gridx = 2;
        gBC.gridy = 1;
        p1.add(p2, gBC);


        gBC.weightx = 0.0;
        gBC.gridwidth = 3;

        gBC.gridx = 0;
        gBC.gridy = 2;
        p1.add(new JSeparator(), gBC);

////////////////////////////////////////////////


        gBC.insets = new Insets(5, 0, 0, 0);

        gBC.gridx = 0;
        gBC.gridy = 3;
        p1.add(l5, gBC);

        gBC.ipadx = 10;
        gBC.weightx = 0.3;
        gBC.gridwidth = 3;

        gBC.gridx = 0;
        gBC.gridy = 4;
        p1.add(new JSeparator(), gBC);

        gBC.insets = new Insets(20, 0, 0, 5);
        gBC.gridwidth = 3;

        gBC.gridx = 0;
        gBC.gridy = 5;
        p1.add(p3, gBC);


p3.setLayout(new GridLayout(1,2,20,0));


p5.setLayout(new GridLayout(3,2,5,10));
        p5.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        p5.setBorder(BorderFactory.createLineBorder(Color.lightGray));



        p4.setLayout(new GridLayout(3,1,5,10));
 p4.add(useCustomSetting);
        p4.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        p4.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        p4.add(l8);

        p4.add(useCustomSetting);

        p4.add(l3);
        p4.add(t3);
        p4.add(l4);
        p4.add(t4);
        p5.add(l6);


        p5.add(t5);


        p5.add(l7);







        p5.add(t6);




        p5.add(l2);
        p5.add(useElitism);

p3.add(p5);
p3.add(p4);


        p6 = getNewPanel(Integer.parseInt(t6.getText()));


        gBC.insets = new Insets(20, 0, 0, 5);
        gBC.gridwidth = 3;

        gBC.gridx = 0;
        gBC.gridy = 6;
        p1.add(p6, gBC);


        ///////

        p.setLayout(new GridLayout(1, 3));
        p.add(start);
        p.add(exit);
        p.add(ok);
        this.add(p1, BorderLayout.NORTH);

        this.add(p, BorderLayout.SOUTH);






        /**Listeners Implementation**/
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        useCustomSetting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (useCustomSetting.getSelectedIndex()==1) {
                    t3.setEnabled(true);
                    t4.setEnabled(true);
                } else {
                    t3.setText("1.0");
                    t4.setText("0.2");
                    t3.setEnabled(false);
                    t4.setEnabled(false);
                }
            }
        });
        insertCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textArea.isEnabled()) {
                    chooseScript.setEnabled(false);
                    textArea.setEnabled(false);
                    insertCode.setEnabled(false);
                    fitnessesCombo.setEnabled(false);

                    new Thread() {
                        public void run() {
                            try {
                                compileOnDemand(textArea.getText());
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }

                        }

                    }.run();


                }


            }
        });
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"© 2017  ALL RIGHTS RESERVED BY POUYAN SHALBAFAN");
            }
        });
        chooseScript.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showDialog(temp, "Open");
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();

                    try {
                        compileOnDemand(selectedFile);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    chooseScript.setEnabled(false);
                    insertCode.setEnabled(false);
                    textArea.setEnabled(false);


                }
            }
        });
        fitnessesCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFitFunc(fitnessesCombo.getSelectedIndex());
            }
        });
        t6.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                p1.remove(p6);
                p6=(getNewPanel(Integer.parseInt(t6.getText())));
                p1.add(p6,gBC);

                    temp.revalidate();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {


            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkCode(chooseScript,insertCode)) {
                    new Thread(() -> {
                        JOptionPane.showMessageDialog(null,startEs(Integer.parseInt(t5.getText()),
                                getInterval(p6),elitismUsed(useElitism)
                                ,Double.parseDouble(t3.getText()), Double.parseDouble(t4.getText())));
                    }).start();




                }else
                {JOptionPane.showMessageDialog(null,"Please Load your code First");}
            }
        });



    }

    private void changeFitFunc(int indx) {
        switch (indx){
            case 0:
                textArea.setText(FitnessesText.ackley);
                break;
            case 1:
                textArea.setText(FitnessesText.rastrigin);

                JOptionPane.showMessageDialog(null,"constrains:  \n" +
                        "-5.12 <= x_i < 5.12\n" +
                        "minimum at x_i = 0\n" +
                        "fitness = 10.0 * Dimension");

                break;
            case 2:
                textArea.setText(FitnessesText.griewangk);
                JOptionPane.showMessageDialog(null,"constrains:  \n" +
                        "-500 < x_i < 500\n" +
                        "minimum at x_i = 0\n" +
                        "this function is very multimodal");


                break;
            case 3:
                textArea.setText(FitnessesText.schwefel);

                JOptionPane.showMessageDialog(null,"constrains:  \n" +
                        "-600.0 < x_i < 600.0\n" +
                        "minimum at x_i = 420.9687\n" );

                break;
            case 4:
                textArea.setText(FitnessesText.rosenbrock);

                JOptionPane.showMessageDialog(null,"constrains:  \n" +
                        "-2.048 < x_i < 2.048\n" +
                        "minimum at x_i = 1.0\n" );

                break;
            case 5:
                textArea.setText(FitnessesText.circle);

                JOptionPane.showMessageDialog(null,"constrains:  \n" +
                        "minimum at x_i = 0\n");

                break;




        }
    }

    private boolean elitismUsed(JComboBox useElitism) {
        return (useElitism.getSelectedIndex()==0);
    }

    private double [][] getInterval(JPanel p6) {
        JScrollPane sc = (JScrollPane)(p6.getComponent(0));
        JViewport viewport = sc.getViewport();
        JPanel jp = (JPanel)viewport.getComponent(0);
        double  temp [][]=new double[2][jp.getComponentCount()/4];
        for (int i = 1,k=0,j=0; i <jp.getComponentCount() ; i=i+2) {
            j=((i-1)/2)%2;


            JTextField tf=(JTextField)jp.getComponent(i);

            temp[j][k] =Double.parseDouble(tf.getText());
            if(j!=0)
        k++;}
        return temp;
    }

    private boolean checkCode(JButton chooseScript, JButton insertCode) {
        if (!chooseScript.isEnabled()||!insertCode.isEnabled())
            return true;
        return false;
    }

    public JPanel getNewPanel(int i) {

        JPanel p6 = new JPanel();


        JLabel[] dimen  =new JLabel[i];
        JTextField[] lower  =new JTextField[i];
        JTextField[] upper  =new JTextField[i];
        JLabel[] colon  =new JLabel[i];
        JButton apply=new JButton("Submit");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(i,4));
        final JScrollPane dimension = new JScrollPane(panel);
        dimension.setBorder( BorderFactory.createLineBorder(Color.lightGray));

        for (int j = 0; j <i ; j++) {
            dimen[j]=new JLabel("Dimension "+(j+1));
            panel.add(dimen[j]);
            lower[j]=new JTextField("-20");
            panel.add(lower[j]);
            colon[j]=new JLabel("            : ");
            panel.add(colon[j]);
            upper[j]=new JTextField("20");
            panel.add(upper[j]);

        }
       if (i<6){
        dimension.setPreferredSize(new Dimension(400,(2*i+1)*12));



        }
        else {
           dimension.setPreferredSize(new Dimension(400,130));
        }
        p6.add(dimension);
        return p6;
    }


    public static void compileOnDemand(String code) throws Exception {
        // create the source
        File sourceFile = new File("Eval.java");
        FileWriter writer = new FileWriter(sourceFile);
        writer.write(code);
        writer.close();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager =
                compiler.getStandardFileManager(null, null, null);

        fileManager.setLocation(StandardLocation.CLASS_OUTPUT,
                Arrays.asList(new File("../../out/production/ES_Project")));
        // Compile the file
        compiler.getTask(null,
                fileManager,
                null,
                null,
                null,
                fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile)))
                .call();
        fileManager.close();



    }

    public static void compileOnDemand(File  sourceFile) throws Exception{

        JavaCompiler compiler    = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager =
                compiler.getStandardFileManager(null, null, null);

        fileManager.setLocation(StandardLocation.CLASS_OUTPUT,
                Arrays.asList(new File("../../out/production/ES_Project")));
        // Compile the file
        compiler.getTask(null,
                fileManager,
                null,
                null,
                null,
                fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile)))
                .call();
        fileManager.close();
}
    private String startEs(int mu,double [][] intrval,boolean isElitism,double permutP,double xoverP) {
       // Individual [] population = new Individual[mu];
        ES es = new ES(mu,intrval,isElitism,permutP,xoverP);
        return es.start();

    }
}
