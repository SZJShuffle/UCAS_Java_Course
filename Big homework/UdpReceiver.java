package Receiver;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class UdpRecv implements Runnable
{
    private DatagramSocket ds;
    private GUI gui;
    UdpRecv(DatagramSocket ds,GUI g)
    {
        //传入套接字对象
        this.ds = ds;
        //传入GUI对象
        gui = g;
    }
    public void run()
    {   
        //基于Udp协议接收消息
        try
        {
            while(true)
            {
                byte[] recvdata = new byte[1024]; 
                DatagramPacket dp = new DatagramPacket(recvdata,recvdata.length);
                 
                ds.receive(dp);
                String ip = dp.getAddress().getHostAddress();
                String data = new String(dp.getData(),0,dp.getLength());
                int port = dp.getPort();
                //System.out.println("发送方的ip地址是："+ip);
                //System.out.println("发送方的消息是："+data);
                //System.out.println("发送方的端口是"+port);
                gui.taShow.append("Your friend(from IP:"+ip+" Port:"+port+")");
                gui.taShow.append("\r\n");
                gui.taShow.append("message:"+data);
                gui.taShow.append("\r\n");
                gui.taShow.append("\r\n");
            }
        }catch(Exception e)
        {
            throw new RuntimeException("running error");
        }
        
    }
}

class GUI
{
    private Frame f;
    public TextArea taShow,taInput;
    private Label lbShow,lbInput;
    private Button but;    
    private DatagramSocket dgs;
    GUI(DatagramSocket ds){
        dgs = ds;      
        init();     
    }
    
    //初始化gui组件
    public void init(){
        f = new Frame("A Toy Chatter");
        but = new Button("Send");
        taShow = new TextArea(10,35);
        taInput = new TextArea(5,35);
        lbShow = new Label("Message");
        lbInput = new Label("Input box");
        f.setLayout(new FlowLayout());
        f.setSize(500,350);
        f.setLocation(300,200);
        
        //taShow.setBounds(,10,20,20);
        //taInput.setBounds(30,30,20,20);
        f.add(lbShow); 
        f.add(taShow);
        f.add(lbInput); 
        f.add(taInput);
        f.add(but);
        
        myEvent();
        f.setVisible(true);
        
    }
    
    //为组件添加事件
    public void myEvent()
    {
        //鼠标点击frame关闭按钮关闭窗体
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }          
        });
        
        //鼠标点击send按钮发送消息
        but.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                sendMessage();
            }
        });
        //快捷键ctrl+enter发送消息
        taInput.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent ke)
            {
                if(ke.isControlDown() && (ke.getKeyCode() == KeyEvent.VK_ENTER))
                    sendMessage();
            }
        });
        

    }
    //基于Udp协议发送消息
    public void sendMessage()
    {
        try
        {
            InetAddress i = InetAddress.getLocalHost();
            String ip = i.getHostAddress();
            String text = taInput.getText(); 
            taInput.setText("");

            taShow.append("You(from IP:"+ip+" Port:8999"+")");
            taShow.append("\r\n");
            taShow.append("message:"+text);
            taShow.append("\r\n");
            taShow.append("\r\n");
            
            //给dgs(DatagramSocket对象)传入text   
            try
            {   
                byte[] data = text.getBytes();
                //指定接收方IP为本地IP,端口为6999
                DatagramPacket dp = new DatagramPacket(data,data.length,InetAddress.getByName("127.0.0.1"),6999);
                
                dgs.send(dp);       
                
            }catch(Exception ex)
            {
                throw new RuntimeException("ex running error");
            }
            
        }catch(Exception ext)
        {
            throw new RuntimeException("ext running error");
        }            
    }    
}
class UdpReceiver
{
     public static void main(String[] args)throws Exception
     {
            //指定本程序占用的端口为8999
            DatagramSocket ds = new DatagramSocket(8999);
            GUI gui = new GUI(ds);
            //开启一个子线程用于接收数据
            UdpRecv udpr = new UdpRecv(ds,gui);
            Thread t = new Thread(udpr);
            t.start();   
            
     }
}