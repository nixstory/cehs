package com.jhomlala.catcher.backend;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ReportLogService {

	private List<ReportLog> reportLogs = new ArrayList<ReportLog>();
	
	public void addReportLog(ReportLog log) {
		reportLogs.add(log);
	}
	
	public List<ReportLog> getReportLogs() {
		
//		for (int i=0;i<5;i++) {
//			reportLogs.add(makeReport());
//		}
		
		return reportLogs;
	}
	
	private ReportLog makeReport () {
		ReportLog reportLog = new ReportLog();
		reportLog.setError("NoSuchMethodError: Class 'bool' has no instance method '+'. Receiver: true Tried calling: +(1)");
		reportLog.setStackTrace("#0 Object.noSuchMethod (dart:core-patch/object_patch.dart:54:5)");
			
		Map<String,String> applicationParameters = new HashMap<>();
		applicationParameters.put("packageName", "io.dubhe.cehs");
		applicationParameters.put("version", "1.0.0");
		reportLog.setApplicationParameters(applicationParameters);

		Map<String,String> deviceParameters = new HashMap<>();
		deviceParameters.put("model", "iPhone");
		reportLog.setDeviceParameters(deviceParameters);
		
		reportLog.setDateTime(new Timestamp(System.currentTimeMillis()));
		
		return reportLog;
		
	}
	
}
