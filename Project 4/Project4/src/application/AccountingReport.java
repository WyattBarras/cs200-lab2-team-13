package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class AccountingReport {

	// Standard date formatting for output
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy");

	// Total class to track total consultations/fees 
	private static class Total {
		int consultations = 0;
		long cents = 0;
	}

	public static void runAccountingReport(ServiceRecordList records, ProviderList providers, ProviderDirectory provDir) {
		// TreeMap allows for sorting providers by provider number
		Map<Integer, Total> byProvider = new TreeMap<>();

		// For each service record, map provider number to total, adding new keys/Totals if the provider number is not already in map
		// Update the relevant Total by incrementing consultations and adding the fee from the relevant Service
		for (ServiceRecord r : records.getRecords()) {
			Service service = provDir.getService(r.getServCode());
			Total t = byProvider.computeIfAbsent(r.getProvNum(), k -> new Total());
			t.consultations++;
			t.cents += Math.round(service.getServiceFee() * 100);
		}

		// Today string for later use
		String today = LocalDate.now().format(DATE_FORMAT);
		
		// Overall total variables and report string
		int totalConsultations = 0;
		long totalCents = 0;
		String report = "ChocAn Accounting Report - " + today + "\n\n";

		/* 
		 * For each entry in the map, get the name of the relevant provider.
		 * Add that name, provider number, and Total (formatted) to report string
		 * Increment overall total variables
		*/ 
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
		
		// Add final totals to report string
		report += "Total Providers: " + byProvider.size() + "\n";
		report += "Total Consultations: " + totalConsultations + "\n";
		report += "Total Fee to be Paid: " + String.format("%d.%02d", totalCents / 100, totalCents % 100);
		
		// self-contained writeFile(), report string going to customized date-based file
		writeFile("Accounting_Report_" + today + ".txt", report);
	}

	// Same as in Terminal.java
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