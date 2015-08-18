package com.zertificon.spikeacra;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import rx.Observable;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {
    private Observable<String> myObserver;
    private Observable<String> myObserver2;
    private Subscriber<String> subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myObserver = MyObserver.NumberToStrings(0, 10, 500);
        myObserver2 = MyObserver.NumberToStringsExtern(0, 10, 500);

        subscription =  new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("**** Subscriber: COMPLETE");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("**** Subscriber: ERROR");
            }

            @Override
            public void onNext(String s) {
                System.out.println("**** Subscriber Number: " + s);
            }
        };

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String temp = null;
                System.out.println("-> " + temp.charAt(9));
            }
        });

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myObserver.subscribe(subscription);
            }
        });

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myObserver2.subscribe(subscription);
            }
        });
    }

}
