package com.bionic.edu.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.FishItem;
import com.bionic.edu.services.GeneralManagerService;

@Named("reportBean")
@Scope("session")
public class ReportBean implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private Map<java.sql.Date, Double> dd;
	private Map<String, Double> tt;
	private FishItem tempFish = null;
	private java.util.Date tempDate1 = null;
	private java.util.Date tempDate2 = null;

	private BarChartModel barModel;
	private PieChartModel pieModel;
	@Inject
	private GeneralManagerService generalManagerService;

	public FishItem getTempFish() {
		return tempFish;
	}

	public void setTempFish(FishItem tempFish) {
		this.tempFish = tempFish;
	}

	public java.util.Date getTempDate1() {
		return tempDate1;
	}

	public void setTempDate1(java.util.Date tempDate1) {
		this.tempDate1 = tempDate1;
	}

	public Map<String, Double> getTt() {
		return tt;
	}

	public void setTt(Map<String, Double> tt) {
		this.tt = tt;
	}

	public java.util.Date getTempDate2() {
		return tempDate2;
	}

	public void setTempDate2(java.util.Date tempDate2) {
		this.tempDate2 = tempDate2;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public Map<java.sql.Date, Double> getDd() {
		init();
		return dd;
	}

	public void setDd(Map<java.sql.Date, Double> dd) {
		this.dd = dd;
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	@PostConstruct
	public void init() {

	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries b = new ChartSeries();
		b.setLabel(tempFish.getFishName());
		for (Map.Entry<java.sql.Date, Double> entry : dd.entrySet()) {
			b.set(entry.getKey().toString(), entry.getValue());
		}

		model.addSeries(b);

		return model;
	}

	private void createBarModel() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		barModel = initBarModel();

		barModel.setTitle("Звіт по " + tempFish.getFishName()
				+ " за період від " + dateFormat.format(tempDate1) + " до "
				+ dateFormat.format(tempDate2));
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Дата");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Продана вага (т)");

	}

	public void getReport() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		java.sql.Date t1 = sqlDate(tempDate1);
		java.sql.Date t2 = sqlDate(tempDate2);
		dd = generalManagerService.getFishWeightReport(tempFish, t1, t2);
		if (!dd.isEmpty()) {
			createBarModel();
			RequestContext.getCurrentInstance().scrollTo(
					"reportWeightForm:chart");
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(
					":reportWeightForm:repGrowl",
					new FacesMessage("Увага", tempFish.getFishName()
							+ " не продавалась за період з "
							+ dateFormat.format(tempDate1) + " до "
							+ dateFormat.format(tempDate2)));
		}

	}

	public void getTotalReport() {
		tt = generalManagerService.getTotalFishReport(sqlDate(tempDate1),
				sqlDate(tempDate2));
		createPieModel();
		RequestContext.getCurrentInstance().scrollTo(
				"reportWeightForm:chart1");
	}

	public java.sql.Date sqlDate(java.util.Date calendarDate) {
		return new java.sql.Date(calendarDate.getTime());
	}

	public void dateChange1(SelectEvent event) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		java.util.Date date = (java.util.Date) event.getObject();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(":reportWeightForm:repGrowl",
				new FacesMessage("Увага", "Початкова дата встановлена "
						+ dateFormat.format(date)));
	}

	public void dateChange2(SelectEvent event) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		java.util.Date date = (java.util.Date) event.getObject();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(":reportWeightForm:repGrowl", new FacesMessage(
				"Увага", "кінцева дата встановлена " + dateFormat.format(date)));
	}

	private void createPieModel() {
		pieModel = new PieChartModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

		for (Map.Entry<String, Double> entry : tt.entrySet()) {
			pieModel.set(entry.getKey(), entry.getValue());
		}

		pieModel.setTitle("Вся продана риба за період від "+dateFormat.format(tempDate1)+" до "+dateFormat.format(tempDate2));
		pieModel.setLegendPosition("e");
		pieModel.setFill(true);
		pieModel.setShowDataLabels(true);
		pieModel.setDiameter(400);
	}
}
