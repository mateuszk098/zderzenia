package projektV5;

import javax.swing.*;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
 
import javax.swing.SwingWorker;
 
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.style.Styler.LegendPosition;


public class WykresKulka2 extends JFrame
{
	MySwingWorker mySwingWorker=new MySwingWorker();
	XYChart chart=QuickChart.getChart("","T (s)","|V| (m/s)","Kulka 2",new double[] {0},new double[] {0});
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
		LinkedList<Double> kulka2=new LinkedList<Double>();
		
		public MySwingWorker()
		{
			kulka2.add(getPredkoscKulka2());
		}		
		
		public Boolean doInBackground() throws Exception 
		{
			while (!isCancelled()) 
			{
				kulka2.add(getPredkoscKulka2());
				
				if (kulka2.size()>500) 
				{
					kulka2.removeFirst();
				}
    	  
				double[] array=new double[kulka2.size()];
				for (int i=0; i<kulka2.size(); i++) 
				{
					array[i]=kulka2.get(i);
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
 
			chart.updateXYSeries("Kulka 2",null,mostRecentDataSet,null);
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
	
	public double getPredkoscKulka2()
	{
		return Math.round(Math.sqrt(PanelRysowania.Kulka2.getVX()*PanelRysowania.Kulka2.getVX()+PanelRysowania.Kulka2.getVY()*PanelRysowania.Kulka2.getVY()));
	}
}