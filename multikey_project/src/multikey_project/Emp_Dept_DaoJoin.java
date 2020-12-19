package multikey_project;

import multikey_project.EmpDto;

import java.sql.SQLException;
import java.util.ArrayList;

import multikey_project.DeptDto;
import multikey_project.Emp_Dept_Dto;
public interface Emp_Dept_DaoJoin {

	  public ArrayList<Emp_Dept_Dto> getList()throws SQLException;
}