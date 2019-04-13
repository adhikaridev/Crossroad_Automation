package testing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

public class Experiment3 {
	static JFrame frame = new JFrame();
	static JLabel labelGr = new JLabel();
	public static void main(String args[]){
		
			try {
				System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
				int[] a1,a2,a3,a4;
				int i = 1;
				
				Branch b1 = new Branch();
				Branch b2 = new Branch();
				Branch b3 = new Branch();
				Branch b4 = new Branch();
				
				b1.imageB = supportMethod_1(1,1, null);
				b2.imageB = supportMethod_1(2,1, null);
				b3.imageB = supportMethod_1(3,1, null);
				b4.imageB = supportMethod_1(4,1, null);
				
				VideoCapture capture1 = new VideoCapture("C:\\Users\\Dell-PC\\Desktop\\exp2\\b1\\001.png");
				VideoCapture capture2 = new VideoCapture("C:\\Users\\Dell-PC\\Desktop\\exp2\\b2\\001.png");
				VideoCapture capture3 = new VideoCapture("C:\\Users\\Dell-PC\\Desktop\\exp2\\b3\\001.png");
				VideoCapture capture4 = new VideoCapture("C:\\Users\\Dell-PC\\Desktop\\exp2\\b4\\001.png");
				
				frame.getContentPane().setBackground(Color.white);
				
				frame.setSize(1366, 768);
				
				JLabel labelA = new JLabel("<html>Segment 1:<br>Front Density<br>Mid Density<br>Back Density </html>");
			    labelA.setSize(100,100);
				labelA.setLocation(100, 177);
			    frame.add(labelA);
				
			    JLabel labelB = new JLabel("<html>Segment 2:<br>Front Density<br>Mid Density<br>Back Density </html>");
			    labelB.setSize(200,200);
			    labelB.setLocation(100, 300);
			    frame.add(labelB);
			    
			    JLabel labelC = new JLabel("<html>Segment 3:<br>Front Density<br>Mid Density<br>Back Density </html>");
			    labelC.setSize(200,200);
			    labelC.setLocation(350, 127);
			    frame.add(labelC);
				
			    JLabel labelD = new JLabel("<html>Segment 4:<br>Front Density<br>Mid Density<br>Back Density </html>");				   
			    labelD.setSize(200,200);
			    labelD.setLocation(350, 300);
			    frame.add(labelD);
			    
			    JLabel labelP = new JLabel("Segment 1");				   
			    labelP.setSize(200,200);
			    labelP.setLocation(525, 225);
			    frame.add(labelP);
			    
			    JLabel labelQ = new JLabel("Segment 2");				   
			    labelQ.setSize(200,200);
			    labelQ.setLocation(900, 50);
			    frame.add(labelQ);
			    
			    JLabel labelR = new JLabel("Segment 3");				   
			    labelR.setSize(200,200);
			    labelR.setLocation(1150, 350);
			    frame.add(labelR);
			    
			    JLabel labelS = new JLabel("Segment 4");				   
			    labelS.setSize(200,200);
			    labelS.setLocation(770, 500);
			    frame.add(labelS);
			    
			    JLabel labelT = new JLabel("Round No ");				   
			    labelT.setSize(200,200);
			    labelT.setLocation(235,50);
			    frame.add(labelT);
			    
			    JLabel labelE = new JLabel("");				   
			    labelE.setSize(200,200);
			    labelE.setLocation(1000, 400);
			    frame.add(labelE);
			    
			    crossroad();
			    
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        //frame.setLocationRelativeTo(null);
			    frame.setVisible(true);
			    
			    JLabel[] labels1 = new JLabel[3];
			    labels1[0] = null;
			    JLabel[] labels2 = new JLabel[3];
			    labels2[0] = null;
			    JLabel[] labels3 = new JLabel[3];
			    labels3[0] = null;
			    JLabel[] labels4 = new JLabel[3];
			    labels4[0] = null;
			    
				int t1=0,t2=0,t3=0,t4=0;
				boolean go1=false,go2=false,go3=false,go4=false;
				boolean startLoop=false;
				String d1=null;String d2=null;String d3=null;String d4=null;
				int loop=0;
				
				JLabel labelU = new JLabel();

			    frame.add(labelGr);
			    
			    while(i!=8){
					b1.imageC = supportMethod_1(1,2,capture1);
					a1 = supportMethod_2(b1.imageB,b1.imageC);
					
					b2.imageC = supportMethod_1(2,2,capture2);
					a2 = supportMethod_2(b2.imageB,b2.imageC);
					
					b3.imageC = supportMethod_1(3,2,capture3);
					a3 = supportMethod_2(b3.imageB,b3.imageC);
					
					b4.imageC = supportMethod_1(4,2,capture4);
					a4 = supportMethod_2(b4.imageB,b4.imageC);
					
					
					System.out.println("Round : "+i);
					printData(a1,1);
					printData(a2,2);
					printData(a3,3);
					printData(a4,4);
					
					
					labels1 = gui(a1,1,labels1);
					labels2 = gui(a2,2,labels2);
					labels3 = gui(a3,3,labels3);
					labels4 = gui(a4,4,labels4);
					
					frame.remove(labelU);
					
					labelU = new JLabel(": "+i);				   
				    labelU.setSize(200,200);
				    labelU.setLocation(300, 50);
				    frame.add(labelU);
				    
				    i++;
					int k=0;
					
					int largest;
					int[] arr = {a1[k],a2[k],a3[k],a4[k]};
					
					for(int c=0;c<3;c++){
						largest = arr[0];
						
						for(int ip=0;ip<4;ip++){
							if(arr[ip]>largest){
								largest = arr[ip];
							}
						}
						System.out.println("largest "+largest);

						int[] refined = {0,0,0,0};
						int p=0;
						int seg = 0;
						
						if(a1[k]==largest){
							if(k!=2)
								refined[0] = a1[k+1];
							p=p+1;
							seg=1;
						}
						if(a2[k]==largest){
							if(k!=2)
								refined[1] = a2[k+1];
							p=p+1;
							seg=2;
						}
						if(a3[k]==largest){
							if(k!=2)
								refined[2] = a3[k+1];
							p=p+1;
							seg=3;
						}	
						if(a4[k]==largest){
							if(k!=2)
								refined[3] = a4[k+1];
							p=p+1;
							seg=4;
						}
						
						
						if(startLoop==true){
							System.out.println("Round 4 ");
							if(d1!="done" && go1==true ){
								seg=1;
								loop++;
							}
							if(d2!="done" && go2==true ){
								seg=2;
								loop++;
								
							}
							if(d3!="done" && go3==true ){
								seg=3;
								loop++;
							}
							if(d4!="done" && go4==true){
								seg=4;
								loop++;
							}
						}
						
						if(p==1){
							if(seg==1){
								System.out.println("pass a1");
								labelGr = direction(1);
								t2=0;t3=0;t4=0;

								t1++;
								if(go1==true || t1==3){
									System.out.println("done upto here,value of t1 "+t1);
									startLoop=true;
									d1="done";
									go2=true;
								}
							}
							if(seg==2){
								System.out.println("pass a2");
								labelGr = direction(2);
								t1=0;t3=0;t4=0;
								
								t2++;
								if(go2==true || t2==3){
									startLoop=true;

									d2="done";
									go3=true;
								}
							}
							if(seg==3){
								System.out.println("pass a3");
								labelGr = direction(3);
								t1=0;t2=0;t4=0;

								t3++;
								if(go3==true || t3==3){
									startLoop=true;
									d3="done";
									go4=true;
								}
							}
							if(seg==4){
								System.out.println("pass a4");
								labelGr = direction(4);
								t1=0;t3=0;t2=0;

								t4++;
								if(go4==true || t4==3){
									startLoop=true;

									d4="done";
									go1=true;
								}
							}
							if(loop==3)	{
								startLoop=false;
								go1=false;go2=false;go3=false;go4=false;
								startLoop=false;
								d1=null;d2=null;d3=null;d4=null;
								loop=0;
							}
							break;
						}
						else{
							arr = refined;
							k=k+1;
						}
						
							
						
					}
					
					
					frame.revalidate();
					frame.repaint();
					//forLine();
					try {
					    Thread.sleep(2000);
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
			    System.out.println("No more images to process.");
			}
			catch (Exception e) {
				System.out.println("Error"+e);
			}
		}
	
		
		public static JLabel[] gui(int[] a,int segment,JLabel[] labels){
			int x,y;
			if(segment==1){
				x = 180;
				y = 20;
			}
			else if(segment==2){
				x = 180;
				y = 193;
			}
			else if(segment==3){
				x = 430;
				y = 20;
			}
			else{
				x = 430;
				y = 193;
			}
			
			if(labels[0]!=null){
				frame.remove(labels[0]);
				frame.remove(labels[1]);
				frame.remove(labels[2]);
			}
			
		    labels[0] = new JLabel(": "+a[0]+"%");
		    labels[0].setSize(400,400);
		    labels[0].setLocation(x,y);
		    
		    labels[1] = new JLabel(": "+a[1]+"%");
		    labels[1].setSize(400,400);
		    labels[1].setLocation(x,y+15);
		    
		    labels[2] = new JLabel(": "+a[2]+"%");
		    labels[2].setSize(400,400);
		    labels[2].setLocation(x,y+30);
		    
		    frame.add(labels[0]);
		    frame.add(labels[1]);
		    frame.add(labels[2]);
		    
		    JLabel labelE = new JLabel("");				   
		    labelE.setSize(200,200);
		    labelE.setLocation(1000, 400);
		    frame.add(labelE);

		    frame.revalidate();
	        frame.repaint();
			
	        return labels;
		}
		
		@SuppressWarnings("serial")
		public static void crossroad(){
			//JFrame t = new JFrame();
	        frame.add(new JComponent() {

	            

	            void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) {
	                Graphics2D g = (Graphics2D) g1.create();
	                Graphics2D g2d = (Graphics2D) g;
	                
	                int i=500;
	                
	                
	                g2d.drawLine(250+i,0,250+i,250);
	                g2d.drawLine(500+i,0,500+i,250);
	                g2d.drawLine(500+i,250,750+i,250);
	                g2d.drawLine(500+i,500,750+i,500);
	                g2d.drawLine(500+i,500,500+i,750);
	                g2d.drawLine(250+i,500,250+i,750);
	                g2d.drawLine(250+i,500,0+i,500);
	                g2d.drawLine(250+i,250,0+i,250);
	                
	                g2d.drawLine(375+i,0,375+i,250);
	                g2d.drawLine(500+i,375,750+i,375);
	                g2d.drawLine(375+i,500,375+i,750);
	                g2d.drawLine(250+i,375,0+i,375);
	                
	                
	               
	            }
	            public void paintComponent(Graphics g) {
	                drawArrow(g, 30, 300, 300, 190);
	            }
	            
	        });
		}
		
		public static  JLabel direction(int segment){
			//JFrame t = new JFrame();
			//JLabel labelG = new JLabel();
			
	        @SuppressWarnings("serial")
			JLabel labelG = new JLabel() {

	            

	            void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) {
	                Graphics2D g = (Graphics2D) g1.create();
	                Graphics2D g2d = (Graphics2D) g;
	                
	                int i=500;

	                g2d.setColor(Color.GREEN);
	                
	                if(segment==1){
	                	g2d.drawLine(225+i,290,525+i,290);
		                g2d.drawLine(505+i,280,525+i,290);
		                g2d.drawLine(505+i,300,525+i,290);
		                
		                g2d.drawLine(225+i,340,420+i,340);
		                g2d.drawLine(420+i,340,420+i,525);
		                g2d.drawLine(410+i,505,420+i,525);
		                g2d.drawLine(430+i,505,420+i,525);
	                }
	                if(segment==2){
	                	g2d.drawLine(460+i,225,460+i,525);
		                g2d.drawLine(450+i,505,460+i,525);
		                g2d.drawLine(470+i,505,460+i,525);
		                
		                g2d.drawLine(410+i,225,410+i,450);
		                g2d.drawLine(410+i,450,225+i,450);
		                g2d.drawLine(225+i,450,245+i,440);
		                g2d.drawLine(225+i,450,245+i,460);
	                }
	                if(segment==3){
	                	g2d.drawLine(525+i,460,225+i,460);
		                g2d.drawLine(225+i,460,245+i,450);
		                g2d.drawLine(225+i,460,245+i,470);
		                
		                g2d.drawLine(525+i,425,300+i,425);
		                g2d.drawLine(300+i,425,300+i,225);
		                g2d.drawLine(300+i,225,290+i,245);
		                g2d.drawLine(300+i,225,310+i,245);
	                }
	                if(segment==4){
	                	g2d.drawLine(290+i,525,290+i,225);
		                g2d.drawLine(290+i,225,280+i,245);
		                g2d.drawLine(290+i,225,300+i,245);
		                
		                g2d.drawLine(350+i,525,350+i,290);
		                g2d.drawLine(350+i,290,525+i,290);
		                g2d.drawLine(525+i,290,505+i,280);
		                g2d.drawLine(525+i,290,505+i,300);
	                }
	                
	            }
	            public void paintComponent(Graphics g) {
	                drawArrow(g, 30, 300, 300, 190);
	            }
	            
	        };
	        frame.remove(labelGr);
	        frame.add(labelG);
			return labelG;
		
		}
		
