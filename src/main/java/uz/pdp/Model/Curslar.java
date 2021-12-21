package uz.pdp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Curslar {
    @JsonProperty("CcyNm_EN")
    private String ccyNmEN;

    @JsonProperty("CcyNm_UZC")
    private String ccyNmUZC;

    @JsonProperty("Diff")
    private String diff;

    @JsonProperty("Rate")
    private String rate;

    @JsonProperty("Ccy")
    private String ccy;

    @JsonProperty("CcyNm_RU")
    private String ccyNmRU;

    @JsonProperty("id")
    private int id;

    @JsonProperty("CcyNm_UZ")
    private String ccyNmUZ;

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Nominal")
    private String nominal;

    @JsonProperty("Date")
    private String date;

    public void setCcyNmEN(String ccyNmEN){
        this.ccyNmEN = ccyNmEN;
    }

    public String getCcyNmEN(){
        return ccyNmEN;
    }

    public void setCcyNmUZC(String ccyNmUZC){
        this.ccyNmUZC = ccyNmUZC;
    }

    public String getCcyNmUZC(){
        return ccyNmUZC;
    }

    public void setDiff(String diff){
        this.diff = diff;
    }

    public String getDiff(){
        return diff;
    }

    public void setRate(String rate){
        this.rate = rate;
    }

    public String getRate(){
        return rate;
    }

    public void setCcy(String ccy){
        this.ccy = ccy;
    }

    public String getCcy(){
        return ccy;
    }

    public void setCcyNmRU(String ccyNmRU){
        this.ccyNmRU = ccyNmRU;
    }

    public String getCcyNmRU(){
        return ccyNmRU;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setCcyNmUZ(String ccyNmUZ){
        this.ccyNmUZ = ccyNmUZ;
    }

    public String getCcyNmUZ(){
        return ccyNmUZ;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public void setNominal(String nominal){
        this.nominal = nominal;
    }

    public String getNominal(){
        return nominal;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "ccyNm_EN = '" + ccyNmEN + '\'' +
                        ",ccyNm_UZC = '" + ccyNmUZC + '\'' +
                        ",diff = '" + diff + '\'' +
                        ",rate = '" + rate + '\'' +
                        ",ccy = '" + ccy + '\'' +
                        ",ccyNm_RU = '" + ccyNmRU + '\'' +
                        ",id = '" + id + '\'' +
                        ",ccyNm_UZ = '" + ccyNmUZ + '\'' +
                        ",code = '" + code + '\'' +
                        ",nominal = '" + nominal + '\'' +
                        ",date = '" + date + '\'' +
                        "}";
    }
}
