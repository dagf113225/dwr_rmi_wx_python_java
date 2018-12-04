package com.lixin.dao.db;
import com.lixin.dao.model.TempMusic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DB {
    private Connection conn;

    // 连接数据库
    public DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wxnkj", "root", "123456");

            System.out.println("连接数据库:" + conn);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void   checkMusicAdd()
    {

        String sql = "SELECT   *  FROM  t_musictemp  WHERE state=1";

        TempMusic[]  tm= null;

        try {
         PreparedStatement  pstmt=   conn.prepareStatement(sql);

        ResultSet  rs= pstmt.executeQuery();

        int count=0;

        while(rs.next())
        {
            count++;
        }

         tm = new TempMusic[count];

        rs.beforeFirst();

        int  row=0;

        //查询state=1
        while(rs.next())
        {
            TempMusic  t = new TempMusic();
            t.setTid(rs.getInt(1));
            t.setTname(rs.getString(2));
            t.setTurl(rs.getString(3));
            t.setState(rs.getInt(4));

            tm[row++]=t;
        }

        //插入动作
            sql="INSERT INTO  t_musicinfo(tname,turl,ctime)  VALUES(?,?,NOW())";

          pstmt= conn.prepareStatement(sql);


         for(TempMusic  t:tm)
         {
             pstmt.setString(1,t.getTname());
             pstmt.setString(2,t.getTurl());
             pstmt.executeUpdate();
         }

         //删除审核通过数据
         sql="delete   from   t_musictemp  where state=1";
         pstmt= conn.prepareStatement(sql);

         pstmt.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Object[][]  getSwiperDatas()
    {
        String sql = "SELECT  *  FROM  t_swiperimg";

        Object[][] datas = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int column = rsmd.getColumnCount();

            int count = 0;

            while (rs.next()) {
                count++;
            }

            // 完成二维数组创建，实例化
            datas = new Object[count][column];

            // 结果集回到第一行
            rs.beforeFirst();

            int row = 0;

            while (rs.next())// 控制的是行
            {
                for (int i = 1; i <= column; i++)// 控制的是列
                {
                    datas[row][i - 1] = rs.getObject(i);
                }
                row++;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            if(null!=conn)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return datas;

    }

    public  int   updateSwiperState(String[]  indexs)
    {

        String sql="UPDATE t_swiperimg SET  state=1  WHERE sid=?";

        int count=0;

        try {
            PreparedStatement  pstmt=conn.prepareStatement(sql);

            for(String index:indexs)
            {
                pstmt.setString(1, index);
                count=pstmt.executeUpdate();
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            if(null!=conn)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return count;

    }



}