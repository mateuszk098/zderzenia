package projekt;

import javax.swing.*;

import java.util.LinkedList;
import java.util.List;
 
import javax.swing.SwingWorker;
 
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.style.Styler.LegendPosition;

public class WykresFrame extends JFrame
{
	MySwingWorker mySwingWorker=new MySwingWorker();
	XYChart chart=QuickChart.getChart("","T (s)","V (m/s)","Kulka 1",new double[] {0},new double[] {0});
	SwingWrapper<XYChart> sw=new SwingWrapper<XYChart>(chart);
	
	public void go() 
	{
		chart.getStyler().setLegendVisible(true);
		chart.getStyler().setXAxisTicksVisible(false);
		chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
		
	  	sw.displayChart();;  	
	  	mySwingWorker.execute();
	}
 
	public class MySwingWorker extends SwingWorker <Boolean,double[]> 
	{
		LinkedList<Double> kulka1=new LinkedList<Double>();
		
		public MySwingWorker()
		{
			kulka1.add(getPredkoscKulka1());
		}		
		
		public Boolean doInBackground() throws Exception 
		{
			while (!isCancelled()) 
			{
				kulka1.add(getPredkoscKulka1());
				
				if (kulka1.size()>500) 
				{
					kulka1.removeFirst();
				}
    	  
				double[] array=new double[kulka1.size()];
				for (int i=0; i<kulka1.size(); i++) 
				{
					array[i]=kulka1.get(i);
				}
				publish(array);
				
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					System.out.println("MySwingWorker shut down.");
				}
			}
			return true;
		}
 
		public void process(List<double[]> chunks) 
		{
			double[] mostRecentDataSet=chunks.get(chunks.size()-1);
 
			chart.updateXYSeries("Kulka 1",null,mostRecentDataSet,null);
			sw.repaintChart();
			
			long start=System.currentTimeMillis();
			long duration=System.currentTimeMillis()-start;
    	
			try
			{
				Thread.sleep(40-duration);
    		
			} catch(InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public double getPredkoscKulka1()
	{
		return Math.round(Math.sqrt(PanelRysowania.Kulka1.getVX()*PanelRysowania.Kulka1.getVX()+PanelRysowania.Kulka1.getVY()*PanelRysowania.Kulka1.getVY()));
	}
}