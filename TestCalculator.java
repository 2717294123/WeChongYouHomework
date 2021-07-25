package testCalculator;

import java.util.Scanner;
public class TestCalculator {
    public static void main(String[] args){
        Calculator calculator=new Calculator();
        calculator.start();
    }
}

//
class Calculator{
    double number1;//数字键1
    double number2;//数字键2
    double result;//结果
    char sign;//运算符键
    boolean reset=true;//复位键
    //构造方法
    Calculator(){}
    //读键盘数据
    void readNumber(){
        Scanner sc1=new Scanner(System.in);
        number1=sc1.nextDouble();
        sign=sc1.next().charAt(0);
        number2=sc1.nextDouble();
    }
    //实现计算方法
    double calculate(){
        if(sign=='+'){
            result=number1+number2;
        }else if(sign=='-'){
            result=number1-number2;
        }else if(sign=='*'){
            result=number1*number2;
        }else{
            result=number1/number2;
        }
        return result;
    }
    //计算器有展示结果的方法
    void showResult(){
        System.out.println(result);
    }
    //退出方法
    void esc(){
        System.out.println("是否继续?");
        Scanner sc2=new Scanner(System.in);
        String str=sc2.next();
        if(str.equals("是")){
            reset=true;
        }else if(str.equals("否")){
            reset=false;
            System.out.println("退出");
        }else{
            System.out.println("输入有误，请重新输入");
        }
    }
    //开始计算
    void start(){
        while(reset){
            System.out.println("请输入需要计算的数字和符号");
            readNumber();
            calculate();
            showResult();
            esc();

        }

    }
}