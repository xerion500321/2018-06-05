import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
    private JLabel jlb1 = new JLabel();
    private JLabel jlb2 = new JLabel();
    private ImageIcon img1 = new ImageIcon("千陽號.jpg");
    private ImageIcon img4 = new ImageIcon("火箭.jpg");
    private Timer t1;
    private Container cp;
    public MainFrame(){
     init();
}
    private void init(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(120,30,1000,800);
        this.setResizable(false);
        cp = getContentPane();
        cp.setLayout(null);
        cp.add(jlb1);
        cp.add(jlb2);
        Image img = img1.getImage();
        Image img2 = img.getScaledInstance(200,150,Image.SCALE_SMOOTH);
        img1.setImage(img2);

        jlb1.setIcon(img1);
        jlb1.setBounds(400,620,200,150);


        Image img3 = img4.getImage();
        Image img5 = img3.getScaledInstance(100,80,Image.SCALE_SMOOTH);
        img4.setImage(img5);
        jlb2.setIcon(img4);

        t1 = new Timer(20, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlb2.setLocation(jlb2.getX(),jlb2.getY()-5);
                if(jlb2.getY()<0){
                    t1.stop();
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                System.out.println(e.getKeyCode());
                switch(e.getKeyCode()){
                    case 37:
                        if(jlb1.getX()>0){
                            jlb1.setLocation(jlb1.getX()-5,jlb1.getY());
                            }
                        break;
                    case 39:
                        if(jlb1.getX()>=0 && jlb1.getX()<795){
                            jlb1.setLocation(jlb1.getX()+5,jlb1.getY());
                        }
                        break;
                    case 32:
                        jlb2.setBounds(jlb1.getX()+50,jlb1.getY()-80,120,100);
                        cp.add(jlb2);
                        t1.start();
                        break;
                }

            }
        });
}
}
