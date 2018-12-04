
SELECT   * FROM  t_swiperimg


-- 创建一个音乐列表 当天

-- 1分钟以后换一批
-- 临时音乐表 A表  人工审核 

-- 上传--->人工审核过的数据---通过
--  select 0--insert --delete 
CREATE TABLE t_musictemp
(
  
   tid  INT   PRIMARY KEY  AUTO_INCREMENT,
   tname VARCHAR(20),
   turl  VARCHAR(100),
   state   INT  

)
SELECT   *  FROM  t_musictemp  WHERE state=1;


INSERT INTO  t_musictemp(tname,turl,state) 
VALUES('歌曲88','/music/88.mp3',1);
INSERT INTO  t_musictemp(tname,turl,state) 
VALUES('歌曲99','/music/99.mp3',1);


INSERT INTO  t_musicinfo(tname,turl,ctime) VALUES(?,?,NOW())


-- 正式发布的表
CREATE  TABLE  t_musicinfo
(
   tid  INT   PRIMARY KEY  AUTO_INCREMENT,
   tname VARCHAR(20),
   turl  VARCHAR(100),
   ctime  DATETIME  
)

SELECT  *  FROM  t_musicinfo

SELECT  *  FROM  t_musicinfo  WHERE DATE_FORMAT(ctime,'%Y-%m-%d')
=DATE_FORMAT(NOW(),'%Y-%m-%d');

-- A-B表

