package com.example.my_dentaku;

import java.math.BigDecimal;

public class Memo {

    private BigDecimal memo=new BigDecimal("0");//  初期値 : 0

    public void plusMemo(String s){          //  足算
       BigDecimal plusmemo=new BigDecimal(s);
       this.memo=memo.add(plusmemo);
    }

    public void minusMemo(String s){         //  引算
        BigDecimal minusmemo=new BigDecimal(s);
        this.memo=memo.subtract(minusmemo);
    }



    public void clearMemo(){  //  メモを初期値(0)へ
        this.memo=this.memo.ZERO;
    }

    public String getMemo(){return this.memo.toString();}
}
