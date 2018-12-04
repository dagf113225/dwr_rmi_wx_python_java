import   pymysql


#优化连接数据库代码
def   connDB():
      conn = pymysql.connect(host="127.0.0.1", port=3306, database="wxnkj", user="root", password="123456",charset="utf8")
      return  conn


def getSwiperInfo():
    conn = connDB()
    dbcursor = conn.cursor()

    sql = 'SELECT  surl  FROM  t_swiperimg  WHERE state=1 '

    dbcursor.execute(sql)

    datas = dbcursor.fetchall()
    print(datas)

    return datas

def getMusicInfo():
    conn = connDB()
    dbcursor = conn.cursor()

    sql = "SELECT  *  FROM  t_musicinfo  WHERE DATE_FORMAT(ctime,'%Y-%m-%d')=DATE_FORMAT(NOW(),'%Y-%m-%d')"

    dbcursor.execute(sql)

    datas = dbcursor.fetchall()
    print(datas)

    return datas

