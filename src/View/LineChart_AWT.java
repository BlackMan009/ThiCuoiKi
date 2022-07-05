package View;
import org.jfree.chart.ChartPanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import Controller.ConnectDB;
import Model.Statistical;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends JFrame {
   
	private String ghichu = "bệnh nhân";
	
   public LineChart_AWT( String applicationTitle , String chartTitle ) {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Tháng/Năm","Số bệnh nhân",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel ); 
   }

   
   private CategoryDataset createDataset() {
		Connection conn = null;
		PreparedStatement sttm = null;
		ResultSet rst = null;
		try {
			String sSQL = "select month(Dayin) as 'month',year(dayin) as 'year',count(*) as 'soluong' from danhSach group by year(dayin),month(dayin)";
			conn = ConnectDB.openConnection();
			sttm = conn.prepareStatement(sSQL);
			rst = sttm.executeQuery();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		try {
			while (rst.next()) {
				Statistical tk = new Statistical();
				String month = rst.getString("month");
				String year = rst.getString("year");
				String year_month = year + "-" + month;
				tk.setSoluong(rst.getInt("soluong"));
				dataset.addValue(tk.getSoluong(), ghichu, year_month);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataset;
	}
   
   public static void main(String[] args) {
	   try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			LineChart_AWT chart = new LineChart_AWT("Thống kê", "Thống kê số bệnh nhân nội trú trong tháng");
			chart.pack();
			RefineryUtilities.centerFrameOnScreen(chart);
			chart.setVisible(true);
		} catch (Exception e1) {
		}
}
}