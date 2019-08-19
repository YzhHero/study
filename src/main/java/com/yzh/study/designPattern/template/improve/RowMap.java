package com.yzh.study.designPattern.template.improve;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMap<T> {
	public T processResult(ResultSet rs) throws SQLException;
}
