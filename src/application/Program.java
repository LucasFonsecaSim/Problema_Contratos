package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		/* / Iniciando a forma da data do programa. / */
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		/* / Guardando os dados. / */
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();
		
		/* / Instanciando a classe Worker com a Department. / */
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));
		
		/* / Decidindo a quantidade de contratos. / */
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();

		/* / Estrutura de repetição para alocar n quantidades de contratos. / */
		for (int i = 0; i < n; i++) {
			System.out.println("Enter contract #" + (i + 1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			/* / Intanciando e alocando os dados na lista. / */
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		/* / Definindo a data que será revisado os contratos. / */
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		/* / Prints com informações do funcionário, o departamento, e o salario com o mes e ano junto o salario base. / */
		System.out.println("name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.print("Income for: " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

		sc.close();
	}

}
/* /  / */