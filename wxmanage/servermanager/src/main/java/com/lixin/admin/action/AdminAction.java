package com.lixin.admin.action;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Timer;

import com.lixin.admin.task.UserTask;
import com.lixin.dao.interfaces.IDao;

public class AdminAction {

	public Object[][] getActionSwiperDatas() {
		System.out.println("AdminAction  is   getActionSwiperDatas  start...");

		Object[][] datas = null;
		// DB db = new DB();
		// Object[][] datas = db.getSwiperDatas();

		try {
			IDao dao = (IDao) Naming.lookup("rmi://127.0.0.1:8210/admindataservice");

			datas = dao.getSwiperDatas();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datas;

	}

	public String updateSelectSwiperValue(String value) {
		System.out.println("AdminAction  is   updateSelectSwiperValue  start...");

		System.out.println("value-->" + value);

		String[] strs = value.split(",");

		int count = 0;

		try {
			IDao dao = (IDao) Naming.lookup("rmi://127.0.0.1:8210/admindataservice");

			count = dao.updateSwiperState(strs);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		for(String  s:strs)
//		{
//			System.out.println("s-->"+s);
//		}

		// DB db = new DB();
		// int count = db.updateSwiperState(strs);

		// System.out.println("启用数量:"+count);

		return count + "";

	}

	public void checkMusicAdd() {
		System.out.println("AdminAction  is   checkMusicAdd  start...");

		// 建立定时器
		Timer t = new Timer();

		// 调度定时线程 延时3秒，间隔15秒
		t.schedule(new UserTask(), 3000, 30000);



	}

}
