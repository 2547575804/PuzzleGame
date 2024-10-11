//项目，参考网址①:https://blog.csdn.net/SENMINGya/article/details/136443123?spm=1001.2014.3001.5506
//实现监听，参考网址②:https://blog.csdn.net/Colinnian/article/details/136142510
package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    //JFrame 界面，窗体
    //子类也表示界面，窗体
    //规定：GameJFrame这个界面表示的就是游戏的主界面
    //以后跟游戏相关的所有逻辑都写在这个类中

    //创建一个二维数组
    //目的：加载图片
    int[][] data = new int[4][4];
    int x = 0;
    int y = 0;

    public GameJFrame() {
        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //初始化数据(打乱)
        initData();
        //初始化图片(根据打乱之后的数据结果加载图片)
        initImage();
        //让界面显示出来，最后写m
        this.setVisible(true);
    }


    //---------------------------------- ---------------------
    private void initData() {
        //1.定义一个一维数组
        int[] temArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //2.打乱数组中的顺序
        //遍历数组，得到每一个元素，拿着每一个元素跟随机索引上的数据进行交换
        Random r = new Random();
        for (int i = 0; i < temArr.length; i++) {
            //获取到随机索引
            int index = r.nextInt(temArr.length);
            //拿着每一个元素跟随机索引上的数据进行交换
            int temp = temArr[i];
            temArr[i] = temArr[index];
            temArr[index] = temp;
        }
        //3.打印看结果
        for (int k : temArr) {
            System.out.print(k + "  ");
        }
        System.out.println();
        //4. 创建二维数组
        int[][] data = new int[4][4];
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                data[i][j] = temArr[index];
                index++;
            }
        }
        //遍历二维数组
        for (int[] datum : data) {
            for (int j = 0; j < data.length; j++) {
                System.out.print(datum[j] + "   ");
            }
            System.out.println();
        }
    }


    //初始化图片
    private void initImage() {
        this.getContentPane().removeAll();

        //外循环  --把内循环重复执行了4次
        for (int i = 0; i < 4; i++) {
            //内循环  --表示在一行添加4张图片
            for (int j = 0; j < 4; j++) {
                //获取当前要加载图片的序号
                int num = data[i][j];
                //创建一个JLabel的对象(管理容器)
                JLabel JLabel = new JLabel(new ImageIcon("C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\PuzzleGame\\a1\\a" + num + ".jpg"));
                //指定图片的位置
                JLabel.setBounds(105 * i + 83, 105 * j + 134, 105, 105);
                //给图片添加边框
                JLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器添加到界面中
                this.getContentPane().add(JLabel);
            }
        }
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\PuzzleGame\\bg.jpg"));
        background.setBounds(40, 40, 508, 560);
        //把背景图片添加到界面当中
        this.getContentPane().add(background);
    }


    private void initJMenuBar() {
        //初始化菜单
        //创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单上面的两个选项的对象  （功能  关于我们）
        JMenu fuctionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        //创建选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reloginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");
        //将每一个选项下的条目添加到对应的选项中
        fuctionJMenu.add(replayItem);
        fuctionJMenu.add(reloginItem);
        fuctionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);
        //将菜单里面的两个选项添加到菜单中
        jMenuBar.add(fuctionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置界面的宽高
        this.setSize(603, 680);//单位是像素

        //设置界面的标题
        this.setTitle("拼图 v1.0");

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认的居中位置，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);

        //添加事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //对上下左右进行判断
        // 左：37，上：38，右：39，下：40
        int code = e.getKeyCode();
        //System.out.println(code);
        if (code == 37) {
            //System.out.println("左");
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            //加载图片
            initImage();
        } else if (code == 38) {
            // x,y 表示空白方块，x-1,y 表示下方数字
            //System.out.println("右");
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            //加载图片
            initImage();
        } else if (code == 39) {
            //System.out.println("上");
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            //加载图片
            initImage();
        } else if (code == 40) {
            //System.out.println("下");
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            //加载图片
            initImage();
        }
}
}
