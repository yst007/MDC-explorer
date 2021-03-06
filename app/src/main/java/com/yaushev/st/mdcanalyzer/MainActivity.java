package com.yaushev.st.mdcanalyzer;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public EditText editText;
    public EditText editText2;
    ImageButton clear2;
    TextView type_button;
    TextView findbuttton;
    ImageButton clear;
    ImageButton link;
    TextView systemname;
    ImageButton help;


    final int ACFC350=1;
    final int ACFC351=2;
    final int ADC350=3;
    final int ADF350=4;
    final int AHRS350=5;
    final int AHRS351=6;
    final int APU350=7;
    final int APU351=8;
    final int APU352=9;
    final int BTMS350=10;
    final int CDU354=11;
    final int CFSS351=12;
    final int CPAM270=13;
    final int CPC270=14;
    final int DBU351=15;
    final int DCP352=16;
    final int DCU242=17;
    final int DCU350=18;
    final int DCU351=19;
    final int DCU352=20;
    final int DME350=21;
    final int ECFC351= 22;
    final int SECU350= 23;
    final int MDC350= 24;
    final int IRS353= 25;
    final int TCAS350= 26;
    final int SECU352= 27;
    final int SECU353= 28;
    final int FMS350= 29;
    final int GPS355= 30;
    final int SPS350= 31;
    final int HSTCU271= 32;
    final int ECFP351= 33;
    final int SECU273= 34;
    final int TDR350= 35;
    final int MFD350= 36;
    final int RCFLP351= 37;
    final int GPWS350= 38;
    final int IRS351= 39;
    final int HGS350= 40;
    final int SECU271= 41;
    final int HSTCU272= 42;
    final int SPS270= 43;
    final int LDU350= 44;
    final int HSTCU273= 45;
    final int EICAS350= 46;
    final int HSTCU350= 47;
    final int HSTCU270= 48;
    final int IOC350= 49;
    final int PFD351= 50;
    final int SECU272= 51;
    final int RCFRC351= 52;
    final int IRS350= 53;
    final int RAC350= 54;
    final int GPWS351= 55;
    final int FQGS276= 56;
    final int ECP377= 57;
    final int RTU352= 58;
    final int PFD350= 59;
    final int RCFLC351= 60;
    final int RTU350= 61;
    final int RCFRP351= 62;
    final int SECU351= 63;
    final int EICAS351= 64;
    final int PSEU273= 65;
    final int FQGS277= 66;
    final int MFD351= 67;
    final int ADC351=68;
    final int VHFCOMM350=69;
    final int VHFNAV350=70;
    final int WXP270=71;
    final int WXR354=72;
    final int FCC071=73;
    final int FCC351Repair=74;
    final int FCC351ApEng=75;
    final int FCC351ApDis=76;
    final int FCC351YdEng=77;
    final int FCC351YdDis=78;
    final int FCC351Boost=79;
    final int SteerByWireRTU=80;


    private String TAG="exeption";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        link=(ImageButton) findViewById(R.id.link);
        link.setOnClickListener(this);



        systemname=(TextView) findViewById(R.id.textView2);
        editText=(EditText) findViewById(R.id.editText);
        findbuttton=(TextView) findViewById(R.id.button) ;
        findbuttton.setOnClickListener(this);
        clear=(ImageButton) findViewById(R.id.button3) ;
        clear.setOnClickListener(this);
        help=(ImageButton) findViewById(R.id.button2);
        help.setOnClickListener(this);
       type_button=(TextView)findViewById(R.id.button5);

        type_button.setOnClickListener(this);

        editText2=(EditText)findViewById(R.id.editText1);
       clear2=(ImageButton)findViewById(R.id.button31);
       clear2.setOnClickListener(this);

       editText2.setVisibility(View.GONE);
       clear2.setVisibility(View.GONE);


        editText.addTextChangedListener(wacher);


        registerForContextMenu(systemname);




    }


    TextWatcher wacher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if(editText.length()==4|editText.length()==9|editText.length()==14|editText.length()==19|editText.length()==24){

                editText.setText(editText.getText()+"-");
                editText.setSelection(editText.getText().length());

            }

        }
    };


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                if(editText.getVisibility()==View.VISIBLE){
                if((editText.getText().toString().equals(""))|(editText.getText().toString().length()<29)){
                    String toaststring= (String) getText(R.string.toast_string);
                    Toast toast=Toast.makeText(MainActivity.this,toaststring,Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{

                    Intent intent = new Intent(this, FindActivity.class);
                    intent.putExtra("inputcode", editText.getText().toString());
                    intent.putExtra("systemname",systemname.getText());
                    startActivity(intent);}

                break;}
                else{
                    if(editText2.getText().toString().length()!=0){
                    String hex=editText2.getText().toString();
                    int hexint=Integer.parseInt(hex,16);
                    String inputBinString=Integer.toBinaryString(hexint);

                    while(inputBinString.length()<24){
                        inputBinString="0"+inputBinString;
                    }

                    Intent intent = new Intent(this, FindActivity.class);
                    intent.putExtra("inputcode", inputBinString);
                    intent.putExtra("systemname",systemname.getText());
                    startActivity(intent);}
                    else
                    {
                        String toaststring2= (String) getText(R.string.toast_string2);
                        Toast toast=Toast.makeText(MainActivity.this,toaststring2,Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    break;

                }

            case R.id.button3: editText.setText("");
                break;
            case R.id.button2:
                Intent intent1 =new Intent(this,HelpActivity.class);
                startActivity(intent1);
                break;
            case R.id.button5:

                if(editText.getVisibility()==View.VISIBLE){
                    editText.setVisibility(View.GONE);
                    editText.setText("");
                    clear.setVisibility(View.GONE);
                    editText2.setVisibility(View.VISIBLE);
                    clear2.setVisibility(View.VISIBLE);
                }else{
                    editText.setVisibility(View.VISIBLE);

                    clear.setVisibility(View.VISIBLE);
                    editText2.setVisibility(View.GONE);
                    editText2.setText("");
                    clear2.setVisibility(View.GONE);
                }
            case R.id.button31:
                editText2.setText("");

                break;
            case R.id.link:

                File file = new File("/sdcard/AMM45-45-00-01.pdf");
                if (file.exists()) {
                    Uri path = Uri.fromFile(file);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(path, "application/pdf");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    try {
                        startActivity(intent);
                    }
                    catch (ActivityNotFoundException e) {
                        Toast.makeText(MainActivity.this,
                                "No Application Available to View PDF",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    String fileNotExistString= (String) getText(R.string.filenotexist);
                    Toast.makeText(MainActivity.this,
                            fileNotExistString,
                            Toast.LENGTH_SHORT).show();
                }




                break;


        }

    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
















        menu.add(0,ACFC350,0,"ACFP(351)");
        menu.add(0,ACFC351,0,"ACFC (351)");
        menu.add(0,ADC350,0,"ADC (350)");
        menu.add(0,ADC351,0,"ADC (351)");
        menu.add(0,ADF350,0,"ADF (350)");
        menu.add(0,AHRS350,0,"AHRS (350)");
        menu.add(0,AHRS351,0,"AHRS (351)");
        menu.add(0,APU350,0,"APU (350)");
        menu.add(0,APU351,0,"APU (351)");
        menu.add(0,APU352,0,"APU (352)");
        menu.add(0,BTMS350,0,"BTMS (350)");
        menu.add(0,CDU354,0,"CDU (354)");
        menu.add(0,CFSS351,0,"CFSS (351)");
        menu.add(0,CPAM270,0,"CPAM (270)");
        menu.add(0,CPC270,0,"CPC (270)");
        menu.add(0,DBU351,0,"DBU (351)");
        menu.add(0,DCP352,0,"DCP (352)");
        menu.add(0,DCU242,0,"DCU (242)");
        menu.add(0,DCU350,0,"DCU (350)");
        menu.add(0,DCU351,0,"DCU (351)");
        menu.add(0,DCU352,0,"DCU (352)");
        menu.add(0,DME350,0,"DME (350)");
        menu.add(0,ECFC351,0,"ECFC (351)");
        menu.add(0,ECFP351,0,"ECFP (351)");
        menu.add(0,ECP377,0,"ECP (377)");
        menu.add(0,EICAS350,0,"EICAS (350)");
        menu.add(0,EICAS351,0,"EICAS (351)");
        menu.add(0,FMS350,0,"FMS (350)");
        menu.add(0,FQGS276,0,"FQGS (276)");
        menu.add(0,FQGS277,0,"FQGS (277)");
        menu.add(0,GPS355,0,"GPS (355)");
        menu.add(0,GPWS350,0,"GPWS (350)");
        menu.add(0,GPWS351,0,"GPWS (351)");
        menu.add(0,HGS350,0,"HGS (350)");
        menu.add(0,HSTCU270,0,"HSTCU (270)");
        menu.add(0,HSTCU271,0,"HSTCU (271)");
        menu.add(0,HSTCU272,0,"HSTCU (272)");
        menu.add(0,HSTCU273,0,"HSTCU (273)");
        menu.add(0,HSTCU350,0,"HSTCU (350)");
        menu.add(0,IOC350,0,"IOC (350)");
        menu.add(0,IRS350,0,"IRS (350)");
        menu.add(0,IRS351,0,"IRS (351)");
        menu.add(0,IRS353,0,"IRS (353)");
        menu.add(0,LDU350,0,"LDU (350)");
        menu.add(0,MDC350,0,"MDC (350)");
        menu.add(0,MFD350,0,"MFD (350)");
        menu.add(0,MFD351,0,"MFD (351)");
        menu.add(0,PFD350,0,"PFD (350)");
        menu.add(0,PFD351,0,"PFD (351)");
        menu.add(0,PSEU273,0,"PSEU (273)");
        menu.add(0,RAC350,0,"RAC (350)");
        menu.add(0,RCFLC351,0,"RCFLC (351)");
        menu.add(0,RCFLP351,0,"RCFLP (351)");
        menu.add(0,RCFRC351,0,"RCFRC (351)");
        menu.add(0,RCFRP351,0,"RCFRP (351)");
        menu.add(0,RTU350,0,"RTU (350)");
        menu.add(0,RTU352,0,"RTU (352)");
        menu.add(0,SteerByWireRTU,0,"Steer By Wire RTU (350)");
        menu.add(0,SECU271,0,"SECU (271)");
        menu.add(0,SECU272,0,"SECU (272)");
        menu.add(0,SECU273,0,"SECU (273)");
        menu.add(0,SECU350,0,"SECU (350)");
        menu.add(0,SECU351,0,"SECU (351)");
        menu.add(0,SECU352,0,"SECU (352)");
        menu.add(0,SECU353,0,"SECU (353)");
        menu.add(0,SPS270,0,"SPS (270)");
        menu.add(0,SPS350,0,"SPS (350)");
        menu.add(0,TCAS350,0,"TCAS (350)");
        menu.add(0,TDR350,0,"TDR (350)");
        menu.add(0,VHFCOMM350,0,"VHF COMM (350)");
        menu.add(0,VHFNAV350,0,"VHF NAV (350)");
        menu.add(0,WXP270,0,"WXP (270) or (355)");
        menu.add(0,WXR354,0,"WXR (354)");
        SubMenu subMenu=menu.addSubMenu("FCC Diagnostic");
        subMenu.add(0,FCC071,0,"FCC (071)");
        subMenu.add(0,FCC351ApDis,0,"FCC (351):AP DISENG");
        subMenu.add(0,FCC351ApEng,0,"FCC (351):AP ENG");
        subMenu.add(0,FCC351Boost,0,"FCC (351):Boost");
        subMenu.add(0,FCC351Repair,0,"FCC (351):Repair");
        subMenu.add(0,FCC351YdDis,0,"FCC (351):YD DISENG");
        subMenu.add(0,FCC351YdEng,0,"FCC (351):YD ENG");






    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case ACFC350:systemname.setText("ACFP351");break;
            case ACFC351:systemname.setText("ACFC351");break;
            case ADC350:systemname.setText("ADC350");break;
            case ADC351:systemname.setText("ADC351");break;
            case ADF350:systemname.setText("ADF350");break;
            case AHRS350:systemname.setText("AHRS350");break;
            case AHRS351:systemname.setText("AHRS351");break;
            case APU350:systemname.setText("APU350");break;
            case APU351:systemname.setText("APU351");break;
            case APU352:systemname.setText("APU352");break;
            case BTMS350:systemname.setText("BTMS350");break;
            case CDU354:systemname.setText("CDU354");break;
            case CFSS351:systemname.setText("CFSS351");break;
            case CPAM270:systemname.setText("CPAM270");break;
            case CPC270:systemname.setText("CPC270");break;
            case DBU351:systemname.setText("DBU351");break;
            case DCP352:systemname.setText("DCP352");break;
            case DCU242:systemname.setText("DCU242");break;
            case DCU350:systemname.setText("DCU350");break;
            case DCU351:systemname.setText("DCU351");break;
            case DCU352:systemname.setText("DCU352");break;
            case DME350:systemname.setText("DME350");break;
            case ECFC351:systemname.setText("ECFC351");break;
            case SECU350:systemname.setText("SECU350");break;
            case MDC350:systemname.setText("MDC350");break;
            case IRS353:systemname.setText("IRS353");break;
            case TCAS350:systemname.setText("TCAS350");break;
            case SECU352:systemname.setText("SECU352");break;
            case SECU353:systemname.setText("SECU353");break;
            case FMS350:systemname.setText("FMS350");break;
            case GPS355:systemname.setText("GPS355");break;
            case SPS350:systemname.setText("SPS350");break;
            case HSTCU271:systemname.setText("HSTCU271");break;
            case ECFP351:systemname.setText("ECFP351");break;
            case SECU273:systemname.setText("SECU273");break;
            case TDR350:systemname.setText("TDR350");break;
            case MFD350:systemname.setText("MFD350");break;
            case RCFLP351:systemname.setText("RCFLP351");break;
            case GPWS350:systemname.setText("GPWS350");break;
            case IRS351:systemname.setText("IRS351");break;
            case HGS350:systemname.setText("HGS350");break;
            case SECU271:systemname.setText("SECU271");break;
            case HSTCU272:systemname.setText("HSTCU272");break;
            case SPS270:systemname.setText("SPS270");break;
            case LDU350:systemname.setText("LDU350");break;
            case HSTCU273:systemname.setText("HSTCU273");break;
            case EICAS350:systemname.setText("EICAS350");break;
            case HSTCU350:systemname.setText("HSTCU350");break;
            case HSTCU270:systemname.setText("HSTCU270");break;
            case IOC350:systemname.setText("IOC350");break;
            case PFD351:systemname.setText("PFD351");break;
            case SECU272:systemname.setText("SECU272");break;
            case RCFRC351:systemname.setText("RCFRC351");break;
            case IRS350:systemname.setText("IRS350");break;
            case RAC350:systemname.setText("RAC350");break;
            case GPWS351:systemname.setText("GPWS351");break;
            case FQGS276:systemname.setText("FQGS276");break;
            case ECP377:systemname.setText("ECP377");break;
            case RTU352:systemname.setText("RTU352");break;
            case PFD350:systemname.setText("PFD350");break;
            case RCFLC351:systemname.setText("RCFLC351");break;
            case RTU350:systemname.setText("RTU350");break;
            case RCFRP351:systemname.setText("RCFRP351");break;
            case SECU351:systemname.setText("SECU351");break;
            case EICAS351:systemname.setText("EICAS351");break;
            case PSEU273:systemname.setText("PSEU273");break;
            case FQGS277:systemname.setText("FQGS277");break;
            case MFD351:systemname.setText("MFD351");break;
            case VHFCOMM350:systemname.setText("VHFCOMM350");break;
            case VHFNAV350:systemname.setText("VHFNAV350");break;
            case WXP270:systemname.setText("WXP270");break;
            case WXR354:systemname.setText("WXR354");break;
            case FCC071:systemname.setText("FCC071");break;
            case FCC351Repair:systemname.setText("FCC351:Repair");break;
            case FCC351ApEng:systemname.setText("FCC351:AP ENG");break;
            case FCC351ApDis:systemname.setText("FCC351:AP DISENG");break;
            case FCC351YdEng:systemname.setText("FCC351:YD ENG");break;
            case FCC351YdDis:systemname.setText("FCC351:YD DISENG");break;
            case FCC351Boost:systemname.setText("FCC351:Boost");break;
            case SteerByWireRTU:systemname.setText("Steer By Wire RTU350");break;


        }


        return super.onContextItemSelected(item);
    }
}


