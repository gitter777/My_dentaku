package com.example.my_dentaku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String txNumber="0"; //表示用の数値
    String mathMode="N"; //計算のモード（通常のニュートラル　or calモード）

    iBOX box=new iBOX(); //計算用の数値
    Memo m=new Memo();  //M+,M-,MC,MRで使用

    TextView txNum;//テキスト(mainのとこ)
    TextView memo;//テキスト「M」
    TextView mode;//テキスト「演算子記号」

//############################################################
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        memo=findViewById(R.id.txM);
        mode=findViewById(R.id.txMode);
        txNum=findViewById(R.id.txResult);

        Typeface mplus=Typeface.createFromAsset(getAssets(),"MPLUS.ttf");
        Typeface M=Typeface.createFromAsset(getAssets(),"Mar.ttf");
        txNum.setTypeface(mplus);
        memo.setTypeface(mplus);
        mode.setTypeface(mplus);
    }
//############################################################



//(表示メソッド)----------------------------------------------
    public void setTxNumber(){

        if(txNumber.matches("0[0-9].*")){txNumber=txNumber.substring(1);}


        txNum.setText(txNumber);
    }


//(数字ボタンクリック処理)----------------------------------------
    public void setOne(View v){
        if(txNumber.length()<13) {
            mathMode = "N";
            txNumber += "1";
            this.setTxNumber();
        }
    }
    public void setTwo(View v){
        if(txNumber.length()<13) {
            mathMode = "N";
            txNumber += "2";
            this.setTxNumber();
        }
    }
    public void setTree(View v){
        if(txNumber.length()<13) {
            mathMode = "N";
            txNumber += "3";
            this.setTxNumber();
        }
    }
    public void setFour(View v){
        if(txNumber.length()<13) {
            mathMode = "N";
            txNumber += "4";
            this.setTxNumber();
        }
    }
    public void setFive(View v){
        if(txNumber.length()<13) {
            mathMode = "N";
            txNumber += "5";
            this.setTxNumber();
        }
    }
    public void setSix(View v){
        if(txNumber.length()<13) {
            mathMode = "N";
            txNumber += "6";
            this.setTxNumber();
        }
    }
    public void setSeven(View v){
        if(txNumber.length()<13) {
            mathMode = "N";
            txNumber += "7";
            this.setTxNumber();
        }
    }
    public void setEight(View v){
        if(txNumber.length()<13) {
            mathMode = "N";
            txNumber += "8";
            this.setTxNumber();
        }
    }
    public void setNine(View v){
        if(txNumber.length()<13) {
            mathMode = "N";
            txNumber += "9";
            this.setTxNumber();
        }
    }
    public void setZero(View v){
        if(!(txNumber.matches("0[0-9].*")) || txNumber.length()<13) {
            mathMode = "N";
            txNumber += "0";
            this.setTxNumber();
        }
    }
    public void setWZero(View v){
        if(!(txNumber.matches("0[0-9].*"))||txNumber.length()<13) {
            mathMode = "N";
            txNumber += "00";
            this.setTxNumber();
        }
    }
    public void setConma(View v){
        if(!(txNumber.contains("."))) {
            mathMode = "N";
            txNumber += ".";
        }
    }
//(コマンド系ボタン)--------------------------------------------
    public void c(View v){
        txNumber="0";
        this.setTxNumber();
    }
    public void ac(View v){
        txNumber="0";
        mathMode="N";
        box.allClear();
        mode.setText("");
        this.setTxNumber();
    }
    public void mPlus(View v){
        if(mathMode=="N") {
            m.plusMemo(txNumber);
            this.memo.setText("M");
        }
    }
    public void mMinus(View v){
        if(mathMode=="N") {
            m.minusMemo(txNumber);
            this.memo.setText("M");
        }
    }
    public void mRecall(View v){
        mathMode="N";
        String s=String.valueOf(m.getMemo());
        txNumber+=s;
        this.setTxNumber();
    }
    public void mClear(View v){
        m.clearMemo();
        this.memo.setText("");
    }
    public void nijo_jo(View v){
        mathMode="N";
        box.xx(txNumber);
        txNumber=box.getResult().toString();
        this.setTxNumber();
    }
//(四則演算コマンド)---------------------------------------------
    public void waru(View v){
        mode.setText("÷");
        if(mathMode.equals("N")) {
            mathMode = "CAL";
            box.wari_zan(txNumber);
            txNum.setText(box.getResult().toString());
            txNumber = "0";
        }else{
            box.changeState("keep/");
        }
    }

    public void kakuru(View v){
        mode.setText("×");
        if(mathMode.equals("N")) {
            mathMode = "CAL";
            box.kake_zan(txNumber);
            txNum.setText(box.getResult().toString());
            txNumber = "0";
        }else{
            box.changeState("keep*");
        }
    }

    public void hiku(View v){
        mode.setText("-");
        if(mathMode.equals("N")) {
            mathMode = "CAL";
            box.hiki_zan(txNumber);
            txNum.setText(box.getResult().toString());
            txNumber = "0";
        }else{
            box.changeState("keep-");
        }
    }

    public void tasu(View v){
        mode.setText("+");
        if(mathMode.equals("N")) {
            mathMode = "CAL";
            box.tasi_zan(txNumber);
            txNum.setText(box.getResult().toString());
            txNumber = "0";
        }else{
            box.changeState("keep+");
        }
    }

    public void equal(View v){
        if(!(mode.getText().equals(""))) {
            mathMode = "N";
            mode.setText("");
            txNumber = box.equal(txNumber);
            this.setTxNumber();
        }
    }





}
