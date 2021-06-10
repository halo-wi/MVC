package com.kosta.sbproject.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kosta.sbproject.model.DeptVO;

public interface DeptVORepository extends CrudRepository<DeptVO, Integer>{
	
	public List<DeptVO> findByDepartmentName(String dname);
	
	@Query("select dept from DeptVO dept where departmentId>0 order by departmentId desc")
	public List<DeptVO> selectAll();

	@Query("select dept from DeptVO dept where departmentId>?1 order by departmentId desc")
	public List<DeptVO> selectById(int deptid);

	@Query("select dept from DeptVO dept where departmentId>:deptid order by departmentId desc")
	public List<DeptVO> selectById2(@Param("deptid") int id);

	@Query("select dept from #{#entityName} dept where departmentId>:deptid order by departmentId desc")
	public List<DeptVO> selectById3(@Param("deptid") int id);
	
	@Query(value="select * from tbl_dept where department_id>?1 order by 1 desc", nativeQuery = true)
	public List<DeptVO> selectById4(int deptid); 
	
}
