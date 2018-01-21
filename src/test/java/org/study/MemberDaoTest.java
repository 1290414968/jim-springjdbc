package org.study;

import com.alibaba.fastjson.JSON;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.study.demo.dao.MemberDao;
import org.study.demo.entity.Member;

import java.util.List;

@ContextConfiguration(locations = {"classpath*:application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberDaoTest {
	@Autowired
	MemberDao memberDao;
	
	@Test
	@Ignore
	public void testSelectByName(){
		try {
			List<Member> r = memberDao.selectByName("cc");
			System.out.println(JSON.toJSON(r));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void testSelectAll(){
		try {
			System.out.println("-------" + JSON.toJSONString(memberDao.selectAll()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void testInsertOne(){
		try {
			Member data = new Member();
			data.setName("cc2");
			boolean r = memberDao.insterOne(data);
			if(r){
				System.out.println(data.getId());
			}else{
				System.out.println("失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
//	@Ignore
	public void testUpdate(){
		try {
			Member data = new Member();
			data.setId(2L);
			data.setName("张无忌");
			boolean r = memberDao.updataOne(data);
			System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	@Ignore
	public void testDelete(){
		try {
			Member data = new Member();
			data.setId(6L);
			boolean r = memberDao.deleteOne(data);
			System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
