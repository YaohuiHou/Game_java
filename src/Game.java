import java.util.Scanner;

public class Game {
    //属性：
    static int role1=0;
    static int role2=0;
    static int random1=0;
    static int random2=0;
    static String name_role1="";
    static String name_role2="";
    static String ori_map = "@@－－－－★¤－－■－－－★－－－★－－〓－－¤－〓－■－－－－－★－－－－★－¤－－－－〓－－－－★－－－－¤－－－－■－－〓★－－－－－－－－－★■－－〓－〓－－－－¤－－★－－－－－－－〓－－¤";

    //入口
    public static void main(String args[]) {
        Welcome(role1,role2);
        SwitchRole();
        StartingGame(name_role1,name_role2);
        System.out.println("");

        //打印地图
        Print ori = new Print();
        ori.HelpinMap();
        ori.PrintMap(ori_map,role1,role2);
        ori.Move();
    }

    static void SwitchRole(){
        switch (role1){
            case 1: name_role1="戴高乐";
                break;
            case 2: name_role1="艾森豪威尔";
                break;
            case 3: name_role1="麦克阿瑟";
                break;
            case 4: name_role1="巴顿";
                break;
        }
        switch (role2){
            case 1: name_role2="戴高乐";
                break;
            case 2: name_role2="艾森豪威尔";
                break;
            case 3: name_role2="麦克阿瑟";
                break;
            case 4: name_role2="巴顿";
                break;
        }

    }

    static void Welcome(int role1_,int role2_){
        System.out.println("**************************************************************\n" +
                "*                                                            *\n" +
                "*                                                            *\n" +
                "*                         骑士飞行棋                         *\n" +
                "*                                                            *\n" +
                "*                                                            *\n" +
                "**************************************************************\n" +
                "\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~两  人  对  战~~~~~~~~~~~~~~~~~~~~~~~~");
        /*
        System.out.println("*           骑士飞行棋           *");
        System.out.println("********************************\n");
        System.out.println("~~~~~~两人对战~~~~~~~~~~~~~~~~~~~");
        */
        System.out.println("请选择角色:1.戴高乐 2.艾森豪威尔 3.麦克阿瑟 4.巴顿");
        Scanner input = new Scanner(System.in);
        System.out.print("请玩家1选择角色：");
        role1_ = input.nextInt();
        role1=role1_;
        System.out.print("请玩家2选择角色：");
        role2_ = input.nextInt();
        for (; role1_ == role2_; ) {
            System.out.print("不能选择" + role1_ + "号角色，因为玩家一已经选择该角色,请从新选择角色:");
            role2_ = input.nextInt();
        }
        role2=role2_;
    }
    static void StartingGame(String name_role1_,String name_role2_){
        System.out.print("**************************************************************\n" +
                "*                        Game Start                          *\n" +
                "**************************************************************\n");
        System.out.println("^_^"+name_role1_+"的士兵：　A");
        System.out.println("^_^"+name_role2_+"的士兵：　B");

    }

}

class Print{
    void PrintMap(String ori_map_,int role1_,int role2_) {
        for (int i = 0; i < 32; i++) {
            System.out.print("" + ori_map_.charAt(i));
        }
        System.out.println("");
        for (int i = 32; i < 36; i++)
            System.out.println("                                                " + ori_map_.charAt(i));
        for (int i = 66; i >= 36; i--) {
            System.out.print("" + ori_map_.charAt(i));
        }
        System.out.println("");
        for (int i = 67; i < 70; i++) System.out.println("" + ori_map_.charAt(i));
        for (int i = 70; i < ori_map_.length(); i++) {
            System.out.print("" + ori_map_.charAt(i));
        }
        System.out.println("");
    }

    void HelpinMap(){
        System.out.println("图例说明：\n" +
                "@@ 起点; ■ 暂停; ¤ 幸运轮盘; ★ 地雷; 〓 时空隧道; － 普通\n" +
                "\n" +
                "地图如下：");
    }
    void Move(){
        System.out.println(Game.name_role1+", 请您按任意字母键后回车启动掷骰子：");
        Scanner reader=new Scanner(System.in);
            Game.random1=(int)Math.random()*100%5+1;
    }
}


