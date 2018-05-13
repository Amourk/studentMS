package cn.yy.test;

import cn.yy.service.administrator.ad_updata_informationService;
import cn.yy.dao.Administrator.ad_add_activityDao;
import cn.yy.dao.Administrator.ad_add_informationDao;
import cn.yy.dao.Administrator.ad_query_abnormalDao;
import cn.yy.dao.user.gradeDao;
import cn.yy.dao.user.loginDao;
import cn.yy.entity.abnormal;
import cn.yy.entity.accout;
import cn.yy.entity.student;
import cn.yy.entity.student_course;
import cn.yy.service.uers.abnormalService;
import cn.yy.service.uers.loginService;
import cn.yy.service.uers.queryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.*;

public class testlogin extends baseTest {
    @Autowired
    private loginDao loginDao;

    @Test
    public void testQueryById(){
//        int sid =2015170204;
//        student student = loginDao.login(sid);
//        System.out.print("密码是："+student.getStudentPassword());
    }
    @Autowired
    private loginService loginService;
    @Test
    public void testlogin(){
//        String sid = "201517020402";
        String sid = "administrator";
        accout s = loginService.login(sid);
        String name = s.getStudentPassword();
        System.out.print("心态炸了呀"+name);
    }
    @Autowired
    private queryService queryService;
    @Test
    public void  query()
    {
        String sname = "阳瑞";
        student student = queryService.queryByName(sname);
        String name = student.getStudentPassword();
        System.out.print("心态炸了呀"+name);

    }
    @Test
    public void resulte()
    {
        String sid = "201517020402";
        List<student_course> list = queryService.queryResult(sid);


        for (int i=0;i<list.size();i++ )
        {
            System.out.printf("成绩是："+list.get(i));
        }
        float j = 1;
        float i = 5;
        float k = (float) ((float) (j*0.2)+i*0.8);

    }

    @Test
    public void string()
    {
        String html[] = new String[10];

        for (int i = 0 ; i<2; i++)
        {
            String htm = "                    <tr>\n" +
                    "                        <td colspan=\"2\">"+i+ "</td>\n" +
                    "                        <td>"+i+"</td>\n" +
                    "                        <td>"+i+"</td>\n" +
                    "                    </tr>";

            html[i]=htm;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < html.length; i++){
            sb. append(html[i]);
        }
        String s = sb.toString();
        System.out.printf(s);

    }
    @Autowired
    private abnormalService abnormalService;
    @Test
    public void add()
    {
        String id = "201517020402";
        String thing = "我错了";
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(df.format(day));
        abnormalService.addAbnormal(id, thing, df.format(day),"asda");

    }

    @Autowired
    private gradeDao gradeDao;

    @Test
    public void selectid()
    {
        student student ;
        String s = "软件工程";
        List<student> list = queryService.queryId(s);
        List<String> id =new ArrayList();
        List<Float> test = new ArrayList<Float>();
        for (int i = 0;i<list.size();i++)
        {
            String sid = list.get(i).getStudentId();
            id.add(sid);
        }
        for (int i =0;i<id.size();i++)
        {
//            gradeDao.selectGrade(id.get(i)).getStudentTest();
            test.add( gradeDao.selectGrade(id.get(i)).getStudentTest());
//            System.out.printf("aaaaaaaa"+gradeDao.selectGrade(id.get(i)).getStudentTest());
        }
        for (int i = 0;i<test.size();i++)
        {
            System.out.printf(test.get(i)+"");
        }
        Collections.reverse(test);

        for (int i = 0;i<test.size();i++)
        {
            System.out.printf("aaaa"+test.get(i)+"");
        }

    }
    @Autowired
    private ad_add_informationDao ad_add_information;
    @Test
    public void add_information()
    {
        String sid = "201517010225";
        String sname = "花花";
        String ssex = "女";
        String sdepartment = "计算机科学技术";
        String sclass = "15-2";
        String splace = "天津";
//        ad_add_information.addInformation(sid,sname,ssex,sdepartment,sclass,splace);
    }

    @Autowired
    private ad_query_abnormalDao ad_query_abnormalDao;
    @Test
    public void query_abnormal()
    {
       List<abnormal> list = ad_query_abnormalDao.queryAbnormal();
       for (int i =0;i<list.size();i++)
       {
           String sid = list.get(i).getStudentId();
           System.out.printf("aaaa"+sid);
       }
    }
    @Autowired
    private ad_add_activityDao ad_add_activityDao;
    @Test
    public void add_activity()
    {
        String id = "201517020403";
        String activity="参加运动会";
        float zcf = 1;
        float cxf = (float) 0.1;

        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        System.out.println(df.format(day));

        long r1 = System.currentTimeMillis();
        //返回带正号的 double 值，大于或等于 0.0，小于 1.0。
        double r2 = Math.random();
        //通过Random类来获取下一个随机的整数
        int r3 = new Random().nextInt();
        String aid = r3+"";
        ad_add_activityDao.addActivity(id,zcf,cxf,activity,df.format(day),aid);
    }
    @Test
    public void contains()
    {
         List<String> list = new ArrayList();
         list.add("2015");
         list.add("2016");
         list.add("2017");
         System.out.printf("aaaa"+list.contains("2018"));
//         list.contains("2016");
    }

    @Autowired
    private ad_updata_informationService ad_updata_informationService;
    @Test
    public void updata()
    {
        String id = "201517020402";
        String sname = "花花";
        String ssex = "女";
        String sdepartment = "计算机科学技术";
        String sclass = "15-2";
        String splace = "天津";
        String bir = "1997-5-19";
        String in = "2015-9-1";
        ad_updata_informationService.updata(id,sname,ssex,sdepartment,sclass,splace,bir,in);

    }

    @Test
    public void comper()
    {
        List<String> id = new ArrayList<String>();
        id.add("1");
        id.add("2");
        id.add("3");
        id.add("4");
        id.add("5");
        List<Float> test = new ArrayList<Float>();
        test.add((float) 25);
        test.add((float) 95);
        test.add((float) 55);
        test.add((float) 45);
        test.add((float) 5);
        List<Map<String,Float>> list = new ArrayList<Map<String, Float>>();
//        Map<String,Float> map = new HashMap<String, Float>();
        for (int i=0;i<id.size();i++)
        {
            Map<String,Float> map = new HashMap<String, Float>();
            map.put(id.get(i),test.get(i));
            list.add(map);
        }
        System.out.println("aaaaaaaaaaaa"+list.get(1).get(id.get(1)));

//        List<Float> list = new ArrayList();
//        list.add((float) 65);
//        list.add((float) 25);
//        list.add((float) 96);
//        list.add((float) 25);
//        list.add((float) 99);
//        list.add((float) 9);
        //对list遍历
        //以这个为准
        for(int i=0;i<list.size();i++){
            int min=i;//记录list剩余列表中的最小值的下标
            for(int j=i; j<list.size(); j++){
                float a= list.get(min).get(id.get(min));
                float b= list.get(j).get(id.get(j));
                if (a>b){
                    min=j;
                }
//                if(list.get(min).get(id.get(min))>list.get(j).get(id.get(j))){
//                    min=j;
//                }
            }
            Map minValue=list.get(min);//记录最小值
            //当前元素和最小值交换位置
            list.set(min,list.get(i));
            list.set(i,minValue);
        }
        for (int i =0;i<list.size();i++)
        {
            System.out.println("aaaaaaaa"+list.get(i).get(i));
        }
    }



}
