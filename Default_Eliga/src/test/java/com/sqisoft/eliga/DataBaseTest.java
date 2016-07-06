package com.sqisoft.eliga;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sqisoft.eliga.sample.dao.SampleDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/context-*.xml"})
public class DataBaseTest {
	
	@Autowired private SampleDao dao;
	
	@Test
	public void exTest() {
		System.out.println("DataBaseTest.exTest()");
		System.out.println(dao.selectSampleQuery().getToday());
	}
	
}
