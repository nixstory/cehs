package com.jhomlala.catcher.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ReportLogController {

	@Autowired
	private ReportLogService reportLogService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String handleLog(Model model) {
		
		List<ReportLog> reportsCopied = new ArrayList<ReportLog>(reportLogService.getReportLogs());
		Collections.reverse(reportsCopied);
		model.addAttribute("reportLogs",reportsCopied);
		return "reports";
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void handleReportLog(@RequestBody ReportLog reportLog) {
		
		System.out.println(reportLog);
		reportLogService.addReportLog(reportLog);
	}

	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public String reportsPage(Model model) {
		List<ReportLog> reportsCopied = new ArrayList<ReportLog>(reportLogService.getReportLogs());
		Collections.reverse(reportsCopied);
		model.addAttribute("reportLogs",reportsCopied);
		return "reports";
	}

}