		public static BufferedImage supportMethod_1(int segment,int type,VideoCapture capture){
			BufferedImage image;
			Branch b = new Branch();
			image = b.readImg(segment,type,capture);
			image = b.setROI(image);
			image = b.grayScale(image);
			return image;
		}
		public static int[] supportMethod_2(BufferedImage imageB,BufferedImage imageC){
			BufferedImage backSubbed; Mat thresholded,morph;
			Branch b = new Branch();
			backSubbed = b.backSub(imageB,imageC);
			thresholded = b.thresholding(backSubbed);
			morph = b.morphology(thresholded);
			int[] a = b.pixelDensity(morph);
			return a;
		}
		
		
		
		public static void printData(int[] a,int segment){
			System.out.println("Segment "+segment+":");
			System.out.println("Front density: "+a[0]+"%");
			System.out.println("Mid density: "+a[1]+"%");
			System.out.println("Back density: "+a[2]+"%");
			System.out.println();
		}
		
	public static class Branch {
		public BufferedImage imageB,imageC;
		
		public BufferedImage readImg(int segment,int type,VideoCapture capture){
			try{
				BufferedImage img;
				if(segment==1 && type==1){
					File imageFile = new File("C:\\Users\\Dell-PC\\Desktop\\exp2\\b1\\Ba.png");
					img = ImageIO.read(imageFile);
				    return img;
				}
				else if(segment==1 && type==2){
					Mat folderImage = new Mat();
					if( capture.isOpened()){
						capture.read(folderImage);
						img= toBufferedImage(folderImage);
						return img;		
					}
					else{
						System.out.println("Couldn't open capture.");
						return null;
					}
				}
				else if(segment==2 && type==1){
					File imageFile = new File("C:\\Users\\Dell-PC\\Desktop\\exp2\\b2\\Ba.png");
					img = ImageIO.read(imageFile);
				    return img;
				}
				else if(segment==2 && type==2){
					Mat folderImage = new Mat();
					if( capture.isOpened()){
						capture.read(folderImage);
						img= toBufferedImage(folderImage);
						return img;		
					}
					else{
						System.out.println("Couldn't open capture.");
						return null;
					}
				}
				else if(segment==3 && type==1){
					File imageFile = new File("C:\\Users\\Dell-PC\\Desktop\\exp2\\b3\\Ba.png");
					img = ImageIO.read(imageFile);
				    return img;
				}
				else if(segment==3 && type==2){
					Mat folderImage = new Mat();
					if( capture.isOpened()){
						capture.read(folderImage);
						img= toBufferedImage(folderImage);
						return img;		
					}
					else{
						System.out.println("Couldn't open capture.");
						return null;
					}
				}
				else if(segment==4 && type==1){
					File imageFile = new File("C:\\Users\\Dell-PC\\Desktop\\exp2\\b4\\Ba.png");
					img = ImageIO.read(imageFile);
				    return img;
				}
				else if(segment==4 && type==2){
					Mat folderImage = new Mat();
					if( capture.isOpened()){
						capture.read(folderImage);
						img= toBufferedImage(folderImage);
						return img;		
					}
					else{
						System.out.println("Couldn't open capture.");
						return null;
					}
				}
				else{
					return null;
				}
			}
			catch (Exception e) {
				System.out.println("Error"+e);
				return null;
			}
		}
		public BufferedImage setROI(BufferedImage image){
			try{
				Graphics2D graph = image.createGraphics();
			    graph.setColor(Color.black);
		        
		        /*int [ ] x = {0,0,150};
		        int [ ] y = {0,310,0};
		        graph.fillPolygon(x, y, 3);

		        int [ ] a = {480,480,370};
		        int [ ] b = {0,250,0};
		        graph.fillPolygon(a, b, 3);*/
			    
			    int [ ] x = {0,0,240,840};
		        int [ ] y = {0,1080,1080,0};
		        graph.fillPolygon(x, y, 4);

		        int [ ] a = {1120,1920,1920};
		        int [ ] b = {0,1080,0};
		        graph.fillPolygon(a, b, 3);
		        
			    graph.dispose();
			    
			    return image;
			}
			catch (Exception e) {
				System.out.println("Error"+e);
				return null;
			}
		}
		
