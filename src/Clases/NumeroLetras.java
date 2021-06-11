package Clases;

import java.text.DecimalFormat;

public class NumeroLetras {
   private int millares ,centenas,decenas,unidades;
  int datoentero;double datodecimal;double decimalentero;
  DecimalFormat reducir=new DecimalFormat("#.##");
public NumeroLetras(){}
    public static String Unidades(int unid) {
        String unidades = "";
        switch (unid) {
            case 0: unidades = "Cero"; break;
            case 1: unidades = "Uno"; break;
            case 2: unidades = "Dos";  break;
            case 3: unidades = "Tres"; break;
            case 4: unidades = "Cuatro"; break;
            case 5:  unidades = "Cinco"; break;
            case 6: unidades = "Seis"; break;
            case 7:  unidades = "Siete"; break;
              case 8: unidades = "Ocho";
                break;case 9:   unidades = "Nueve";  break;
        } return unidades;
    }
    public static String Decenas(int DEC) {
        String decenas = "";
        switch (DEC) {
            case 0: decenas="";break;
            case 1: decenas = "Diez"; break;
            case 2:  decenas = "Veinte";break;
            case 3: decenas = "Treinta"; break;
            case 4: decenas = "Cuarenta"; break;
            case 5: decenas = "Cincuenta"; break;
            case 6: decenas = "Sesenta";break;
            case 7: decenas="Setenta";break;
            case 8:decenas = "Ochenta"; break;
            case 9: decenas = "Noventa";break;}return decenas;}
    public static String decenasGenerales(int dec, int unid) {
        String decgen = "";
        if (dec == 1 && unid == 1) {
            decgen = "Once";
        } else {
            if (dec == 1 && unid == 2) {
                decgen = "Doce";
            } else {
                if (dec == 1 && unid == 3) {
                    decgen = "Trece";
                } else {
                    if (dec == 1 && unid == 4) {
                        decgen = "Catorce";
                    } else {
                        if (dec == 1 && unid == 5) {
                            decgen = "Quince";}}}}}return decgen;}
    public static String Decenasdiesi(int de, int uni) {
        String gen = "";
        if (de == 1 && (uni >= 6 && uni <= 9)) {gen = "Dieci";}
        return gen;}
    public static String DecenasVenti(int de, int uni) {
        String venti = "";
        if (de == 2 && (uni >= 1 && uni <= 9)) {venti = "Veinti";}
        return venti;}
    public static String Centenas(int centenas) {
        String cent = "";
        switch (centenas) {
            case 0:cent="";break;
            case 1: cent = "Ciento";  break;
            case 2:cent = "Doscientos";  break;
            case 3: cent = "Trescientos"; break;
            case 4: cent = "Cuatrocientos"; break;
            case 5:cent = "Quinientos"; break;
            case 6: cent = "Seiscientos"; break;
            case 7:cent = "Setesientos"; break;
            case 8:cent = "Ochocientos"; break;
            case 9:cent = "Novecientos"; break;
        }return cent;
    }
    public static String Millares(int m){
        String millar="";
        switch(m){case 0:millar="";break;case 1 : millar="Mil";break;case 2: millar="Dos Mil ";break;
        case 3 :millar="Tres Mil";break;case 4 :millar="Cuatro Mil";break;case 5:millar="Cinco Mil";break;case 6:millar="Seis Mil";break;
        case 7 :millar="Siete Mil";break;case 8:millar="Ocho Mil";break;case 9 :millar="Nueve Mil";break;}
        return millar;
    }
    public String DineroLetras(int millar, int cent, int dec, int uni) {
        String dineroLetr = "";
    if (millar == 0 && cent == 0 && dec == 0 && (uni >= 0 && uni <= 9)) {
  dineroLetr = Unidades(uni);
 }else {if (millar == 0 && cent == 0 && (dec >= 1 && dec <= 9) && uni == 0) {
  dineroLetr = Decenas(dec);
     } else {if (millar == 0 && cent == 0 && dec == 1 && (uni > 0 && uni <= 5)) {
   dineroLetr = decenasGenerales(dec, uni);
 } else { if (millar == 0 && cent == 0 && dec == 1 && (uni >= 6 && uni <= 9)) {
   dineroLetr = Decenasdiesi(dec, uni) + Unidades(uni);
   } else {if (millar == 0 && cent == 0 && dec == 2 && (uni >= 1 && uni <= 9)) {
   dineroLetr = DecenasVenti(dec, uni) + Unidades(uni);
   } else {if (millar == 0 && cent == 0 && (dec >= 3 && dec <= 9) && (uni >= 1 && uni <= 9)) {
   dineroLetr = Decenas(dec) + " y " + Unidades(uni);
  } else { if (millar == 0 && (cent == 1) && dec == 0 && uni == 0) {
     dineroLetr = "Cien";
    } else {if (millar == 0 && (cent >= 1 && cent <= 9) && dec == 0 && (uni >= 1 & uni <= 9)) {
   dineroLetr = Centenas(cent) + " " + Unidades(uni);
   } else {if (millar == 0 && (cent >= 1 && cent <= 9) && (dec >= 1 && dec <= 9) && uni == 0) {
 dineroLetr = Centenas(cent) + " " + Decenas(dec);
  } else {if (millar == 0 && (cent >= 1 && cent <= 9) && (dec == 1) && (uni > 0 && uni <= 5)) {
  dineroLetr = Centenas(cent) + " " + decenasGenerales(dec, uni);
  } else {if (millar == 0 && (cent >= 1 && cent <= 9) && (dec == 1) && (uni >= 6 && uni <= 9)) {
 dineroLetr = Centenas(cent) + " " + Decenasdiesi(dec, uni) + Unidades(uni);
  } else {if (millar == 0 && (cent >= 1 && cent <= 9) && (dec == 2) && (uni >= 1 && uni <= 9)) {
  dineroLetr = Centenas(cent) + " " + DecenasVenti(dec, uni) + Unidades(uni);
  }else{if (millar == 0 && (cent >= 1 && cent <= 9) && (dec >= 3 && dec <= 9) && (uni >= 1 && uni <= 9)) {
  dineroLetr = Centenas(cent) + " " + Decenas(dec) + " y " + Unidades(uni);
  } else {if (millar == 0 && cent == 1 && (dec >= 3 && dec <= 9) && (uni >= 1 && uni <= 9)) {
  dineroLetr = Centenas(cent) + " " + Decenas(dec) + " y " + Unidades(uni);
 } else {if ((millar >= 1 && millar <= 9) && cent == 0 && dec == 0 && (uni == 0)) {
  dineroLetr = Millares(millar);
 } else {if ((millar >= 1 && millar <= 9) && (cent >= 0 && cent <= 9) && dec == 0 && (uni >= 1 && uni <= 9)) {
  dineroLetr = Millares(millar) + " " + Centenas(cent) + " " + Unidades(uni);
  } else {if ((millar >= 1 && millar <= 9) && (cent >= 0 && cent <= 9) && dec == 1 && (uni >= 1 && uni <= 5)) {
dineroLetr = Millares(millar) + " " + Centenas(cent) + " " + decenasGenerales(dec, uni);
} else {if ((millar >= 1 && millar <= 9) && (cent >= 0 && cent <= 9) && dec == 1 && (uni >= 6 && uni <= 9)) {
dineroLetr = Millares(millar) + " " + Centenas(cent) + " " + Decenasdiesi(dec, uni) + Unidades(uni);
} else {if ((millar >= 1 && millar <= 9) && (cent >= 0 && cent <= 9) && dec == 2 && (uni >= 1 && uni <= 9)) {
dineroLetr = Millares(millar) + " " + Centenas(cent) + " " + DecenasVenti(dec, uni) + Unidades(uni);
 } else {if ((millar >= 1 && millar <= 9) && (cent >= 0 && cent <= 9) && (dec >= 3 && dec <= 9) && (uni >= 1 && uni <= 9)) {
 dineroLetr = Millares(millar) + " " + Centenas(cent) + " " + Decenas(dec) + " y " + Unidades(uni);}}}}}}}}}}}}}}}} }}} }return dineroLetr;}
public String  ImprimirDineroLetra(double num) {
datoentero = (int) num;String resultado="";
decimalentero = (num - datoentero) * 100;millares = (int) (datoentero / 1000);
centenas = ((datoentero % 1000) / 100);decenas = (((datoentero % 1000) % 100) / 10);
unidades = (((datoentero % 1000) % 100) % 10);    
if(decimalentero==0){
 resultado=DineroLetras(millares,centenas, decenas, unidades)+" con  "+reducir.format(decimalentero)+"0/100 Soles ";
}else{ resultado=(DineroLetras(millares,centenas, decenas, unidades)+" con  "+reducir.format(decimalentero)+"/100 Soles ");
 }return resultado;}
}
