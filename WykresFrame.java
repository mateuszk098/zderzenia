package projektV6;

import javax.swing.*;

import java.util.LinkedList;
import java.util.List;
 
import javax.swing.SwingWorker;
 
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class WykresFrame extends JFrame
{
	MySwingWorker mySwingWorker=new MySwingWorker();
	XYChart chart=QuickChart.getChart("","Czas","Predkosc (m/s)","Kulki",new double[] {0},new double[] {0});

	SwingWrapper<XYChart> sw=new SwingWrapper<XYChart>(chart);
	
	public void go() 
	{
		chart.getStyler().setLegendVisible(false);
		chart.getStyler().setXAxisTicksVisible(false);
		chart.addSeries("Kulka 1",new double[] {0});
		chart.addSeries("Kulka 2",new double[] {0});
	  	sw.displayChart();
	  	mySwingWorker.execute();
	}
	
	public class MySwingWorker extends SwingWorker <Boolean,double[]> 
	{
		LinkedList<Double> kulka1=new LinkedList<Double>();
		LinkedList<Double> kulka2=new LinkedList<Double>();
		
		public MySwingWorker()
		{
			kulka1.add(PanelRysowania.Kulka1.getVX());
			kulka2.add(PanelRysowania.Kulka2.getVX());
		}
			
	public Boolean doInBackground() throws Exception 
	{
		while (!isCancelled()) 
		{
			kulka1.add(PanelRysowania.Kulka1.getVX());
			kulka2.add(PanelRysowania.Kulka2.getVX());
			
			if (kulka1.size()>500) 
			{
				kulka1.removeFirst();
			}
			
			if (kulka2.size()>500) 
			{
				kulka2.removeFirst();
			}
    	  
			double[] array=new double[kulka1.size()];
			for (int i=0; i<kulka1.size(); i++) 
			{
				array[i]=kulka1.get(i);
			}
			publish(array);

			double[] array1=new double[kulka2.size()];
			for (int i=0; i<kulka2.size(); i++) 
			{
				array1[i]=kulka2.get(i);
			}
			publish(array1);
			
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
}


