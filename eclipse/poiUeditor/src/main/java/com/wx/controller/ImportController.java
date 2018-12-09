package com.wx.controller;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wx.entity.Text;
import com.wx.service.TextService;
import com.wx.tools.StringUtil;

@Controller
public class ImportController {

	@Autowired
	private TextService textService;

	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String importExcel() {
		return "index/import";
	}

	@RequestMapping(value = "/import", method = RequestMethod.POST)
	@ResponseBody
	public String uploadExcel(HttpServletRequest request) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		InputStream inputStream = null;
		List<List<Object>> list = null;
		MultipartFile file = multipartRequest.getFile("filename");
		if (file.isEmpty()) {
			return "文件不能为空";
		}
		inputStream = file.getInputStream();
		list = textService.getBankListByExcel(inputStream, file.getOriginalFilename());
		inputStream.close();
		// 连接数据库部分
		for (int i = 1; i < list.size(); i++) {
			List<Object> lo = list.get(i);
			Text text = new Text();
			text.setLineName(lo.get(1).toString());
			text.setBranchLineName(lo.get(2).toString());
			text.setProjectName(lo.get(3).toString());
			text.setWorkContent(lo.get(4).toString());
			text.setTaskSource(lo.get(5).toString());
			text.setPlanningNature(lo.get(6).toString());
			text.setWorkType(lo.get(7).toString());
			text.setMajor(lo.get(8).toString());
			text.setWorkingGroup(lo.get(9).toString());
			text.setWorkingPlace(lo.get(10).toString());
			text.setPlannedBlackoutTime(lo.get(11).toString());
			text.setPlannedCommTime(lo.get(12).toString());
			text.setPlannedCompTime(lo.get(13).toString());
			text.setPlannedReply(lo.get(14).toString());
			text.setOperationMode(lo.get(15).toString());
			text.setPatrolCategory(lo.get(16).toString());
			text.setInspectionCategory(lo.get(17).toString());
			text.setVoltageGrade(lo.get(18).toString());
			text.setAcStopEquipment(lo.get(19).toString());
			text.setScopeOfInfluence(lo.get(20).toString());
			text.setInfluenceLoad(Double.parseDouble(lo.get(21).toString()));
			text.setInfluenceUsers(Integer.parseInt(lo.get(22).toString()));
			text.setInfluenceVariables(Integer.parseInt(lo.get(23).toString()));
			text.setImportantUser(lo.get(24).toString());
			text.setDurationTime(Double.parseDouble(lo.get(25).toString()));
			text.setTransferPowerSupply(lo.get(26).toString());
			text.setResponsibleUnit(lo.get(27).toString());
			text.setOperationUnit(lo.get(28).toString());
			text.setRiskLevel(lo.get(29).toString());
			text.setControlLevel(lo.get(30).toString());
			text.setControlMode(lo.get(31).toString());
			text.setAcceptanceLevel(lo.get(32).toString());
			text.setConstructionPlan(StringUtil.stringToByte(lo.get(33).toString().trim()));
			text.setWorkInstruction(StringUtil.stringToByte(lo.get(34).toString().trim()));
			text.setWorkTicket(StringUtil.stringToByte(lo.get(35).toString().trim()));
			text.setOperationTicket(StringUtil.stringToByte(lo.get(36).toString().trim()));
			text.setRecordForm(StringUtil.stringToByte(lo.get(37).toString().trim()));
			text.setRemarks(lo.get(38).toString());
			textService.save(text);
			// textService.add(text);
			// userMapper.insert(String.valueOf(lo.get(0)), String.valueOf(lo.get(1)),
			// String.valueOf(lo.get(2)));
			// 调用mapper中的insert方法
		}
		return "上传成功";
	}
}
