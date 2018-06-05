package ES;
import java.awt.*;
import javax.swing.*;

public class Progress extends JFrame {

    JProgressBar progressBar;
    JTextArea l=new JTextArea();
    JScrollPane js =new JScrollPane(l);
    public  Progress(){
        JPanel panel2 = new JPanel();

        js.setPreferredSize(new Dimension(50,50));
        this.setSize(557, 300);
        this.setTitle("Evolution Progress");
        this.setLocationRelativeTo(null);

        panel2.setLayout(new BorderLayout());
        progressBar = new JProgressBar();
        progressBar.setValue(0);

        progressBar.setStringPainted(true);
        panel2.add(js,BorderLayout.CENTER);
        panel2.add(progressBar, BorderLayout.SOUTH);

        this.setContentPane(panel2);

        this.setVisible(true);



}

public void setValue(int i,Individual in[]){
    progressBar.setValue(i/10+1);
    if(i%10==0)
    l.setText(l.getText()+(i+1)+"'th Generation and the best Individual is:\n \n"+in[0].fitness+"\n\n");

}

}