package com.example.my_dentaku;

import java.math.BigDecimal;

public class iBOX {

    private BigDecimal box=new BigDecimal("0"); //  初期値 : 0

    private String state="nutral";
//---ジャッジメソッド → 直前に押されたボタン　[+,-,*,/]　を判定,    ~stateを用いて~
    private void judge(String status, String s){
        BigDecimal keep=new BigDecimal(s);
        switch(status){
            case "nutral":
                this.box=keep;
                break;
            case "keep+":
                this.box=box.add(keep);
                break;
            case "keep-":
                this.box=box.subtract(keep);
                break;
            case "keep*":
                this.box=box.multiply(keep);
                break;
            case "keep/":
                this.box=box.divide(keep,10,BigDecimal.ROUND_HALF_UP);
                break;
        }
    }
//(四則計算)---------------------------------------
    public void tasi_zan(String txNum){//   +
        this.judge(this.state,txNum);
        this.state="keep+";
    }
    public void hiki_zan(String txNum){//   -
        this.judge(this.state,txNum);
        this.state="keep-";
    }
   public void kake_zan(String txNum) {//   ×
        this.judge(this.state,txNum);
        this.state="keep*";
    }
   public void wari_zan(String txNum){ //   ÷
        this.judge(this.state,txNum);
        this.state="keep/";
    }
   public String equal(String txNum){  //   =
        this.judge(this.state,txNum);
        this.state="nutral";
        return box.toString();
   }

//(コマンド)--------------------------------------

    public void changeState(String state){this.state=state;}
    public void xx(String txNum){
        if(this.state.equals("nutral")){
            BigDecimal x=new BigDecimal(txNum);
            this.box=x;
            box=box.multiply(x);
        }
    }
    public BigDecimal getResult(){return box;}

    public void allClear(){
        this.state="nutral";
        this.box=this.box.ZERO;
    }
}
