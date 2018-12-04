package com.lixin.admin.task;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.TimerTask;

import com.lixin.dao.interfaces.IDao;

public class UserTask extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("UserTask  is  run  start...," + new Date());

		try {
			IDao dao = (IDao) Naming.lookup("rmi://127.0.0.1:8210/admindataservice");

			//查询审核通过的音乐，把审核通过的音乐插入到正式发布的音乐表中
			dao.checkMusicAdd();

			
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

	}

}
