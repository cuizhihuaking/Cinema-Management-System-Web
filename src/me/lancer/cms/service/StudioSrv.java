package me.lancer.cms.service;

import java.util.List;
import java.util.Map;

import me.lancer.cms.idao.DAOFactory;
import me.lancer.cms.idao.iStudioDAO;
import me.lancer.cms.model.Employee;
import me.lancer.cms.model.Studio;

public class StudioSrv {

	private iStudioDAO stuDAO = DAOFactory.creatStudioDAO();

	public int add(Studio stu) {
		return stuDAO.insert(stu);
	}

	public int modify(Studio stu) {
		return stuDAO.update(stu);
	}

	public int delete(int ID) {
		return stuDAO.delete(ID);
	}

	public List<Studio> Fetch(String condt) {
		return stuDAO.select(condt);
	}
	
	public List<Studio> Fetch_(Map<String, String> map) {
		return stuDAO.select_(map);
	}

	public List<Studio> FetchAll() {
		return stuDAO.select("");
	}

	public int createSeats(Studio stu) {
		if (stu.getStudioFlag() == 0) {
			return stuDAO.createSeats(stu);
		}
		return -1;
	}
	
	public List<Studio> FetchByPage(int start, int size) {
		return stuDAO.select("limit "+start+","+size);
	}
}
