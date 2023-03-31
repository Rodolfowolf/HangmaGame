/**
 * Assignment 8 College Course objects working with bidimensional array and try catch.
 * @author Igor Guimaraes 200540189 - Navjot Kaur 200547472 - Yuvraj Singla - Rodolfo Carvalho 200536943
 * @date March 18, 2023
 * @time 09:00pm 
 */

public class Hangman {
    private String wordRec;
    private String tipsRec;

    public Hangman(String wordRec, String tipsRec) {
        this.wordRec = wordRec;
        this.tipsRec = tipsRec;
    }

    public String getWordRec() {
        return this.wordRec;
    }

    public void setWordRec(String wordRec) {
        this.wordRec = wordRec;
    }

    public String getTipsRec() {
        return this.tipsRec;
    }

    public void setTipsRec(String tipsRec) {
        this.tipsRec = tipsRec;
    }

}