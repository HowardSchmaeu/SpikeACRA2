package com.zertificon.spikeacra;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by MSC on 02.06.2015.
 *
 * More Infos: http://blog.danlew.net/2014/09/15/grokking-rxjava-part-1/
 * and the Special Android Part:
 * http://blog.danlew.net/2014/10/08/grokking-rxjava-part-4/
 */
public class MyObserver {


    public static Observable<String> NumberToStrings(int from, int to, final long delay) {
        return Observable.range(from, to).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                if (integer == 5) {
                    System.out.println("******* CRASH ******");
                    String temp = null;
                    System.out.println("-> " + temp.charAt(9));
                    System.out.println("******* END CRASH ******");
                }
                return integer.toString();
            }
        }).doOnNext(new Action1<String>() {
            @Override
            public void call(String s) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println("**** InterruptedException ****");
                }
            }
        });
    }

    public static Observable<String> NumberToStringsExtern(int from, int to, final long delay) {
        return Observable.range(from, to).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                if (integer == 5) {
                    Mail mail = new Mail();
                    mail.getName();
                }
                return integer.toString();
            }
        }).doOnNext(new Action1<String>() {
            @Override
            public void call(String s) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println("**** InterruptedException ****");
                }
            }
        });
    }
}
