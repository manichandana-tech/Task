package com.ezatpanah.retrofit_youtube.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ezatpanah.retrofit_youtube.R;
import com.ezatpanah.retrofit_youtube.adapter.NumberGridAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  static  final int GRID_SIZE =100;
    private GridView gridView;
    private NumberGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid_view);
        adapter =new NumberGridAdapter(this,generateNumberList());
        gridView.setAdapter(adapter);

        highlightOddNumbers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_odd_numbers:
                highlightOddNumbers();
                return true;
            case  R.id.menu_even_numbers:
                highlightEvenNumbers();
                return true;
            case R.id.prime_number:
                highLightNumbers(findPrimNumber());
                return true;
            case R.id.Fibonaci_series:
                highLightNumbers(findFibanociNumber());
                return true;
        }

        return super.onOptionsItemSelected(item);

    }

    private List<Integer> generateNumberList() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= GRID_SIZE; i++) {
            numbers.add(i);
        }
        return  numbers;
    }
    private void highlightOddNumbers(){
        List<Integer>oddNumbers = new ArrayList<>();
        for(int i=1; i<=GRID_SIZE; i++){
            if(i%2 != 0){
                oddNumbers.add(i);
            }
        }
        highLightNumbers(oddNumbers);
    }

    private void highlightEvenNumbers(){
        List<Integer>evenNumbers = new ArrayList<>();
        for(int i=1; i<=GRID_SIZE; i++){
            if(i%2 == 0){
                evenNumbers.add(i);
            }
        }
        highLightNumbers(evenNumbers);
    }

    private List<Integer> findPrimNumber()
    {
        List<Integer> PrimeNumbers =new ArrayList<>();
        for(int i=2; i<=GRID_SIZE; i++){
            if(isPrime(i)){
                PrimeNumbers.add(i);
            }
        }
        return PrimeNumbers;
    }
    private boolean isPrime(int number){
        if(number <= 1){
            return false;
        }
        if(number <=3){
            return true;
        }
        if(number % 2==0||number%3==0){
            return false;
        }
        int i=5;
        while (i*i<=number){
            if (number%i ==0|| number%(i+2)==0){
                return false;
            }
            i+=6;
        }
        return true;
    }

    private List<Integer> findFibanociNumber(){
        List<Integer> fibonaciNumbers =new ArrayList<>();
        int a=1;
        int b=1;
        fibonaciNumbers.add(a);
        fibonaciNumbers.add(b);
        while (true){
            int c=a+b;
            if(c>GRID_SIZE){
                break;
            }
            fibonaciNumbers.add(c);
            a=b;
            b=c;
        }
        return fibonaciNumbers;
    }
    private void highLightNumbers(List<Integer> numberToHightLight){
        adapter.setHightlightNumbers(numberToHightLight);
    }
}
