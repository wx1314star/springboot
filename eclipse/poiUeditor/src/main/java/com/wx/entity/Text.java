package com.wx.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "text")
public class Text {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "line_name")
	private String lineName;

	@Column(name = "branch_line_name")
	private String branchLineName;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "work_content")
	private String workContent;

	@Column(name = "task_source")
	private String taskSource;

	@Column(name = "planning_nature")
	private String planningNature;

	@Column(name = "work_type")
	private String workType;

	@Column(name = "major")
	private String major;

	@Column(name = "working_group")
	private String workingGroup;

	@Column(name = "working_place")
	private String workingPlace;

	@Column(name = "planned_blackout_time")
	private String plannedBlackoutTime;

	@Column(name = "planned_comm_time")
	private String plannedCommTime;

	@Column(name = "planned_comp_time")
	private String plannedCompTime;

	@Column(name = "planned_reply")
	private String plannedReply;

	@Column(name = "operation_mode")
	private String operationMode;

	@Column(name = "patrol_category")
	private String patrolCategory;

	@Column(name = "inspection_category")
	private String inspectionCategory;

	@Column(name = "voltage_grade")
	private String voltageGrade;

	@Column(name = "ac_stop_equipment")
	private String acStopEquipment;

	@Column(name = "scope_of_influence")
	private String scopeOfInfluence;

	@Column(name = "influence_load")
	private Double influenceLoad;

	@Column(name = "influence_users")
	private Integer influenceUsers;

	@Column(name = "influence_variables")
	private Integer influenceVariables;

	@Column(name = "important_user")
	private String importantUser;

	@Column(name = "duration_time")
	private Double durationTime;

	@Column(name = "transfer_power_supply")
	private String transferPowerSupply;

	@Column(name = "responsible_unit")
	private String responsibleUnit;

	@Column(name = "operation_unit")
	private String operationUnit;

	@Column(name = "risk_level")
	private String riskLevel;

	@Column(name = "control_level")
	private String controlLevel;

	@Column(name = "control_mode")
	private String controlMode;

	@Column(name = "acceptance_level")
	private String acceptanceLevel;

	@Column(name = "construction_plan")
	private Byte constructionPlan;

	@Column(name = "work_instruction")
	private Byte workInstruction;

	@Column(name = "work_ticket")
	private Byte workTicket;

	@Column(name = "operation_ticket")
	private Byte operationTicket;

	@Column(name = "record_form")
	private Byte recordForm;

	@Column(name = "remarks")
	private String remarks;

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return line_name
	 */
	public String getLineName() {
		return lineName;
	}

	/**
	 * @param lineName
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName == null ? null : lineName.trim();
	}

	/**
	 * @return branch_line_name
	 */
	public String getBranchLineName() {
		return branchLineName;
	}

	/**
	 * @param branchLineName
	 */
	public void setBranchLineName(String branchLineName) {
		this.branchLineName = branchLineName == null ? null : branchLineName.trim();
	}

	/**
	 * @return project_name
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName == null ? null : projectName.trim();
	}

	/**
	 * @return work_content
	 */
	public String getWorkContent() {
		return workContent;
	}

	/**
	 * @param workContent
	 */
	public void setWorkContent(String workContent) {
		this.workContent = workContent == null ? null : workContent.trim();
	}

	/**
	 * @return task_source
	 */
	public String getTaskSource() {
		return taskSource;
	}

	/**
	 * @param taskSource
	 */
	public void setTaskSource(String taskSource) {
		this.taskSource = taskSource == null ? null : taskSource.trim();
	}

	/**
	 * @return planning_nature
	 */
	public String getPlanningNature() {
		return planningNature;
	}

	/**
	 * @param planningNature
	 */
	public void setPlanningNature(String planningNature) {
		this.planningNature = planningNature == null ? null : planningNature.trim();
	}

	/**
	 * @return work_type
	 */
	public String getWorkType() {
		return workType;
	}

	/**
	 * @param workType
	 */
	public void setWorkType(String workType) {
		this.workType = workType == null ? null : workType.trim();
	}

	/**
	 * @return major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major
	 */
	public void setMajor(String major) {
		this.major = major == null ? null : major.trim();
	}

	/**
	 * @return working_group
	 */
	public String getWorkingGroup() {
		return workingGroup;
	}

	/**
	 * @param workingGroup
	 */
	public void setWorkingGroup(String workingGroup) {
		this.workingGroup = workingGroup == null ? null : workingGroup.trim();
	}

	/**
	 * @return working_place
	 */
	public String getWorkingPlace() {
		return workingPlace;
	}

	/**
	 * @param workingPlace
	 */
	public void setWorkingPlace(String workingPlace) {
		this.workingPlace = workingPlace == null ? null : workingPlace.trim();
	}

	/**
	 * @return planned_blackout_time
	 */
	public String getPlannedBlackoutTime() {
		return plannedBlackoutTime;
	}

	/**
	 * @param plannedBlackoutTime
	 */
	public void setPlannedBlackoutTime(String plannedBlackoutTime) {
		this.plannedBlackoutTime = plannedBlackoutTime;
	}

	/**
	 * @return planned_comm_time
	 */
	public String getPlannedCommTime() {
		return plannedCommTime;
	}

	/**
	 * @param plannedCommTime
	 */
	public void setPlannedCommTime(String plannedCommTime) {
		this.plannedCommTime = plannedCommTime;
	}

	/**
	 * @return planned_comp_time
	 */
	public String getPlannedCompTime() {
		return plannedCompTime;
	}

	/**
	 * @param plannedCompTime
	 */
	public void setPlannedCompTime(String plannedCompTime) {
		this.plannedCompTime = plannedCompTime;
	}

	/**
	 * @return planned_reply
	 */
	public String getPlannedReply() {
		return plannedReply;
	}

	/**
	 * @param plannedReply
	 */
	public void setPlannedReply(String plannedReply) {
		this.plannedReply = plannedReply;
	}

	/**
	 * @return operation_mode
	 */
	public String getOperationMode() {
		return operationMode;
	}

	/**
	 * @param operationMode
	 */
	public void setOperationMode(String operationMode) {
		this.operationMode = operationMode == null ? null : operationMode.trim();
	}

	/**
	 * @return patrol_category
	 */
	public String getPatrolCategory() {
		return patrolCategory;
	}

	/**
	 * @param patrolCategory
	 */
	public void setPatrolCategory(String patrolCategory) {
		this.patrolCategory = patrolCategory == null ? null : patrolCategory.trim();
	}

	/**
	 * @return inspection_category
	 */
	public String getInspectionCategory() {
		return inspectionCategory;
	}

	/**
	 * @param inspectionCategory
	 */
	public void setInspectionCategory(String inspectionCategory) {
		this.inspectionCategory = inspectionCategory == null ? null : inspectionCategory.trim();
	}

	/**
	 * @return voltage_grade
	 */
	public String getVoltageGrade() {
		return voltageGrade;
	}

	/**
	 * @param voltageGrade
	 */
	public void setVoltageGrade(String voltageGrade) {
		this.voltageGrade = voltageGrade == null ? null : voltageGrade.trim();
	}

	/**
	 * @return ac_stop_equipment
	 */
	public String getAcStopEquipment() {
		return acStopEquipment;
	}

	/**
	 * @param acStopEquipment
	 */
	public void setAcStopEquipment(String acStopEquipment) {
		this.acStopEquipment = acStopEquipment == null ? null : acStopEquipment.trim();
	}

	/**
	 * @return scope_of_influence
	 */
	public String getScopeOfInfluence() {
		return scopeOfInfluence;
	}

	/**
	 * @param scopeOfInfluence
	 */
	public void setScopeOfInfluence(String scopeOfInfluence) {
		this.scopeOfInfluence = scopeOfInfluence == null ? null : scopeOfInfluence.trim();
	}

	/**
	 * @return influence_load
	 */
	public Double getInfluenceLoad() {
		return influenceLoad;
	}

	/**
	 * @param influenceLoad
	 */
	public void setInfluenceLoad(Double influenceLoad) {
		this.influenceLoad = influenceLoad;
	}

	/**
	 * @return influence_users
	 */
	public Integer getInfluenceUsers() {
		return influenceUsers;
	}

	/**
	 * @param influenceUsers
	 */
	public void setInfluenceUsers(Integer influenceUsers) {
		this.influenceUsers = influenceUsers;
	}

	/**
	 * @return influence_variables
	 */
	public Integer getInfluenceVariables() {
		return influenceVariables;
	}

	/**
	 * @param influenceVariables
	 */
	public void setInfluenceVariables(Integer influenceVariables) {
		this.influenceVariables = influenceVariables;
	}

	/**
	 * @return important_user
	 */
	public String getImportantUser() {
		return importantUser;
	}

	/**
	 * @param importantUser
	 */
	public void setImportantUser(String importantUser) {
		this.importantUser = importantUser == null ? null : importantUser.trim();
	}

	/**
	 * @return duration_time
	 */
	public Double getDurationTime() {
		return durationTime;
	}

	/**
	 * @param durationTime
	 */
	public void setDurationTime(Double durationTime) {
		this.durationTime = durationTime;
	}

	/**
	 * @return transfer_power_supply
	 */
	public String getTransferPowerSupply() {
		return transferPowerSupply;
	}

	/**
	 * @param transferPowerSupply
	 */
	public void setTransferPowerSupply(String transferPowerSupply) {
		this.transferPowerSupply = transferPowerSupply == null ? null : transferPowerSupply.trim();
	}

	/**
	 * @return responsible_unit
	 */
	public String getResponsibleUnit() {
		return responsibleUnit;
	}

	/**
	 * @param responsibleUnit
	 */
	public void setResponsibleUnit(String responsibleUnit) {
		this.responsibleUnit = responsibleUnit == null ? null : responsibleUnit.trim();
	}

	/**
	 * @return operation_unit
	 */
	public String getOperationUnit() {
		return operationUnit;
	}

	/**
	 * @param operationUnit
	 */
	public void setOperationUnit(String operationUnit) {
		this.operationUnit = operationUnit == null ? null : operationUnit.trim();
	}

	/**
	 * @return risk_level
	 */
	public String getRiskLevel() {
		return riskLevel;
	}

	/**
	 * @param riskLevel
	 */
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel == null ? null : riskLevel.trim();
	}

	/**
	 * @return control_level
	 */
	public String getControlLevel() {
		return controlLevel;
	}

	/**
	 * @param controlLevel
	 */
	public void setControlLevel(String controlLevel) {
		this.controlLevel = controlLevel == null ? null : controlLevel.trim();
	}

	/**
	 * @return control_mode
	 */
	public String getControlMode() {
		return controlMode;
	}

	/**
	 * @param controlMode
	 */
	public void setControlMode(String controlMode) {
		this.controlMode = controlMode == null ? null : controlMode.trim();
	}

	/**
	 * @return acceptance_level
	 */
	public String getAcceptanceLevel() {
		return acceptanceLevel;
	}

	/**
	 * @param acceptanceLevel
	 */
	public void setAcceptanceLevel(String acceptanceLevel) {
		this.acceptanceLevel = acceptanceLevel == null ? null : acceptanceLevel.trim();
	}

	/**
	 * @return construction_plan
	 */
	public Byte getConstructionPlan() {
		return constructionPlan;
	}

	/**
	 * @param constructionPlan
	 */
	public void setConstructionPlan(Byte constructionPlan) {
		this.constructionPlan = constructionPlan;
	}

	/**
	 * @return work_instruction
	 */
	public Byte getWorkInstruction() {
		return workInstruction;
	}

	/**
	 * @param workInstruction
	 */
	public void setWorkInstruction(Byte workInstruction) {
		this.workInstruction = workInstruction;
	}

	/**
	 * @return work_ticket
	 */
	public Byte getWorkTicket() {
		return workTicket;
	}

	/**
	 * @param workTicket
	 */
	public void setWorkTicket(Byte workTicket) {
		this.workTicket = workTicket;
	}

	/**
	 * @return operation_ticket
	 */
	public Byte getOperationTicket() {
		return operationTicket;
	}

	/**
	 * @param operationTicket
	 */
	public void setOperationTicket(Byte operationTicket) {
		this.operationTicket = operationTicket;
	}

	/**
	 * @return record_form
	 */
	public Byte getRecordForm() {
		return recordForm;
	}

	/**
	 * @param recordForm
	 */
	public void setRecordForm(Byte recordForm) {
		this.recordForm = recordForm;
	}

	/**
	 * @return remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}
}