package com.lixin.dao.appservice;

import com.lixin.dao.impl.AdminDaoImpl;
import com.lixin.dao.interfaces.IDao;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class AppService {


    public  static void  main(String[]  args)
    {
        System.out.println("rmi的远程数据服务启动....");


        try {
            IDao dao = new AdminDaoImpl();

            LocateRegistry.createRegistry(8210);

            Naming.bind("rmi://127.0.0.1:8210/admindataservice",dao);


            System.out.println("rmi的远程数据服务发布成功");


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
