package org.study.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Repository
public class AccountDao {
	private JdbcTemplate template;
	@Resource(name="dataSource")
	protected void setDataSource(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	/**
	 * 转出
	 * @param out 由哪个账号转出
	 * @param money 转出多少钱
	 * @throws Exception
	 */
	public int updateForOut(final String out,final Double money) {
		String sql = "update account set money = money-? where name = ? and money >= ?";
		int count = template.update(sql,money,out,money);
		return count;
	}
	/**
	 * 转入
	 * @param in 转给谁
	 * @param money 转多少钱
	 * @throws Exception
	 */
	public int upateForIn(final String in,final Double money) {
		String sql = "update account set money = money+? where name = ?";
		int count = template.update(sql,money,in);
		return count;
	}
}
