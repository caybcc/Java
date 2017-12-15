package com.cyc.jdbc.dao.refactor;

import java.sql.ResultSet;

public interface RowMapper {
	public Object mapRow(ResultSet rs);
}