		public BufferedImage grayScale(BufferedImage image){
			try{
				int width = image.getWidth();
				int height = image.getHeight();
		
				for(int j=0; j<height; j++){
					for(int i=0; i<width; i++){
						Color c = new Color(image.getRGB(i, j));
						int red = (int)(c.getRed() * 0.299);
						int green = (int)(c.getGreen() * 0.587);
						int blue = (int)(c.getBlue() *0.114);
						Color newColor = new Color(red+green+blue,red+green+blue,red+green+blue);
						image.setRGB(i,j,newColor.getRGB());
					}
				}
				return image;
			}
			catch (Exception e) {
				System.out.println("Error"+e);
				return null;
			}
		}
		
		public BufferedImage backSub(BufferedImage bImage,BufferedImage cImage){
			try{
				int width=bImage.getWidth();
				int height=bImage.getHeight();
				for(int i=0;i<height;i++){
					for(int j=0;j<width;j++){
						Color c = new Color(cImage.getRGB(j,i));
						Color b = new Color(bImage.getRGB(j,i));
						int red = c.getRed()-b.getRed();
						int green = c.getGreen()-b.getGreen();
						int blue = c.getBlue()-b.getBlue();
						red= Math.abs(red);
						green= Math.abs(green);
						blue= Math.abs(blue);
						Color newColor=new Color(red,green,blue);
						cImage.setRGB(j,i,newColor.getRGB());
					}
				}
				return cImage;
			}
			catch (Exception e) {
				System.out.println("Error"+e);
				return null;
			}
		}
		
