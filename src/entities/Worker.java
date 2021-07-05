package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

/* / Classe funcion�rio. / */
public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	/* / Instanciando a variavel concatenando com a classe Department, e a lista de contratos com a classe HourContract. / */
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	/* / Construtores. / */
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
	/* / Fun��es gets e sets. / */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	/* / F. para adicionar o contrato na lista do funcion�rio. / */
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	/* / F. para remover o contrato na lista do funcion�rio. / */
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	/* / F. onde verifica o mes e o ano e passa o total ganho nesse periodo junto com o salario base do funcion�rio. / */
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();

		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);

			if (year == c_year && month == c_month) {

				sum += c.totalValue();
			}
		}
		return sum;
	}

}
