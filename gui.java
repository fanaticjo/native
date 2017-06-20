import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
public class gui extends Applet implements ActionListener,Runnable
{   
	public static final int x=500;
	public static final int y=500;
	Thread t;
	Font f;
	Button b1,b2,b3,b4;
	Label l1,l2;
	TextField tf1,tf2;
	public void init()
	{
		b1=new Button("Start");
		b2=new Button("kill");
		b3=new Button("Resume");
		b4=new Button("stop");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		f=new Font("Verdana",Font.BOLD,22);
		b1.setFont(f);
		b2.setFont(f);
		b3.setFont(f);
		b4.setFont(f);
		l1=new Label("No of Balls ");
		l1.setFont(f);
		tf1=new TextField(22);
		tf1.setFont(f);
		l2=new Label("speed");
		l2.setFont(f);
		tf2=new TextField(22);
		tf2.setFont(f);
		add(l1);
		add(tf1);
		add(l2);
		add(tf2);
		add(b1);
		add(b2);
		add(b3);
		add(b4);

	}
	public void actionPerformed(ActionEvent ae)
	{
		if((ae.getSource()==b1) && (t==null))
		{
			t=new Thread(this);
			t.start();
		}
		else if((ae.getSource()==b2) && (t!=null))
		{
			t.stop();
			t=null;
		}
		else if((ae.getSource()==b3) && (t!=null))
		{
			t.resume();
		}
		else if((ae.getSource()==b4) && (t!=null))
		{
			t.suspend();
		}
	}
	public void run()
	{
		//int x2=x;
		for(int x3=1;x3<=getSize().width;x3+=20)
			{	repaint();
		while(true)
		{  

			
			repaint();
			try{
				Thread.sleep(Long.parseLong(tf2.getText()));
			}catch(Exception ee)
			   {
			   	ee.printStackTrace();
			   }
			   if(x3==900)
			   {
			   	System.exit(0);

			   }
				}

		}

			
	}
	public void paint(Graphics t)
	{
		for(int i=1;i<=(Integer.parseInt(tf1.getText()));i++)
		{
			int r=(int)((Math.random()*1000)%254);
			int g=(int)((Math.random()*1000)%254);
			int b=(int)((Math.random()*1000)%254);
			Color c=new Color(r,g,b);
			t.setColor(c);
			int x1=(int)((Math.random()*1000)%x);
			int y1=(int)((Math.random()*1000)%y);
			t.fillOval(x1,y1,70,70);
		}
	}
}
/*<applet code="gui" width=900 height=900>
</applet>*/