		public Mat thresholding(BufferedImage bi){
			Mat source = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
			byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
			source.put(0, 0, data);
			Mat destination = new Mat(source.rows(),source.cols(),source.type());
			destination = source;
			Imgproc.threshold(source, destination, 30,255,Imgproc.THRESH_BINARY_INV);
			return destination;
		}
		public Mat filter(Mat source){
			Mat destination = new Mat(source.rows(),source.cols(),source.type());
			destination = source;
			Imgproc.medianBlur(source, destination, 3);
			return destination;
		}
		public Mat morphology(Mat source){
			Mat destination = new Mat(source.rows(),source.cols(),source.type());
			destination = source;
			int erosion_size = 5;
			Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2*erosion_size+1,2*erosion_size+1));
			Imgproc.erode(source, destination, element);
			return destination;
		}
		
		public int[] pixelDensity(Mat image){
			try {
				BufferedImage img1 = toBufferedImage(image);
				
				int width = img1.getWidth();
				int height = img1.getHeight();
				int counter = 0;
				int front,mid = 0,back = 0;
				int front_density = 0;
				int mid_density = 0;
				int back_density = 0;
				for(int j=0; j<height; j++){
					for(int i=0; i<width; i++){
						int p = img1.getRGB(i, j);
						p = Math.abs(p);
						if(p!=1){
							counter=counter+1;
						}
					}
					if(j==359){
						back = counter;
						back_density = back*100/188777;
					}
					if(j==719){
						mid = counter-back;
						mid_density = mid*100/356674;
					}
					if(j==1079){
						front = counter-mid-back;
						front_density = front*100/525416;
					}
				}
				int[] a = {front_density,mid_density,back_density};
				return a;
			} 
			catch (Exception e) {
				System.out.println("Error"+e);
				return null;
			}	
		}
		
		public BufferedImage toBufferedImage(Mat matrix){
			int type = BufferedImage.TYPE_BYTE_GRAY;
			if ( matrix.channels() > 1 ) {
				type = BufferedImage.TYPE_3BYTE_BGR;
			}
			int bufferSize = matrix.channels()*matrix.cols()*matrix.rows();
			byte [] buffer = new byte[bufferSize];
			matrix.get(0,0,buffer); // get all the pixels
			BufferedImage image = new BufferedImage(matrix.cols(),matrix.rows(), type);
			final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
			System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);  
			return image;
		}
	}
}
