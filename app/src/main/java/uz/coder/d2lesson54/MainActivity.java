package uz.coder.d2lesson54;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uz.coder.d2lesson54.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding ;
private List<QuizModel> list;
private int currenIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        setData();




    }

    private void setData() {
        QuizModel quizModel = list.get(currenIndex);
        String bayroqNomi = quizModel.getBayroqNomi();
        int length = bayroqNomi.length();
        int imge = quizModel.getImg();
        binding.img.setImageResource(imge);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT,1.0f);
        for (int i = 0; i < length; i++) {
            Button button = new Button(this);
            button.setLayoutParams(layoutParams);
            button.setText(String.valueOf(bayroqNomi.charAt(i)));
            binding.linerJavob.addView(button);
        }
        List<String> randomHarf = getRandomHarf(bayroqNomi);
        for (int i = 0; i < randomHarf.size(); i++) {
            Button button = new Button(this);
            button.setLayoutParams(layoutParams);


            button.setText(list.get(i).toString());
            binding.linerHarf1.addView(button);
        }
        for (int i = randomHarf.size()/2; i < randomHarf.size(); i++) {
            Button button = new Button(this);
            button.setLayoutParams(layoutParams);


            button.setText(list.get(i).toString());
            binding.linerHarf2.addView(button);
        }

    }

    private List<String> getRandomHarf(String bayroqNomi) {
        String alfabet = "ABCDEFJHIJKLMNOPKRSTUVWXYZ";

        String s = alfabet.substring(0,18-bayroqNomi.length());
        List<String> harfList = new ArrayList<>();
        for (int i= 0; i < bayroqNomi.length(); i++){
            harfList.add(String.valueOf(s.charAt(i)));
        }
        for (int i= 0; i < s.length(); i++){
            harfList.add(String.valueOf(s.charAt(i)));
        }
        Collections.shuffle(harfList);
        return  harfList;
    }

    private void loadData() {
        list = new ArrayList<>();
        list.add(new QuizModel(R.drawable.ic_launcher_background,"Japan"));
        list.add(new QuizModel(R.drawable.ic_launcher_background,"Usa"));
        list.add(new QuizModel(R.drawable.ic_launcher_background,"Uzbekistan"));
        list.add(new QuizModel(R.drawable.ic_launcher_background,"Russia"));
        list.add(new QuizModel(R.drawable.ic_launcher_background,"Argintina"));

    }
}