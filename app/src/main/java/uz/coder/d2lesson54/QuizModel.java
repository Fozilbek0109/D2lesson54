package uz.coder.d2lesson54;

public class QuizModel {
    private int img;
    private String bayroqNomi;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getBayroqNomi() {
        return bayroqNomi;
    }

    public void setBayroqNomi(String bayroqNomi) {
        this.bayroqNomi = bayroqNomi;
    }

    @Override
    public String toString() {
        return "QuizModel{" +
                "img=" + img +
                ", bayroqNomi='" + bayroqNomi + '\'' +
                '}';
    }

    public QuizModel(int img, String bayroqNomi) {
        this.img = img;
        this.bayroqNomi = bayroqNomi;
    }
}
