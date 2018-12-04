package com.lixin.dao.impl;

import com.lixin.dao.db.DB;
import com.lixin.dao.interfaces.IDao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdminDaoImpl  extends UnicastRemoteObject implements IDao {


    public  AdminDaoImpl() throws RemoteException {
    }

    @Override
    public Object[][] getSwiperDatas() throws RemoteException {

        System.out.println("AdminDaoImpl  is  getSwiperDatas  start... ");

        DB db  = new DB();

        return db.getSwiperDatas();
    }

    @Override
    public int updateSwiperState(String[] indexs) throws RemoteException {
        System.out.println("AdminDaoImpl  is  updateSwiperState  start... ");

        DB db  =new DB();

       int  count= db.updateSwiperState(indexs);


        return count;
    }

    @Override
    public void  checkMusicAdd() throws RemoteException {
        System.out.println("AdminDaoImpl  is  checkMusicAdd  start... ");


        DB  db  = new DB();

        db.checkMusicAdd();

    }
}
