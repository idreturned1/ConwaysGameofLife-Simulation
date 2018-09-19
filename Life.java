
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;



public class Life extends JPanel implements ActionListener, MouseListener, MouseMotionListener , ItemListener , ChangeListener {
	
	MosaicPanel display;
  int a=300;
  int upper =255;
  int lower =1 ;
  int speed =200;
  String a1 ="GREEN";

    
    public static void main(String[] args) {
        JFrame f = new JFrame("Life");
        JPanel p = new Life();
        f.setContentPane(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocation(100,0);
        f.setVisible(true);
    }

    private final int GRID_SIZE =300;  
    private boolean[][] alive;   
	  
    private Timer timer;  
    private JButton  stopGoButton;  
    private JButton  nextButton;   
    private JButton  randomButton;  
    private JButton  clearButton;   
    private JButton  quitButton; 
    private JButton  pattern; 
    private JButton  pattern1;
    private JButton  pattern2;
	 private JButton  z; 
    private JButton  z1;
	private JButton t;
	Choice c1,ch;
	JSlider slider = new JSlider(JSlider.HORIZONTAL, 0,500,0);
                            	
    public Life() {
        alive = new boolean[GRID_SIZE][GRID_SIZE];
        setLayout(new BorderLayout(3,3));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
        int cellSize = 600/GRID_SIZE; 
      display = new MosaicPanel(GRID_SIZE,GRID_SIZE,cellSize,cellSize);
        if (cellSize < 1)
            display.setGroutingColor(null);
        display.setUse3D(false);
        add(display,BorderLayout.CENTER);
        JPanel bottom = new JPanel();
		JPanel top = new JPanel();
		add(top,BorderLayout.NORTH);
		
        add(bottom,BorderLayout.SOUTH);
		
        clearButton = new JButton("Clear");
        stopGoButton = new JButton("Start");
        quitButton = new JButton("Quit");
        nextButton = new JButton("One Step");
        randomButton = new JButton("Random Fill");
		t = new JButton("Increse");
		pattern= new JButton("Load puffer");
		pattern1 =new JButton("Load Acorn");
		pattern2 = new JButton("Load Glider Gun");
		JLabel a1 = new JLabel("Speed");
		
		   slider.setMinorTickSpacing(100);
           slider.setMinorTickSpacing(50);
           slider.setPaintTicks(true);
		   slider.setPaintLabels(true);
        
      
	  
		


		
		
		ImageIcon c2 = new ImageIcon("rsz_zoomin.png");
		ImageIcon c3 = new ImageIcon("rsz_zoomout.jpg");
		z1 = new JButton(c2);
		z = new JButton(c3);
		c1 = new Choice();
		c1.add("DIY");  
		c1.add("Puffer");
		c1.add("AND GATE");
		c1.add("OR GATE");
		c1.add("NOT GATE");
		c1.add("Acorn");
		
		
		ch=new Choice();
		ch.add("Green");
		ch.add("Random");  
		ch.add("Red");
		ch.add("White");
		ch.add("Blue");
		ch.add("Yellow");
		
		
		
        bottom.add(stopGoButton);
        bottom.add(nextButton);
        bottom.add(randomButton);
        bottom.add(clearButton);
        bottom.add(quitButton);
		bottom.add(c1);
		bottom.add(z1);
		bottom.add(z);
		top.add(ch);
		
		
	   slider.addChangeListener(this); 
          

       
		
		
        stopGoButton.addActionListener(this);
        clearButton.addActionListener(this);
        quitButton.addActionListener(this);
        randomButton.addActionListener(this);
        nextButton.addActionListener(this);
		pattern.addActionListener(this);
		pattern1.addActionListener(this);
		pattern2.addActionListener(this);
		c1.addItemListener(this);
		z.addActionListener(this);
		z1.addActionListener(this);
        display.addMouseListener(this);
        display.addMouseMotionListener(this);
		
        timer = new Timer(50,this);
    }

    

    private void doFrame() {
		  
        boolean[][] newboard = new boolean[GRID_SIZE][GRID_SIZE];
        for ( int r = 0; r < GRID_SIZE; r++ ) {
            int above, below; 
            int left, right;  
            above = r > 0 ? r-1 : GRID_SIZE-1;
            below = r < GRID_SIZE-1 ? r+1 : 0;
            for ( int c = 0; c < GRID_SIZE; c++ ) {
                left =  c > 0 ? c-1 : GRID_SIZE-1;
                right = c < GRID_SIZE-1 ? c+1 : 0;
                int n = 0; 
                if (alive[above][left])
                    n++;
                if (alive[above][c])
                    n++;
                if (alive[above][right])
                    n++;
                if (alive[r][left])
                    n++;
                if (alive[r][right])
                    n++;
                if (alive[below][left])
                    n++;
                if (alive[below][c])
                    n++;
                if (alive[below][right])
                    n++;
                if (n == 3 || (alive[r][c] && n == 2))
                    newboard[r][c] = true;
                else
                    newboard[r][c] = false;
            }
        }
        alive = newboard;
    }


    
    private void showBoard() {
        display.setAutopaint(false); 
        for (int r = 0; r < GRID_SIZE; r++) {
            for (int c = 0; c < GRID_SIZE; c++) {
				
            if(a1.equals("RANDOM"))
		{
                if (alive[r][c])
                    display.setColor(r,c,(int) (Math.random() * (upper - lower)) + lower,(int) (Math.random() * (upper - lower)) + lower,(int) (Math.random() * (upper - lower)) + lower);
                else
                    display.setColor(r,c,null); 
		}  
		if(a1.equals("GREEN"))
		{
                if (alive[r][c])
                    display.setColor(r,c,Color.GREEN);
                else
                    display.setColor(r,c,null); 
		}  
		if(a1.equals("RED"))
		{
                if (alive[r][c])
                    display.setColor(r,c,Color.RED);
                else
                    display.setColor(r,c,null); 
		}  
		if(a1.equals("BLUE"))
		{
                if (alive[r][c])
                    display.setColor(r,c,Color.BLUE);
                else
                    display.setColor(r,c,null); 
		}
		if(a1.equals("YELLOW"))
		{
                if (alive[r][c])
                    display.setColor(r,c,Color.YELLOW);
                else
                    display.setColor(r,c,null); 
		} 
		if(a1.equals("WHITE"))
		{
                if (alive[r][c])
                    display.setColor(r,c,Color.WHITE);
                else
                    display.setColor(r,c,null); 
		} 		
		   
        
			}
			display.setAutopaint(true);  
    }}


    
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource(); 
        if (src == quitButton) { 
            System.exit(0);
        }
        else if (src == clearButton) {  
            alive = new boolean[GRID_SIZE][GRID_SIZE];
            display.clear();
        }
		
		else if(src  == z1)
		{
			if(a>50)
			{
				
				a=a-50;
				
				display.setGridSize(a,a,true);
				
				
		}}
			  else if(src ==  z)
		{
			if((a>=50)&&(a<300))
			{
				a=a+50;
				
				display.setGridSize(a,a,true);
				
			}
			
			
		}
        else if (src == nextButton) {  
            doFrame();
            showBoard();
        }
        else if(src == t)
		{
			if(speed>50)
			speed =speed -50;
		
		    timer.setDelay(speed);
			
			
		}
		
		else if (src == stopGoButton) {  
            if (timer.isRunning()) { 
                timer.stop(); 
                clearButton.setEnabled(true);  
                randomButton.setEnabled(true);
                nextButton.setEnabled(true);
                stopGoButton.setText("Start"); 
            }
            else {  
                timer.start();  
                clearButton.setEnabled(false);  
                randomButton.setEnabled(false);
                nextButton.setEnabled(false);
                stopGoButton.setText("Stop"); 
            }
        }
        else if (src == randomButton) { 
            for (int r = 0; r < GRID_SIZE; r++) {
                for (int c = 0; c < GRID_SIZE; c++)
                    alive[r][c] = (Math.random() < 0.25);  
            }
            showBoard();
        }
        else if (src == timer) { 
            doFrame();
            showBoard();
        }
    }

