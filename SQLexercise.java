/*public class SQLexercise {
}*/
/*创建一个学生表*/
create table student(
        stu_num int primary key,//学号作为主键
        name varchar(100),//姓名
        birthday Date,//出生年月
        sex varchar(20)//性别
        )
/*创建一个教室表*/
create table teacher(
        teacher_num int,//教师号
        teacher_name varchar(100)//姓名
        )
/*创建一个课程表*/
create table course(
        course_num int primary key,//课程号
        course_name varchar(100),//课程名
        tea_num,//教师号（外键）
        foreign key(tea_num) references teacher(teacher_num)//将tea_num作为外间与teacher表关联
        )
/*创建一个成绩表*/
create table score(
        s_num int,//学号（外键）
        c_num int,//课程号（外键）
        scores int,//成绩
        foreign key(s_num) references student(stu_num),//将s_num作为外键与学生表关联
        foreign key(c_num) references course(course_num)//将c_num作为外键与课程表关联
        )
/*输出各科课程号、最高成绩以及最低成绩*/
        select c_num,MAX(scores),MIN(scores) from score where c_num in(select c_num from score)
        -> group by c_num;
        /*用子类查询完成*/
/*查询学生总成绩进行排名*/
        select s_num,name,SUM(scores) from student,score//选取姓名，学号，成绩
        -> where s_num in(select s_num from score) and student.stu_num=score.s_num//用where筛选条件，并匹配学生表的名字和成绩表的学号
        -> group by s_num//按照学号排列
        -> order by SUM(scores) desc;//按照成绩总和降序排列
/*查询平均成绩大于60分的学生的学号和平均成绩*/
        select s_num,name,AVG(scores) from student,score
        -> where student.stu_num=score.s_num and s_num in(select s_num from score)
        -> group by stu_num
        -> having AVG(scores)>60//筛选60分以上的成绩
        -> order by AVG(scores);
/*需要注意的事项：
1.定义外键时需要将这个键与另一个表中的主键相关联，否则会关联失败
2.group by和where不能用于聚合函数
3.where用于group by前面而having用于group by后面
4.where，group by，having以及order语句中可以用各个列的简写，如定义 stu_num AS s，之后的语句就可以用s替换前者
5.order by 默认升序，desc可定义为降序，asc定义为升序
 */