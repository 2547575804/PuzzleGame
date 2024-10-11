package ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame {
    public static void main(String[] args) {
    // 登录界面
    JFrame loginJframe = new JFrame();
    loginJframe.setSize(488,430);
    loginJframe.setSize(488,430);
    //设置界面的标题
    loginJframe.setTitle("登录界面");
    // 设置界面置顶 ,false 会使活动窗口在上面，true就是一直在顶层。
    loginJframe.setAlwaysOnTop(true);
    // 设置 窗口居中显示
    loginJframe.setLocationRelativeTo(null);
    // 当关闭窗口的时候程序结束
    //this.setDefaultCloseOperation(3);
    loginJframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //设置布局方式
    loginJframe.setLayout(null);
    //创建按钮
    JButton jtb = new JButton("登录");
    //设置按钮的大小
    jtb.setBounds(0,0,200,100);
    //设置事件ActionListener单击鼠标左键或者是空格按下会触发
//        jtb.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("按钮被点击了");
//            }
//        });
    jtb.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    });
    loginJframe.getContentPane().add(jtb);
    loginJframe.setVisible(true);
    loginJframe.setVisible(true);
}
}