    public void itemStateChanged(ItemEvent ie)
	{
		
		if(ch.getSelectedItem() == "Green")
		{
			a1="GREEN";
			showBoard();
		}
		if(ch.getSelectedItem() == "Random")
		{
			a1="RANDOM";
			showBoard();
		}
		if(ch.getSelectedItem() == "Red")
		{
			a1="RED";
			showBoard();
		}
		if(ch.getSelectedItem() == "White")
		{
			a1="WHITE";
			showBoard();
		}
		if(ch.getSelectedItem() == "Blue")
		{
			a1="BLUE";
			showBoard();
		}
	    if(ch.getSelectedItem() == "Yellow")
		{
			a1="YELLOW";
			showBoard();
		}
		
		
		
		if(c1.getSelectedItem() == "OR GATE")
		{
			
			 alive[12][5]=true;
		alive[12][6]=true;
		alive[13][5]=true;
		alive[13][6]=true;
		alive[12][15]=true;
		alive[13][15]=true;
		alive[14][15]=true;
		alive[11][16]=true;
		alive[15][16]=true;
		alive[10][17]=true;
		alive[10][18]=true;
		alive[16][17]=true;
		alive[16][18]=true;
		alive[13][19]=true;
		alive[11][20]=true;
		alive[15][20]=true;
		alive[12][21]=true;
		alive[13][21]=true;
		alive[14][21]=true;
		alive[13][22]=true;
		alive[10][25]=true;
		alive[11][25]=true;
		alive[12][25]=true;
		alive[10][26]=true;
		alive[11][26]=true;
		alive[12][26]=true;
		alive[9][27]=true;
		alive[13][27]=true;
		alive[8][29]=true;
		alive[9][29]=true;
		alive[13][29]=true;
		alive[14][29]=true;
		alive[10][39]=true;
		alive[11][39]=true;
		alive[10][40]=true;
		alive[11][40]=true;
            alive[12][50]=true;
		alive[12][51]=true;
		alive[13][50]=true;
		alive[13][51]=true;
		alive[12][60]=true;
		alive[13][60]=true;
		alive[14][60]=true;
		alive[11][61]=true;
		alive[15][61]=true;
		alive[10][62]=true;
		alive[10][62]=true;
		alive[16][62]=true;
		alive[16][63]=true;
		alive[13][64]=true;
		alive[11][65]=true;
		alive[15][65]=true;
		alive[12][66]=true;
		alive[13][66]=true;
		alive[14][66]=true;
		alive[13][67]=true;
		alive[10][70]=true;
		alive[11][70]=true;
		alive[12][70]=true;
		alive[10][71]=true;
		alive[11][71]=true;
		alive[12][71]=true;
		alive[9][72]=true;
		alive[13][72]=true;
		alive[8][74]=true;
		alive[9][74]=true;
		alive[13][74]=true;
		alive[14][74]=true;
		alive[10][84]=true;
		alive[11][84]=true;
		alive[10][85]=true;
		alive[11][85]=true;
		alive[10][63]=true;
		
		
		
		alive[12][105]=true;
		alive[12][106]=true;
		alive[13][105]=true;
		alive[13][106]=true;
		alive[12][115]=true;
		alive[13][115]=true;
		alive[14][115]=true;
		alive[11][116]=true;
		alive[15][116]=true;
		alive[10][117]=true;
		alive[10][117]=true;
		alive[16][117]=true;
		alive[16][118]=true;
		alive[13][119]=true;
		alive[11][120]=true;
		alive[15][120]=true;
		alive[12][121]=true;
		alive[13][121]=true;
		alive[14][121]=true;
		alive[13][122]=true;
		alive[10][125]=true;
		alive[11][125]=true;
		alive[12][125]=true;
		alive[10][126]=true;
		alive[11][126]=true;
		alive[12][126]=true;
		alive[9][127]=true;
		alive[13][127]=true;
		alive[8][129]=true;
		alive[9][129]=true;
		alive[13][129]=true;
		alive[14][129]=true;
		alive[10][139]=true;
		alive[11][139]=true;
		alive[10][140]=true;
		alive[11][140]=true;
		alive[10][118]=true;
		alive[18][128]=true;
		alive[19][128]=true;
		alive[18][129]=true;
		alive[20][129]=true;
		alive[20][130]=true;
		alive[20][131]=true;
		alive[21][131]=true;
		
		
		alive[13][155]=true;
		alive[13][156]=true;
		alive[12][155]=true;
		alive[12][156]=true;
		alive[11][166]=true;
		alive[10][166]=true;
		alive[15][166]=true;
		alive[16][166]=true;
		alive[11][168]=true;
		alive[15][168]=true;
		alive[12][169]=true;
		alive[12][170]=true;
		alive[13][169]=true;
		alive[13][170]=true;
		alive[14][169]=true;
		alive[14][170]=true;
		alive[15][173]=true;
		alive[14][174]=true;
		alive[15][174]=true;
		alive[16][174]=true;
		alive[13][175]=true;
		alive[17][175]=true;
		alive[15][176]=true;
		alive[12][177]=true;
		alive[12][178]=true;
		alive[18][177]=true;
		alive[18][178]=true;
		alive[13][179]=true;
		alive[17][179]=true;
		alive[14][180]=true;
		alive[15][180]=true;
		alive[16][180]=true;
		alive[14][189]=true;
		alive[14][190]=true;
		alive[15][189]=true;
		alive[15][190]=true;
		
		
		
		
		
	
	
		
		
	
				showBoard();
		
		
		
		
		
			
			
			
			
		}
		
		
		if(c1.getSelectedItem() == "NOT GATE")
		{
			
		alive[12][55]=true;
		alive[12][56]=true;
		alive[13][55]=true;
		alive[13][56]=true;
		alive[12][65]=true;
		alive[13][65]=true;
		alive[14][65]=true;
		alive[11][66]=true;
		alive[15][66]=true;
		alive[10][67]=true;
		alive[10][67]=true;
		alive[16][67]=true;
		alive[16][68]=true;
		alive[13][69]=true;
		alive[11][70]=true;
		alive[15][70]=true;
		alive[12][71]=true;
		alive[13][71]=true;
		alive[14][71]=true;
		alive[13][72]=true;
		alive[10][75]=true;
		alive[11][75]=true;
		alive[12][75]=true;
		alive[10][76]=true;
		alive[11][76]=true;
		alive[12][76]=true;
		alive[9][77]=true;
		alive[13][77]=true;
		alive[8][79]=true;
		alive[9][79]=true;
		alive[13][79]=true;
		alive[14][79]=true;
		alive[10][89]=true;
		alive[11][89]=true;
		alive[10][90]=true;
		alive[11][90]=true;
		alive[10][68]=true;
		alive[18][78]=true;
		alive[19][78]=true;
		alive[18][79]=true;
		alive[20][79]=true;
		alive[20][80]=true;
		alive[20][81]=true;
		alive[21][81]=true;	
		alive[13][100]=true;
		alive[13][101]=true;
		alive[12][100]=true;
		alive[12][101]=true;
		alive[11][111]=true;
		alive[10][111]=true;
		alive[15][111]=true;
		alive[16][111]=true;
		alive[11][113]=true;
		alive[15][113]=true;
		alive[12][114]=true;
		alive[12][115]=true;
		alive[13][114]=true;
		alive[13][115]=true;
		alive[14][114]=true;
		alive[14][115]=true;
		alive[15][118]=true;
		alive[14][119]=true;
		alive[15][119]=true;
		alive[16][119]=true;
		alive[13][120]=true;
		alive[17][120]=true;
		alive[15][121]=true;
		alive[12][122]=true;
		alive[12][123]=true;
		alive[18][122]=true;
		alive[18][123]=true;
		alive[13][124]=true;
		alive[17][124]=true;
		alive[14][125]=true;
		alive[15][125]=true;
		alive[16][125]=true;
		alive[14][134]=true;
		alive[14][135]=true;
		alive[15][134]=true;
		alive[15][135]=true;
		
		
	
				showBoard();
			
		}
		if(c1.getSelectedItem() == "Puffer")
		{
			
			for (int r = 0; r < GRID_SIZE; r++) {
                for (int c = 0; c < GRID_SIZE; c++){
                    alive[r][c] = false;
				
             			
				

            }}
			
				alive[24][20]=true;		
		alive[26][20]=true;
		alive[32][20]=true;
		alive[34][20]=true;
		alive[25][21]=true;
		alive[28][21]=true;
		alive[30][21]=true;
		alive[33][21]=true;
		alive[23][22]=true;
		alive[25][22]=true;
		alive[27][22]=true;
		alive[29][22]=true;
		alive[31][22]=true;
		alive[33][22]=true;
		alive[35][22]=true;
		alive[22][23]=true;
		alive[24][23]=true;
		alive[25][23]=true;
		alive[27][23]=true;
		alive[31][23]=true;
		alive[31][23]=true;
		alive[33][23]=true;
		alive[34][23]=true;
		alive[36][23]=true;
		alive[18][24]=true;
		alive[19][24]=true;
		alive[24][24]=true;
		alive[28][24]=true;
		alive[30][24]=true;
		alive[34][24]=true;
		alive[39][24]=true;
		alive[40][24]=true;
		alive[22][25]=true;
		alive[23][25]=true;
		alive[28][25]=true;
		alive[30][25]=true;
		alive[35][25]=true;
		alive[36][25]=true;
		alive[19][26]=true;
		alive[22][26]=true;
		alive[26][26]=true;
		alive[28][26]=true;
		alive[30][26]=true;
		alive[32][26]=true;
		alive[36][26]=true;
		alive[39][26]=true;
		alive[19][27]=true;
		alive[20][27]=true;
		alive[24][27]=true;
		alive[28][27]=true;
		alive[30][27]=true;
		alive[34][27]=true;
		alive[38][27]=true;
		alive[39][27]=true;
		alive[20][28]=true;
		alive[22][28]=true;
		alive[24][28]=true;
		alive[26][28]=true;
		alive[27][28]=true;
		alive[28][28]=true;
		alive[30][28]=true;
		alive[31][28]=true;
		alive[32][28]=true;
		alive[34][28]=true;
		alive[36][28]=true;
		alive[38][28]=true;
		alive[20][29]=true;
		alive[21][29]=true;
		alive[37][29]=true;
		alive[38][29]=true;
		alive[20][30]=true;
		alive[21][30]=true;
		alive[23][30]=true;
		alive[35][30]=true;
		alive[37][30]=true;
		alive[38][30]=true;
		alive[23][31]=true;
		alive[35][31]=true;
		alive[22][32]=true;
		alive[23][32]=true;
		alive[25][32]=true;
		alive[33][32]=true;
		alive[35][32]=true;
		alive[36][32]=true;
		alive[25][33]=true;
		alive[33][33]=true;
		alive[13][34]=true;
		alive[14][34]=true;
	
		alive[24][34]=true;
		alive[25][34]=true;
		alive[27][34]=true;
		alive[29][34]=true;
		alive[31][34]=true;
		alive[33][34]=true;
		alive[34][34]=true;
		alive[44][34]=true;
		alive[45][34]=true;
		alive[14][35]=true;
		alive[15][35]=true;
		alive[16][35]=true;
		alive[18][35]=true;
		alive[22][35]=true;
		alive[27][35]=true;
		alive[29][35]=true;
		alive[31][35]=true;
		alive[36][35]=true;
		alive[40][35]=true;
		alive[42][35]=true;
		alive[43][35]=true;
		alive[44][35]=true;
		alive[14][36]=true;
		alive[15][36]=true;
		alive[19][36]=true;
		alive[21][36]=true;
		alive[26][36]=true;
		alive[32][36]=true;
		alive[37][36]=true;
		alive[39][36]=true;
		alive[43][36]=true;
		alive[44][36]=true;
		alive[14][37]=true;
		alive[15][37]=true;
		alive[17][37]=true;
		alive[19][37]=true;
		alive[21][37]=true;
		alive[23][37]=true;
		alive[28][37]=true;
		alive[30][37]=true;
		alive[35][37]=true;
		alive[37][37]=true;
		alive[39][37]=true;
		alive[41][37]=true;
		alive[43][37]=true;
		alive[44][37]=true;
		alive[17][38]=true;
		alive[19][38]=true;
		alive[22][38]=true;
		alive[24][38]=true;
		alive[28][38]=true;
		alive[30][38]=true;
		alive[34][38]=true;
		alive[36][38]=true;
		alive[39][38]=true;
		alive[41][38]=true;
		alive[16][39]=true;
		alive[17][39]=true;
		alive[19][39]=true;
		alive[22][39]=true;
		alive[23][39]=true;
		alive[24][39]=true;
		alive[27][39]=true;
		alive[31][39]=true;
		alive[34][39]=true;
		alive[35][39]=true;
		alive[36][39]=true;
		alive[39][39]=true;
		alive[41][39]=true;
		alive[42][39]=true;
		alive[18][40]=true;
		alive[19][40]=true;
		alive[24][40]=true;
		alive[25][40]=true;
		alive[26][40]=true;
		alive[32][40]=true;
		alive[33][40]=true;
		alive[34][40]=true;
		alive[39][40]=true;
		alive[40][40]=true;
		alive[19][41]=true;
		alive[20][41]=true;
		alive[21][41]=true;
		alive[37][41]=true;
		alive[38][41]=true;
		alive[39][41]=true;
		alive[20][42]=true;
		alive[38][42]=true;
				showBoard();
			
			
		}
		
		
		if(c1.getSelectedItem() == "AND GATE")
		{
			
			for (int r = 0; r < GRID_SIZE; r++) {
                for (int c = 0; c < GRID_SIZE; c++){
                    alive[r][c] = false;
				
             			
				

            }}
		
		 alive[12][5]=true;
		alive[12][6]=true;
		alive[13][5]=true;
		alive[13][6]=true;
		alive[12][15]=true;
		alive[13][15]=true;
		alive[14][15]=true;
		alive[11][16]=true;
		alive[15][16]=true;
		alive[10][17]=true;
		alive[10][18]=true;
		alive[16][17]=true;
		alive[16][18]=true;
		alive[13][19]=true;
		alive[11][20]=true;
		alive[15][20]=true;
		alive[12][21]=true;
		alive[13][21]=true;
		alive[14][21]=true;
		alive[13][22]=true;
		alive[10][25]=true;
		alive[11][25]=true;
		alive[12][25]=true;
		alive[10][26]=true;
		alive[11][26]=true;
		alive[12][26]=true;
		alive[9][27]=true;
		alive[13][27]=true;
		alive[8][29]=true;
		alive[9][29]=true;
		alive[13][29]=true;
		alive[14][29]=true;
		alive[10][39]=true;
		alive[11][39]=true;
		alive[10][40]=true;
		alive[11][40]=true;
               alive[12][55]=true;
		alive[12][56]=true;
		alive[13][55]=true;
		alive[13][56]=true;
		alive[12][65]=true;
		alive[13][65]=true;
		alive[14][65]=true;
		alive[11][66]=true;
		alive[15][66]=true;
		alive[10][67]=true;
		alive[10][67]=true;
		alive[16][67]=true;
		alive[16][68]=true;
		alive[13][69]=true;
		alive[11][70]=true;
		alive[15][70]=true;
		alive[12][71]=true;
		alive[13][71]=true;
		alive[14][71]=true;
		alive[13][72]=true;
		alive[10][75]=true;
		alive[11][75]=true;
		alive[12][75]=true;
		alive[10][76]=true;
		alive[11][76]=true;
		alive[12][76]=true;
		alive[9][77]=true;
		alive[13][77]=true;
		alive[8][79]=true;
		alive[9][79]=true;
		alive[13][79]=true;
		alive[14][79]=true;
		alive[10][89]=true;
		alive[11][89]=true;
		alive[10][90]=true;
		alive[11][90]=true;
		alive[10][68]=true;
		alive[18][78]=true;
		alive[19][78]=true;
		alive[18][79]=true;
		alive[20][79]=true;
		alive[20][80]=true;
		alive[20][81]=true;
		alive[21][81]=true;
		alive[12][100]=true;
		alive[12][101]=true;
		alive[13][100]=true;
		alive[13][101]=true;
		alive[11][111]=true;
		alive[10][111]=true;
		alive[15][111]=true;
		alive[16][111]=true;
		alive[11][113]=true;
		alive[15][113]=true;
		alive[12][114]=true;
		alive[12][115]=true;
		alive[13][114]=true;
		alive[13][115]=true;
		alive[14][114]=true;
		alive[14][115]=true;
		alive[15][118]=true;
		alive[14][119]=true;
		alive[15][119]=true;
		alive[16][119]=true;
		alive[13][120]=true;
		alive[17][120]=true;
		alive[15][121]=true;
		alive[12][122]=true;
		alive[12][123]=true;
		alive[18][122]=true;
		alive[18][123]=true;
		alive[13][124]=true;
		alive[17][124]=true;
		alive[14][125]=true;
		alive[15][125]=true;
		alive[16][125]=true;
		alive[14][134]=true;
		alive[14][135]=true;
		alive[15][134]=true;
		alive[15][135]=true;
		
		
	
				showBoard();
			
			
		}
		
		
			
		if(c1.getSelectedItem() == "Acorn")
		{
			
			for (int r = 0; r < GRID_SIZE; r++) {
                for (int c = 0; c < GRID_SIZE; c++){
                    alive[r][c] = false;
				
             			
				

            }}
			
		
			alive[70][70]=true;
			alive[70][71]=true;
			alive[68][71]=true;
			alive[69][73]=true;
			alive[70][74]=true;
			alive[70][75]=true;
			alive[70][76]=true;
			showBoard();
			
	}}
	
	
	 public void stateChanged(ChangeEvent e) {
               
			   
				 speed =  (int) slider.getValue();
				 
				
				 
				 
				 
				 }

            
	
	
	
		
		

    
    public void mousePressed(MouseEvent e) {
        if (timer.isRunning())
            return;
        int row = display.yCoordToRowNumber(e.getY());
        int col = display.yCoordToRowNumber(e.getX());
        if (row >= 0 && row < display.getRowCount() && col >= 0 && col < display.getColumnCount()) {
            if (e.isMetaDown() || e.isControlDown()) {
                display.setColor(row,col,null);
                alive[row][col] = false;
            }
            else {
               
				if(alive[row][col]==true)
				{
					display.setColor(row,col,null);
                alive[row][col] = false;
					
				}
                 else
				 {    display.setColor(row,col,Color.GREEN);
					 alive[row][col] = true;
				
            }
        }
    }
	}


   
    public void mouseDragged(MouseEvent e) {
        mousePressed(e); 
    }

	
	
	
    public void mouseClicked(MouseEvent e) { }  
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { }


}
