package com.settings.svce;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.core.parameters.Params;
import com.settings.dao.MenuDao;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Resource(name="menuDao")
	private MenuDao menuDao;
	
	@Override
	public List<Map<String, Object>> getSidebarMenu() throws Exception{
		return menuDao.getSidebarMenu();
	}
	
	@Override
	public void modifyMenu(Params inParams) throws Exception{
		System.out.println("modifyProgram :" + inParams);
		
		
		String flag = null;
		flag = inParams.getString("flag");
		
		if(flag.equals("insert")) {
			menuDao.insertMenu(inParams);
		}else if(flag.equals("modify")) {
			menuDao.updateMenu(inParams);
		}else if(flag.equals("delete")) {
			menuDao.deleteMenu(inParams);
		}
	};
	
}
