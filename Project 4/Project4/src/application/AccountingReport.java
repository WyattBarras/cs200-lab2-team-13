package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class AccountingReport {

	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy");

	private static class Total {
		int consultations = 0;
		long cents = 0;
	}

	public static void runAccountingReport(ServiceRecordList records, ProviderList providers, ProviderDirectory provDir) {
		// Sorts providers by provider number
		Map<Integer, Total> byProvider = new TreeMap<>();

		for (ServiceRecord r : records.getRecords()) {
			Service service = provDir.getService(r.getServCode());
			Total t = byProvider.computeIfAbsent(r.getProvNum(), k -> new Total());
			t.consultations++;
			t.cents += Math.round(service.getServiceFee() * 100);
		}

		String today = LocalDate.now().format(DATE_FORMAT);
		
		int totalConsultations = 0;
		long totalCents = 0;
		String report = "ChocAn Accounting Report - " + today + "\n\n";

		for (Map.Entry<Integer, Total> entry : byProvider.entrySet()) {
			int provNum = entry.getKey();
			Total t = entry.getValue();

			String provName = "Unknown provider";
			for (Provider p : providers.providerList) {
				if (p.getNumber() == provNum) {
					provName = p.getName();
					break;
				}
			}
			
			report += provName + "   " + provNum + "   " + String.format("%d.%02d", t.cents / 100, t.cents % 100) + "\n";

			totalConsultations += t.consultations;
			totalCents += t.cents;
		}
		
		report += "Total Providers: " + byProvider.size() + "\n";
		report += "Total Consultations: " + totalConsultations + "\n";
		report += "Total Fee to be Paid: " + String.format("%d.%02d", totalCents / 100, totalCents % 100);
		
		writeFile("Accounting_Report_" + today + ".txt", report);
	}

	private static void writeFile(String filename, String contents) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
			out.write(contents);
			System.out.println("Wrote " + filename);
		} catch (IOException e) {
			System.out.println("Could not write " + filename);
			e.printStackTrace();
		}
	}
}