package multikey_project;

public class Emp_Dept_Dto {
  
	private EmpDto empDto;
	private DeptDto deptDto;
	
	
	public EmpDto getEmpDto() {
		if(empDto == null) {
			empDto = new EmpDto();
		}
		return empDto;
	}
	public void setEmpDto(EmpDto empDto) {
		this.empDto = empDto;
	}
	public DeptDto getDeptDto() {
		if(deptDto == null) {
			deptDto = new DeptDto();			
		}
		return deptDto;
	}
	public void setDeptDto(DeptDto deptDto) {
		this.deptDto = deptDto;
	}
}
