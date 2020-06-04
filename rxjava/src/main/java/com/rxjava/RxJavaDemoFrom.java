package com.rxjava;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

public class RxJavaDemoFrom {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		Observable<Integer> fromObservable = Observable.from(numbers);

		Subscriber<Integer> intSubscriber = new Subscriber<Integer>() {
			public void onCompleted() {
				System.out.println("onCompleted");
			}

			public void onError(Throwable e) {
				System.out.println("onError");
			}

			public void onNext(Integer integer) {
				System.out.println("onNext: " + integer);
			}
		};

		fromObservable.subscribe(intSubscriber);
	}
}
